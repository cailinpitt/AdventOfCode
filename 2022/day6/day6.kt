import java.io.File

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

fun main() {

  val file = File("/Users/cailin/Development/adventofcode/2022/day6/input.txt")
    .readText(Charsets.UTF_8)

  for (i in 0..file.length - 4) {
    val possibleMarker = "${file[i]}${file[i + 1]}${file[i + 2]}${file[i + 3]}"

    if (possibleMarker.allUnique()) {
      println("Part 1: ${i + 4}")
      break
    }
  }

  for (i in 0..file.length - 14) {
    val possibleMarker = file.substring(i, i + 14)

    if (possibleMarker.allUnique()) {
      println("Part 2: ${i + 14}")
      break
    }
  }
}
