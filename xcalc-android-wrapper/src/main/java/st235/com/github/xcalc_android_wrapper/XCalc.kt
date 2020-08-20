package st235.com.github.xcalc_android_wrapper

class XCalc {

    fun evaluate(input: String): String {
        return XCalcInternal.evaluate(input)
    }

}