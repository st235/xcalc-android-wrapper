package st235.com.github.xcalc_android_wrapper

internal object XCalcInternal {

    init {
        System.loadLibrary("native-lib")
    }

    @JvmStatic
    fun evaluate(angleUnits: AngleUnits, input: String): String {
        return evaluate(angleUnits.id, input)
    }

    @JvmStatic
    external fun evaluate(angleUnits: Int, input: String): String

}
