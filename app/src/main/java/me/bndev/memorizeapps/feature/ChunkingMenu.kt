package me.bndev.memorizeapps.feature

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chunking_menu.*
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.RecyclerChunkingMenuAdapter
import me.bndev.memorizeapps.model.ChunkingItem

class ChunkingMenu : AppCompatActivity() {

    private var objects = mutableListOf(
        ChunkingItem(
            1,
            "Random Word",
            "Generate random word",
            R.color.card_blue_background
        ),
        ChunkingItem(
            2,
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
        adapter.setOnSelectedItemListener { position ->
            onSelectedItem(position)
        }
        recycler_menu.adapter = adapter;
    }

    fun onSelectedItem(pos: Int) {
        when (pos) {
            0 -> Toast.makeText(this, objects[pos].title, Toast.LENGTH_SHORT).show()
            1 -> moveTo(objects[pos].id)
        }
    }

    fun moveTo(id: Int) {
        val intent = Intent(this, ChunkingPractice::class.java)
    }

}