package com.example.cards.fragments

import androidx.fragment.app.Fragment
import com.example.cards.activities.MainActivity

abstract class BaseMainActivityFragment(layoutId: Int): Fragment(layoutId) {

    val mainActivity: MainActivity by lazy { activity as MainActivity }

    fun setActionBarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }
}