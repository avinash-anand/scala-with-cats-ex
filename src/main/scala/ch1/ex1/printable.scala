package ch1.ex1

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val printableString = new Printable[String] {
    override def format(value: String): String = value
  }
  implicit val printableInt = new Printable[Int] {
    override def format(value: Int): String = value.toString
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
  }
}
