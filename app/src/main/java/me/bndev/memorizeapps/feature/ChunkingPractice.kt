package me.bndev.memorizeapps.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_chunking_practice.*
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.SpinnerChunkingLevelAdapter
import me.bndev.memorizeapps.app.IActivity
import me.bndev.memorizeapps.fragment.ChunkingRandomNumber
import me.bndev.memorizeapps.model.ChunkingEnum
import me.bndev.memorizeapps.model.LevelMod

class ChunkingPractice : IActivity() {

    private val levelList = mutableListOf<LevelMod>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chunking_practice)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setLevelUntil(15)
        spinner_level.adapter = SpinnerChunkingLevelAdapter(this, levelList)

        button_start.setOnClickListener {
            spinner_level.isEnabled = false
            button_start.isEnabled = false

            actionStartButton()
        }
    }

    fun actionStartButton() {
        val chunkinType = intent.getSerializableExtra("chunking-id") as? ChunkingEnum
        val level = spinner_level.selectedItem as? LevelMod

        val tr = supportFragmentManager.beginTransaction()
        var fragment: Fragment? = null

        when (chunkinType) {
            ChunkingEnum.NUMBER -> fragment = ChunkingRandomNumber(level!!)
        }

        if (fragment != null) {
            tr.add(R.id.frame_content, fragment)
            tr.disallowAddToBackStack()
            tr.commit()
        }
    }

    fun setLevelUntil(until: Int) {
        for (i in 1..until) {
            val level = LevelMod()
            level.level = i
            level.title = "Level $i"

            var n = 12

            for (j in 1..i) {
                n += n
            }

            level.numberOfObject = n / 2

            levelList.add(level)
        }
    }

}