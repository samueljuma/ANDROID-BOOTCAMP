package gettingcracked.solidprinciples.lsp

interface Printer2 {
    fun print()
    fun scan()
}

class SimplePrinter2 : Printer2 {
    override fun print() {}
    override fun scan() {
        throw UnsupportedOperationException()
    }
}

interface Printer{
    fun print()
}

interface Scanner {
    fun scan()
}

open class PrinterScanner: Printer, Scanner {
    override fun print() {}
    override fun scan() {}
}