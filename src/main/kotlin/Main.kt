fun main(args: Array<String>) {
    val stringArray = Array(10) { _ -> "" }
    stringArray.set(1, "Hello")
    val last = stringArray.get(9)
    val mutableList = mutableListOf("Mon")
    mutableList.add("Tue")
    val b = mutableList.get(1)
    mutableList.set(1, "MON")
    val set = mutableSetOf<String>()
    set.add("JAN")
    set.add("JAN")
    println(set)
    val map = mutableMapOf<String, String>()
    map.put("name", "cookie")
    map.get("name")

    val mutableSet = mutableSetOf<String>("Cookie", "Hello")
    println(mutableSet.contains("Cookie"))

    val doubleArr = DoubleArray(10)
    val floatArr = FloatArray(10)
    val longArr = LongArray(10)
    val intArr = IntArray(10)
    val shortArr = ShortArray(10)
    val byteArr = ByteArray(10)
    val charArr = CharArray(10)
    val boolArr = BooleanArray(10)

    for (i in 100 downTo 10 step 2) {
        if (i < 50) break
        println(i)
    }
    for (e in set) {
        println(e)
    }
    my1("Cookie", n3 = "Good")

    val age = 25
    val result = when (age) {
        in 10 until 20 -> {
            "down"
        }
        in 20 .. 30 -> {
            "up"
        }
        else -> {
            "nothing"
        }
    }
}

fun my1(n1: String, n2: String = "Poky", n3: String) {
    println("$n1 $n2 $n3")
}

class myClass {
    constructor(value: String) {

    }
    constructor(value: Int) {

    }
    constructor(value1: Int, value2: String) {

    }
    companion object {
        fun printName() {
            println("Hi Cookie")
        }
    }
}

object MyObj {
    var name: String = "Cookie"
    fun printName() {
        println(name)
    }
}

object MyObj2 {
    var name: String = "Poky"
    fun printName() {
        println(name)
    }
}