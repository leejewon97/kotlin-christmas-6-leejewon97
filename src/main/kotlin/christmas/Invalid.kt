package christmas

import christmas.enumeration.December
import christmas.enumeration.Menus
import christmas.enumeration.Order

class Invalid {
    fun date(date: Int?): Boolean {
        return date !in December.FIRST.date..December.LAST.date
    }

    fun orders(ordersText: String): Boolean {
        val orders = ordersText.split(",")
        return orders.any {
            invalidFormat(it) || invalidMenu(it.split("-")[Order.MENU.index]) || invalidQuantity(
                it.split(
                    "-"
                )[Order.QUANTITY.index]
            )
        } ||
                overMaxQuantity(orders) || onlyDrink(orders) || notDistinctiveMenu(orders)
    }

    private fun notDistinctiveMenu(orders: List<String>): Boolean {
        val menus = orders.map { it.split("-")[Order.MENU.index] }
        return menus.size != menus.distinct().size
    }

    private fun onlyDrink(orders: List<String>) = orders.map { it.split("-")[Order.MENU.index] }.all { menu ->
        Menus.entries.filter { it.type == Menus.MenuType.DRINK }.map { it.menu }.contains(menu)
    }

    private fun overMaxQuantity(orders: List<String>) =
        orders.sumOf { it.split("-")[Order.QUANTITY.index].toInt() } > Order.Quantity.MAX.value

    private fun invalidQuantity(quantity: String) =
        quantity.toInt() < Order.Quantity.MIN.value

    private fun invalidMenu(menu: String) =
        !Menus.entries.map { it.menu }.contains(menu)

    private fun invalidFormat(order: String) =
        order.split("-").size != 2 || order.split("-")[Order.QUANTITY.index].toIntOrNull() == null
}