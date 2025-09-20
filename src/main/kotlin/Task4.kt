import java.lang.Exception

/////////////////////////////////////////////
//
// Практическая №1. Массивы, коллекции
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

fun main() {
    println(
        """Программа, выполняет следующий функционал:
        пользователь дает на вход два числовых массива, числа в массиве могут повторяться. 
        На выходе приложение выдает пересечение этих массивов. 
        Например, на входе [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2, 2]. 
        На выходе должны получить [1, 2, 2, 3]. 
        То есть учитывается количество повторений чисел в массиве.
        Число 2 в одном массиве повторялось два раза, в другом - три.
        Значит в итоговом массиве число два должно быть два раза"""
    )

    println("Введите первый массив (через пробел): ")
    val firstArray = input1DArray() ?: return
    println("Введите второй массив (через пробел): ")
    val secondArray = input1DArray() ?: return

    println("Получившеся массивы: ")

    print1DArray(firstArray)
    print1DArray(secondArray)

    val resultUnion = createUnion(firstArray, secondArray)

    if (resultUnion.isNotEmpty()) {
        println("Пересечение этих массивов: ")
        print1DArray(resultUnion)
    } else {
        println("Массивы не пересекаются :( ")
    }
}

private fun createUnion(firstArray: Array<Int>, secondArray: Array<Int>): Array<Int> {
    var newArray = mutableListOf<Int>()

    for (i in 0..firstArray.size-1) {
        if (secondArray.contains(firstArray[i])) {
            newArray.add(firstArray[i])
        }
    }

    var resultArray = Array(newArray.size) { 0 }
    for (i in 0..newArray.size-1) {
        resultArray[i] = newArray[i]
    }
    return resultArray.sortedArray()
}