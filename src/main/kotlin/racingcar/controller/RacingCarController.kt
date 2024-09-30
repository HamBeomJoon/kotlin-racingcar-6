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
    }

    private fun inputCarName() {
        inputView.printInputCarName()

        val carName = Console.readLine()
    }
