package com.example.cards.cards

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cards.R
import com.squareup.picasso.Picasso

class CardDataAdapter(
    private val cardDataSet: ArrayList<CardData>,
    private val cardDataInterface: CardDataInterface,
): RecyclerView.Adapter<CardDataAdapter.CardDataViewHolder>() {

    inner class CardDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val likesImage: ImageView
        val title: TextView
        val description: TextView
        val moreButton: Button

        init {
            image = view.findViewById(R.id.cardImageImageView)
            likesImage = view.findViewById(R.id.likedImageView)
            title = view.findViewById(R.id.cardTitleTextVIew)
            description = view.findViewById(R.id.cardDescriptionShortTextView)
            moreButton = view.findViewById(R.id.cardMoreButton)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardDataViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_holder_card, viewGroup, false)

        return CardDataViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CardDataViewHolder, position: Int) {
        viewHolder.image.setImageResource(cardDataSet[position].imageId)
/*        Picasso.get()
            .load(cardDataSet[position].imageUrl)
            .into(viewHolder.image)*/

        viewHolder.title.text = cardDataSet[position].title
        viewHolder.description.text = cardDataSet[position].descriptionShort

        viewHolder.moreButton.setOnClickListener {
            cardDataInterface.onMoreButtonClick(position)
        }

        val likesIconId  = if(cardDataSet[position].isLiked) R.drawable.ic_favorite_24 else R.drawable.ic_favorite_border_24
        viewHolder.likesImage.setImageResource(likesIconId)
        viewHolder.likesImage.setColorFilter(R.color.red)
        viewHolder.likesImage.setOnClickListener {
            cardDataInterface.onLikedImageClick(position)
        }

    }

    override fun getItemCount() = cardDataSet.size

}