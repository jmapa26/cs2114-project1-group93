// import statements here

// -----------------------------------------------------------------------------
/**
 * Stores information about a Fridge (bag) and the food objects insaide of it
 * 
 * @author Katie Smith (ksmith08)
 * @version Sep 24, 2026
 */

public class Fridge implements Bag<Food>
{

    // ~ Fields ................................................................
    private Food[] food;
    private int size;
    private int capacity;

    private static final int DEFAULT_SIZE = 10;

    // ~ Constructor ...........................................................
    /**
     * Constructor, creates a Fridge object
     */
    public Fridge() 
    {
        this(DEFAULT_SIZE);
    }
    
    /**
     * Constructor, creates a Fridge object
     * 
     * @param  capacity number of items that the bag can hold
     */
    @SuppressWarnings("unckecked")
    public Fridge(int capacity)
    {
        this.food = (Food[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    // ~ Public Methods ........................................................

    /*
     * Please add javadoc comments for all your methods,
     * even if they are self-explanatory!
     *
     * For javadoc comments, you can use the following tags
     * 
     * @param parameter
     * Include parameter explanation
     * 
     * @return return value, and explanation if necessary
     * 
     * @throws exceptionName
     * if the method throws an exception
     */


    public boolean add(Food newFood) 
    {
        if(size >= capacity)
        {
            return false;
        }
        food[size] = newFood;
        size++;
        return true;
    }
    
    
    public Food remove(Food toBeRemoved)
    {
        if(size == capacity)
        {
            return null;
        }
        for(int i = 0; i < size; i++)
        {
            if(food[i].equals(toBeRemoved))
            {
                food[i] = null;
                size--;
                return toBeRemoved;
            }
        }
        return toBeRemoved;
    }
    
    
    public void clear()
    {
        for(int i = 0; i < size; i++)
        {
            food[i] = null;
        }
    }
    
    
    public boolean contains(String anEntry)
    {
        for(int i = 0; i < size; i++)
        {
            if(food[i].getName().equals(anEntry))
            {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }
    
    
    public int getFrequency(String anEntry)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
        {
            if(food[i].getName().equals(anEntry))
            {
                count++;
            }
        }
        return count;
    }
    
    
    public int getCurrentSize()
    {
        return size;
    }
    
    
    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }
        
        String foodString = "[";
        for(int i = 0; i < size - 1; i++)
        {
            foodString += food[i] + ", ";
        }
        foodString += food[size - 1] + "]";
        return foodString;
    }
    
    
    public Food[] toArray()
    {
        Food[] foodArr = new Food[size];
        for(int i = 0; i < size; i++)
        {
            foodArr[i] = food[i];
        }
        return foodArr;
    }
    
    
    
    
}

