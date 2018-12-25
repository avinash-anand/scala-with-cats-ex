package ch1.ex5

import cats.Eq
import cats.instances.int._
import cats.instances.option._
import cats.instances.string._
import cats.syntax.eq._

//Exercise: Equality, Liberty, and Felinity
//Implement an instance of Eq for our running Cat example:
final case class Cat(name: String, age: Int, color: String)

object Main {

  implicit val catEquality: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.color === cat2.color
  }

  def main(args: Array[String]): Unit = {
    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")
    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]
    println(cat1 === cat2)
    println(cat1 =!= cat2)
    println(optionCat1 === optionCat2)
    println(optionCat1 =!= optionCat2)
  }
}
