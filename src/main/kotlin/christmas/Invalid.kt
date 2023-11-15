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

    private fun onlyDrink(orders: List<String>) = orders.map { it.split("-")[0] }.all { menu ->
        Menus.entries.filter { it.type == Menus.MenuType.DRINK }.map { it.menu }.contains(menu)
    }

    private fun overMaxQuantity(orders: List<String>) =
        orders.sumOf { it.split("-")[1].toInt() } > 20

    private fun invalidQuantity(quantity: String) =
        quantity.toInt() < 1

    private fun invalidMenu(menu: String) =
        !Menus.entries.map { it.menu }.contains(menu)

    private fun invalidFormat(order: String) =
        order.split("-").size != 2 || order.split("-")[1].toIntOrNull() == null
}