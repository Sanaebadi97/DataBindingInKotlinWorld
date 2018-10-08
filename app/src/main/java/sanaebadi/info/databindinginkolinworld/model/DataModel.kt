package sanaebadi.info.databindinginkolinworld.model

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.databinding.BindingAdapter


data class DataModel(val imgProfile: String, val txtTitle: String,
                     val txtMessage: String)

@BindingAdapter("imgProfile")
fun loadImage(view: ImageView, imageUrl: String) {

    Glide.with(view.context)
            .load(imageUrl)
            .into(view)
}



