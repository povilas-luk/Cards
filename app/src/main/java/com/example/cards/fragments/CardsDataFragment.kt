package com.example.cards.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.example.cards.R
import com.example.cards.SharedPrefUtil
import com.example.cards.cards.CardData
import com.squareup.picasso.Picasso

class CardsDataFragment : BaseMainActivityFragment(R.layout.fragment_cards_data) {

    private val cardData: CardData by lazy {
        mainActivity.cardDataList.find {
            it.id == requireArguments().getString("cardDataId")
        }?: CardData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image: ImageView = view.findViewById(R.id.cardImageImageView)
        val title: TextView = view.findViewById(R.id.cardTitleTextVIew)
        val description: TextView = view.findViewById(R.id.cardDescriptionTextView)

        //image.setImageResource(cardData.imageId)
        Picasso.get()
            .load(cardData.imageUrl)
            .into(image)
        title.text = cardData.title
        description.text = cardData.descriptionLong

        setHasOptionsMenu(true)

        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            this.title = title.text.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_card_data_detail, menu)
        if (cardData.isLiked) {
            menu.findItem(R.id.likeMenuItem)?.setIcon(R.drawable.ic_favorite_24)
        }
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mainActivity.supportFragmentManager.popBackStack()
                true
            }
            R.id.shoppingCartMenuItem -> {
                val url = "http://www.google.com/search?q=buy+fruit+${cardData.id}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                true
            }
            R.id.likeMenuItem -> {
                val isLiked = cardData.isLiked
                if (!isLiked) {
                    item.setIcon(R.drawable.ic_favorite_24)
                } else {
                    item.setIcon(R.drawable.ic_favorite_border_24)
                }
                cardData.isLiked = !isLiked
                SharedPrefUtil.setCardDataLiked(cardData.id, cardData.isLiked)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}