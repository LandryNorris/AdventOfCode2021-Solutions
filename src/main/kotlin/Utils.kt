
fun List<Int>.bitArrayToInt() = joinToString(separator = "") { it.toString() }.toInt(2)

fun <T> List<T>.filterIf(condition: Boolean, predicate: (T) -> Boolean) = if(condition) filter(predicate) else this