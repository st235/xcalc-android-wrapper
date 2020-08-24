package st235.com.github.xcalc_android_wrapper

import st235.com.github.xcalc_android_wrapper.CalculationStatus.Companion.toCalculationStatus

typealias RawOutput = String

internal val ERROR_MATCHER = Regex("error\\(([\\d*])\\).*")

data class CalculationResult(
    val output: String?,
    val calculationStatus: CalculationStatus
)

internal fun RawOutput.toCalculationResult(): CalculationResult {
    val match = ERROR_MATCHER.find(this)

    if (match == null) {
        return CalculationResult(this, CalculationStatus.OK)
    }

    val (code) = match.destructured
    return CalculationResult(null, code.toInt().toCalculationStatus())
}
