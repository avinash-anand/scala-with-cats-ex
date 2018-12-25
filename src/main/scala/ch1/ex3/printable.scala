package ch1.ex3

trait Printable[A] {
  def format(value: A): String
}

final case class Cat(name: String, age: Int, color: String)

object PrintableInstances {
  implicit val printableString = new Printable[String] {
    override def format(value: String): String = value
  }
  implicit val printableInt = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
  implicit val printableCat: Printable[Cat] = (value: Cat) => s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat."
}

object Printable {
  def format[A](value: A)(implicit printableInstance: Printable[A]): String = printableInstance.format(value)

  def print[A](value: A)(implicit printableInstance: Printable[A]): Unit = println(format(value))
}

object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = Printable.format(value)

    def print(implicit p: Printable[A]): Unit = Printable.print(value)
  }

}

object Main {

  import PrintableInstances._
  import PrintableSyntax._

  def main(args: Array[String]): Unit = {
    Printable.print("hi")
    Printable.print(10)
    val bob = Cat("Bob", 5, "RED")
    Printable.print(bob)
    bob.print
  }
}
