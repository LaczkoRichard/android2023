package main

import java.util.Base64
import kotlin.random.Random

fun main(args: Array<String>) {
    /// 1
    val number1 : Int = 10
    val number2 : Int = 15
    println("$number1 + $number2 = ${number1 + number2}")
    printSumOfNumbers(number1, number2)

    /// 2
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    printDaysOfWeek(daysOfWeek)
    workingWithImmutableList()

    /// 3
    val start = 1
    val end = 20
    println("Prime numbers between $start and $end:")
    for (i in start..end) {
        if (checkIfPrime(i)) {
            println(i)
        }
    }

    /// 4
    println(decodeMessage("R3llcmUga29kb2xkIGxlIGV6dDog44OE4pyo"))
    println(decodeMessage("d2UgbmVlZCBtb3JlIGZyZWUgY29mZmVl"))
    println(encodeMessage("Richard faradt"))


    /// 5
    println("List of even numbers:")
    println(printEvenNumFromList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("double of 69 is:"+double(69)+"\n")
    /// 6
    println("Doubled list :")
    println(printListDoubleElements(listOf(2,4,6,8)))

    println("\nDays of week uppercase:")
    println(printDaysUppercase(daysOfWeek))

    println("\n Days of week first letter uppercase:")
    println(printDaysFirstLetterUppercase(daysOfWeek))

    println("\n Length of days:")
    println(printLengthOfDays(daysOfWeek))

    println("\n Average length of days:")
    println(printAverageLengthOfDays(daysOfWeek))

    /// 7
    println("\ndays of week converted to mutable list and removed letter n:")
    println(convertToMutableAndRemoveN(daysOfWeek))

    val mutableDaysOfWeek = convertToMutableAndRemoveN(daysOfWeek)
    println(mutableDaysOfWeek)

    for ((index, day) in mutableDaysOfWeek.withIndex()) {
        println("Item at $index is $day")
    }

    val sortedDaysOfWeek = mutableDaysOfWeek.sorted()
    println(sortedDaysOfWeek)

    workingWithMutableList()

    /// 8
    printArrayOperations()



}

fun printSumOfNumbers( number1: Int, number2: Int) {
    println("$number1 = $number2 = ${number1 + number2}")
}

fun returnSumOfNumbers( number1: Int, number2: Int) : Int {
    return number1 + number2
}

fun returnSumOfNumbersCompact( number1: Int, number2: Int) = number1 + number2

fun printDaysOfWeek(daysOfWeek: List<String>) {
    for (day in daysOfWeek) {
        println(day)
    }
}

fun workingWithImmutableList() {
    println("All days of week \n")
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    printDaysOfWeek(daysOfWeek)

    daysOfWeek.forEach() {
        println(it)
    }

    println("---Days starting with T \n")
    daysOfWeek
        .filter { day -> day.startsWith("T") }
        .forEach { day -> println(day) }

    println("---Days that contains the letter e \n")
    daysOfWeek
        .filter { day -> day.contains("e") }
        .forEach { day -> println(day) }

    println("---Days with length 6 \n")
    daysOfWeek
        .filter { day -> day.length == 6 }
        .forEach { day -> println(day) }

}

fun checkIfPrime(number: Int): Boolean {
    if (number <= 1) {
        return false
    }
    for (i in 2 until number ) {
        if (number % i == 0) {
            return false
        }
    }
    return true


}

fun arithmeticCoding(number1: Int, number2: Int, func: (Int, Int) -> Int): Int {
    return func(number1, number2)
}

fun decodeMessage(input: String): String {
    return String(Base64.getDecoder().decode(input.toByteArray()))
}

fun encodeMessage(input: String): String {
    return Base64.getEncoder().encodeToString(input.toByteArray())
}

fun printEvenNumFromList(list: List<Int>) = list.filter { it % 2 == 0 }

fun double(x: Int):Int = x * 2

fun printListDoubleElements(list: List<Int>) = list.map { it*2 }

fun printDaysUppercase(daysOfWeek: List<String>) = daysOfWeek.map { it.toUpperCase() }

fun printDaysFirstLetterUppercase(daysOfWeek: List<String>) = daysOfWeek.map {
    it.replaceFirstChar { it.toUpperCase() }
}

fun printLengthOfDays(daysOfWeek: List<String>) = daysOfWeek.map { it.length }

fun printAverageLengthOfDays(daysOfWeek: List<String>) = daysOfWeek.map { it.length }.average()

fun convertToMutableAndRemoveN (daysOfWeek: List<String>): MutableList<String> {
    val mutableDaysOfWeek = mutableListOf<String>()
    for (day in daysOfWeek) {
        if (!day.contains('n')) {
            mutableDaysOfWeek.add(day)
        }
    }
    return mutableDaysOfWeek
}

//fun printListWithIndex(daysOfWeek: List<String>) { for ((index, day) in daysOfWeek.withIndex()) {
//    println("Item at $index is $day")}
//}
//
//fun sortListAlphabetically(daysOfWeek: List<String>) = daysOfWeek.sorted()

fun workingWithMutableList(){
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    println("\nAll days of week without n")
    val mutableDaysOfWeek = convertToMutableAndRemoveN(daysOfWeek)
    println(mutableDaysOfWeek)

    println("\nprint list with index:")
    for ((index, day) in mutableDaysOfWeek.withIndex()) {
        println("Item at $index is $day")
    }

    println("\ndays of week sorted:")
    val sortedDaysOfWeek = mutableDaysOfWeek.sorted()
    println(sortedDaysOfWeek)
}

fun printArrayOperations() {
    // Generate an array of 10 random integers between 0 and 100
    val randomIntArray = Array(10) { Random.nextInt(0, 101) }

    // Print each element of the array in a new line using forEach
    println("\nRandom numbers:")
    randomIntArray.forEach { println(it) }
    println("------")

    // Print the array sorted in ascending order
    val sortedArray = randomIntArray.sorted()
    println("\nSorted numbers:")
    sortedArray.forEach { println(it) }
    println("------")

    // Check whether the array contains any even number
    val containsEven = randomIntArray.any { it % 2 == 0 }
    println("Array contains even number: $containsEven")

    // Check whether all the numbers are even
    val allEven = randomIntArray.all { it % 2 == 0 }
    println("All numbers are even: $allEven")

    println("------")

    // Calculate the average of generated numbers and print it using forEach
    val sum = randomIntArray.sum()
    val average = sum.toDouble() / randomIntArray.size
    println("Average: $average")
}