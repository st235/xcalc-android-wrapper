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
        this.angleUnits = angleUnits
    }

    fun getAngleUnits(): AngleUnits {
        return angleUnits
    }

    fun evaluate(input: String): CalculationResult {
        return XCalcInternal.evaluate(angleUnits, input).toCalculationResult()
    }

    fun evaluateAsync(input: String, onSuccess: (output: String) -> Unit, onError: ((error: CalculationStatus) -> Unit)? = null) {
        backgroundThreadMarshaller.post(Runnable {
            val result = XCalcInternal.evaluate(angleUnits, input).toCalculationResult()

            mainThreadMarshaller.post(Runnable {
                val output = result.output
                if (output != null && result.calculationStatus == CalculationStatus.OK) {
                    onSuccess(output)
                } else {
                    onError?.invoke(result.calculationStatus)
                }
            })
        })
    }

}