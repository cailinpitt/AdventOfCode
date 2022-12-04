import java.io.File

// A for Rock, B for Paper, and C for Scissors
// X for Rock, Y for Paper, and Z for Scissors

fun main() {
  val rounds: List<List<String>> = File("./input.txt")
    .readLines()
    .map { it.split(" ") }
    .map { chooseShape(it) } // part 2

    println(rounds)

  val roundScores: List<Int> = rounds
    .map {
      roundResult(it[0], it[1]) + shapeResult(it[1])
    }

    println(roundScores)
    println(roundScores.sum())
}

fun roundResult(opponent: String, you: String): Int {
  return if (opponent == "A") {
    if (you == "X") {
      3
    } else if (you == "Y") {
      6
    } else {
      0
    }
  } else if (opponent == "B") {
    if (you == "X") {
      0
    } else if (you == "Y") {
      3
    } else {
      6
    }
  } else {
    if (you == "X") {
      6
    } else if (you == "Y") {
      0
    } else {
      3
    }
  }
}

fun shapeResult(you: String): Int {
  return when (you) {
    "X" -> 1
    "Y" -> 2
    "Z" -> 3
    else -> 0
  }
}

fun chooseShape(round: List<String>): List<String> {
  val choice: String
  val equivalent = mapOf("A" to "X", "B" to "Y", "C" to "Z")
  
  if (round[1] == "Y") {
    choice = equivalent[round[0]]!!
  } else if (round[1] == "X") {
    if (round[0] == "A") {
      choice = "Z"
    } else if (round[0] == "B") {
      choice = "X"
    } else {
      choice = "Y"
    }
  } else {
     if (round[0] == "A") {
      choice = "Y"
    } else if (round[0] == "B") {
      choice = "Z"
    } else {
      choice = "X"
    }
  }

  return listOf(round[0], choice)
}
