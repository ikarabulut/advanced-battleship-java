import java.util.ArrayList;

public class StartupBust {
  private GameHelper helper = new GameHelper(); // Create a private instance variable called helper that is creating a new GameHelper object
  private ArrayList<String> startups = new ArrayList<Startup>(); // Create a private instance variable called startups that is a new ArrayList object of Startup objects
  private int numOfGuesses = 0; // Create a private int instance variable called numOfGuesses and set it to 0

  private void setUpGame() {
    // create a private StartupBust method called setUpGame
    Startup one = new Startup(); // create a reference called one that points to a new Startup object
    one.setName("poniez"); // call setName method on the one Startup object and pass "poniez"
    Startup two = new Startup(); 
    two.setName("hacqi");
    Startup three = new Startup();
    three.setName("cabista");
    startups.add(one); // add the reference to the one Startup object and add it to the startups ArrayList
    startups.add(two);
    startups.add(three);

    system.out.println("Your goal is to sink three Startups."); // Print out instructions to the game in the Command line
    system.out.println("poniez, hacqi, cabista");
    system.out.println("Try to sink them all in the fewest number of guesses");

    for (Startup startup : startups) { // go through the startups ArrayList with each position named startup and a Startup object
      ArrayList<String> newLocation = helper.placeStartup(3); // create an ArrayList object called newLocation and place the return from the helper method called placeStartup
      startup.setLocationCells(newLocation); // call the setLocationCells and pass the newLocation ArrayList object
    }
  }

  private void startPlaying() {
    // create a private StartupBust method called startPlaying
    while (!startups.isEmpty()) {
      // while the startups ArrayList is not empty
      String userGuess = helper.getUserInput("Enter a guess"); // create a String variable called userGuess and set it to the return value when the helper method getUserInput is called
      checkUserGuess(userGuess); // pass the userGuess variable to the checkUserGuess StartupBust method
    }
    finishGame(); // call the finishGame StartupBust method if the startups ArrayList is empty
  }

  private void checkUserGuess(String userGuess) {
    // create a private StartupBust method called checkUserGuess that takes in a String argument named userGuess
    numOfGuesses++; //increment numOfGuesses by 1 each time checkUserGuess is called
    String result = "miss"; // create a String variable named result and set it to miss
    
    for (Startup startupToTest : startups) {
      // go through each postion in the startups ArrayList and name each position startupToTest
      result = startupToTest.checkYourself(userGuess); // set the result variable to the return value from calling the Startup method checkYourself by passing the userGuess argument
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        startups.remove(startupToTest);
        break;
      }
    }
    System.out.println(result);
  }

  private void finishGame() {
    System.out.println("All Startups are dead! Your stock is now worthless");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options");
    }
  }

  public static void main(String[] args) {
    StartupBust game = new StartupBust();
    game.setUpGame();
    game.startPlaying();
  }
}




