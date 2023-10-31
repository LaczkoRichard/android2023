package main

class ItemController(private val itemService: ItemService) {

    fun quiz(numberOfItems: Int) {
        val questions: List<Item> = itemService.selectRandomItems(numberOfItems)
        var numberOfCorrectAnsweres = 0

        for ((i, q) in questions.withIndex()) {
            println("${i + 1}. ${q.question}")
            for ((j, a) in q.answers.withIndex()) {
                println("${j + 1}) $a")
            }
            print("Answer: ")
            val answer: String? = readLine()
            val correct = q.correct.toString()
            if (answer == correct) {
                println("-----☺-----\nCorrect\n-----☺-----")
                numberOfCorrectAnsweres++
            } else {
                println("-----☹-----\nWrong\n-----☹-----")
                println("The correct Answer is: $correct\n---------------------------")
            }
        }

        println("✰ You got $numberOfCorrectAnsweres out of $numberOfItems correct ✰\n---------------------------")
    }
}