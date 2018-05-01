/*
URL: https://www.hackerrank.com/challenges/migratory-birds/problem

You have been asked to help study the population of birds migrating across the continent. Each type of bird you are
interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will
 be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list
  of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common,
  choose the type with the smallest ID number.

Input Format

The first line contains an integer denoting , the number of birds sighted and reported in the array .
The second line describes  as  space-separated integers representing the type numbers of each bird sighted.

Constraints
It is guaranteed that each type is 1, 2, 3,4 , or 5.
Output Format

Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input 0

6
1 4 4 4 5 3
Sample Output 0

4
Explanation 0

The different types of birds occur in the following frequencies:

Type :  bird
Type :  birds
Type :  bird
Type :  birds
Type :  bird
The type number that occurs at the highest frequency is type , so we print  as our answer.
 */

import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

// Complete the migratoryBirds function below.
fun migratoryBirds(n: Int, ar: Array<Int>): Int {
    val countArray = Array(5) { 0 }

    for (i in 0 until n) {
        countArray[ar[i] - 1]++
    }

    val highestIndex = countArray.withIndex().maxBy { it.value }?.index ?: -1

    return highestIndex + 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = migratoryBirds(arCount, ar)

    println(result)
}
