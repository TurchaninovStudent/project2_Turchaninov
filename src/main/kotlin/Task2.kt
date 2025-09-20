import java.lang.Exception

/////////////////////////////////////////////
//
// Практическая №2. Массивы, коллекции
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

fun main() {
    println(
        """Программа, выполняет следующий функционал:
        Имеется массив целых чисел из 5-и строк и 5-и столбцов. Выяснить, симметричен ли он относительно главной диагонали. То есть - элемент 1,2 равен элементу 2,1. Элемент 1,3 равен элементу 3,1 и т.д. Например массив
        5  9  6  7  2
        9  8  4  5  3
        6  4  3  8  7
        7  5  8  4  8
        2  3  7  8  1
        является симметричным относительно главной диагонали"""
    )

    val n: Int
    val m: Int

    try {
        println("Введите количество строк: ")
        n = readln().toInt()

        println("Введите количество столбцов: ")
        m = readln().toInt()

    } catch (_: Exception) {
        print("Вводить только числа - ")
        return
    }

    val startArray: Array<Array<Int>> = Array(n) { Array(m) { 0 } }
    val resultArray = inputTableArray(startArray, null) ?: return

    println("Получившаяся таблица: ")

    printTableArray(resultArray)

    if (isSimetrical(resultArray)) {
        println("Результат: Массив является симметричным относительно главной диагонали\n")
    } else {
        println("Результат: Массив не является симметричным относительно главной диагонали\n")
    }
}

private fun isSimetrical(targetArray: Array<Array<Int>>): Boolean {
    var state = true

    for (i in 0..targetArray.size-1) {
        for (j in 0..targetArray[i].size-1) {
           if (targetArray[i][j] != targetArray[j][i]) {
               state = false
           }
        }
    }

    return state
}