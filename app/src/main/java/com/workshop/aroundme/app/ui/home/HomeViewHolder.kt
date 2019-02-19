package com.workshop.aroundme.app.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.PlaceEntity

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView = itemView.findViewById<TextView>(R.id.name)
    private val addressTextView = itemView.findViewById<TextView>(R.id.address)
    private val likesTextView = itemView.findViewById<TextView>(R.id.likes)
    private val likesContainer = itemView.findViewById<View>(R.id.likesContainer)
    private val image = itemView.findViewById<ImageView>(R.id.image)

    fun bind(placeEntity: PlaceEntity) {
        nameTextView.text = placeEntity.name
        addressTextView.text = placeEntity.address
        likesTextView.text = placeEntity.likes.toString()

        Picasso.get().load(placeEntity.imageUrl).into(image)

        likesContainer.visibility = if (placeEntity.likes != null && placeEntity.likes > 0) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}