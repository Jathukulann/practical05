import scala.collection.mutable.Set
import scala.io.StdIn.{readLine, readInt}

object library_management {
  def main(args: Array[String]): Unit = {

    // Define a case class for Book
    case class Book(title: String, author: String, isbn: String)

    
    val book1 = Book("Programming in Scala", "Alvin Alexander", "12415124")
    val book2 = Book("The Colombo Town", "Kumara", "3421351")
    val book3 = Book("The Student", "Nimal", "77771111")

    val books: Set[Book] = Set(book1, book2, book3)

    
    def getBook(): Unit = {
      val bookName = readLine("Enter the name of the book: ")
      val bookAuthor = readLine("Enter the author: ")
      val bookIsbn = readLine("Enter the ISBN of the book: ")

      
      if (books.exists(_.isbn == bookIsbn)) {
        println(s"A book with ISBN $bookIsbn already exists. Cannot add duplicate ISBN.")
      } else {
        val newBook = Book(bookName, bookAuthor, bookIsbn)
        books += newBook
        println(s"Book titled '$bookName' added successfully.")
      }
    }

    
    def findBookIsbn(bookSet: Set[Book], bookIsbn: String): Option[Book] = {
      bookSet.find(_.isbn == bookIsbn)
    }

    
    def searchBooksByAuthor(author: String): Set[Book] = {
      books.filter(_.author.equalsIgnoreCase(author))
    }

    
    def searchBooksByTitle(title: String): Set[Book] = {
      books.filter(_.title.equalsIgnoreCase(title))
    }

   
    def printBooks(bookSet: Set[Book]): Unit = {
      if (bookSet.nonEmpty) {
        bookSet.foreach(book => println(s"Title: ${book.title} _ Author: ${book.author} _ ISBN: ${book.isbn}"))
      } else {
        println("No books found.")
      }
    }

    
    def removeBook(bookSet: Set[Book], isbn: String): Unit = {
      bookSet.find(_.isbn == isbn) match {
        case Some(book) => bookSet -= book
        case None => println(s"No book found with ISBN: $isbn")
      }
    }

    
    def removeBookUserCall(): Unit = {
      val remIsbnNum = readLine("ISBN number of the book to be removed: ")
      removeBook(books, remIsbnNum)
      printBooks(books)
    }

    
    def searchBooksByAuthorUserCall(): Unit = {
      val authorName = readLine("Enter the author name: ")
      val foundBooks = searchBooksByAuthor(authorName)
      printBooks(foundBooks)
    }

    
    def searchBooksByTitleUserCall(): Unit = {
      val title = readLine("Enter the title: ")
      val foundBooks = searchBooksByTitle(title)
      printBooks(foundBooks)
    }

    
    def mainLoop(): Unit = {
      var continue = true
      while (continue) {
        println("\nLibrary Management System")
        println("1. Add a book")
        println("2. Remove a book")
        println("3. Display books")
        println("4. Search books by author")
        println("5. Search books by title")
        println("6. Exit")
        val choice = readInt()
        choice match {
          case 1 =>
            getBook()
          case 2 =>
            removeBookUserCall()
          case 3 =>
            printBooks(books)
          case 4 =>
            searchBooksByAuthorUserCall()
          case 5 =>
            searchBooksByTitleUserCall()
          case 6 =>
            continue = false
          case _ =>
            println("Invalid choice! Please try again.")
        }
      }
    }

    
    mainLoop()
  }
}