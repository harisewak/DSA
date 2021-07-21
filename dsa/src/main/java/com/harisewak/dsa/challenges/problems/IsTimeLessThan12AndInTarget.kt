package com.harisewak.dsa.challenges.problems


    fun isCorrect(start: Int, end: Int, target: Int): Boolean {

        val hourDiff: Int
        val inBetween: Boolean

        if (end - start < 0) {
            hourDiff = (24 - start) + end
            inBetween = target < end
        } else {
            hourDiff = end - start
            inBetween = (target > start) && (target < end)
        }

        if (hourDiff < 12 && inBetween) {
            return true
        }

        return false
    }
