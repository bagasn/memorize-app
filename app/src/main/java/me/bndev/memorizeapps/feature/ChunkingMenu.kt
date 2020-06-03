package me.bndev.memorizeapps.feature

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chunking_menu.*
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.IRecycler
import me.bndev.memorizeapps.adapter.RecyclerChunkingMenuAdapter
import me.bndev.memorizeapps.app.IActivity
import me.bndev.memorizeapps.model.ChunkingEnum
import me.bndev.memorizeapps.model.ChunkingItem

class ChunkingMenu : IActivity() {

    private var objects = mutableListOf(
        ChunkingItem(
            ChunkingEnum.WORD,
            "Random Word",
            "Generate random word",
            R.color.card_blue_background
        ),
        ChunkingItem(
            ChunkingEnum.NUMBER,
            "Random Number",
            "Generate random number",
            R.color.card_green_background
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chunking_menu)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = RecyclerChunkingMenuAdapter(this, objects)
        adapter.setOnSelectedItemListener (IRecycler.OnSelectItemListener { pos: Int ->
            onSelectedItem(pos)
        })
        recycler_menu.adapter = adapter;
    }

    fun onSelectedItem(pos: Int) {
        when (pos) {
            0 -> Toast.makeText(this, objects[pos].title, Toast.LENGTH_SHORT).show()
            1 -> moveTo(objects[pos].id)
        }
    }

    fun moveTo(id: ChunkingEnum?) {
        val intent = Intent(this, ChunkingPractice::class.java)
        intent.putExtra("chunking-id", id);
        startActivity(intent)
    }

}