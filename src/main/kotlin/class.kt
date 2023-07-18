/*
 Class 지시자 modifier
 - final: 상속할 수 없는 클래스 (default)
 - open: 상속할 수 있는 클래스
 - abstract: 상속을 해야만 하는 추상 클래스
 */

/*
 Class 지시자 visuality modifier
 - public: 어디에서나 사용 가능 (default)
 - private: 파일 내부에서만 사용 가능
 - protected: 파일 내부 또는 상속한 경우에만 사용 가능
 - internal: 컴파일 단위의 모듈에서만 사용 가능
 */

class basicClass constructor(val attr1: Int): Any() {
    init {
        println("initialize class")
    }

    var attr2: String = "myClass1"

    constructor(param1: String, param2: Int): this(param2) {
        var attr3: String = param1
    }
}

// 아무런 기능이 없는 클래스 (컴파일러가 자동으로 주 생성자를 만들어 줌)
class emptyClass1
class emptyClass2 {}

// 주 생성자
// C1과 C2는 서로 같음 (매개변수에 직접 var 또는 val을 사용하여 속성으로 정의)
class C1(name: String, age: Int) {
    val name = name
    val age = age
}
class C2(val name: String, val age: Int)

// Initialize
// 주 생성자는 매개변수와 속성만 작성할 수 있으므로, 추가적인 로직은 init에서 처리
class C3(name: String, age: Int) {
    var name: String = ""
    var age: Int = 0

    init {
        this.name = name
        this.age = age
    }
}

class Person {
    var name: String = ""
    var age: Int = 0

    constructor(name: String) {
        this.name = name
    }

    constructor(age: Int) {
        this.age = age
    }
}

// 보조 생성자만 있는 클래스
class C4 {
    var name = ""
    var age = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

// 주 생성자와 보조 생성자가 모두 있는 클래스
class C5 (name: String) {
    var name = ""
    var age = 0
    var year = 0

    init {
        this.name = name
        println("주 생성자")
    }

    // 주 생성자가 있는 경우, 보조 생성자에서 주 생성자를 위임 호출해야 함
    constructor(name: String, age: Int) : this(name) {
        this.age = age
        println("보조 생성자1")
    }

    // 다른 보조 생성자가 있는 경우, 해당 보조 생성자를 위임 호출할 수도 있음
    constructor(year: Int, age: Int): this("no Name", age) {
        this.year = year
        println("보조 생성자2")
    }
}
fun classRun1() {
    val c1 = C5("Cookie")
    val c2 = C5("Poky", 25)
//    val c3 = C5("Choky", 24, 2023)

//    println("${c1.name}: ${c1.age}, ${c2.name}: ${c2.age}, ${c3.name}: ${c3.age} (${c3.year})")
}

// Inheritance
open class SuperClass(val name: String) {
    override fun toString(): String {
        return "[super]id: ${this.hashCode()}"
    }

    open fun info() = "Super Class Info"
    fun getSuper(): String {
        return "Super Class Method"
    }
    fun callMyName() = name
}
open class SubClass(name: String, var age: Int): SuperClass(name) {
    var weight = 0
    var isMale = false
    constructor(name: String, age: Int, weight: Int): this(name, age) {
        this.weight = weight
    }
    constructor(name: String, age: Int, isMale: Boolean): this(name, age) {
        this.isMale = isMale
    }
    override fun toString(): String {
        return "[sub]id: ${this.hashCode()}"
    }
    final override fun info() = "Sub Class Info "
    fun callMyWeight() = weight
}
class SubSubClass(name: String, age: Int, var height: Float): SubClass(name, age) {
    fun callMyHeight() = height
}
fun classRun2() {
    val c1 = SuperClass("Cookie")
    val c2 = SubClass("Poky", 24)
    val c3 = SubClass("Alex", 26, 67)
    val c4 = SubClass("Jane", 24, false)
    val c5 = SubSubClass("Kally", 23, 168.5F)

    println("---c1---")
    println(c1.info())
    println(c1.toString())
    println(c1.callMyName())
    println(c1.getSuper())

    println("\n---c2---")
    println(c2.info())
    println(c2.toString())
    println(c2.callMyName())
    println(c2.getSuper())
    println(c2.callMyWeight())

    println("\n---c3---")
    println(c3.callMyName())
    println(c3.callMyWeight())
    println(c3.age)

    println("\n---c4---")
    println(c4.name)
    println(c4.callMyWeight())
    println(c4.isMale)

    println("\n---c5---")
    println(c5.info())
    println(c5.toString())
    println(c5.callMyName())
    println(c5.getSuper())
    println(c5.callMyWeight())
    println(c5.callMyHeight())
    println(c5.isMale)
}

fun main() {
//    classRun1()
//    classRun2()
    val a = C5("Cookie")
    println("---")
    val b = C5("Cookie", 24)
    println("---")
    val c = C5(2020, 25)
}