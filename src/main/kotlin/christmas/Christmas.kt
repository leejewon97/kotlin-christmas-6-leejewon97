package christmas

import christmas.enumeration.December
import christmas.enumeration.Discount
import christmas.enumeration.Menus

class Christmas {
    private val visitDate = InputView().readDate()
    private var christmasDDayDiscount = christmasDDayDiscount(visitDate)
    private val isWeekend = isWeekend(visitDate)
    private var dayOfWeekDiscount = Discount.NO_DISCOUNT.price
    private var specialDiscount = specialDiscount(visitDate)
    private var presentDiscount = Discount.NO_DISCOUNT.price
    private val orders = InputView().readOrdersText()
    private val totalPrice = calculateTotalPrice()

    init {
        refreshDiscount()
    }

    private fun refreshDiscount() {
        when {
            totalPrice < Discount.ENABLE_DISCOUNT_STANDARD.price -> {
                christmasDDayDiscount = Discount.NO_DISCOUNT.price
                specialDiscount = Discount.NO_DISCOUNT.price
            }

            else -> {
                dayOfWeekDiscount()
                presentDiscount()
            }
        }
    }

    private fun presentDiscount() {
        TODO("Not yet implemented")
    }

    private fun dayOfWeekDiscount() {
        TODO("Not yet implemented")
    }

    private fun christmasDDayDiscount(visitDate: Int) = when (visitDate) {
        in December.FIRST.date..December.CHRISTMAS.date ->
            Discount.START_DISCOUNT.price + visitDate * Discount.PER_DAY_DISCOUNT.price

        else -> Discount.NO_DISCOUNT.price
    }

    private fun isWeekend(visitDate: Int) =
        visitDate % December.WHOLE_WEEK.date in December.FIRST_WEEKEND.date..December.SECOND_WEEKEND.date

    private fun specialDiscount(visitDate: Int) = when {
        visitDate == December.CHRISTMAS.date || visitDate % December.WHOLE_WEEK.date == December.FIRST_WEEKEND.date -> Discount.SPECIAL_DISCOUNT.price
        else -> Discount.NO_DISCOUNT.price
    }

    private fun calculateTotalPrice(): Int {
        var totalPrice = 0
        orders.forEach { (menu, quantity) ->
            totalPrice += Menus.valueOf(menu).price * quantity
        }
        return totalPrice
    }
}