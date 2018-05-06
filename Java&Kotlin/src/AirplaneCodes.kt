import jdk.nashorn.internal.parser.JSONParser
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    print(getItinerary(arrayOf("{A:B}","{C:D}","{B:Z}","{Z:C}")))
}

fun getItinerary(flights: Array<String>) : String {
    val answer = LinkedList<String>()

    var formatted = flights.map { it -> it.replace("[{}]+".toRegex(),"").split(":") }
    val numberOfStops = formatted.size + 1

    answer.add(formatted[0][0])
    answer.add(formatted[0][1])
    formatted = formatted.drop(1)

    while (answer.size != numberOfStops) {
        var updated = false
        formatted.forEach {
            when {
                answer.last == it[0] -> {
                    answer.addLast(it[1])
                    updated = true
                }
                answer.first == it[1] -> {
                    answer.addFirst(it[0])
                    updated = true
                }
            }
        }

        if (!updated) return "Not Connected"
    }

    return answer.toString()
}