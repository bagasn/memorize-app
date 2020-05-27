package me.bndev.memorizeapps.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_chunking_child.*
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.RecyclerChunkingNumberAdapter
import me.bndev.memorizeapps.model.LevelMod
import java.util.*

class ChunkingRandomNumber(var level: LevelMod) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chunking_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context, calculateColumnNumber(16f))
        recycler_chunking.layoutManager = layoutManager

        val adapter = RecyclerChunkingNumberAdapter(context, generateRandomNumber(level))
        recycler_chunking.adapter = adapter
    }

    fun generateRandomNumber(level: LevelMod): List<Int> {
        val listObject = mutableListOf<Int>()

        var r = Random()
        for (i in 0..level.numberOfObject) {
            listObject.add(r.nextInt(10))
        }

        return listObject
    }

    fun calculateColumnNumber(itemWidth: Float): Int {
        if (context == null)
            return 1

        val displayMetrics = recycler_chunking.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / itemWidth + 0.5).toInt()
    }
}