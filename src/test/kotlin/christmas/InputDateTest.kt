package christmas

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputDateTest : NsTest() {
    @Test
    fun `날짜 예외 테스트 문자`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `날짜 예외 테스트 0`() {
        assertSimpleTest {
            runException("0")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `날짜 예외 테스트 32`() {
        assertSimpleTest {
            runException("32")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `날짜 예외 테스트 소수`() {
        assertSimpleTest {
            runException("1.1")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `날짜 예외 테스트 음수`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    override fun runMain() {
        main()
    }
}