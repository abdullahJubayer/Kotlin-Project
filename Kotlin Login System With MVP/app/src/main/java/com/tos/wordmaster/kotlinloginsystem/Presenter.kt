package com.tos.wordmaster.kotlinloginsystem

class Presenter(private val view:MainActivityView,private val model:ModelInterface) : PresenterInterFace {

    override fun loginResult(email: String, pass: String) {
        model.login(email,pass, object : Listner {
            override fun Success(message: String) {
                view.SuccessMessage(message)
            }

            override fun Failed(error: String) {
                view.ErrorMessage(error)
            }
        })
    }

}