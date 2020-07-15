package com.nokhyun.observer

class ScoreRecord : Subject() {
    // 해당 스코어 점수관리
    var scores = ArrayList<Int>()
    lateinit var scoreText: String

    // 점수를 추가하면 등록되어 있는 observer들을 전부 update
    fun addScore(score: Int) {
        scores.add(score)
        notifyObservers()
    }

    fun addScore(score: String){
        scoreText = score
        notifyObservers()
    }

}