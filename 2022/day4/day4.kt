import java.io.File

fun main() {

  val pairs: List<Int> = File("./input.txt")
    .readLines()
    .map { it.split(",") }
    .flatten()
    .map { it.split("-") }
    .flatten()
    .map{ it.toInt() }

  var partOneOverlaps: Int = 0
  for (i in 0..pairs.size - 1 step 4) {
    if (pairs[i] <= pairs[i + 2] && pairs[i + 1] >= pairs[i + 3]) {
      partOneOverlaps++
    } else if (pairs[i] >= pairs[i + 2] && pairs[i + 1] <= pairs[i + 3]) {
      partOneOverlaps++
    }
  }

  var partTwoOverlaps: Int = 0
  for (i in 0..pairs.size - 1 step 4) {
    if (pairs[i] <= pairs[i + 2] && pairs[i + 1] >= pairs[i + 3]) {
      partTwoOverlaps++
    } else if (pairs[i] >= pairs[i + 2] && pairs[i + 1] <= pairs[i + 3]) {
      partTwoOverlaps++
    } else if (pairs[i] <= pairs[i + 2] && pairs[i + 1] <= pairs[i + 3] && pairs[i + 1] >= pairs[i + 2]) {
      partTwoOverlaps++
    } else if (pairs[i] >= pairs[i + 2] && pairs[i + 1] >= pairs[i + 3] && pairs[i] <= pairs[i + 3]) {
      partTwoOverlaps++
    }
  }
  
  println("Part 1: $partOneOverlaps")
  println("Part 2: $partTwoOverlaps")
}