package com.example.cards

import android.app.Application
import com.example.cards.cards.CardData

class CardsApplication: Application() {

    companion object {
        lateinit var application: CardsApplication

        //lateinit var cardDataList: ArrayList<CardData>
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        SharedPrefUtil.init(this)
    }
}