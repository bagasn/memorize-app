package me.bndev.memorizeapps.fragment

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_chunking_child.*
import me.bndev.memorizeapps.R
import me.bndev.memorizeapps.adapter.RecyclerChunkingNumberAdapter
import me.bndev.memorizeapps.app.database.table.ChunkingTable
import me.bndev.memorizeapps.feature.ChunkingInputObject
import me.bndev.memorizeapps.model.LevelMod
import me.bndev.memorizeapps.utils.DatabaseManager
import java.util.*

class ChunkingRandomNumber(private val level: LevelMod) : Fragment() {

    var mTimeStarting: Long? = null
    var numberList: List<Int>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chunking_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context!!, calculateColumnNumber(16f))
        recycler_chunking.layoutManager = layoutManager

        numberList = generateRandomNumber(level)
        val adapter = RecyclerChunkingNumberAdapter(context!!, numberList!!)
        recycler_chunking.adapter = adapter

        button_next.setOnClickListener {
            val timeFinished = System.currentTimeMillis()
            val realTime = timeFinished - mTimeStarting!!

            val hour = realTime / 3600000
            val minute = realTime / 60000
            val seconds = realTime / 1000

            val timeValue = convertToString(hour, minute, seconds)

            insertToTableChunking(timeValue)
        }

        mTimeStarting = System.currentTimeMillis()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            activity!!.finish()
        }
    }

    private fun insertToTableChunking(timeRemember: String) {
        val contentValues = ContentValues()

        contentValues.put(ChunkingTable.colGenerateObject, convertToString(numberList!!))
//        contentValues.put(ChunkingTable.colInputObject, "")
        contentValues.put(ChunkingTable.colChunkingType, "number")
//        contentValues.put(ChunkingTable.colPercentageOfCorrect, "")
        contentValues.put(ChunkingTable.colTimeToRemember, timeRemember)
        contentValues.put(ChunkingTable.colLevel, level.level.toString())
        contentValues.put(ChunkingTable.colNumberOfObject, level.numberOfObject.toString())

        val insertId = DatabaseManager.init(context)
            .insert(ChunkingTable.tableName, contentValues)

        if (insertId != -1L) {
            val intent = Intent(context, ChunkingInputObject::class.java)
            intent.putExtra("id", insertId)
            intent.putExtra("chunking-type", "number")
            startActivity(intent)

            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun generateRandomNumber(level: LevelMod): List<Int> {
        val listObject = mutableListOf<Int>()

        var r = Random()
        for (i in 0..level.numberOfObject) {
            listObject.add(r.nextInt(10))
        }

        return listObject
    }

    private fun calculateColumnNumber(itemWidth: Float): Int {
        if (context == null)
            return 1

        val displayMetrics = recycler_chunking.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / itemWidth + 0.5).toInt()
    }

    private fun convertToString(hour: Long, minute: Long, seconds: Long): String {
        var text = ""
        if (hour < 10)
            text += "0$hour"
        else
            text += "$hour"

        if (minute < 10)
            text += "0$minute"
        else
            text += "$minute"

        if (seconds < 10)
            text += "0$seconds"
        else
            text += "$seconds"

        return text
    }

    private fun convertToString(numbers: List<Int>): String {
        var text = ""
        for (i in numbers.indices) {
            val value = numbers[i].toString()
            text += value

            if (i != numbers.size - 1) {
                text += ", "
            }
        }

        return text
    }

}