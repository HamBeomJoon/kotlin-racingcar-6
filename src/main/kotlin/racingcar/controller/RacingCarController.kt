package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarName

class RacingCarController {
    val inputView = InputView()
    val outputView = OutputView()

    fun start() {
        inputCarName()

        inputRaceCount()
        println()

    }

    private fun inputCarName() {
        inputView.printInputCarName()

        val carName = Console.readLine()
        CarName(carName)
    }

    private fun inputRaceCount() {
        inputView.printInputRaceCount()

        val raceCount = Console.readLine()
        require(isNumber(raceCount)) { RACE_COUNT_NOT_INT }
        require(isOverZero(raceCount)) { RACE_COUNT_OVER_ZERO }
    }

    private fun outputRaceResult() {
        outputView.printOutputRaceResult()

    }
    private fun isNumber(raceCount: String) = raceCount.matches(NUMBER_REGEX.toRegex())
    private fun isOverZero(raceCount: String) = raceCount.toInt() > 0

    companion object {
        const val RACE_COUNT_NOT_INT = "숫자만 입력해야 합니다."
        const val RACE_COUNT_OVER_ZERO = "0보다 큰 수를 입력해야 합니다."

        const val NUMBER_REGEX = "^[0-9]+"
    }
}