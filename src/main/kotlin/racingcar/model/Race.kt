package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

class Race(private val carList: MutableList<CarInfo>, private val raceCount: Int) {
   private val outputView = OutputView()

    init {
        doRacing()
    }

    private fun doRacing() {
        repeat(raceCount) {
           goConditionCheck()
           outputView.printOutputRaceResult(carList)
        }
    }

    private fun goConditionCheck() {
        for (car in carList) {
            val goCondition = Randoms.pickNumberInRange(0, 9)
            if (goCondition > 3) car.goCount++
        }
    }
}