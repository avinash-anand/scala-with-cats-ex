package ch1.ex4

final case class Cat(name: String, age: Int, color: String)


object Main {

  import cats.Show
  import cats.instances.int._
  import cats.instances.string._
  import cats.syntax.show._

  def main(args: Array[String]): Unit = {
    implicit val catShow: Show[Cat] = Show.show[Cat] { t => s"${t.name.show} is a ${t.age.show} year-old ${t.color.show} cat."
    }
    val bob = Cat("Bob", 5, "RED")
    println(bob.show)
  }
}
