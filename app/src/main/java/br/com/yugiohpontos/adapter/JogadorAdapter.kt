package br.com.yugiohpontos.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohpontos.R

class JogadorAdapter(
    private val dataSet: List<Int>?
) : RecyclerView.Adapter<JogadorAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textInfo: TextView = view.findViewById(R.id.points1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hist_p1, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet?.get(position)
        item?.let {
            holder.textInfo.setTextColor(Color.RED)
        }
        holder.textInfo.text = item.toString()
    }

    override fun getItemCount() = dataSet!!.size

}