package vierGewinnt

import inputMethods.readInt

fun main(args: Array<String>) {
    var rotIstAmZug = false
    val spielfeld = Spielfeld()
    spielfeld.zeichneFeld()

    while(true) {
        val spalte = readIntWithBounds(1, spielfeld.anzSpalten, "Bitte Spalte eingeben: ")
        val erfolg = spielfeld.setzeStein(spalte, rotIstAmZug)

        if(!erfolg) {
            println()
            println("FEHLER: Spalte ist voll")
            println("Bitte noch einmal versuchen!")
            continue
        } else
            rotIstAmZug = !rotIstAmZug
    }
}

fun readIntWithBounds(minVal: Int, maxVal: Int, frageText: String) : Int {
    var error: Boolean
    var retVal: Int

    do {
        print(frageText)
        retVal = readInt()

        error = retVal > maxVal || retVal < minVal
        if(error) {
            println("FEHLER: Wert muss zwischen ${minVal} und ${maxVal} liegen.")
            println("Bitte noch einmal eingeben!")
        }
    } while (error)

    return retVal
}

