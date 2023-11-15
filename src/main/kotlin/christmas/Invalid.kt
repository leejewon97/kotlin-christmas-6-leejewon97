package christmas

import christmas.enumeration.December
import christmas.enumeration.Menus

class Invalid {
    fun date(date: Int?): Boolean {
        return date !in December.FIRST.date..December.LAST.date
    }

    fun orders(ordersText: String): Boolean {
        val orders = ordersText.split(",")
        return orders.any { invalidFormat(it) || invalidMenu(it.split("-")[0]) || invalidQuantity(it.split("-")[1]) } ||
                overMaxQuantity(orders) || onlyDrink(orders) || notDistinctedMenu(orders)
    }

    private fun invalidMenu(menu: String) =
        !Menus.entries.map { it.menu }.contains(menu)

    private fun invalidFormat(order: String) =
        order.split("-").size != 2 || order.split("-")[1].toIntOrNull() == null
}