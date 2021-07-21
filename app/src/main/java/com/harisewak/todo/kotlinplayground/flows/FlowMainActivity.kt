package com.harisewak.todo.kotlinplayground.flows

import android.app.Activity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

const val TAG = "FlowMainActivity"

class FlowMainActivity: Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flow = flow {
            for (i in 1..10) {
                emit(i)
                delay(1000L)
            }
        }

        GlobalScope.launch {
            flow.buffer(2000000).filter {
                it % 2 == 0
            }.map {
                it * it
            }.collect {
                println(it)
                delay(1000L)
            }
        }
    }

    suspend fun helloWorld(): String {
        return "Hello World!"
    }

}