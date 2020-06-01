package me.bndev.memorizeapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.IRecycler.OnSelectItemListener
import me.bndev.memorizeapps.adapter.RecyclerMainAdapter.MenuHolder

class RecyclerMainAdapter(
    private val context: Context,
    private val menuList: List<String>
) : RecyclerView.Adapter<MenuHolder>() {
    private var mListener: OnSelectItemListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.recycler_item_main_menu, parent, false)
        return MenuHolder(view)
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.textItem.text = menuList[position]
        holder.setOnClick(View.OnClickListener {
            if (mListener != null) {
                mListener!!.onSelectedItem(position)
            }
        })
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun setOnMenuClickListener(listener: OnSelectItemListener?) {
        mListener = listener
    }

    class MenuHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textItem: TextView = itemView.findViewById(R.id.text_item)
        fun setOnClick(listener: View.OnClickListener?) {
            itemView.setOnClickListener(listener)
        }

    }

}