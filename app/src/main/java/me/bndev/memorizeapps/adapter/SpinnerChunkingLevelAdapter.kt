package me.bndev.memorizeapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.model.LevelMod

class SpinnerChunkingLevelAdapter(context: Context, objects: List<LevelMod?>) :
    ArrayAdapter<LevelMod?>(context, R.layout.spinner_item_view, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.spinner_item_view, parent, false)
        }
        val textContent = view!!.findViewById<TextView>(R.id.text_content)
        val level = getItem(position)
        if (level != null) {
            textContent.text = level.title
        } else {
            textContent.text = ""
        }
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.spinner_item_descriptions, parent, false)
        }
        val textContent = view!!.findViewById<TextView>(R.id.text_content)
        val textDescription = view!!.findViewById<TextView>(R.id.text_description)
        val level = getItem(position)
        if (level != null) {
            textContent.text = level.title

            val desc = "Number of value " + level.numberOfObject
            textDescription.text = desc
        } else {
            textContent.text = ""
            textDescription.text = ""
        }
        return view
    }
}