package com.tos.wordmaster.eventbusexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: DataModel) {
        if (event.eventName == "Main"){
            Toast.makeText(this,event.data,Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,event.data,Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getData(view: View) {
        val networkCall=NetworkCall()
        networkCall.getDataFromServer()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

}
