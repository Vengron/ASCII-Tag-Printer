package signature

import java.io.File
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter name and surname: ")
    val name = scanner.nextLine().trim().toCharArray()
    println("Enter person\'s status: ")
    val status = scanner.nextLine().trim().toUpperCase().toCharArray()
    scanner.close()
    val loader = FontLoader()
    val romanFont = loader.loadFont(
            File("roman.txt"))
    val mediumFont = loader.loadFont(
            File("medium.txt"))
    val converter = Converter()
    val printer = Printer()
    printer.printTable(converter.convert(name, romanFont),
            converter.lengthOfText,
            converter.convert(status, mediumFont),
            converter.lengthOfText)
}


