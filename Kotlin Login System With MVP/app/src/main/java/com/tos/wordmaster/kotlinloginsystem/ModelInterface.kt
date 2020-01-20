package com.tos.wordmaster.kotlinloginsystem

interface ModelInterface {
    fun login(email:String,pass:String,listner: Listner)
}