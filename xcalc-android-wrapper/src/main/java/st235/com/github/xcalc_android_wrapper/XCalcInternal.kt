package st235.com.github.xcalc_android_wrapper

internal object XCalcInternal {

    init {
        System.loadLibrary("native-lib")
    }

    @JvmStatic
    external fun evaluate(input: String): String

}
