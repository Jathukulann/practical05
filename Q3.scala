import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object fibonacci{
    def main(args: Array[String]): Unit = {
        
        def fibonacci_series(n:Int): Int = n match {
            case x if (x==0)=> 0
            case x if(x ==1) => 1
            case _ => fibonacci_series(n-1)+ fibonacci_series(n-2)
        }

        def printFibonacci(n:Int): Unit = {
            if (n>0) {printFibonacci(n-1)}
            print(s"${fibonacci_series(n)}, ")
            
        }
        print("Enter the number to fabbinnoci: ")
        var a = readInt()
        printFibonacci(a)
    }
}