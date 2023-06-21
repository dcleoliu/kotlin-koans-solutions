// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.partition {
        it.orders.partition { it.isDelivered == true }.first.size <
                it.orders.partition { it.isDelivered == true }.second.size
    }.first.toSet()

fun Shop.getCustomersWithMoreUndeliveredOrders1(): Set<Customer> = customers.filter {
    var (delivered, undelivered) = it.orders.partition { it.isDelivered }
    delivered.size < undelivered.size
}.toSet()