package christmas

import christmas.enumeration.DDayDiscount
import christmas.enumeration.December

class Christmas {
    private val visitDate = InputView().readDate()
    private val christmasDDayDiscount = christmasDDayDiscount(visitDate)

    private fun christmasDDayDiscount(visitDate: Int): Int {
        return when (visitDate) {
            in December.FIRST.date..December.CHRISTMAS.date
            -> DDayDiscount.START_DISCOUNT.value + visitDate * DDayDiscount.PER_DAY_DISCOUNT.value
            else -> DDayDiscount.NO_DISCOUNT.value
        }
    }
}