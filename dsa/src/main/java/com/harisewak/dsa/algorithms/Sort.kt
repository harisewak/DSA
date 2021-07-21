package com.harisewak.dsa.algorithms

object Sort {

    /*
        * Select an element as pivot
        * arrange elements such that elements less or equals to pivot are ahead of it and greater are after it
        * Take the left half and right half array and follow the same procedure
        * 4, 1, 5, 4, 3
        * */

    @JvmStatic
    fun quickSort(arr: IntArray, start: Int, end: Int): IntArray {
        //println("Sorting from $start to $end")

        if (start >= end) {
            return arr
        }

        var pivotIndex = start // 0
        var next = pivotIndex + 1 // 1
        while (next <= arr.lastIndex) { // true
            if (arr[next] < arr[pivotIndex]) { // 3 <= 4
                val temp = arr[next] // 3
                arr[next] = arr[pivotIndex] // 4
                arr[pivotIndex] = temp // 3
                pivotIndex = next // 4
                next = pivotIndex + 1 // 5
            } else {
                next++ //
            }
        }

        quickSort(arr, start, pivotIndex - 1)
        quickSort(arr, pivotIndex+1, end)

        return arr
    }

    @JvmStatic
    fun mergeSort(arr: IntArray, start: Int, end: Int): IntArray {
        if (start == end) {
            return arr
        }
        if (start == end - 1) {
            if (arr[0] > arr[1]) {
                arr[0] = arr[1]
                arr[1] = arr[0]
            }
            return arr
        }

        val mid: Int = arr.size / 2
        var firstHalf: IntArray = returnArray(arr, start, mid)
        firstHalf = mergeSort(firstHalf, 0, firstHalf.size - 1) //

        var secondHalf: IntArray = returnArray(arr, mid + 1, end)
        secondHalf = mergeSort(secondHalf, 0, secondHalf.size - 1)
        var firstCursor = 0
        var secondCursor = 0
        var finalCursor = 0
        val finalArr = IntArray(firstHalf.size + secondHalf.size) { -1 }

        while (firstCursor < firstHalf.size && secondCursor < secondHalf.size) {
            if (firstHalf[firstCursor] < secondHalf[secondCursor]) {
                finalArr[finalCursor] = firstHalf[firstCursor]
                firstCursor++
            } else {
                finalArr[finalCursor] = secondHalf[secondCursor]
                secondCursor++
            }
            finalCursor++
        }

        while (firstCursor < firstHalf.size) {
            finalArr[finalCursor] = firstHalf[firstCursor]
            firstCursor++
            finalCursor++
        }

        while (secondCursor < secondHalf.size) {
            finalArr[finalCursor] = secondHalf[secondCursor]
            secondCursor++
            finalCursor++
        }

        return finalArr
    }

    @JvmStatic
    fun findInversionCount(arr: IntArray, start: Int, end: Int, inversionCount: Int = 0): Int {
        var inversionCountUpdated = inversionCount
        if (start == end) {
            return inversionCountUpdated
        }
        if (start == end - 1) {
            if (arr[0] > arr[1]) {
                arr[0] = arr[1]
                arr[1] = arr[0]
                inversionCountUpdated++
            }
            return inversionCountUpdated
        }

        val mid: Int = arr.size / 2
        var firstHalf: IntArray = returnArray(arr, start, mid)
        inversionCountUpdated = findInversionCount(firstHalf, 0, firstHalf.size - 1, inversionCountUpdated)

        var secondHalf: IntArray = returnArray(arr, mid + 1, end)
        inversionCountUpdated = findInversionCount(secondHalf, 0, secondHalf.size - 1, inversionCountUpdated)
        var firstCursor = 0
        var secondCursor = 0
        var finalCursor = 0
        val finalArr = IntArray(firstHalf.size + secondHalf.size) { -1 }

        while (firstCursor < firstHalf.size && secondCursor < secondHalf.size) {
            if (firstHalf[firstCursor] < secondHalf[secondCursor]) {
                finalArr[finalCursor] = firstHalf[firstCursor]
                firstCursor++
            } else {
                finalArr[finalCursor] = secondHalf[secondCursor]
                secondCursor++
                inversionCountUpdated++
            }
            finalCursor++
        }

        while (firstCursor < firstHalf.size) {
            finalArr[finalCursor] = firstHalf[firstCursor]
            firstCursor++
            finalCursor++
        }

        while (secondCursor < secondHalf.size) {
            finalArr[finalCursor] = secondHalf[secondCursor]
            secondCursor++
            finalCursor++
        }

        return inversionCountUpdated
    }

    fun returnArray(arr: IntArray, l: Int, r: Int): IntArray {
        var left = l
        val size = r - left + 1
        val result = IntArray(size) { -1 }
        var i = 0
        while (i < size) {
            result[i] = arr[left]
            i++
            left++
        }
        return result
    }
}