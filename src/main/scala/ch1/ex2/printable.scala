package ch1.ex2

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
  implicit val printableCat = new Printable[Cat] {
    override def format(value: Cat): String = s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat."
  }
}

object Printable {
  def format[A](value: A)(implicit printableInstance: Printable[A]): String = printableInstance.format(value)

  def print[A](value: A)(implicit printableInstance: Printable[A]): Unit = println(format(value))
}


object Main {

  import PrintableInstances._

  def main(args: Array[String]): Unit = {
    Printable.print("hi")
    Printable.print(10)
    Printable.print(Cat("Bob", 5, "RED"))
  }
}
