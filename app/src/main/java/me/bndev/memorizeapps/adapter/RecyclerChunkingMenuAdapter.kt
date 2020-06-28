package me.bndev.memorizeapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.IRecycler.OnSelectItemListener
import me.bndev.memorizeapps.adapter.RecyclerChunkingMenuAdapter.ChunkinHolder
import me.bndev.memorizeapps.model.ChunkingItem

class RecyclerChunkingMenuAdapter(private val context: Context, private val chunkingList: List<ChunkingItem>)
    : RecyclerView.Adapter<ChunkinHolder>() {

    private var mListener: OnSelectItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChunkinHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.recycler_item_chunking_menu, parent, false)
        return ChunkinHolder(view)
    }

    override fun onBindViewHolder(holder: ChunkinHolder, position: Int) {
        val item = chunkingList[position]
        holder.textTitle.text = item.title
        holder.textDescription.text = item.description
        holder.cardContainer.setCardBackgroundColor(context.getColor(item.color))
        holder.setupClickAction(View.OnClickListener {
            if (mListener != null) {
                mListener!!.onSelectedItem(position)
            }
        })
    }

    override fun getItemCount(): Int {
        return chunkingList.size
    }

    fun setOnSelectedItemListener(listener: OnSelectItemListener?) {
        mListener = listener
    }

    class ChunkinHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textTitle: TextView = itemView.findViewById(R.id.text_title)
        val textDescription: TextView = itemView.findViewById(R.id.text_description)
        val cardContainer: CardView = itemView.findViewById(R.id.card_container)

        fun setupClickAction(listener: View.OnClickListener?) {
            cardContainer.setOnClickListener(listener)
        }
    }

}