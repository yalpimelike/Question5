
# Genel Bakış

* Projenin veritabanı bağlantısı Docker üzerinde çalışan postgres konteyneri 
aracılığıyla sağlandı.

* Proje, Spring Framework'ün esnekliğini göstermek adına hem anotasyonlar ile
hem de XML tabanlı bean yapılandırmasıyla geliştirildi.

* Hataların daha net anlaşılabilmesi ve kullanıcılara daha iyi geri 
bildirim sağlanması için exception sınıfı özelleştirildi.


# Entpoins

* **AddCustomer** ->   `localhost:9090/api/v1/customer`

----------------

* **GetProduct** ->    `localhost:9090/api/v1/product/{id}`
  
* **CreateProduct** ->    `localhost:9090/api/v1/product`
  
* **UpdateProduct** ->   `localhost:9090/api/v1/product`

* **DeleteProduct** ->      `localhost:9090/api/v1/product?id={id}`

----------------

* **GetCart** ->   `localhost:9090/api/v1/cart/{id}`
  
* **UpdateCart** ->    `localhost:9090/api/v1/cart?cartId={id}`
  
* **EmptyCart** ->    `localhost:9090/api/v1/cart?customerId={id}`

* **AddProductToCart** ->   `localhost:9090/api/v1/cart`

* **RemoveProductFromCart** ->  `localhost:9090/api/v1/cart`


----------------
    

* **PlaceOrder** ->  `localhost:9090/api/v1/order/{id}`
  
* **GetOrderForCode** -> `localhost:9090/api/v1/order/{code}`
  
* **GetAllOrdersForCustomer** ->  `localhost:9090/api/v1/order?customerId={id}`

# Database

### Customer

![table_customers.png](photos%2Fdb%2Ftable_customers.png)

### Cart

![table_carts.png](photos%2Fdb%2Ftable_carts.png)
    
### Product

![table_products.png](photos%2Fdb%2Ftable_products.png)
    
### Added Product

![table_added_products.png](photos%2Fdb%2Ftable_added_products.png)

### Order

![table_orders.png](photos%2Fdb%2Ftable_orders.png)

### Order Product

![table_order_products.png](photos%2Fdb%2Ftable_order_products.png)

# İşleyiş

## AddCustomer

![AddCustomer.png](photos%2Fpostman%2FAddCustomer.png)

Müşteri oluşturulduğunda o müşteriye ait Cart oluşturma işlemide gerçekleştirilir.

## GetCartById

![GetCartById.png](photos%2Fpostman%2FGetCartById.png)

Müşteri için oluşturulan Cart.

## AddProductFromCart

![AddProductFromCart.png](photos%2Fpostman%2FAddProductFromCart.png)

Cart ta eklenen her ürün için Ürün Adeti ( **count** ) Aynı Ürünlerin Toplam Fiyatı ( **totalPrice** ) ve Cartın Toplam Fiyatı
( **cartPrice** ) hesaplanır ve güncellenir.

Ürün Stok bilgisi kontrol edilir ve güncellenir.


## RemoveProductToCart

![RemoveProductFromCart.png](photos%2Fpostman%2FRemoveProductFromCart.png)

Carttan silinen her ürün için Cartın tüm bilgileri ve ürün stok bilgisi güncellenir.


## ProductUpdate

![ProductUpdate.png](photos%2Fpostman%2FProductUpdate.png)

Ürün bilgisi güncellendiğinde Ürünün bulunduğu her Cartta Ürün bilgileri güncellenir.
Ürünle beraber bulunduğu Cartta güncel fiyat bilgisi tekrar hesaplanır ve güncellenir.

Bir Ürünün silinmesi durumunda bulunduğu Cartlardada ürün bilgisi silinir. Ürün silindikten sonra 
Cart fiyat durumu tekrar güncellenir. 

## CreateOrder

![CreateOrder.png](photos%2Fpostman%2FCreateOrder.png)

Sipariş oluşturulduğunda Cart ta bulunan tüm bilgiler Order olarak kaydedilir ve Cart temizlenir.

## GetAllOrdersForCustomer

![OrdersByCustomerId.png](photos%2Fpostman%2FOrdersByCustomerId.png)

Müşteri siparişi verdikten sonra aldığı ürünün güncel fiyatını - **productCurrenPrice** - alanında görebilmektedir.








