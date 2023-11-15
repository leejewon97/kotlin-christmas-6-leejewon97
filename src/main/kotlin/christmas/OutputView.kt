package christmas

import christmas.enumeration.OutputPhrase

class OutputView {
    fun printHi() {
        println(OutputPhrase.HI.text)
    }

    fun printMenu() {
        println("<주문 메뉴>")
        // ...
    }
}