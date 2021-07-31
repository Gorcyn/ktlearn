package com.gorcyn.learn.gameOfLife

import org.junit.Assert
import org.junit.Test

class MainTest {

    @Test
    fun `all dead should stay all dead`() = assert(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    ), arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    ))

    @Test
    fun `a square in a corner should stay there`() = assert(arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 0)
    ), arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 0)
    ))

    @Test
    fun `all alive should change to corners only`() = assert(arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1)
    ), arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1)
    ))

    @Test
    fun `middle row should change to middle column`() = assert(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 0)
    ), arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0)
    ))

    @Test
    fun `plus sign should change to all but center`() = assert(arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 0)
    ), arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
    ))

    @Test
    fun `5 by 5 X should change to inner square`() = assert(arrayOf(
        intArrayOf(1, 0, 0, 0, 1),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 1)
    ), arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
    ))

    //region utils
    private fun debug(name: String, grid: Array<IntArray>) = println("--- $name ---\n${grid.joinToString("\n") {
        "|${it.joinToString(" | ", " ", " ")}|"
    }}")

    private fun assert(grid: Array<IntArray>, expected: Array<IntArray>) {
        val main = Main()
        val result = main.next(grid)
        debug("expected", expected)
        debug("result", result)
        Assert.assertArrayEquals(expected, result)
    }
    //endregion
}
