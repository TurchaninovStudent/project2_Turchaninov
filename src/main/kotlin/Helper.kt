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

public fun inputTableArray(targetArray: Array<Array<Int>>, elementSize: Int?): Array<Array<Int>>? {
    for (i in 0..targetArray.size-1) {
        for (j in 0..targetArray[i].size-1) {
            print("${i+1}-ая строка, ${j+1}-й столбец: ")
            try {
                val response = readln()
                if (elementSize != null) {
                    if (response.length != elementSize) {
                        throw InvalidParameterException()
                    }
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

public fun input1DArray(): Array<Int>? {
    val response = readlnOrNull() ?: "";
    val potentionalNumbers = response.split(" ")

    var resultArray = Array(potentionalNumbers.size) { 0 }

    for (i in 0..potentionalNumbers.size-1) {
        try {
            resultArray[i] = potentionalNumbers[i].toInt()

        } catch (_: Exception) {
            print("Вводить только целые числа")
            return null
        }

    }

    return resultArray
}

public fun inputStringArray(): Array<String> {
    val response = readlnOrNull() ?: "";
    val splitResponse = response.split(" ")

    var resultArray = Array<String>(splitResponse.size) { "" }

    for (i in 0..splitResponse.size-1) {
            resultArray[i] = splitResponse[i]
    }

    return resultArray
}

public fun printTableArray(targetArray: Array<Array<Int>>) {
    for (i in 0..targetArray.size-1) {
        targetArray[i].forEach { print("$it\t") }
        println()
    }
}

public fun printTableStringArray(targetArray: Array<Array<String>>) {
    for (i in 0..targetArray.size-1) {
        targetArray[i].forEach { print("$it\t") }
        println()
    }
}

public fun print1DArray(targetArray: Array<Int>) {
    targetArray.forEach { print("$it\t") }
    println()
}

public fun printStringArray(targetArray: Array<String>) {
    targetArray.forEach { print("$it\t") }
    println()
}