package Generator

import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

object Gen02 {

  /** `oneOf` method creates a generator that randomly picks one of its
    * parameters each time it generates a value
    */

  val vowel = Gen.oneOf('A', 'E', 'I', 'O', 'U')

  val validChars: Seq[Char] = Seq('A', 'I')

  def main(args: Array[String]): Unit = {
    forAll(vowel) { v => validChars.contains(v) }.check() // failed, E
  }
  
}
