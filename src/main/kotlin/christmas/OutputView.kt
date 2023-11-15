package christmas

import christmas.enumeration.Discount
import christmas.enumeration.OutputPhrase

class OutputView {
    private fun formatPrice(price: Int): String {
        return price.toString().reversed().chunked(3).joinToString(",").reversed()
    }

    fun printHi() {
        println(OutputPhrase.HI.text)
    }

    fun printEventPreview() {
        println(OutputPhrase.EVENT_PREVIEW.text)
    }

    fun printMenu(orders: Map<String, Int>) {
        println(OutputPhrase.ORDERED_MENU.text)
        orders.forEach { (menu, quantity) ->
            println("$menu $quantity${OutputPhrase.MENU_UNIT.text}")
        }
    }

    fun printBeforeDiscountTotalPrice(totalPrice: Int) {
        println(OutputPhrase.BEFORE_DISCOUNT_TOTAL_PRICE.text)
        println("${formatPrice(totalPrice)}${OutputPhrase.PRICE_UNIT.text}")
    }

    fun printPresentMenu(presentDiscount: Int) {
        println(OutputPhrase.PRESENT_MENU.text)
        when (presentDiscount) {
            Discount.NO_DISCOUNT.price -> println(OutputPhrase.NOTHING.text)
            else -> println("${OutputPhrase.CHAMPAGNE.text} ${OutputPhrase.MENU_UNIT.text}")
        }
    }

    fun printDiscountList() {
        println(OutputPhrase.DISCOUNT_LIST.text)
        // ...
    }

    fun printTotalDiscountPrice() {
        println(OutputPhrase.TOTAL_DISCOUNT_PRICE.text)
        // ...
    }

    fun printAfterDiscountTotalPrice() {
        println(OutputPhrase.AFTER_DISCOUNT_TOTAL_PRICE.text)
        // ...
    }

    fun printDecemberEventBadge() {
        println(OutputPhrase.DECEMBER_EVENT_BADGE.text)
        // ...
    }
}