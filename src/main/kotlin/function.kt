// 한줄로 함수 표현
fun oneLineFun() = println("This is one line function")

// 파라미터에 초기값을 지정할 수 있음
fun sayMyName(first: String, middle: String = "Poky", last: String) {
    println("$first $middle $last")
}
fun run1() {
    // 기본적으로 순서대로 인자를 전달
    sayMyName("Cookie", "Poky", "Choky")
    // 초기값이 중간에만 지정된 경우, 파라미터의 이름을 명시하여 인자를 전달
    sayMyName(first = "Cookie", last = "Choky")
}

// vararg 키워드를 이용해 가변인자 지정
fun manyParams(vararg x: Int): Int {
    var result = 0
    for (i in x) result += i
    return result
}
fun run2() {
    manyParams()
    manyParams(1, 2, 3, 4)
    // 스프레드 연산자(*)을 이용하여 배열을 가변인자로 사용
    manyParams(*intArrayOf(1, 2, 3 ,4))
}

// 가변객체와 불변객체
// 불변객체를 인자로 받는 경우, 인자로 받은 원본 값이 바뀌지 않음
fun addList1(list: List<Int>): List<Int> {
    return list + listOf(6, 7)
}
// 가변객체를 인자로 받는 경우, 인자로 받은 원본 값이 바뀔 수 있음
fun addList2(list: MutableList<Int>): MutableList<Int> {
    for (i in 5 .. 10) list.add(i)
    return list
}
fun run3() {
    val origin1 = listOf(1, 2, 3, 4, 5)
    println(addList1(origin1)) // [1, 2, 3, 4, 5, 6, 7]
    println(origin1) // [1, 2, 3, 4, 5]

    val origin2 = mutableListOf(1, 2, 3, 4) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(addList2(origin2)) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(origin2)
}

// Anonymous Function 익명함수
val sum = fun (a: Int, b: Int): Int {
    return a + b
}
fun run4() {
    println(sum(1, 2))
    println((fun(): String { return "Anonymous Function" })())
    (fun(str: String): String { return str })("IIFE, Immediately Invoked Function Expression")
}

// Lambda Expression
val multiply = { x: Int, y: Int -> x * y }

// 함수를 인자로 받는 함수
fun funArg(x: Int, y: Int, f: (Int, Int) -> Int): Int {
    return  f(x, y)
}
fun run5() {
    println(multiply(5, 10))
    println({ x: Int, y: Int -> x * y }(10, 20))
    // 함수를 인자로 받는 경우 람다 표현식으로 표현할 수 있음
    println(funArg(5, 10, { x: Int, y: Int -> x * y }))
    // 함수 호출 시 맨 뒤에 전달되는 인자가 람다식인 경우, 해당 람다식을 괄호 밖으로 뺄 수 있음
    println(funArg(5, 10) { x: Int, y: Int -> x * y })
}

// Closure
fun anonymousClosure(): () -> Int {
    var secretVar = 0
    // 익명함수를 생성하여 이를 반환
    val inner = fun (): Int {
        secretVar += 1
        return secretVar
    }
    return inner
}
fun lambdaClosure(): () -> Int {
    var secretVar = 0
    // lambda 함수를 생성하여 이를 반환
    return { -> ++secretVar}
}
fun reflectionClosure(): () -> Int {
    var secretVar = 0
    // 일반 함수를 생성하고, 해당 함수의 reference 반환 (:: reflection 사용)
    fun inner(): Int {
        secretVar += 1
        return secretVar
    }
    return ::inner
}
fun run6() {
    val inc1 = anonymousClosure()
    println(inc1()) // 1
    println(inc1()) // 2
    println(inc1()) // 3

    val inc2 = lambdaClosure()
    println(inc2()) // 1
    println(inc2()) // 2
    println(inc2()) // 3

    val inc3 = reflectionClosure()
    println(inc3()) // 1
    println(inc3()) // 2
    println(inc3()) // 3
}

// Nullable -> Invoke
// 함수 자료형을 괄호로 묶은 후 물음표를 사용하면 null 사용이 가능해짐
fun nullFun(action: (() -> Unit)?) {
    // null 가능성이 있는 경우 안전호출연산(?.)을 사용해야 함
    // nullable 함수 자료형을 처리할 때는 호출연산자(소괄호) 대신 invoke를 사용
    // invoke가 실행되면 함수의 반환 자료형에 속하는 객체를 반환
    action?.invoke()
}

// Function Overloading
// 함수 식별자가 다른 경우 같은 이름의 함수를 여러 개 정의할 수 있음
// 함수 식별자 = 함수이름 + 시그니처

fun overFun(v1: String, v2: Int) {
    println("overFun ver1")
}
fun overFun(v1: String) {
    println("overFun ver2")
}
fun overFun() {
    println("overFun ver3")
}
fun overFun(v2: Int, v1: String) {
    println("overFun ver4")
}
fun run7() {
    overFun("Hello", 2)
    overFun("Hello")
    overFun()
    overFun(2, "Hello")
    /*
    overFun(v1 = "Hello", v2 = 2)
    오버로드 해결이 모호합니다. 이 모든 함수가 일치합니다.
    public fun overFun(v2: Int, v1: String): Unit defined in root package in file function.kt
    public fun overFun(v1: String, v2: Int): Unit defined in root package in file function.kt
     */
}

fun main() {
//    run1()
//    run2()
//    run3()
//    run4()
//    run5()
//    run6()
    run7()
}