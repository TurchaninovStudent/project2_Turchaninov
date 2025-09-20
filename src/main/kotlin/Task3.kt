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
        Имеется массив из символов русского алфавита (все 33 символа, могут быть не по порядку). Символы алфавита нумеруются от 1 до 33. Каждое число используется только один раз.  Сообщение шифруется с помощью ключевого слова, задаваемого пользователем. Номер символа ключевого слова показывает, на сколько нужно сдвинуться по массиву из символов русского алфавита. Составить программу шифровки и дешифровки строкового выражения (то есть программа спрашивает - зашифровать или расшифровать текст и ключевое слово). Первый массив считать закольцованным. Регистр букв не имеет значения. Например:
        
        А	Б	В	Г	Д	Е	Ё	Ж	З	И	Й	К	Л	М	Н	О	П	Р	С	Т	У	Ф	Х	Ц	Ч	Ш	Щ	Ь	Ы	Ъ	Э	Ю	Я
        21	13	4	20	22	1	25	12	24	14	2	28	9	23	3	29	6	16	15	11	26	5	30	27	8	18	10	33	31	32	19	7	17
        
        Ключевое слово - ПОЛЕ
        Исходный текст - СООБЩЕНИЕ
        Зашифрованный текст - АЁФИРХЖСЮ"""
    )

    val letterNumber = mapOf(
        'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25, 'Ж' to 12, 'З' to 24, 'И' to 14, 'Й' to 2,
        'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29, 'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26, 'Ф' to 5,
        'Х' to 30, 'Ц' to 27, 'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17,
    )

    val numberLetter = letterNumber.entries.associate { it.value to it.key }

    println(
        """
        Выберете действие:
        1 - закодировать
        2 - декодировать"""
    )

    val chosenOperation = readln()

    if (chosenOperation != "1" && chosenOperation != "2") {
        print("Вводить только числа - ")
        return
    }

    println("Введите кодовое слово: ")
    val keyWord = readln()
    println("Введите ваше слово: ")
    val targetWord = readln()

    val decodedWord = if (chosenOperation == "1") {
        encode(keyWord, targetWord, letterNumber, numberLetter)
    } else {
        decode(keyWord, targetWord, letterNumber, numberLetter)
    }

    if (decodedWord != "") {
        println("Зашифрованный текст : $decodedWord")
    }
}

private fun encode(keyWord: String, targetWord: String, letterNumber: Map<Char, Int>, numberLetter: Map<Int, Char>): String {
    var result = ""

    for (i in 0 .. targetWord.length-1) {
        val letter = targetWord[i]
        val currentLetterForKeyWord = keyWord[i % keyWord.length]

        val letterIndex: Int
        val codeIndex: Int

        try {
            letterIndex = letterNumber[letter.uppercaseChar()] ?: throw Exception()
            codeIndex = letterNumber[currentLetterForKeyWord.uppercaseChar()] ?: throw Exception()
        } catch (_: Exception) {
            print("Вводить символы русского алфавита")
            return ""
        }

        val resultIndex = letterIndex + codeIndex
        result += numberLetter[resultIndex % letterNumber.size]
    }

    return result
}

private fun decode(keyWord: String, targetWord: String, letterNumber: Map<Char, Int>, numberLetter: Map<Int, Char>): String {
    var result = ""

    for (i in 0 .. targetWord.length-1) {
        val letter = targetWord[i]
        val currentLetterForKeyWord = keyWord[i % keyWord.length]

        val letterIndex: Int
        val codeIndex: Int

        try {
            letterIndex = letterNumber[letter.uppercaseChar()] ?: throw Exception()
            codeIndex = letterNumber[currentLetterForKeyWord.uppercaseChar()] ?: throw Exception()
        } catch (_: Exception) {
            print("Вводить символы русского алфавита")
            return ""
        }

        var resultIndex = letterIndex - codeIndex

        if (resultIndex <= 0) {
            resultIndex += letterNumber.size
        }

        result += numberLetter[resultIndex % letterNumber.size]
    }

    return result
}