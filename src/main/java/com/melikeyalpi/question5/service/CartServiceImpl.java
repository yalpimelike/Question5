package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Cart;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.entity.Product;
import com.melikeyalpi.question5.dto.request.ToCartRequest;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.CartRepository;
import com.melikeyalpi.question5.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;


    public void createCart(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cartRepository.save(cart);

    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElse(null);
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

        if (cart.getProductList().stream().anyMatch(p -> p.getId().equals(request.getProductId()))){
            // current same product
            AddedProduct addedProduct = cart.getProductList().stream()
                    .filter(p -> p.getId().equals(request.getProductId())).findAny().get();
            addedProduct.setCount(addedProduct.getCount() + 1);

            addedProduct.setTotalPrice(product.getPrice() * addedProduct.getCount());

            cart.getProductList().remove(addedProduct);
            cart.getProductList().add(addedProduct);
        }
        else {
            cart.getProductList().add(new AddedProduct(product,cart.getId()));
        }
        product.setStock(product.getStock() - 1);
        cart.setCartPrice(calculateCartTotalPrice(cart));

        cartRepository.save(cart);
        return cart;

    }


    public Cart removeProductFromCart(ToCartRequest request) {

        Cart cart = cartRepository.findById(request.getCartId()).orElse(null);
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if ( cart == null || product == null ) {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }

        if (cart.getProductList().stream().anyMatch(p -> p.getId().equals(request.getProductId()))){

            AddedProduct addedProduct = cart.getProductList().stream()
                    .filter(p -> p.getId().equals(request.getProductId())).findAny().get();

            if (addedProduct.getCount() > 1){
                addedProduct.setCount(addedProduct.getCount() - 1);
                addedProduct.setTotalPrice(product.getPrice() * addedProduct.getCount());
            }
            else {
                cart.getProductList().remove(addedProduct);
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


}
