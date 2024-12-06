package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Cart;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.entity.Product;
import com.melikeyalpi.question5.dto.request.ToCartRequest;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.AddedProductRepository;
import com.melikeyalpi.question5.repository.CartRepository;
import com.melikeyalpi.question5.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    private final AddedProductRepository addedProductRepository;


    public void createCart(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cartRepository.save(cart);
    }



    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart == null) {
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }
        return cart;
    }



    public Cart updateCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.setCartPrice(0);
            cart.getProductList().stream().forEach(addedProduct -> {
                addedProduct.setTotalPrice(addedProduct.getCount() * addedProduct.getProduct().getPrice());
                cart.setCartPrice(cart.getCartPrice() + addedProduct.getTotalPrice());
            });
        }
        else {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }
        return cartRepository.save(cart);
    }



    public Cart addProductToCart(ToCartRequest request) {

        Cart cart = cartRepository.findById(request.getCartId()).orElse(null);
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if ( cart == null || product == null) {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }

        if (product.getStock() < 1){
            log.error(ExceptionMessages.OUT_OF_STOCK);
            throw new BasicException(ExceptionMessages.OUT_OF_STOCK);
        }

        if (cart.getProductList().stream().anyMatch(addedProduct -> addedProduct.getProduct().getId().equals(request.getProductId()))){
            // current same product
            AddedProduct addedProduct = cart.getProductList().stream()
                    .filter(p -> p.getProduct().getId().equals(request.getProductId())).findAny().get();

            addedProduct.setCount(addedProduct.getCount() + 1);

            addedProduct.setTotalPrice(product.getPrice() * addedProduct.getCount());
            AddedProduct savedAddedProduct = addedProductRepository.save(addedProduct);

            cart.getProductList().remove(addedProduct);
            cart.getProductList().add(savedAddedProduct);
        }
        else {
            cart.getProductList().add(addedProductRepository.save(new AddedProduct(product,cart)));
        }

        product.setStock(product.getStock() - 1);
        cart.setCartPrice(calculateCartTotalPrice(cart));

        cartRepository.save(cart);
        return cart;

    }


    @Transactional
    public Cart removeProductFromCart(ToCartRequest request) {

        Cart cart = cartRepository.findById(request.getCartId()).orElse(null);
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if ( cart == null || product == null ) {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }

        if (cart.getProductList().stream().anyMatch(p -> p.getProduct().getId().equals(request.getProductId()))){

            AddedProduct addedProduct = cart.getProductList().stream()
                    .filter(p -> p.getProduct().getId().equals(request.getProductId())).findAny().get();

            if (addedProduct.getCount() > 1){
                addedProduct.setCount(addedProduct.getCount() - 1);
                addedProduct.setTotalPrice(product.getPrice() * addedProduct.getCount());
            }
            else {
                cart.getProductList().remove(addedProduct);
                addedProductRepository.deleteById(addedProduct.getId());

            }
        }

        product.setStock(product.getStock() + 1);
        cart.setCartPrice(calculateCartTotalPrice(cart));
        cartRepository.save(cart);
        return cart;

    }


    public int calculateCartTotalPrice(Cart cart) {
        AtomicInteger totalPrice = new AtomicInteger();
        cart.getProductList().forEach(product -> totalPrice.addAndGet(product.getTotalPrice()));
        return totalPrice.get();
    }



    public void refreshCart(Product product){
        List<AddedProduct> addedProductList = addedProductRepository.findAllByProductId(product.getId());
        addedProductList.forEach(addedProduct ->
                {
                    addedProduct.setTotalPrice(product.getPrice() * addedProduct.getCount());
                }
        );
        addedProductRepository.saveAll(addedProductList);
        addedProductList.forEach(addedProduct -> updateTotalPrice(addedProduct.getCart()));
    }

    public void refreshCart(List<AddedProduct> addedProductList){
       addedProductList.forEach(addedProduct -> updateTotalPrice(addedProduct.getCart()));
    }



    public void updateTotalPrice(Cart cart) {
        if (cart != null) {
            cart.setCartPrice(0);
            cart.getProductList().forEach(addedProduct -> {
                cart.setCartPrice(cart.getCartPrice() + addedProduct.getTotalPrice());
            });
            cartRepository.save(cart);
        }
        else {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }
    }



}
