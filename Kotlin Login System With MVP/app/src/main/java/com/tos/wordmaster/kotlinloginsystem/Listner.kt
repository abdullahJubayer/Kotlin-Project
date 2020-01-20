package com.tos.wordmaster.kotlinloginsystem

interface Listner {
    fun Success(message:String)
    fun Failed(error:String)
}