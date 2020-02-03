package signature

import kotlin.math.abs

class Printer {

    private var widthOfTable: Int = 8
    private var difference: Int = 0
    private var printSpace = true

    fun printTable(name: ArrayList<Symbol>,
                   lengthOfName: Int,
                   status: ArrayList<Symbol>,
                   lengthOfStatus: Int) {
        determineWidth(lengthOfName, lengthOfStatus)
        printBorder()
        printText(name)
        printText(status)
        printBorder()
    }

    private fun printText(text: ArrayList<Symbol>) {
        var indexOfRow = 0
        val height = text[0].symbol.size
        while (indexOfRow < height) {
            print("88  ")
            printSpaces()
            for (i in text.indices) {
                print(text[i].symbol[indexOfRow])
            }
            printSpaces()
            if (difference % 2 == 1 && printSpace) print(" ")
            println("  88")
            ++indexOfRow
        }
        printSpace = !printSpace
    }

    private fun printSpaces() {
        if(printSpace) {
            repeat(difference / 2) {
                print(" ")
            }
        }
    }

    private fun printBorder() {
        repeat(widthOfTable) {
            print("8")
        }
        println()
    }

    private fun determineWidth(lengthOfName: Int, lengthOfStatus: Int) {
        widthOfTable += if (lengthOfName >= lengthOfStatus) lengthOfName else lengthOfStatus
        difference = abs(lengthOfName - lengthOfStatus)
        printSpace = lengthOfName - lengthOfStatus < 0
    }
}
