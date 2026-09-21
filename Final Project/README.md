# My Personal Library

## This project helps avid readers keep track of their book collection. Who is currently borrowing the book and which books are back on their shelf.

## I built this code because as an avid reader myself I find it difficult to remember who of my friends I lent my books to. If they are in the system as 'checked in' then I know I've simply just misplaced the book and it is not in use.

## I am especially proud of this section of the code:
      '''// tell the buttons what to do when they're clicked
      btAddBook.setOnAction(e -> handleBook()); // add the typed book to the list
      btAddBorrower.setOnAction(e -> handleAddBorrower()); // add the typed person to the list
      btOUT.setOnAction(e -> handleCheckOut()); // mark selected book as borrowed
      btIN.setOnAction(e -> handleCheckIn()); // mark selected book as returned

      // enable/disable buttons based on selection/state
      lvBooks.getSelectionModel().selectedItemProperty().addListener(
          (obs, oldV, newV) -> updateButtons());
      cbBorrowers.valueProperty().addListener((obs, oldV, newV) -> updateButtons());
      updateButtons(); // set the buttons to their correct starting state'''

## I have been using JUnit4 to test the code

## My professor, Jason Adams, instructed me after I built the initial code on how to fix some bugs.
