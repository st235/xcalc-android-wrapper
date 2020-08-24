package st235.com.github.xcalc_android_wrapper

enum class CalculationStatus(
    internal val id: Int
) {
    OK(-1),
    DIVIDE_BY_ZERO(0),
    CONST_NOT_FOUND(1),
    FUNCTION_NOT_FOUND(2),
    ARITHMETIC_ERROR(3),
    NO_SUCH_OPERATOR(4),
    SYNTAX_ERROR(5);

    companion object {

        internal fun Int.toCalculationStatus() =
            values().find { it.id == this } ?: throw IllegalArgumentException("Cant find error status")
    }
}
