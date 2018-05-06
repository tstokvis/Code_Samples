// Problem URL: https://www.hackerrank.com/challenges/sock-merchant/problem

import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    val score = scan.nextLine().split(" ").map{ it.trim().toInt() }

    print(numberOfMatchingPairs(score))
}

fun numberOfMatchingPairs(sockArray: List<Int>): Int {
    val countMap = HashMap<Int,Int>()

    sockArray.forEach {
        countMap.put(it, countMap.getOrDefault(it, 0) + 1)
    }

    return countMap.values.fold(0, {acc, next -> acc + ( next / 2 )})
}