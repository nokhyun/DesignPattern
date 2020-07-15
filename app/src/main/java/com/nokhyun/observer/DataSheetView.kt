package com.nokhyun.observer

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView

class DataSheetView(
    private val scoreRecord: ScoreRecord,
    private val llResult: LinearLayout,
    private val context: Context
) : Observer {

    companion object {
        private val TAG = DataSheetView::class.java.simpleName
    }

    override fun update() {
        Log.d(TAG, "update")
        val record = scoreRecord.scores
        displayScores(record)

        val recodeText = scoreRecord.scoreText
        displayScores(recodeText)
    }

    private fun displayScores(record: List<Int>) {
        for (element in record) {
            Log.d(TAG, "Score: $element  ")
        }

    }

    private fun displayScores(record: String){
        llResult.addView(createTextView(record))
    }

    private fun createTextView(scoreText: String): TextView {
        val tv = TextView(context)
        tv.text = scoreText
        return tv
    }


}