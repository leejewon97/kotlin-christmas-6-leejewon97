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
        OutputView().printEventPreview()
        OutputView().printMenu(orders)
        OutputView().printBeforeDiscountTotalPrice(totalPrice)
        OutputView().printPresentMenu(presentDiscount)
        val discounts = listOf(christmasDDayDiscount, dayOfWeekDiscount, specialDiscount, presentDiscount)
        OutputView().printDiscounts(isWeekend, discounts)
        OutputView().printTotalDiscountPrice(discounts)
        OutputView().printAfterDiscountTotalPrice(totalPrice, discounts, presentDiscount)
        OutputView().printDecemberEventBadge(discounts)
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
        if (totalPrice >= Discount.PRESENT_STANDARD.price) {
            presentDiscount = Discount.PRESENT_DISCOUNT.price
        }
    }

    private fun dayOfWeekDiscount() {
        orders.forEach { (menu, quantity) ->
            if (!isWeekend && Menus.entries.find { it.menu == menu }!!.type == Menus.MenuType.DESSERT) {
                dayOfWeekDiscount += Discount.DAY_OF_WEEK_DISCOUNT.price * quantity
            } else if (isWeekend && Menus.entries.find { it.menu == menu }!!.type == Menus.MenuType.MAIN) {
                dayOfWeekDiscount += Discount.DAY_OF_WEEK_DISCOUNT.price * quantity
            }
        }
    }

    private fun christmasDDayDiscount(visitDate: Int) = when (visitDate) {
        in December.FIRST.date..December.CHRISTMAS.date ->
            Discount.START_DISCOUNT.price + (visitDate - 1) * Discount.PER_DAY_DISCOUNT.price

        else -> Discount.NO_DISCOUNT.price
    }

    private fun isWeekend(visitDate: Int) =
        visitDate % December.WHOLE_WEEK.date in December.FIRST_WEEKEND.date..December.SECOND_WEEKEND.date

    private fun specialDiscount(visitDate: Int) = when {
        visitDate == December.CHRISTMAS.date || visitDate % December.WHOLE_WEEK.date == December.FIRST_SUNDAY.date -> Discount.SPECIAL_DISCOUNT.price
        else -> Discount.NO_DISCOUNT.price
    }

    private fun calculateTotalPrice(): Int {
        var totalPrice = 0
        orders.forEach { (menu, quantity) ->
            totalPrice += Menus.entries.find { it.menu == menu }!!.price * quantity
        }
        return totalPrice
    }
}