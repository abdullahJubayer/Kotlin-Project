package com.tos.wordmaster.eventbusexample

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    fun getData(@Url url: String):Call<ResponseBody>
}