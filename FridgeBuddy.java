// import statements here
package GitHub-Introduction-Files
import java.util.Scanner;
import java.time.LocalDate;
// -----------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author INSERT AUTHOR NAME
 * @version Sep 24, 2026
 */

public class FridgeBuddy {

    // ~ Main Method ...........................................................
    public static void main(String[] args) {
        readFoodFile();
        System.out.println("hi");
    }
    
    
    // ~ Fields ................................................................
    private Fridge myFridge;
    private String foodFile;
    
    // ~ Public Methods ........................................................


    /*
     * Please add javadoc comments for all your methods,
     * even if they are self-explanatory!
     */
    /**
     * For javadoc comments, you can use the following tags
     * 
     * @param parameter
     *            Include parameter explanation
     * @return return value, and explanation if necessary
     * @throws if
     *             the method throws an
     */
/*
 * 
Method
main(String[] args) : void
Calls readFoodFile then loop that asks what the user wants to do and calls the corresponding FridgeBuddy method, once exits loop calls writeFoodFile
searchFood() : void
Prints to the terminal asking what food the user wants to look for and tells the user if it available
displayFood() : void
Prints to the terminals all the foods in the fridge in a nice method
addFood() : void
Ask users for name, description, and expiration and adds a corresponding Food object to Fridge
removeFood() : void
Asks user for name of food to remove,displays all of the food with same name and ask for which one
printExpiredFood() : void
Prints to the terminal all of the expired food
readFoodFile() : void
Reads a corresponding file and using information contained in to update Fridge object
writeFoodFile() : void
Uses information in Fridge and updates corresponding foodfile

 */
    public void searchFood() {
        
    }
    
    public void readFoodFile() {
        if (!foodfile.exists()) {
            File foodfile = new File(foodfile);
            return;
        }
        Scanner scanner = new Scanner(foodfile)
        while (scanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(scanner.nextLine());
            if(!lineScanner.hasNext()) {
                continue;
            }
            String name = lineScanner.next();
            LocalDateTime expiration = LocalDateTime.now();
            if(lineScanner.hasNext()) {
                String[] date = lineScanner.next().split("/");
                LocalDateTime expiration = LocalDateTime.now();
                LocalDateTime dateTime = LocalDateTime.of((int)date[2],(int)date[0],(int)date[1])
            }
            

        }
            String line = scanner.nextLine();
            myFridge.add();
            scanner.next()
    }
}
