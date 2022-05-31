package com.steve.twitterclone.ui.home

import androidx.lifecycle.ViewModel
import com.steve.twitterclone.model.Data
import com.steve.twitterclone.model.TweetItem

class HomeViewModel : ViewModel() {

    var scrollPosition: Int = 0
    fun getData(): ArrayList<TweetItem> {
        return Data.getTweets()
    }
}