package christmas

import christmas.enumeration.December
import christmas.enumeration.Discount

class Christmas {
    private val visitDate = InputView().readDate()
    private val christmasDDayDiscount = christmasDDayDiscount(visitDate)
    private val isWeekend = isWeekend(visitDate)
    private val specialDiscount = specialDiscount(visitDate)

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
}