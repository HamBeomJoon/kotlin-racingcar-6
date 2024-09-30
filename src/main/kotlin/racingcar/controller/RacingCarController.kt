package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarInfo
import racingcar.model.CarName
import racingcar.model.Race

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private var carList = mutableListOf<CarInfo>()
    private var raceCount = 0

    fun start() {
        val carName = inputCarName()
        carName.map { carList.add(CarInfo(it, 0)) }

        raceCount = inputRaceCount()
        println()

        racing(carList, raceCount)

        outputWinner()
    }

    private fun inputCarName(): List<String> {
        inputView.printInputCarName()

        val carName = Console.readLine()
        val carList = CarName(carName).getCarList()

        return carList
    }

    private fun inputRaceCount(): Int {
        inputView.printInputRaceCount()

        val raceCount = Console.readLine()
        isCountNumber(raceCount)

        return raceCount.toInt()
    }

    private fun racing(carList: MutableList<CarInfo>, raceCount: Int) {
        Race(carList, raceCount)
    }

    private fun outputWinner() {
        var winnerList = mutableListOf<String>()
        val maxCount = carList.maxOf { it.goCount }
        carList.map {
            if (it.goCount == maxCount) {
                winnerList.add(it.carName)
            }
        }

        outputView.printOutputWinner(winnerList)
    }

    fun isCountNumber(raceCount: String) {
        if (!raceCount.matches(NUMBER_REGEX.toRegex())) {
            throw IllegalArgumentException(RACE_COUNT_NOT_INT)
        }
    }

    fun isCountOverZero(raceCount: String) {
        if (raceCount.toInt() < 1) {
            throw IllegalArgumentException(RACE_COUNT_OVER_ZERO)
        }
    }

    companion object {
        const val RACE_COUNT_NOT_INT = "숫자만 입력해야 합니다."
        const val RACE_COUNT_OVER_ZERO = "0보다 큰 수를 입력해야 합니다."

        const val NUMBER_REGEX = "^[0-9]+"
    }
}