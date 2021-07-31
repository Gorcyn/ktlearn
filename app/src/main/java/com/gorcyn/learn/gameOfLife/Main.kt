package com.gorcyn.learn.gameOfLife

class Main {

    fun next(grid: Array<IntArray>): Array<IntArray> {
        val next = Array(grid.size) { IntArray(grid.first().size) }
        next.forEachIndexed { x, row ->
            row.indices.forEach { y ->
                next[x][y] = if (isAlive(grid, x, y)) 1 else 0
            }
        }
        return next
    }

    private fun isAlive(grid: Array<IntArray>, x: Int, y: Int): Boolean {
        val search = intArrayOf(-1, 0, 1)
        var livingNeighbors: Int = -grid[x][y]
        search.forEach { horizontal ->
            search.forEach { vertical ->
                val searchX = x + horizontal
                val searchY = y + vertical
                livingNeighbors += if (!grid.indices.contains(searchX)) 0
                    else if (!grid[searchX].indices.contains(searchY)) 0
                    else grid[searchX][searchY]
            }
        }
        return when (grid[x][y]) {
            0 -> livingNeighbors == 3
            else -> livingNeighbors in 2..3
        }
    }
}
