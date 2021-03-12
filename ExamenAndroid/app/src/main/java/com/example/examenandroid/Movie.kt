package com.example.examenandroid

import com.google.gson.annotations.SerializedName

class Movie(title:String, tagline:String, status:String) {

    var title:String = ""
    var tagline:String = ""
    var status:String = ""
    init {
        this.title = title
        this.tagline = tagline
        this.status = status
    }
}

