package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.enumeration.December
import christmas.enumeration.InputPhrase

class InputView {
    fun readDate(): Int {
        println(InputPhrase.DATE.text)
        val date = Console.readLine().toIntOrNull()
        if (invalidDate(date)) {
            try {
                throw IllegalArgumentException(InputPhrase.ERROR_DATE.text)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return readDate()
            }
        }
        return date!!
    }

    private fun invalidDate(date: Int?): Boolean {
        return date !in December.FIRST.date..December.LAST.date
    }
}