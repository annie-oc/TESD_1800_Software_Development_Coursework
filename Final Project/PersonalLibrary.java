// Author: Annie O'Connor
// Date: 9.18.26

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PersonalLibraryTwo extends Application {

   // box to add a new book:
    TextField tfNewTitle = new TextField();
   // box to add the author of that new book:
    TextField tfNewAuthor = new TextField();
   // button to save it:
    Button btAddBook = new Button ("Add Book");
   // box to add a new name for a borrower:
    TextField tfNewBorrower = new TextField();
   // button to save their name:
    Button btAddBorrower = new Button("Add Borrower");

    // one for books:
    ObservableList<Book> books = FXCollections.observableArrayList();
    // and one for borrowers:
    ObservableList<Borrower> borrowers = FXCollections.observableArrayList();

    // a list to show all the books you've saved and if they're available:
    ListView<Book> lvBooks = new ListView<>();
    // a dropdown to choose who will be borrowing that book:
    ComboBox<Borrower> cbBorrowers = new ComboBox<>();

    // one to check out a book:
    Button btOUT = new Button("Check Out");
    // and one to check in a book:
    Button btIN = new Button("Check In");

  @Override // override the start method in the application class
  public void start(Stage stage) {

      // connect the list and dropdown to our data
      lvBooks.setItems(books);
      cbBorrowers.setItems(borrowers);

      // set the height of the book list
      lvBooks.setPrefHeight(220);

      // create a way to add a book
      HBox addBookBox = new HBox(8,
              new Label("Title: "), tfNewTitle,
              new Label("Author: "), tfNewAuthor,
              btAddBook
      );

      // align everything to the left
      addBookBox.setAlignment(Pos.CENTER_LEFT);

      // create a way to add a borrower of that book
      HBox addBorrowerBox = new HBox(8,
              new Label("Borrower: "), tfNewBorrower,
              btAddBorrower
      );

      // create a way to checkin/checkout that book with that specific person
      HBox checkoutBox = new HBox(8,
              new Label("With: "), cbBorrowers,
              btOUT, btIN
      );

      // align checkout controls to the right
      checkoutBox.setAlignment(Pos.CENTER_RIGHT);

      // stack everything vertically on the screen
      VBox root = new VBox(10,
              addBookBox,
              addBorrowerBox,
              new Label("Books: "),
              lvBooks,
              checkoutBox
      );

      // add space around the outside of the window
      root.setPadding(new Insets(10));

      // tell the buttons what to do when they're clicked
      btAddBook.setOnAction(e -> handleBook()); // add the typed book to the list
      btAddBorrower.setOnAction(e -> handleAddBorrower()); // add the typed person to the list
      btOUT.setOnAction(e -> handleCheckOut()); // mark selected book as borrowed
      btIN.setOnAction(e -> handleCheckIn()); // mark selected book as returned

      // enable/disable buttons based on selection/state
      lvBooks.getSelectionModel().selectedItemProperty().addListener(
          (obs, oldV, newV) -> updateButtons());
      cbBorrowers.valueProperty().addListener((obs, oldV, newV) -> updateButtons());
      updateButtons(); // set the buttons to their correct starting state

      // show window
      Scene scene = new Scene(root, 650, 420);
      stage.setTitle("My Personal Library");
      stage.setScene(scene);
      stage.show();
  }

  /* when 'add book' is clicked, the program will read the title and author
   * from the text boxes, if both are filled in, then it will make a new book
   * and add it to the list
   * then it will clear the text boxes for the next entry
   */
  private void handleBook() {
      String title = tfNewTitle.getText().trim();
      String author = tfNewAuthor.getText().trim();

      if (title.isEmpty() || author.isEmpty()) {
          showInfo("Please enter a title and an author");
          return;
      }

      books.add(new Book(title, author));
      tfNewTitle.clear();
      tfNewAuthor.clear();
      updateButtons();
  }

  /* when 'add borrower' is clicked the program will read the name
   * if the it's a new name and the space is not empty it will add them
   * to the list of borrowers
   */
  private void handleAddBorrower() {
      String name = tfNewBorrower.getText().trim();
    
      if (name.isEmpty()) {
          showInfo("Please enter borrower's name");
          return;
      }

      // basic duplicate check w/o streams
      for (Borrower b : borrowers) {
          if (b.getName().equalsIgnoreCase(name)) {
              showInfo("That borrower already exists");
              return;
          }
      }

      borrowers.add(new Borrower(name));
      tfNewBorrower.clear();
      updateButtons();
  }

  /* when 'check out' is clicked the program will look at the selected book
   * and the selected borrower
   * if the book is available it will be marked as OUT to that person
   */
  private void handleCheckOut() {
      Book sel = lvBooks.getSelectionModel().getSelectedItem();
      Borrower bor = cbBorrowers.getValue();

      if (sel == null || bor == null) return;

      if (sel.getBorrower() != null) {
          showInfo("This book is already checked out");
          return;
      }

      sel.setBorrower(bor); // now the book remembers who has it
      lvBooks.refresh(); // update how the book looks in the list
      updateButtons(); // fix which buttons are enabled
  }

  /* when 'check in' is clicked the program will see if the selected book is out
   * if it is, the program will mark it as available again
   */
  private void handleCheckIn() {
      Book sel = lvBooks.getSelectionModel().getSelectedItem();

      if (sel == null) return;

      if (sel.getBorrower() == null) {
          showInfo("This book is not checked out");
          return;
      }

      sel.setBorrower(null); // says nobody has it now
      lvBooks.refresh(); // updates the list display
      updateButtons(); // fixes which buttons are enabled
  }

  // using smart buttons so you can't choose the wrong thing:
  // 'check out' only works if a book is selected, it's available, and a borrower is picked
  // 'check in' only works if a book is selected and it's currently checked out
  private void updateButtons() {
      Book sel = lvBooks.getSelectionModel().getSelectedItem();
      Borrower bor = cbBorrowers.getValue();

      boolean canOUT = sel != null&& sel.getBorrower() == null && bor != null;
      boolean canIN = sel != null && sel.getBorrower() != null;

      btOUT.setDisable(!canOUT);
      btIN.setDisable(!canIN);
  }

  // shows a message if the user forgets something or does something invalid
  private void showInfo(String message) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
      alert.setHeaderText(null);
      alert.setTitle("Info");
      alert.showAndWait();
  }

  // starts the JavaFX app
  public static void main(String[] args) {
      launch(args);
  }

  // borrower = person with a name
  // toString() = returns the name so the combo box shows it
  public static class Borrower {
      private String name;

      public Borrower(String name) {
          this.name = name;
      }

      public String getName() { return name; }

      @Override
      public String toString() {
          return name;
      }
  }

  // a book can now know its title, author, and it's borrower
  public static class Book {
      private String title;
      private String author;
      private Borrower borrower; // null means available

      public Book(String title, String author) {
          this.title = title;
          this.author = author;
      }

      public String getTitle() { return title; }
      public String getAuthor() { return author; }
      public Borrower getBorrower() { return borrower; }
      public void setBorrower(Borrower b) { this.borrower = b; }

      // this controls how the book appears as text in the list view
      @Override
      public String toString() {
    
          if (borrower == null) {
              return title + " - " + author + " [Available]";
          } else {
              return title + " - " + author + " [OUT to " + borrower.getName() + "]";
          }
        }
    }
}
