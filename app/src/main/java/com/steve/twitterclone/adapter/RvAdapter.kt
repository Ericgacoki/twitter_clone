package com.steve.twitterclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.steve.twitterclone.R
import com.steve.twitterclone.databinding.PostListItemBinding
import com.steve.twitterclone.model.TweetItem

class RvAdapter(val tweets: ArrayList<TweetItem>) : RecyclerView.Adapter<RvAdapter.TweetViewHolder>() {

    inner class TweetViewHolder(val tweet:PostListItemBinding):RecyclerView.ViewHolder(tweet.root){
        fun bind(tweetItem: TweetItem){
            tweet.ivProfile.setImageResource(tweetItem.profileImage!!)
            tweet.tvName.text = tweetItem.userName
            tweet.tvUserName.text = tweetItem.userTag
            tweet.tvDescription.text = tweetItem.tweetDesc
            tweet.ivPost.setImageResource(tweetItem.postImage!!)

            tweet.tvReply.text = tweetItem.replyCount.toString()
            tweet.tvRetweet.text = tweetItem.retweetCount.toString()
            tweet.tvLikeFalse.text = tweetItem.likeCount.toString()
            tweet.tvShare.text = tweetItem.shareCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {

        return TweetViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))

    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.bind(tweets[position])
    }

    override fun getItemCount(): Int {
        return tweets.size

    }
}