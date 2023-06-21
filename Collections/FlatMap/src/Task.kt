// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap(Order::products)

fun Customer.getOrderedProducts1(): List<Product> =
        orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        customers.flatMap { customer: Customer -> customer.getOrderedProducts() }.toSet()

fun Shop.getOrderedProducts1(): Set<Product> =
        customers.flatMap { it.getOrderedProducts() }.toSet()

fun Shop.getOrderedProducts2(): Set<Product> =
        customers.flatMap(Customer::getOrderedProducts).toSet()
