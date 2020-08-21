package st235.com.github.xcalc_android_wrapper

import st235.com.github.xcalc_android_wrapper.utils.BackgroundThreadMarshaller
import st235.com.github.xcalc_android_wrapper.utils.MainThreadMarshaller
import st235.com.github.xcalc_android_wrapper.utils.ThreadMarshaller

class XCalc(
    private var angleUnits: AngleUnits
) {

    private val mainThreadMarshaller: ThreadMarshaller = MainThreadMarshaller()
    private val backgroundThreadMarshaller: ThreadMarshaller = BackgroundThreadMarshaller()

    fun changeAngleUnits(angleUnits: AngleUnits) {
        this.angleUnits = angleUnits;
    }

    fun evaluate(input: String): String {
        return XCalcInternal.evaluate(angleUnits, input)
    }

    fun evaluateAsync(input: String, callback: (output: String) -> Unit) {
        backgroundThreadMarshaller.post(Runnable {
            val output = XCalcInternal.evaluate(angleUnits, input)

            mainThreadMarshaller.post(Runnable {
                callback(output)
            })
        })
    }

}