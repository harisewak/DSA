package com.harisewak.todo

import kotlin.math.absoluteValue

val list = listOf(2, 5, 7, 8, 3)
val strings = listOf("Hi", "Hello", "How're are you?", "What's up!")


    fun main() {

        val value: String? = null
        val newVal = value ?: throw NotImplementedError("value is empty")
        println("newVal: $newVal")
    }

    fun <T> List<T>.customFilter(filterFunction: (T) -> Boolean): List<T> {
        val list = mutableListOf<T>()
        for (value in this) {
            if (filterFunction(value)) {
                list.add(value)
            }
        }
        return list
    }
