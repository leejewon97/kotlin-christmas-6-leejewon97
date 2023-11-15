package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.enumeration.InputPhrase
import christmas.enumeration.Order

class InputView {
    fun readDate(): Int {
        println(InputPhrase.DATE.text)
        val date = Console.readLine().toIntOrNull()
        if (Invalid().date(date)) {
            try {
                throw IllegalArgumentException(InputPhrase.ERROR_DATE.text)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return readDate()
            }
        }
        return date!!
    }

    fun readOrdersText(): Map<String, Int> {
        println(InputPhrase.MENU.text)
        val ordersText = Console.readLine()
        if (Invalid().orders(ordersText)) {
            try {
                throw IllegalArgumentException(InputPhrase.ERROR_MENU.text)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return readOrdersText()
            }
        }
        return ordersTextToMap(ordersText)
    }

    private fun ordersTextToMap(ordersText: String): Map<String, Int> {
        val orders = ordersText.split(",")
        val menuAndQuantity = mutableMapOf<String, Int>()
        orders.forEach {
            val order = it.split("-")
            menuAndQuantity[order[Order.MENU.index]] = order[Order.QUANTITY.index].toInt()
        }
        return menuAndQuantity
    }
}