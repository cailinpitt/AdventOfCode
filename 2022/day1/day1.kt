import java.io.File

fun main() {
  val caloriesPerElf = mutableListOf<MutableList<Int>>()
  var elf = mutableListOf<Int>()

  File("./input.txt")
    .readLines()
    .forEach {
      if (it != "") {
        elf.add(it.toInt())
      } else {
        caloriesPerElf.add(elf)
        elf = mutableListOf<Int>()
      }
    }

    val sortedMaxCaloriesPerElves = caloriesPerElf
    .map{ it.sum() }
    .sortedDescending()

  println(sortedMaxCaloriesPerElves[0])
  println(sortedMaxCaloriesPerElves[0] + sortedMaxCaloriesPerElves[1] + sortedMaxCaloriesPerElves[2])
}
