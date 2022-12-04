import java.io.File

fun main() {
  val commonLetters = mutableListOf<List<Char>>()
  val priorities = createPriorities()

  val compartments = File("./input.txt")
    .readLines()
    .chunked(3)
  
  compartments
    .forEach {
      val letters = mutableListOf<Char>()

      for (i in 0..it[0].length - 1) {
        if (it[1].contains(it[0][i]) && it[2].contains(it[0][i])) {
          letters.add(it[0][i])
        }
      }

      commonLetters.add(letters.distinct())
    }

var prioritySum: Int = 0

commonLetters
  .forEach {
    for (i in 0..it.size - 1) {
      prioritySum += priorities[it[i]]!!
    }
  }

  println(prioritySum)
}

fun createPriorities(): Map<Char, Int> {
  val priorities = mutableMapOf<Char, Int>()
  var letter: Char = 'a'

  for (i in 1..52) {
    priorities[letter] = i

    if (letter == 'z') {
      letter = 'A'
    } else {
      ++letter
    }
  }

  return priorities
}

/*
Part 1

fun main() {
  val commonLetters = mutableListOf<List<Char>>()
  val priorities = createPriorities()

  val compartments = File("./input.txt")
    .readLines()
    .map { it.chunked(it.length / 2) }
  
  compartments
    .forEach {
      val letters = mutableListOf<Char>()

      for (i in 0..it[0].length - 1) {
        if (it[1].contains(it[0][i])) {
          letters.add(it[0][i])
        }
      }

      commonLetters.add(letters.distinct())
    }

var prioritySum: Int = 0

commonLetters
  .forEach {
    for (i in 0..it.size - 1) {
      prioritySum += priorities[it[i]]!!
    }
  }

  println(prioritySum)
}
*/