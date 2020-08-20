package st235.com.github.xcalc_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_calculation_item.view.*

class CalcAdapter: RecyclerView.Adapter<CalcAdapter.ViewHolder>() {

    private val items = mutableListOf<CalcInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.content_calculation_item, parent, false)
        return ViewHolder(view)
    }

    fun add(calcInfo: CalcInfo) {
        items.add(calcInfo)
        notifyItemInserted(items.size - 1)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val input = itemView.input
        val output = itemView.output

        fun bind(calcInfo: CalcInfo) {
            input.text = calcInfo.input
            output.text = calcInfo.output
        }
    }
}