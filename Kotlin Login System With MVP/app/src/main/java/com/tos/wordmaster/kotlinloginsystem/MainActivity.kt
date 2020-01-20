package com.tos.wordmaster.kotlinloginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainActivityView {
    private lateinit var model:ModelInterface
    private lateinit var presenter: PresenterInterFace
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model=Model()
        presenter=Presenter(this,model)

        login_btn.setOnClickListener {
            var email: String= email_et.text.toString()
            var password: String= pass_et.text.toString()
            presenter.loginResult(email,password)

        }
    }

    override fun ErrorMessage(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun SuccessMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
