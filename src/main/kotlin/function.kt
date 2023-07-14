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

fun main() {
//    run1()
//    run2()
//    run3()
}