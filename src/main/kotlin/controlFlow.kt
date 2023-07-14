import java.lang.Exception

fun compare() {
    // 비교연산자
    val a = 1
    val b = 2

    val lt = a < b
    val lte = a <= b
    val gt = a > b
    val gte = a >= b
    val eq = a == b
    val ne = a != b

    // 포함연산자
    val contains = 1 in 1 .. 10
    val notContains = 10 !in 1 until 10

    // any, all, none
    val list = listOf(1, 2, null)
    println(list.any { it == null }) // 모두 참인 경우 true
    println(list.all { it == null }) // 하나라도 참인 경우 true
    println(list.none { it == null }) // 모두 거짓인 경우 true

    // 논리연산자
    println(true && true)
    println(true || false)

    // Equality
    /*
    - Structural equality: ==
    - Referential equality: ===
     */
}

fun conditional() {
    val a = 5
    val b = 10

    // if
    if (a > 12) {
        println("large")
    } else if (a > 6) {
        println("medium")
    } else {
        println("small")
    }

    // when
    when (a) {
        1 -> println("1")
        2, 3 -> println("2 or 3")
        in 4 .. 7 -> print("4 .. 7")
        in 8 until 20 -> print("8 .. 19") // until은 마지막 수를 포함하지 않음
    }
    // when에 파라미터를 사용하지 않으면 내부에서 if문처럼 사용할 수 있음
    when {
        a == 1 -> println("1")
        a == 2 || a == 3 -> println("2 or 3")
        a in 4 .. 7 -> println("4 .. 7")
        a in 8 until 20 -> println("8 .. 19")
        a >= 20 -> println("20 up")
    }

    // 삼항연산자
    val isBigger = if (a > b) "yes is Bigger" else "$b is small"
    val result = when (a) {
        in 10 until 20 -> "down"
        in 20 .. 30 -> "up"
        else -> "nothing"
    }

    // try catch
    val tryCatchResult = try {
        val input = readLine()!!.toInt()
        if (input > 100) throw Exception("too large") // throw를 이용해 예외처리
        200 // 삼항연산자처럼 변수에 값을 할당할 수 있음
    } catch (e: Exception) {
        println(e)
        400 // 삼항연산자처럼 변수에 값을 할당할 수 있음
    } finally {
        // finally는 제외 가능
        println("finish")
    }
}

fun loop() {
    // for
    for (i in 1 .. 10) {
        println("loop $i")
    }
    for (i in 1 until 10) {
        println("loop $i")
    }
    for (i in 1 .. 10 step 2) {
        println("loop $i")
    }
    for (i in 10 downTo 1 step 3) {
        println("loop $i")
    }
    for (day in listOf("MON", "TUE", "WED")) {
        println(day)
    }
    for (char in 'a' .. 'f') {
        println(char)
    }
    for (char in 'f' downTo 'a' step 2) {
        println(char)
    }

    firstLoop@ for (i in 1 .. 3) {
        for (j in 1 .. 5) {
            if (j < 2) {
                continue@firstLoop
            }
            if (j == 3) {
                break@firstLoop
            }
            println("i: $i, j: $j")
        }
    }

    // while
    var i = 0
    while (i < 5) {
        println(i++)
    }
    do {
        println(i++)
    } while (i < 20)

    // iterator
    for (i in (1 .. 10).iterator()) print(i)
}