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
        - запрашивается количество строк и столбцов для двумерного массива
        - вводится необходимое количество трехзначных чисел (числа могут повторяться)
        - подсчитывается количество различных цифр в полученном массиве
        - на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
        Например, для массива
        100   951   101   950
        519   999   155   501
        510   911   144   554
        выведется результат: В массиве использовано 5 различных цифр"""
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

    val resultArray: Array<Array<Int>> = inputTableArray(startArray, 3) ?: return

    println("Получившаяся таблица: ")

    printTableArray(resultArray)

    val result = countUniqueDigitsIn(resultArray)

    println("Результат: в массиве использовано $result различных цифр")
}

private fun countUniqueDigitsIn(targetArray: Array<Array<Int>>): Int {
    val uniqueDigits = mutableListOf<Char>()

    for (i in 0..targetArray.size-1) {
        for (j in 0..targetArray[i].size-1) {
            val stringNumber = targetArray[i][j].toString()
            stringNumber.forEach {
                if (!uniqueDigits.contains(it)) {
                    uniqueDigits.add(it)
                }
            }
        }
    }

    return uniqueDigits.size
}