package com.nokhyun.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var scoreRecord: ScoreRecord
    private lateinit var dataSheetView: DataSheetView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        scoreTestInit()

        setListener()
        init()
    }

    private fun init(){
        // Subject를 상속받은 class (Observer관리)
        scoreRecord = ScoreRecord()

        // constructor scoreRecord parameter로 넘김. (스코어 List가 있음)
        // 추가로 add버튼으로 추가했을때 뷰에 추가를 위해 Layout도 같이 넘겨줌.
        dataSheetView = DataSheetView(scoreRecord, ll_result, this@MainActivity)

        // dataSheetView observer에 추가.(연결)
        scoreRecord.attach(dataSheetView)

    }

    private fun setListener(){
        bt_add.setOnClickListener {
            scoreRecord.addScore(et_score.text.toString())
        }
    }

    private fun scoreTestInit(){
        val scoreRecord = ScoreRecord()

        val dataSheetView = DataSheetView(scoreRecord, ll_result, this@MainActivity)
        scoreRecord.attach(dataSheetView)

        scoreRecord.addScore(3)
        // update 호출되면서 로그 출력.

        // observer연결해제
        scoreRecord.detach(dataSheetView)
        // 미출력
        scoreRecord.addScore(6)


    }
}