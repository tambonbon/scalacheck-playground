package Property

import org.scalacheck.Prop.forAll
import org.scalacheck.Gen

object Prop01 {

  /** A "property" is a testable unit
   * When you run check on the properties,
    ScalaCheck generates random instances of the function parameters and evaluates the results, reporting any failing cases.
    */

  val propConcatList = forAll { (list1: List[Int], list2: List[Int]) =>
    list1.size + list2.size == (list1 ::: list2).size
  }

  val propSqrt = forAll { (n: Int) => scala.math.sqrt(n * n) == n }

  def main(args: Array[String]): Unit = {
    propConcatList.check() // OK, passed 100 tests
    propSqrt.check() // Falsifie after 0 passted test: ARG_0: -1

    {
      forAll((s1: String, s2: String) => (s1 + s2).endsWith(s2) == true )
    }.check() // passed

    // A generator generates numbers from 0 to 100, inclusively
    // val smallInteger: Gen[Int] = Gen.choose(0, 100)
    // {
    //   forAll(smallInteger)(n => (n >= 0 && n <= 100) == false)
    // }.check()
  }

  
}
