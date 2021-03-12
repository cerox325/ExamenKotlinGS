package com.example.examenandroid

import com.squareup.okhttp.Call
import retrofit2.http.GET
import retrofit2.http.Query
//
interface lastService {
    @GET("?api_key=ef3468d93176d04f563a91fd260d8807")
    fun getTitle(@Query("title") title: String): Call
    @GET("?api_key=ef3468d93176d04f563a91fd260d8807")
    fun getTagline(@Query("tagline") tagline: String): Call
    @GET("?api_key=ef3468d93176d04f563a91fd260d8807")
    fun getStatus(@Query("status") status: String): Call

}