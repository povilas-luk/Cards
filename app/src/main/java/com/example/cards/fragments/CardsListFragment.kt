package com.example.cards.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cards.R
import com.example.cards.cards.CardData
import com.example.cards.cards.CardDataAdapter

class CardsListFragment : BaseMainActivityFragment(R.layout.fragment_cards_list) {

    private lateinit var cardDataAdapter: CardDataAdapter

    private val cardDataList: ArrayList<CardData>
        get() = mainActivity.cardDataList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            title = "Fruits"
        }

        cardDataAdapter = CardDataAdapter(cardDataList, mainActivity)
        val cardsRecyclerView: RecyclerView = view.findViewById(R.id.cardsRecyclerView)
        cardsRecyclerView.adapter = cardDataAdapter
    }

    /*override fun onResume() {
        super.onResume()
        //cardDataAdapter.notifyItemChanged(currentPosition)
    }*/

    fun onLikeClick(position: Int) {
        cardDataAdapter.notifyItemChanged(position)
    }
}