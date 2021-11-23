package Generator

import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

object Gen01 {

  /** A generator can be seen simply as a function that takes some generation
    * parameters, and (maybe) returns a generated value.
    * ---> type `Gen[T]` may be thought of as a function of type `Gen.Params =>
    * Option[T]`
    */

  def main(args: Array[String]): Unit = {
    
    val myGen = for {
      n <- Gen.choose(10, 20)
      m <- Gen.choose(n + 2, 50)
    } yield (n, m)

    forAll(myGen) { case (n, m) => (m >= 2 * n) == true }.check()

  }
}
