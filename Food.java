// import statements here

// -----------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author INSERT AUTHOR NAME
 * @version Sep 24, 2026
 */

public class Food {

    // ~ Fields ................................................................
    private String name;
    private LocalDate expirationDate;
    private description string;

    // ~ Constructor ...........................................................
    /**
     * Constructor, creates a Food object with description
     * 
     * @param name
     *            name of food item
     * @param expirationDate
     *            date on which food item expires
     * @param description
     *            extra information on food item
     */
    public Food(String name, LocalDate expirationDate, String description) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.description = description;
    }

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

    public boolean isExpired() {

    }


    public int getTimeLeft() {

    }


    public String getName() {

    }


    public void setName(String CHANGE_PARAM_NAME) {

    }


    public LocalDate getExpirationDate() {

    }


    public void setExpirationDate(LocalDate CHANGE_PARAM_NAME) {

    }


    public String getDescription() {

    }


    public void setDescription(String CHANGE_PARAM_NAME) {

    }
}
