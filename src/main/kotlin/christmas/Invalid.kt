package christmas

import christmas.enumeration.December

class Invalid {
    fun date(date: Int?): Boolean {
        return date !in December.FIRST.date..December.LAST.date
    }

    fun orders(ordersText: String): Boolean {
        val orders = ordersText.split(",")
        return orders.any { invalidFormat(it) || invalidMenu(it.split("-")[0]) || invalidQuantity(it.split("-")[1]) } ||
                overMaxQuantity(orders) || onlyDrink(orders) || notDistinctedMenu(orders)
    }
}