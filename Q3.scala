import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object fabbinocci {
    def main(args: Array[String]): Unit = {
        
        def fabbinocci_series(n:Int): Int = n match {
            case x if (x==0)=> 0
            case x if(x ==1) => 1
            case _ => fabbinocci_series(n-1)+ fabbinocci_series(n-2)
        }
        print("Enter the number to fabbinnoci: ")
        var a = readInt()
        println(s"The fibonacci of ${a} is : ${fabbinocci_series(a)}")

    }
}