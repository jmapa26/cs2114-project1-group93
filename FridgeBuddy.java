// import statements here
package GitHub-Introduction-Files

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
// -----------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author INSERT AUTHOR NAME
 * @version Sep 24, 2026
 */

public class FridgeBuddy
{

    // ~ Main Method ...........................................................
    // Calls readFoodFile then loop that asks what the user wants to do and
    // calls the corresponding FridgeBuddy method, once exits loop calls
    // writeFoodFile
    public static void main(String[] args)
    {
        while(True) {
        readFoodFile();
        Scanner scanner = new Scanner(System.in);
        int validOption = 0;
        While ( validOption<1 || validOption>5){
        System.out.println("What do you want to do: ");
        System.out.println("Option 1, look for a food");
        System.out.println("Option 2, display all food");
        System.out.println("Option 3, add a food");
        System.out.println("Option 4, remove a food");
        System.out.println("Option 5, display all expired food");
        System.out.println("Just enter the number of the option you want to choose");
        String validOption = (int) scanner.nextLine();
        }
        
        switch (validOption) {
            case 1:
                searchFood();
                break;
            case 2:
                displayFood();
                break;
            case 3:
                addFood();
                break;
            case 4:
                removeFood();
                break;
            case 5:
                printExpiredFood();
        }
      }
    }

    // ~ Fields ................................................................
    private Fridge myFridge;
    private static Final String FOOD_FILE;
    private Scanner scanner;


    // ~ Public Methods ........................................................

    /*
     * Please add javadoc comments for all your methods, even if they are
     * self-explanatory!
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
// Prints to the terminal asking what food the user wants to look for and tells
// the user if it available
    public void searchFood()
    {
        System.out.println("What food are you looking for?");
        String foodname = scanner.nextLine();
        ArrayList<Food> foods = new ArrayList<>();
        for(Food food : myFridge.toArray()) {
            if(food.getName() == userFood) {
                foods.add(food);
            }
        }
        While(foods.size() ==0){
            System.out.println("That foods does not exist, try another");
            String foodname = scanner.nextLine();
            for(Food food : myFridge.toArray()) {
                if(food.getName() == userFood) {
                    foods.add(food);
                }
            }
        }
        System.out.println("All foods with the same name");
        for(Food food: foods) {
            System.out.println("\nFood " + (String) i + ":");
            System.out.println("Name: "+ food.getName());
            System.out.println("Expiration: "+ food.getExpirationDate().format(formatter))
            System.out.println("Description: "+ food.getDescription());
        }
    }


    // Prints to the terminals all the foods in the fridge in a nice method
    public void displayFood()
    {
        Food[] foods = myFridge.toArray();
        System.out.println("Here are all the Foods:")
        for(Food food: foods) {
            System.out.println("\n"+food.getName() + "will expire on: " + food.getExpirationDate.toLocalDate().toString());
            System.out.println(food.getDescription());
        }
    }


    // Ask users for name, description, and expiration and adds a corresponding
    // Food object to Fridge
    public void addFood()
    {
        System.out.println("What should be the name of the food (no spaces)")
        String name = scanner.nextLine();
        while (name.contains(" ")) {
            System.out.println("Your food name included a space, try again. (Maybe use underscores instead of spaces")
            String name = scanner.nextLine();
        }
        

    }


    // Asks user for name of food to remove,displays all of the food with same
    // name and ask for which one
    public void removeFood()
    {
        System.println("What is the name of the food you want to remove?");
        String userFood = scanner.nextLine();
        ArrayList<Food> foods = new ArrayList<>();
        for(Food food : myFridge.toArray()) {
            if(food.getName() == userFood) {
                foods.add(food);
            }
        }
        while(foods.size()==0) {
            System.out.println("No food appeared with that name try again");
            String userFood = scanner.nextLine();
            for(Food food : myFridge.toArray()) {
                if(food.getName() == userFood) {
                    foods.add(food);
                }
            }
        }
        Food chosenFood;
        if(foods.size()>1) {
            System.out.println("Type the integer option of the food you want to remove")
            int option = -1;
            while(option<0 || option>foods.size()-1) {
                for(int i = 0; i<foods.size()-1; i++) {
                    Food food = foods.get(i);
                    System.out.println("\nOption " + (String) i + ":");
                    System.out.println("Name: "+ food.getName());
                    System.out.println("Expiration: "+ food.getExpirationDate().format(formatter))
                    System.out.println("Description: "+ food.getDescription());
                }
                Int option = (int) scanner.nextLine();
            }
            chosenFood = foods.get(i);
        } else {
            chosenFood = foods.get(0);
        }
        myFridge.remove(chosenFood);
        System.out.println("You have removed: " + chosenFood.getName());
        System.out.println("With expiration date: " + choseFood.getExpirationDate().format(formatter));
        System.out.println("And description: " + chosenFood.getDescription());
    }


    // Prints to the terminal all of the expired food
    public void printExpiredFood()
    {
        Food[] expireds = myFridge.getExpiredFood();
        System.out.println("Here are all the Expired Foods")
        for(Food food: expireds) {
            System.out.println("\n"+food.getName() + "will expire on: " + food.getExpirationDate.toLocalDate().toString());
            System.out.println(food.getDescription());
        }
    }


    // Reads a corresponding file and using information contained in to update
    // Fridge object
    public void readFoodFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        if (!foodfile.exists()) {
            File foodfile = new File(FOOD_FILE);
            return;
        }
        Scanner fileScanner = new Scanner(FOOD_FILE)
        while (fileScanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",",-1);
            
            
            if(data[0].strip()=="") {
                continue;
            }
            if(!data[1].isValidDate()) {
                LocalDate date = LocalDate.now();
                data[1] = date.format(formatter);     
            }
            LocalDate date = LocalDate.parse(data[1], formatter);
            Food addedFood = new food(data[0],date,data[2]);
            myFridge.add(addedFood);
        }
    }


    // Uses information in Fridge and updates corresponding foodfile
    public void writeFoodFile()
    {
        Food[] foods = myFridge.toArray();
        PrintWriter writer = new PrintWriter(new FileWriter(FOOD_FILE, false));
        for(Food food: foods) {
            String[] data = {food.getName(), food.getExpirationDate().format(formatter), food.getDescription()};
            writer.println(String.join(",", data));
            }

        writer.close();
        }
    }
    
    public boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
            LocalDate.parse(input, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
