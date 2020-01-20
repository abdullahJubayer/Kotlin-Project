package com.tos.wordmaster.kotlinloginsystem

class Model : ModelInterface {
    override fun login(email: String, pass: String, listner: Listner) {
        if (email == "abc@gmail.com" && pass == "123456"){
            listner.Success("Login Success")
        }else{
            listner.Failed("Login Failed")
        }
    }
}