package com.nokhyun.observer

abstract class Subject {
    private val observers = ArrayList<Observer>()

    // observer 추가
    fun attach(observer: Observer) {
        observers.add(observer)
    }

    // observer 삭제
    fun detach(observer: Observer){
        observers.remove(observer)
    }

    // 각 observer에 업데이트 요청.
    fun notifyObservers(){
        observers.forEach { it.update() }
    }
}