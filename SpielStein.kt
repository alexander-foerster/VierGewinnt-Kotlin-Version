package vierGewinnt

import java.awt.Color

data class SpielStein(val istRot: Boolean) {
    fun zeiche(x: Double, y: Double, radius: Double) {
        if(istRot)
            StdDraw.setPenColor(Color.RED)
        else
            StdDraw.setPenColor(Color.YELLOW)

        StdDraw.filledCircle(x, y, radius)
    }
}