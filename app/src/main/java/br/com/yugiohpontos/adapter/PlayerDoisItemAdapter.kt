package br.com.yugiohpontos.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohpontos.R

class PlayerDoisItemAdapter(
    private val dataSet: List<String>
) : RecyclerView.Adapter<PlayerDoisItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textInfo: TextView = view.findViewById(R.id.points2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hist_p2, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        if (item.contains("-")){
            holder.textInfo.setTextColor(Color.RED)
        } else {
            holder.textInfo.setTextColor(Color.BLUE)
        }
        holder.textInfo.text = item
    }

    override fun getItemCount() = dataSet.size

}