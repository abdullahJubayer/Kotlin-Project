package com.tos.wordmaster.eventbusexample

import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkCall {

    fun getDataFromServer(){
        val call:Api=getRetrofitClient().create(Api::class.java)
        call.getData("https://raw.githubusercontent.com/hasancse91/EventBus-Android-Tutorial/master/Data/data.json").enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                EventBus.getDefault().post(DataModel("Main",t.message.toString()))
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                EventBus.getDefault().post(DataModel("Main",response.message()))
            }

        })
    }


    private fun getRetrofitClient(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}