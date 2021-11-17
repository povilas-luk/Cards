package com.example.cards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.example.cards.*
import com.example.cards.cards.CardData
import com.example.cards.cards.CardDataInterface
import com.example.cards.fragments.CardsDataFragment
import com.example.cards.fragments.CardsListFragment

class MainActivity : AppCompatActivity(), CardDataInterface {

    lateinit var cardDataList: ArrayList<CardData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Cards"
        cardDataList = getFruitCardDataArrayList()

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, CardsListFragment())
            }
        }
    }

    override fun onMoreButtonClick(position: Int) {
        val cardData = cardDataList[position]
        val bundle = bundleOf("cardDataId" to cardData.id)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            setCustomAnimations(
                R.anim.fade_in,
                R.anim.fade_out,
            )
            replace(R.id.fragment_container_view, CardsDataFragment().apply {
                arguments = bundle
            })
        }
    }

    override fun onLikedImageClick(position: Int) {
        val cardData = cardDataList[position]
        cardData.isLiked = !cardData.isLiked

        (supportFragmentManager.fragments[0] as? CardsListFragment)?.onLikeClick(position)

        SharedPrefUtil.setCardDataLiked(cardData.id, cardData.isLiked)
    }

    private fun getFruitCardDataArrayList(): ArrayList<CardData> {
        return ArrayList<CardData>().apply {
            add(
                CardData(
                id = "apples",
                title = "Apples",
                descriptionShort = "Do you like apples?...",
                descriptionLong = "I hope you do like apples if you do go and buy them.",
                imageId = R.drawable.apples,
                imageUrl = "https://post.healthline.com/wp-content/uploads/2020/09/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail-1-732x549.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("apples")
            )
            )
            add(
                CardData(
                id = "bananas",
                title = "Bananas",
                descriptionShort = "Do you like bananas?...",
                descriptionLong = "I hope you do like bananas if you do go and buy them.",
                imageId = R.drawable.bananas,
                imageUrl = "https://images.everydayhealth.com/images/diet-nutrition/all-about-bananas-nutrition-facts-health-benefits-recipes-and-more-rm-722x406.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("bananas")
            )
            )
            add(
                CardData(
                id = "peaches",
                title = "Peaches",
                descriptionShort = "Do you like peaches?...",
                descriptionLong = "I hope you do like peaches if you do go and buy them.",
                imageId = R.drawable.peaches,
                imageUrl = "https://cdn.vox-cdn.com/thumbor/Ce-YQtYxMf1EHSd8R97n_CKrUiY=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/21811525/shutterstock_1307566264.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("peaches")

            )
            )
            add(
                CardData(
                id = "oranges",
                title = "Oranges",
                descriptionShort = "Do you like oranges?...",
                descriptionLong = "I hope you do like oranges if you do go and buy them.",
                imageId = R.drawable.oranges,
                imageUrl = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/half-of-orange-on-the-heap-of-oranges-royalty-free-image-1598525395.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("oranges")
            )
            )
            add(
                CardData(
                id = "strawberries",
                title = "Strawberries",
                descriptionShort = "Do you like strawberries?...",
                descriptionLong = "I hope you do like strawberries if you do go and buy them.",
                imageId = R.drawable.strawberries,
                imageUrl = "https://hips.hearstapps.com/clv.h-cdn.co/assets/15/22/1432664914-strawberry-facts1.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("strawberries")
            )
            )
            add(
                CardData(
                id = "pears",
                title = "Pears",
                descriptionShort = "Do you like pears?...",
                descriptionLong = "I hope you do like pears if you do go and buy them.",
                imageId = R.drawable.pears,
                imageUrl = "https://media.self.com/photos/5b6b0bd7ff2fab32610fafc2/16:9/w_4032,h_2268,c_limit/pears.jpg",
                isLiked = SharedPrefUtil.getCardDataLiked("pears")
            )
            )
        }

    }

}

