package main

interface IDictionary {
    fun add(word: String):Boolean
    fun find(word: String):Boolean
    fun size():Int

    companion object {
        const val FILE_PATH = "C:\\UNI\\3.1\\android\\kotlin-exercises\\labor-02\\src\\resources\\dict.txt"
    }
}