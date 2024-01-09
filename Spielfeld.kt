package vierGewinnt
import java.awt.Color
import java.lang.Double.min

class Spielfeld {
    val anzZeilen = 6
    val anzSpalten = 7

    private val steine: Array<Array<SpielStein?>> = Array(anzZeilen) { row ->
        Array(anzSpalten) { col ->
            null
        }
    }

    private val maxX = 100.0
    private val maxY = 100.0

    private val breite = maxX / anzSpalten
    private val hoehe = maxY / anzZeilen

    private val feldGroesse = min(breite, hoehe)
    private val feldRadius = feldGroesse * 0.75 / 2.0
    private val steinRadius = feldRadius * 0.7

    private inline fun getXKoordinate(spalte: Int) = spalte*breite - breite/2.0
    private inline fun getYKoordinate(zeile: Int) = zeile*hoehe - hoehe/2.0

    fun zeichneFeld() {
        StdDraw.setXscale(0.0, maxX)
        StdDraw.setYscale(0.0, maxY)

        StdDraw.setPenColor(Color.BLACK)
        for(zeile in 1..anzZeilen)
            for(spalte in 1..anzSpalten)
                StdDraw.circle( getXKoordinate(spalte), getYKoordinate(zeile), feldRadius)
    }

    private fun zeichneSteine() {
        for(zeile in 1..anzZeilen)
            for(spalte in 1..anzSpalten) {
                if(steine[zeile-1][spalte-1] == null)
                    continue
                else
                    steine[zeile-1][spalte-1]!!.zeiche(getXKoordinate(spalte), getYKoordinate(zeile), steinRadius)
            }
    }

    fun setzeStein(spalte: Int, farbe: Boolean): Boolean {
        // gibt zurück, ob Stein gelegt werden konnte

        var freieZeile: Int? = null

        // Finde Zeile
        for(zeile in 1..anzZeilen) {
            if(steine[zeile-1][spalte-1] == null) {
                freieZeile = zeile
                break
            }
        }

        if(freieZeile == null)
            return false

        steine[freieZeile-1][spalte-1] = SpielStein(farbe)
        zeichneSteine()
        return true
    }
}