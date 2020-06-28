package me.bndev.memorizeapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import me.bndev.memorizeapps.adapter.IRecycler
import me.bndev.memorizeapps.adapter.RecyclerMainAdapter
import me.bndev.memorizeapps.feature.ChunkingMenu
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    val menuList = mutableListOf(
        "Chunking"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_main_menu)

        val adapter = RecyclerMainAdapter(this, menuList)
        adapter.setOnMenuClickListener(IRecycler.OnSelectItemListener { pos: Int ->
            onItemSelected(pos)
        })
        recycler_menu.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.action_setting -> throw RuntimeException("Test Crash")
        }
        return super.onOptionsItemSelected(item)
    }

    fun onItemSelected(pos: Int) {
        when (pos) {
            // Chunking
            0 -> moveTo(Intent(this, ChunkingMenu::class.java))
        }
    }

    fun moveTo(intent: Intent) {
        startActivity(intent)
    }

}
