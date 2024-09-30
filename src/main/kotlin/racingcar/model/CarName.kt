package racingcar.model

class CarName(carName: String) {
    private val carList = carName.split(",")

    init {
        require(isValidName()) { CAR_NAME_ERROR_MESSAGE }
    }

    private fun isValidName() = carList.all { it.isNotEmpty() && it.length < 5 }

    companion object {
        const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다."
    }
}