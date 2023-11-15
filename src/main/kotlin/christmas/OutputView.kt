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

    private fun dayOfWeekDiscountPhrase(isWeekend: Boolean) = when (isWeekend) {
        true -> OutputPhrase.Discount.WEEKEND.text
        else -> OutputPhrase.Discount.WEEKDAY.text
    }

    private fun decidePrintDiscount(index: Int, discount: Int, isWeekend: Boolean) {
        if (discount == Discount.NO_DISCOUNT.price) return
        when (index) {
            0 -> println("${OutputPhrase.Discount.CHRISTMAS_D_DAY.text}${formatPrice(discount)}${OutputPhrase.PRICE_UNIT.text}")
            1 -> println("${dayOfWeekDiscountPhrase(isWeekend)}${formatPrice(discount)}${OutputPhrase.PRICE_UNIT.text}")
            2 -> println("${OutputPhrase.Discount.SPECIAL.text}${formatPrice(discount)}${OutputPhrase.PRICE_UNIT.text}")
            3 -> println("${OutputPhrase.Discount.PRESENT.text}${formatPrice(discount)}${OutputPhrase.PRICE_UNIT.text}")
        }
    }

    fun printDiscounts(isWeekend: Boolean, discounts: List<Int>) {
        println(OutputPhrase.DISCOUNT_LIST.text)
        if (discounts.sum() == 0) {
            println(OutputPhrase.NOTHING.text)
            return
        }
        discounts.forEachIndexed { index, discount -> decidePrintDiscount(index, discount, isWeekend) }
    }

    fun printTotalDiscountPrice(discounts: List<Int>) {
        println(OutputPhrase.TOTAL_DISCOUNT_PRICE.text)
        if (discounts.sum() == 0) {
            println(OutputPhrase.NOTHING.text)
            return
        }
        println("-${formatPrice(discounts.sum())}${OutputPhrase.PRICE_UNIT.text}")
    }

    fun printAfterDiscountTotalPrice(totalPrice: Int, discounts: List<Int>, presentDiscount: Int) {
        println(OutputPhrase.AFTER_DISCOUNT_TOTAL_PRICE.text)
        println("${formatPrice(totalPrice - discounts.sum() - presentDiscount)}${OutputPhrase.PRICE_UNIT.text}")
    }

    fun printDecemberEventBadge() {
        println(OutputPhrase.DECEMBER_EVENT_BADGE.text)
        // ...
    }
}