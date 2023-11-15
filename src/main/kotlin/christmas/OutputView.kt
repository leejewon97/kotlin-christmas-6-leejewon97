package christmas

import christmas.enumeration.OutputPhrase

class OutputView {
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

    fun printBeforeDiscountTotalPrice() {
        println(OutputPhrase.BEFORE_DISCOUNT_TOTAL_PRICE.text)
        // ...
    }

    fun printPresentMenu() {
        println(OutputPhrase.PRESENT_MENU.text)
        // ...
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