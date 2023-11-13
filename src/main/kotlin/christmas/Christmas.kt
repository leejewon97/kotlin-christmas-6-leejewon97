package christmas

import christmas.enumeration.December
import christmas.enumeration.Discount

class Christmas {
    private val visitDate = InputView().readDate()
    private val christmasDDayDiscount = christmasDDayDiscount(visitDate)
    private val isWeekend = isWeekend(visitDate)

    private fun christmasDDayDiscount(visitDate: Int) = when (visitDate) {
        in December.FIRST.date..December.CHRISTMAS.date ->
            Discount.START_DISCOUNT.value + visitDate * Discount.PER_DAY_DISCOUNT.value

        else -> Discount.NO_DISCOUNT.value
    }

    private fun isWeekend(visitDate: Int) =
        visitDate % December.WHOLE_WEEK.date in December.FIRST_WEEKEND.date..December.SECOND_WEEKEND.date
}