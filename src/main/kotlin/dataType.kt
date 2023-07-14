fun variable() {
    // 변수 var
    var year = 2023 // 선언과 동시에 초기화
    var age: Int // 선언만 하는 경우 타입을 명시

    // 읽기 전용 변수 val
    val v1 = 2023 // 이후에 수정할 수 없으므로, 반드시 선언과 동시에 초기화
}

// 상수 const
object Const {
    const val PI = 3.141592
}

fun dataType() {
    // Primitive Type
    val double = 3.141592       // 64bit (default)
    val float = 3.141592F       // 32bit
    val long = 3141592L         // 64bit
    val int = 3141592           // 32bit (default)
    val short: Short = 314      // 16bit
    val byte: Byte = 3          // 8bit
    val char = 'A'              // 16bit
    val bool = true             // true or false

    // String
    val string = "String is not primitive type"
}

fun string() {
    // String Template
    val year = 2023
    val month = 7
    val date = 14
    println("today: $year/$month/$date, sum: ${year + month + date}")

    // Escape Character
    /*
    - single quote: \'
    - double quote: \"
    - slash: \/
    - backslash: \\
    - new line: \n
    - carriage return: \r
    - tab: \t
    - backspace: \b
    - form feed: \f
    - vertical tab: \v
    - null character: \0
    - dollar sign: \$
     */
    println("This is string\nNew Line!")

    // Raw String
    println("""Raw String에서는 \n과 같은 Escape Character가 동작하지 않음""")
    println("""하지만 ${100 + 200}과 같은 String Template기능은 그대로 동작""")

    // String Formatting
    val float = 1234.5
    val int = 100
    val string = "This is string"
    val exp = 10e15
    val hex = 0xffff

    println("float: %6.2f, int: %6d, string: %10s".format(float, int, string))
    // float: 1234.50, int: ___100, string: _is String (_는 띄워쓰기를 의미)

    println("exp: %e, hex: %x".format(exp, hex))
    // exp: 1.000000e+16, hex=ffff
}