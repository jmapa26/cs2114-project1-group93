// import statements here

import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.format.DateTimeParseException;

// -----------------------------------------------------------------------------
/**
 * Records and gives infomration on the food in a fridge including its
 * expiration and description. It is console based and can also read and write
 * infomration to a file.
 * 
 * @author Leo Chenoweth
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
        FridgeBuddy fridgeBuddy = new FridgeBuddy();
        fridgeBuddy.readFoodFile();
        boolean quit = false;
        while (!quit) {
            String validOption = "";
            System.out.println("What do you want to do: ");
            System.out.println("Option 1, look for a food");
            System.out.println("Option 2, display all food");
            System.out.println("Option 3, add a food");
            System.out.println("Option 4, remove a food");
            System.out.println("Option 5, display all expired food");
            System.out.println("Option 6, quit the program");
            System.out.println(
                "Just enter the number of the option you want to choose");
            validOption = fridgeBuddy.scanner.nextLine();
            while (!"123456".contains(validOption) && validOption.length() != 1)
            {
                System.out
                    .println(validOption + " is not a number between 1 and 6");
                validOption = fridgeBuddy.scanner.nextLine();
            }
            switch (Integer.parseInt(validOption))
            {
                case 1:
                    fridgeBuddy.searchFood();
                    break;
                case 2:
                    fridgeBuddy.displayFood();
                    break;
                case 3:
                    fridgeBuddy.addFood();
                    break;
                case 4:
                    fridgeBuddy.removeFood();
                    break;
                case 5:
                    fridgeBuddy.printExpiredFood();
                    break;
                case 6:
                    quit = true;
            }
        }
        fridgeBuddy.writeFoodFile();
    }

    // ~ Fields ................................................................
    private Fridge myFridge = new Fridge();
    private static final String FOOD_FILE = "Foods_inside_fridge.csv";
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");

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
        String desiredFood = scanner.nextLine();
        ArrayList<Food> foods = new ArrayList<>();
        for (Food food : myFridge.toArray())
        {
            if (food.getName().equals(desiredFood))
            {
                foods.add(food);
            }
        }
        while (foods.size() == 0)
        {
            System.out.println("That foods does not exist, try another");
            desiredFood = scanner.nextLine();
            for (Food food : myFridge.toArray())
            {
                if (food.getName().equals(desiredFood))
                {
                    foods.add(food);
                }
            }
        }
        System.out.println("All foods with the same name");
        for (int i = 0; i < foods.size(); i++)
        {
            Food food = foods.get(i);
            System.out.println("\nFood " + i + ":");
            System.out.println("Name: " + food.getName());
            System.out.println(
                "Expiration: " + food.getExpirationDate().format(formatter));
            System.out.println("Description: " + food.getDescription());
        }
    }


    // Prints to the terminals all the foods in the fridge in a nice method
    public void displayFood()
    {
        Food[] foods = myFridge.toArray();
        System.out.println("Here are all the Foods:");
        for (Food food : foods)
        {
            System.out.println(
                "\n" + food.getName() + " will expire on: "
                    + food.getExpirationDate().format(formatter));
            System.out.println(food.getDescription());
        }
    }


    // Ask users for name, description, and expiration and adds a corresponding
    // Food object to Fridge. None of the fields can contians commas.
    public void addFood()
    {
        System.out.println("What should be the name of the food (no commas)");
        String name = scanner.nextLine();
        while (name.contains(","))
        {
            System.out.println("Foods with commas are not allowed");
            name = scanner.nextLine();
        }
        System.out.println("What is the expiration date?");
        String date = scanner.nextLine();
        while (!isValidDate(date))
        {
            System.out.println("The date was invalid try again");
            date = scanner.nextLine();
        }
        System.out.println("What is the description of the food? (no commas)");
        String description = scanner.nextLine();
        while (description.contains(","))
        {
            System.out.println("Foods with commas are not allowed");
            description = scanner.nextLine();
        }
        LocalDate expirationDate = LocalDate.parse(date, formatter);
        Food food = new Food(name, expirationDate, description);
        myFridge.add(food);
    }


    // Asks user for name of food to remove,displays all of the food with same
    // name and ask for which one
    public void removeFood()
    {
        System.out.println("What is the name of the food you want to remove?");
        String userFood = scanner.nextLine();
        ArrayList<Food> foods = new ArrayList<>();
        for (Food food : myFridge.toArray())
        {
            if (food.getName().equals(userFood))
            {
                foods.add(food);
            }
        }
        while (foods.size() == 0)
        {
            System.out.println(
                "No food appeared with that name try again. Type \"quit\" to quit.");
            userFood = scanner.nextLine();
            if (userFood.equals("quit"))
            {
                return;
            }
            for (Food food : myFridge.toArray())
            {
                if (food.getName().equals(userFood))
                {
                    foods.add(food);
                }
            }
        }
        Food chosenFood;
        if (foods.size() > 1)
        {
            System.out.println(
                "Type the integer option of the food you want to remove");
            int option = -1;
            while (option < 0 || option > foods.size() - 1)
            {
                for (int i = 0; i < foods.size(); i++)
                {
                    Food food = foods.get(i);
                    System.out.println("\nOption " + i + ":");
                    System.out.println("Name: " + food.getName());
                    System.out.println(
                        "Expiration: "
                            + food.getExpirationDate().format(formatter));
                    System.out.println("Description: " + food.getDescription());
                }
                option = Integer.parseInt(scanner.nextLine());
            }
            chosenFood = foods.get(option);
        }
        else
        {
            chosenFood = foods.get(0);
        }
        myFridge.remove(chosenFood);
        System.out.println("You have removed: " + chosenFood.getName());
        System.out.println(
            "With expiration date: "
                + chosenFood.getExpirationDate().format(formatter));
        System.out.println("And description: " + chosenFood.getDescription());
    }


    // Prints to the terminal all of the expired food
    public void printExpiredFood()
    {
        Food[] expireds = myFridge.getExpiredFood();
        System.out.println("Here are all the Expired Foods");
        for (Food food : expireds)
        {
            System.out.println(
                "\n" + food.getName() + " will expire on: "
                    + food.getExpirationDate().format(formatter));
            System.out.println(food.getDescription());
        }

    }


    // Reads a corresponding file and using information contained in to update
    // Fridge object
    public void readFoodFile()
    {
        File foodFile = new File(FOOD_FILE);
        if (!foodFile.exists())
        {
            try
            {
                foodFile.createNewFile();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
        Scanner fileScanner;
        try
        {
            fileScanner = new Scanner(foodFile);
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        while (fileScanner.hasNextLine())
        {
            String line = fileScanner.nextLine();
            String[] data = line.split(",", -1);

            if (data[0].strip().equals(""))
            {
                continue;
            }
            if (!isValidDate(data[1]))
            {
                LocalDate date = LocalDate.now();
                data[1] = date.format(formatter);
            }
            LocalDate date = LocalDate.parse(data[1], formatter);
            Food addedFood = new Food(data[0], date, data[2]);
            myFridge.add(addedFood);
        }
        fileScanner.close();
    }


    // Uses information in Fridge and updates corresponding foodfile
    public void writeFoodFile()
    {
        Food[] foods = myFridge.toArray();
        PrintWriter writer;
        try
        {
            writer = new PrintWriter(new FileWriter(FOOD_FILE, false));
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        for (Food food : foods)
        {
            String[] data =
                { food.getName(), food.getExpirationDate().format(formatter),
                    food.getDescription() };
            writer.println(String.join(",", data));
        }

        writer.close();

    }


    // Checks if a String is a valid date.
    public boolean isValidDate(String date)
    {
        try
        {
            LocalDate.parse(date, formatter);
            return true;
        }
        catch (DateTimeParseException e)
        {
            return false;
        }
    }
}
