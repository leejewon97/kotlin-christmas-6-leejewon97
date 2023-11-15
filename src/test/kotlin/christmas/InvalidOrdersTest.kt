package christmas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InvalidOrdersTest {
    @ValueSource(strings = ["양송이수프1", "양송이수프-1,", "양송이수프-1-2", "양송이수프-a", "양송이수프-1, 타파스-2"])
    @ParameterizedTest
    fun `메뉴가 형식에 맞지 않을 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }

    @ValueSource(strings = ["단호박수프-1", "양송이수프-1,단호박수프-1"])
    @ParameterizedTest
    fun `메뉴가 메뉴판에 없을 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }

    @ValueSource(strings = ["양송이수프-0", "양송이수프--1"])
    @ParameterizedTest
    fun `메뉴의 개수가 1개 미만일 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }

    @ValueSource(strings = ["양송이수프-21", "양송이수프-10,타파스-11", "양송이수프-10,타파스-9,시저샐러드-2"])
    @ParameterizedTest
    fun `메뉴의 개수가 20개 초과일 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }

    @ValueSource(strings = ["제로콜라-1", "제로콜라-1,레드와인-1"])
    @ParameterizedTest
    fun `메뉴가 음료밖에 없을 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }

    @ValueSource(strings = ["양송이수프-1,양송이수프-1", "양송이수프-1,타파스-1,양송이수프-1"])
    @ParameterizedTest
    fun `메뉴가 중복일 때`(ordersText: String) {
        val isInvalid = Invalid().orders(ordersText)
        assertThat(isInvalid).isTrue()
    }
}