package racingcar.view

import racingcar.model.CarInfo

class OutputView {
    fun printOutputRaceResult(carInfoList: MutableList<CarInfo>) {
        for (car in carInfoList) {
            println("${car.carName} : ${"-".repeat(car.goCount)}")
        }
        println()
    }

}