package signature

import kotlin.collections.ArrayList

class Converter {

    var lengthOfText = 0

    fun convert(text: CharArray, font: ArrayList<Symbol>): ArrayList<Symbol> {
        lengthOfText = 0
        val convertedText = ArrayList<Symbol>()
        for(ch in text) {
            for(sym in font) {
                if (ch == sym.name) {
                    convertedText.add(sym)
                    lengthOfText += sym.width
                }
            }
        }
        return convertedText
    }
}