package st235.com.github.xcalc_android

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import st235.com.github.xcalc_android_wrapper.AngleUnits
import st235.com.github.xcalc_android_wrapper.XCalc

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = XCalc(angleUnits = AngleUnits.DEG)

        angleUnitsSwitcher.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                calc.changeAngleUnits(angleUnits = AngleUnits.RADS)
            } else {
                calc.changeAngleUnits(angleUnits = AngleUnits.DEG)
            }
        }

        val adapter = CalcAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        inputField.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                val input = inputField.text.toString()
                inputField.setText("")
                val calcResult = CalcInfo(input, calc.evaluate(input))
                adapter.add(calcResult)

                return@setOnEditorActionListener true
            }

            false
        }
    }
}
