import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object inventory_management {
    def main(args: Array[String]): Unit ={
        

        def getProductList(itemList: List[String]): List[String] = {
            val word = readLine("Enter string or 'done' to stop adding list: ")
            word match {
                case "done" => itemList
                case _ => getProductList(itemList :+ word)
            }
        }

        def printProductList(itemList:List[String],index: Int = 1): Any = if(!itemList.isEmpty)
            {println(s"$index => ${itemList.head}");printProductList(itemList.tail,index + 1)}

        def getTotalProducts(itemList:List[String]): Unit = {
            println(s"The total number of list entered is: ${itemList.length}")

        }

        val initialList = List[String]()
        val productList = getProductList(initialList)
        printProductList(productList)

        getTotalProducts(productList)



    }
}