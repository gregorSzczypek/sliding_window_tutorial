fun main() {
    val question = Question("Are you a human?", "yes") // create Question instance (can be whatever)
    var confidence = 0.0 // variable for confidence, we're gonna save the confidence here

    println("Hello to sliding window tutorial!\n") // welcome text
    println("We are going to calculate how confident you are being a human based on ten questions")

    for (i in 0..9) { // ask question 10 times to fill the sliding window
        println("Answer following question:")

        val result = question.askQuestionCheckAnswer() // call method and save result
        question.slidingWindow.removeAt(0) // remove oldest entry from sliding window

        if (result) { // if the result is correct (expression is already true or false no need for "== true")
            question.slidingWindow.add(1) // add 1 to last position of list (weight of right answer)
        } else { // if the result is false (answer incorrect)
            question.slidingWindow.add(-1) // adjust your result by adding 0 or -1 (weight of wrong answer)
        }

        println("Current sliding window: ${question.slidingWindow}") // show current sliding window

        // Calculate average of sliding window
        confidence =
            question.slidingWindow.average() * 100 // times 100 because we only have 10 entries and each is value 1
        println("Your confidence is: $confidence%\n") // print current confidence
    }
    println("You are $confidence% sure that you are human!") // print final confidence
}