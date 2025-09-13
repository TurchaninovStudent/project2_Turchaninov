import java.lang.Exception
import java.security.InvalidParameterException

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
        """Создать программу, выполняющую следующий функционал:
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

    var n = 1
    var m = 1

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

    var resultArray: Array<Array<Int>>? = inputArray(startArray)

    if (resultArray == null) {
        return
    }

    println("Получившаяся таблица: ")

    printArray(resultArray!!)

    val result = countUniqueDigitsIn(resultArray)

    println("Результат: в массиве использовано $result различных цифр")
}

fun inputArray(targetArray: Array<Array<Int>>): Array<Array<Int>>? {
    for (i in 0..targetArray.size-1) {
        for (j in 0..targetArray[i].size-1) {
            print("${i+1}-ая строка, ${j+1}-й столбец: ")
            try {
                val response = readln()
                if (response.length != 3) {
                    throw InvalidParameterException()
                }
                targetArray[i][j] = response.toInt();


            } catch (_: Exception) {
                print("Вводить только трёхзначные целые числа")
                return null
            }
        }
        println()
    }

    return targetArray;
}

fun printArray(targetArray: Array<Array<Int>>) {
    for (i in 0..targetArray.size-1) {
        targetArray[i].forEach { print("$it\t") }
        println()
    }
}

fun countUniqueDigitsIn(targetArray: Array<Array<Int>>): Int {
    var uniqueDigits = mutableListOf<Char>()

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