package me.bndev.memorizeapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.RecyclerChunkingNumberAdapter.ChunkingHolder

class RecyclerChunkingNumberAdapter(
    private val context: Context,
    private val objects: List<Int>
) : RecyclerView.Adapter<ChunkingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChunkingHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.recycler_item_chunking_number, parent, false)
        return ChunkingHolder(view)
    }

    override fun onBindViewHolder(holder: ChunkingHolder, position: Int) {
        val value = objects[position].toString()
        holder.textItem.text = value
    }

    override fun getItemCount(): Int {
        return objects.size
    }

     class ChunkingHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textItem: TextView = itemView.findViewById(R.id.text_item)

     }

}