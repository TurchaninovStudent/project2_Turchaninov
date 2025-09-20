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
        Создать приложение, в котором пользователь вводит массив из различных слов. 
        На выходе приложение должно показать слова сгруппированные по признаку "состоят из одинаковых букв". 
        Например, на входе ["eat", "tea", "tan", "ate", "nat", "bat"]. 
        Получаем группы:
        "ate", "eat", "tea"
        "nat", "tan"
        "bat" """
    )

    println("Введите первый массив (через пробел): ")
    val targetArray = inputStringArray()

    println("Получившеся массив: ")
    printStringArray(targetArray)

    val resultArray = groupByUniqueLetters(targetArray)

    if (resultArray.isNotEmpty()) {
        println("Полученные группы: ")
        printTableStringArray(resultArray)

    } else {
        println("Групп нет :( ")
    }
}

private fun groupByUniqueLetters(targetArray: Array<String>): Array<Array<String>> {
    val resultList = MutableList(1) { MutableList(1) { "" } }

    for (target in targetArray) {
        if (resultList[0].isEmpty()) {
            resultList[0].add(target)
            continue
        }

        var added = false

        for (currentGroup in resultList) {
            if (hasTheSameLetters(target, currentGroup[0])) {
                currentGroup.add(target)
                added = true
                break
            }
        }
        if (!added) {
            resultList.add(MutableList(1) {target})
        }
    }

    val resultArray = Array(resultList.size) { Array(resultList.maxOf { it.size }) {""} }

    for (i in 0..resultList.size-1) {
        for (j in 0..resultList[i].size-1) {
            resultArray[i][j] = resultList[i][j]
        }
    }

    return resultArray
}

private fun hasTheSameLetters(firstString: String, secondString: String): Boolean {
    var state = true

    for (letter in firstString) {
        if (!secondString.contains(letter)) {
            state = false
        }
    }

    return state
}