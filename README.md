
# Genel Bakış

* Projenin veritabanı bağlantısı Docker üzerinde çalışan postgres konteyneri 
aracılığıyla sağlandı.

* Proje, Spring Framework'ün esnekliğini göstermek adına hem anotasyonlar ile
hem de XML tabanlı bean yapılandırmasıyla geliştirildi.

* Hataların daha net anlaşılabilmesi ve kullanıcılara daha iyi geri 
bildirim sağlanması için exception sınıfları özelleştirildi.


# Entpoins

* AddCustomer ->   `localhost:9090/api/v1/customer`



* GetProduct ->    `localhost:9090/api/v1/product/{id}`
  
* CreateProduct ->    `localhost:9090/api/v1/product`
  
* UpdateProduct ->   `localhost:9090/api/v1/product`

* DeleteProduct ->      `localhost:9090/api/v1/product?id={id}`

    

* GetCart ->   `localhost:9090/api/v1/cart/{id}`
  
* UpdateCart ->    `localhost:9090/api/v1/cart?cartId={id}`
  
* EmptyCart ->    `localhost:9090/api/v1/cart?customerId={id}`

* AddProductToCart ->   `localhost:9090/api/v1/cart`

* RemoveProductFromCart ->  `localhost:9090/api/v1/cart`


    

* PlaceOrder ->  `localhost:9090/api/v1/order/{id}`
  
* GetOrderForCode -> `localhost:9090/api/v1/order/{code}`
  
* GetAllOrdersForCustomer ->  `localhost:9090/api/v1/order?customerId={id}`

# Database

Customer Tablosu

![table_customers.png](photos%2Fdb%2Ftable_customers.png)

Cart Tablosu

![table_carts.png](photos%2Fdb%2Ftable_carts.png)
    
Product Tablosu

![table_products.png](photos%2Fdb%2Ftable_products.png)
    
Cart Entity sinde Bulunan Product Tablosu

![table_cart_products.png](photos%2Fdb%2Ftable_cart_products.png)

Order Tablosu

![table_orders.png](photos%2Fdb%2Ftable_orders.png)

Order Entity sinde Bulunan Product Tablosu

![table_orders_products.png](photos%2Fdb%2Ftable_orders_products.png)

# İşleyiş

* Müşteri oluşturulduğunda ona ait Cart oluşturulur.

![addCustomer.png](photos%2Fpostman%2FaddCustomer.png)

* Kullanıcı için Cart

![cartByID.png](photos%2Fpostman%2FcartByID.png)

* Cart içerisinde ki ürün işlemlerinin herbirinde toplam fiyat (cartPrice), adet (count) ve stok (stock) bilgisi güncellenir.

![addProductToCart.png](photos%2Fpostman%2FaddProductToCart.png)

![addProductToCart2.png](photos%2Fpostman%2FaddProductToCart2.png)

![addProductToCart3.png](photos%2Fpostman%2FaddProductToCart3.png)

![addProductToCart4.png](photos%2Fpostman%2FaddProductToCart4.png)
    
Remove Product To Cart

![removeProductToCart.png](photos%2Fpostman%2FremoveProductToCart.png)

* Sipariş oluşturulduğunda Cart ta bulunan tüm bilgiler alınır ve Cart temizlenir.

![createOrder.png](photos%2Fpostman%2FcreateOrder.png)
