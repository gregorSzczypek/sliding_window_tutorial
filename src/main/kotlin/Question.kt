class Question (var question: String, // question
                var answer: String, // right answer
                var slidingWindow: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0) // sliding window
) {

    fun askQuestionCheckAnswer(): Boolean {
        print(question) // print question
        println("  yes/no") // complete question string
        val userAnswer = readln() // read user input

        return userAnswer == this.answer // userAnswer equals correct answer or not - true/false
    }
}