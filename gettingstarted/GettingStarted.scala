object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n, 1)
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial value of %d is %d"
    msg.format(x, factorial(x))
  }

  // Excercise 2.1
  def fib(n: Int): Int = {
    val max = n
    def go(n: Int, x: Int, y: Int): Int =
      if (n < 2) x
      else go(n - 1, y, x + y)

    go(n, 0, 1)
  }

  private def formatFib(x: Int) = {
    val msg = "The fib value of %d is %d"
    msg.format(x, fib(x))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  // Excercise 2.2
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(x: A, xs: Array[A]): Boolean = {
      if (xs.isEmpty) true
      else if (ordered(x, xs.head)) loop(xs.head, xs.tail)
      else false
    }
    loop(as.head, as.tail)
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(5))
    println(formatFib(5))
    println(isSorted(Array(1, 2, 3, 4, 5), (a: Int, b: Int) => a <= b))
  }

}