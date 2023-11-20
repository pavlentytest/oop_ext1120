interface Base {
    fun print()
    fun print1()
    fun print2()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
    override fun print1() {
    }
    override fun print2() {

    }
}

class Derived(b: Base) : Base by b {
    override fun print1() {
        println("Hello")
    }
}


fun main() {
    val b = BaseImpl(10)
    b.print1()
    Derived(b).print1()
}


// Паттерны проектирования



class Country {
    init {
        println("Init!")
    }
    val homecity by lazy {
        println("Start")
        "Default"
    }
}

fun main11() {
    val rus = Country()
    println(rus.homecity)
}

























interface Switchable {
    fun switchOn()
    fun switchOff()
    fun printStatus() {
        println("Status!")
    }
}
interface Moveable {
    fun move()
}


class Lamp : Switchable, Moveable {
    override fun switchOn() {
        TODO("Not yet implemented")
    }
    override fun switchOff() {
        TODO("Not yet implemented")
    }
    override fun move() {
        TODO("Not yet implemented")
    }
}
fun interface Calculable {
    fun calc(a: Int, b: Int) : Int
}


fun main12() {

    val calc = Calculable { a, b -> a + b }
    val calc2 = object: Calculable {
        override fun calc(a: Int, b: Int): Int {
            return a+b
        }
    }



    val lamp = Lamp()
    lamp.move()
    lamp.switchOn()
    lamp.switchOff()

    val tv = object : Switchable {
        override fun switchOn() {
            TODO("Not yet implemented")
        }

        override fun switchOff() {
            TODO("Not yet implemented")
        }
    }
    tv.switchOn()
    tv.switchOff()


}

















abstract class Transport {
    abstract fun doMove()
    open fun doBeep() {
        println("Make beep!")
    }
}
class Bus : Transport() {
    override fun doMove() {
        println("Bus is moving!")
    }

    override fun doBeep() {
        super.doBeep()
    }
}
fun main8() {
   // val transport = Transport()
    val bus = Bus()
    val bus2 = object : Transport() {
        override fun doMove() {
          //logic
        }
    }

}


















open class Animal(alias: String, age: Int) {
    open fun makeSound() {
        println("Make sound!")
    }
    open fun makeSound(str: String) {
        println(str)
    }
}
class Cat(alias: String, age: Int) : Animal(alias, age) {
    override fun makeSound() {
        println("Mau!")
    }

    override fun makeSound(str: String) {
        super.makeSound(str)
    }
}

fun main10() {
    val cat = Cat("Barsik",4)
}
























class NumInc(n: Int = 1, gap: Int = 1) {
    var number = n
        get() {
            return field
        }
        set(v) {
            if(v % 2 == 0) {
                field = v
            } else {
                field = v - 2
                println("Else!")
            }
        }
    var step = gap
        get() {
            return field
        }
    val flag : Boolean
        get() {
            return step != 1
        }
    fun inc() {
        number += step
    }
    fun dec() {
        number -= step
    }
}

fun main3() {
    val num = NumInc(10)
    println(num.number)
    num.number = 100
}
















class Car(n: String , p: Int) {
    var name: String
    var power: Int
    var color: String = "White"
    init {
        name = "Default"
        power = 0
    }
    // вторичный конструктор
    constructor() : this("Test", 200) {

    }
    constructor(name: String, p: Int, c: String) : this(name,p) {
        this.name = name
        this.color = c
        this.power = p
    }
}

fun main2() {
    val car1 = Car()
    val car2 = Car()
    val car3 = Car("Tesla",200,"Red")


}