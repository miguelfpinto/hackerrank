package twodarray

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {

    val maxHourGlass = (1 until arr.size - 1).flatMap { row ->
        (1 until arr[0].size - 1).map { col ->
            sumHourGlass(arr, row, col)
        }
    }.max()

    return maxHourGlass!!
}

fun sumHourGlass(arr: Array<Array<Int>>, row:Int, col:Int): Int {
    return arr[row-1][col-1] + arr[row-1][col] + arr[row-1][col+1] +
            arr[row][col] +
            arr[row+1][col-1] + arr[row+1][col] + arr[row+1][col+1]
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
