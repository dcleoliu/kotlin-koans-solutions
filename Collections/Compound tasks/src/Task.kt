// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxByOrNull(Product::price)
}

fun findMostExpensiveProductBy1(customer: Customer): Product? {
    return customer.orders.filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap(Customer::getOrderedProducts).count { it == product }
}

fun Shop.getNumberOfTimesProductWasOrdered1(product: Product): Int {
    return customers.flatMap {
        it.getOrderedProducts().filter {
            it == product
        }
    }.size
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }
