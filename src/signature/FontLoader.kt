package signature

import java.io.File
import java.util.Scanner
import kotlin.collections.ArrayList

class FontLoader {

    fun loadFont(file: File): ArrayList<Symbol> {
        val font = ArrayList<Symbol>()
        val scanner = Scanner(file)
        val height = scanner.nextInt()
        val number = scanner.nextLine().trim().toInt()
        repeat(number) {
            font.add(Symbol(scanner.next()[0],
                    scanner.nextLine().trim().toInt(),
                    Array(height) { scanner.nextLine() }))
        }
        scanner.close()
        font.add(createSpace(height, font[0].width))
        return font
    }

    private fun createSpace(height: Int, width: Int): Symbol {
        val sb = StringBuilder()
        repeat(width) {
            sb.append(" ")
        }
        return Symbol(' ', width, Array(height) {sb.toString()})
    }
}

data class Symbol(val name: Char, val width: Int, val symbol: Array<String>)
