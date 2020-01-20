package com.tos.wordmaster.kotlinloginsystem

interface MainActivityView {
    fun SuccessMessage(msg:String)
    fun ErrorMessage(error:String)
}