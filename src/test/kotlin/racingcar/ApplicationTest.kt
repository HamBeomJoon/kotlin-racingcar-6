package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.RacingCarController
import racingcar.model.CarInfo
import racingcar.model.CarName

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `자동차 이름 길이 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { CarName("pobi,joon,kotlincar") }
        }
    }

    @Test
    fun `레이싱 횟수 정수 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingCarController().isCountNumber("a") }
            assertThrows<IllegalArgumentException> { RacingCarController().isCountNumber("1_@") }

            assertDoesNotThrow { RacingCarController().isCountNumber("10") }
        }
    }

    @Test
    fun `레이싱 횟수 유효 범위 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingCarController().isCountOverZero("-1") }
            assertThrows<IllegalArgumentException> { RacingCarController().isCountOverZero("0") }
        }
    }
    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
