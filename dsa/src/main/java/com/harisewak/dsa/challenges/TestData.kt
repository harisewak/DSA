package com.harisewak.dsa.challenges

import com.sun.org.apache.xpath.internal.operations.Bool


fun maxProfitArrays(): Array<IntArray> {
    return Array<IntArray>(7) { index ->
        when (index) {
            0 -> intArrayOf(8, 7, 4, 3, 1, 5)
            1 -> intArrayOf(5, 4, 3, 2, 1)
            2 -> intArrayOf(2, 1)
            3 -> intArrayOf(1)
            4 -> intArrayOf(7, 1, 5, 3, 6, 4)
            5 -> intArrayOf(2, 4, 1, 5)
            6 -> intArrayOf(2, 1, 2, 1, 0, 1, 2)
            else -> intArrayOf(0)
        }
    }
}

fun generatePossibleTowers(arr: IntArray, k: Int): Array<IntArray> {
    val size = arrSize(arr.size)
    val possibilities = Array<IntArray>(size) {
        IntArray(arr.size)
    }
    println("possibilities size ${size}")
    if (arr.size == 1) {
        val possArr1 = intArrayOf(arr[0] + k)
        val possArr2 = intArrayOf(arr[0] - k)
        possibilities[0] = possArr1
        possibilities[1] = possArr2
    }

    return possibilities
}

fun generatePossibleTowers3(arr: IntArray, k: Int): Array<IntArray> {

    val possibilities = Array(arrSize(arr.size)) {
        IntArray(arr.size)
    }

//    generatePossibilities(possibilities, arr, k, 0, 0)

    return possibilities
}

//fun generatePossibilities(possibilities: Array<IntArray>, arr: IntArray, k: Int) {
//    var index = 0
//    for (i in 0..1) {
//
//        for (j in 0..1) {
//
//            for (m in 0..1) {
//                val firstVal = if (i == 0) {
//                    arr[i] + k
//                } else {
//                    arr[i] - k
//                }
//
//                val secondVal = if (j == 0) {
//                    arr[j] + k
//                } else {
//                    arr[j] - k
//                }
//
//                val thirdVal = if (m == 0) {
//                    arr[m] + k
//                } else {
//                    arr[m] - k
//                }
//
//                println("possibility (last loop): ${possibilities[index].joinToString()}")
//                possibilities[index++] = intArrayOf(firstVal, secondVal, thirdVal)
//            }
//        }
//    }
//}

fun generatePossibilities(
    arr: IntArray,
    k: Int
): Array<IntArray> {
    val possibilities = Array(arrSize(arr.size)) {
        IntArray(arr.size) {
            -1
        }
    }
    for (i in possibilities.indices) {
        var temp = IntArray(arr.size)
        var isNegative = false
        for (j in arr.indices) {
            temp[j] = determineValue(possibilities.size, i, j, arr[j], k)
            if (temp[j] < 0) {
              isNegative = true
            }
        }

        if (!isNegative) {
            possibilities[i] = temp
        }

    }
    return possibilities
}

fun determineValue(total: Int, index: Int, position: Int, value: Int, k: Int): Int {
    var result = -1
    val alternateBetween = alternateCount(total, position)
    val quotient = (index + 1) / alternateBetween
    val remainder = (index + 1) % alternateBetween

    if (quotient % 2 == 0 && remainder == 0) {
        //    quotient is even & remainder is 0 = low
        result = value - k
    } else if (quotient % 2 == 0 && remainder > 0) {
        //    quotient is even & remainder > 0 = high
        result = value + k
    } else if (quotient % 2 != 0 && remainder == 0) {
        //    quotient is odd & remainder is 0 = high
        result = value + k
    } else if (quotient % 2 != 0 && remainder > 0) {
        //    quotient is odd & remainder > 0 = low
        result = value - k
    }

    return result
}

fun alternateCount(total: Int, position: Int): Int {
    var result = 1;
    for (i in 1..position + 1) {
        result *= 2
    }

    return total / result;
}


fun generatePossibleTowers2(arr: IntArray, k: Int): Array<IntArray> {

    val possibilities = Array(arrSize(arr.size)) {
        intArrayOf(arr.size)
    }

    var index = 0
    for (i in arr.indices) {
        val firstVal = if (i == 0) {
            arr[i] + k
        } else {
            arr[i] - k
        }

        for (j in arr.indices) {
            val secondVal = if (j == 0) {
                arr[j] + k
            } else {
                arr[j] - k
            }

            possibilities[index++] = intArrayOf(firstVal, secondVal)
        }
    }

    return possibilities
}


fun arrSize(size: Int): Int {
    var result = 1
    repeat(size) {
        result *= 2
    }
    return result
}

fun countDifferences(possibilities: Array<IntArray>): IntArray {
    val differences = IntArray(possibilities.size)

    for ((index, possibility) in possibilities.withIndex()) {
        var min = possibility[0]
        var max = possibility[0]
        possibility.forEach {
            if (it < min) {
                min = it
            } else if (it > max) {
                max = it
            }
        }
        val diff = max - min

        differences[index] = diff
    }

    return differences
}

fun main() {
    val generatePossibleTowers3 = generatePossibilities(intArrayOf(1, 5, 8, 10), 2)
    val differences = countDifferences(generatePossibleTowers3)
    generatePossibleTowers3.forEachIndexed { index, arr ->
        println("index: $index, possibility: ${arr.joinToString()}, difference: ${differences[index]}")
    }
//    val minDiff = minDifference(differences)
//    println("minDiff: $minDiff")
//
//    println("alternate count: ${alternateCount(8, 1)}")
}

fun minDifference(differences: IntArray): Int {
    var result = Integer.MAX_VALUE

    differences.forEach {
        if (it != 0 && it < result) {
            result = it
        }
    }

    return result
}

fun assertThat(product: Number, target: Number): Boolean {
    return product.toLong() == target.toLong()
}
