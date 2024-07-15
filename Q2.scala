import scala.collection.mutable.Set
import scala.io.StdIn.{readLine, readInt}

object library_management {
  def main(args: Array[String]): Unit = {

    // Define a case class for Book
    case class Book(title: String, author: String, isbn: String)

    // Initially declared three books
    val book1 = Book("Programming in Scala", "Alvin Alexander", "12415124")
    val book2 = Book("The Colombo Town", "Kumara", "3421351")
    val book3 = Book("The Student", "Nimal", "77771111")

    val books: Set[Book] = Set(book1, book2, book3)

    // Adding new book to the system
    def getBook(): Unit = {
      val bookName = readLine("Enter the name of the book: ")
      val bookAuthor = readLine("Enter the author: ")
      val bookIsbn = readLine("Enter the ISBN of the book: ")

      // Check if the ISBN already exists
      if (books.exists(_.isbn == bookIsbn)) {
        println(s"A book with ISBN $bookIsbn already exists. Cannot add duplicate ISBN.")
      } else {
        val newBook = Book(bookName, bookAuthor, bookIsbn)
        books += newBook
        println(s"Book titled '$bookName' added successfully.")
      }
    }

    // Find book by ISBN
    def findBookIsbn(bookSet: Set[Book], bookIsbn: String): Option[Book] = {
      bookSet.find(_.isbn == bookIsbn)
    }

    // Search books by author name
    def searchBooksByAuthor(author: String): Set[Book] = {
      books.filter(_.author.equalsIgnoreCase(author))
    }

    // Search books by title
    def searchBooksByTitle(title: String): Set[Book] = {
      books.filter(_.title.equalsIgnoreCase(title))
    }

    // Print all books
    def printBooks(bookSet: Set[Book]): Unit = {
      if (bookSet.nonEmpty) {
        bookSet.foreach(book => println(s"Title: ${book.title} _ Author: ${book.author} _ ISBN: ${book.isbn}"))
      } else {
        println("No books found.")
      }
    }

    // Remove book by ISBN
    def removeBook(bookSet: Set[Book], isbn: String): Unit = {
      bookSet.find(_.isbn == isbn) match {
        case Some(book) => bookSet -= book
        case None => println(s"No book found with ISBN: $isbn")
      }
    }

    // User call to remove book
    def removeBookUserCall(): Unit = {
      val remIsbnNum = readLine("ISBN number of the book to be removed: ")
      removeBook(books, remIsbnNum)
      printBooks(books)
    }

    // User call to search books by author
    def searchBooksByAuthorUserCall(): Unit = {
      val authorName = readLine("Enter the author name: ")
      val foundBooks = searchBooksByAuthor(authorName)
      printBooks(foundBooks)
    }

    // User call to search books by title
    def searchBooksByTitleUserCall(): Unit = {
      val title = readLine("Enter the title: ")
      val foundBooks = searchBooksByTitle(title)
      printBooks(foundBooks)
    }

    // Main loop
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

    // Start the main loop
    mainLoop()
  }
}