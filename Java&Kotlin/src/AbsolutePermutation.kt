import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

/*
 * Complete the absolutePermutation function below.
 */
fun absolutePermutation(n: Int, k: Int): Array<Int> {

    // array with the answers
    val answers = Array(n) { 0 }

    // Need an array to keep track of whether a number has already been used,
    // so it doesn't get used twice. Since space is not a
    // constraint but time is, create a boolean array of size n to
    // record if an element is used. This way we can check if an element is
    // used in O(1) time instead of using .contains() which is O(n)
    val hasBeenUsed = Array(n) { false }

    for (i in 1..n) {
        // if |f(i) - i| = k, then there are only two possible numbers that
        // can be used f(i) = -(k-i) or f(i) = k + i, these are the only
        // two numbers that need to be considered
        val smallestPossible = -(k-i)
        val largestPossible = k + i

        when {
        // the smallest number has to be above 0 and not used
        // since k is strictly less than n, smallestPossible cannot be more than n
            smallestPossible > 0 && !hasBeenUsed[smallestPossible - 1] -> {
                answers[i - 1] = smallestPossible
                hasBeenUsed[smallestPossible - 1] = true
            }
        // largest needs to be below n and not used, cannot be less than 0 by design
            largestPossible <= n && !hasBeenUsed[largestPossible - 1] -> {
                answers[i - 1] = largestPossible
                hasBeenUsed[largestPossible - 1] = true
            }
            else -> return arrayOf(-1)
        }
    }

    return answers

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val nk = scan.nextLine().split(" ")

        val n = nk[0].trim().toInt()

        val k = nk[1].trim().toInt()

        val result = absolutePermutation(n, k)

        println(result.joinToString(" "))
    }
}
