package com.demoapp.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demoapp.R
import com.niravjoshi.proof_of_concept.concepts.model.FeedDetailDTO
import com.niravjoshi.proof_of_concept.concepts.model.FeedsDTO
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_feed_layout.view.*

class MainAdapter(
    private val feedDetailDTO: ArrayList<FeedDetailDTO>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(feedsDetailDTO: FeedDetailDTO) {
            itemView.tv_title.text = feedsDetailDTO.mTitle
            itemView.tv_desc.text = feedsDetailDTO.mDescription
            Glide.with(itemView.appCompatImageView.context)
                .load(feedsDetailDTO.mImageUrl)
                .into(itemView.appCompatImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_feed_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = feedDetailDTO.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(feedDetailDTO.get(position))

    fun addData(list: ArrayList<FeedDetailDTO>) {
        feedDetailDTO.addAll(list)
    }

}