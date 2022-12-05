import java.io.File

fun main() {

  val file = File("./input.txt")
    .readText(Charsets.UTF_8)
    .split("\n\n")

  // had a hard time figuring out a good way to transform the starting crate state into a list of lists!
  val stacks: MutableList<MutableList<String>> = mutableListOf(
    mutableListOf("F", "T", "C", "L", "R", "P", "G", "Q"),
    mutableListOf("N", "Q", "H", "W", "R", "F", "S", "J"),
    mutableListOf("F", "B", "H", "W", "P", "M", "Q"),
    mutableListOf("V", "S", "T", "D", "F"),
    mutableListOf("Q", "L", "D", "W", "V", "F", "Z"),
    mutableListOf("Z", "C", "L", "S"),
    mutableListOf("Z", "B", "M", "V", "D", "F"),
    mutableListOf("T", "J", "B"),
    mutableListOf("Q", "N", "B", "G", "L", "S", "P", "H")
  )

  val moves = file[1]
    .split("\n")
    .map{ it.replace("move ", "") }
    .map{ it.replace(" from ", " ") }
    .map{ it.replace(" to ", " ") }
    .map{ it.split(" ") }
    .flatten()
    .map{ it.toInt() }
    .chunked(3)

  for (i in moves.indices) {
    val numCrates = moves[i][0]
    val toStack = moves[i][2] - 1
    val fromStack = moves[i][1] - 1

    val cratesToMove = mutableListOf<String>()

    for (j in 0 until numCrates) {
      val movedCrate = stacks[fromStack].removeLast()
      cratesToMove.add(movedCrate)
    }

    stacks[toStack].addAll(cratesToMove.reversed())
  }

  // Part 1
  // for (i in moves.indices) {
  //   val numCrates = moves[i][0]
  //
  //   for (j in 0 until numCrates) {
  //     val toStack = moves[i][2] - 1
  //     val fromStack = moves[i][1] - 1
  //
  //     // val fromIndex = lastNonNullIndex(stacks[fromStack])
  //     // val toIndex = lastNonNullIndex(stacks[toStack]) + 1
  //
  //     val movedCrate = stacks[fromStack].removeLast()
  //     stacks[toStack].add(movedCrate)
  //   }
  // }

  println(stacks)
}

fun lastNonNullIndex(list: List<String?>): Int {
  val index = list.size - 1

  if (list[list.size - 1] != null) {
    return index
  }

  for (i in list.size - 1 downTo 0) {
    if (list[i] != null) {
      return i
    }
  }

  return index
}
