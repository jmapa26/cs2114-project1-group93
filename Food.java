import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Stores information about a food item.
 *
 * @author Zhaojin Gao
 * @version 09.22.2026
 */
public class Food {
    private String name;
    private LocalDate expirationDate;
    private String description;

    /**
     * Creates food with a default description.
     *
     * @param name the food name
     * @param expirationDate the expiration date
     * @throws IllegalArgumentException if name or date is null
     */
    public Food(String name, LocalDate expirationDate) {
        this(name, expirationDate, "Missing description");
    }

    /**
     * Creates food with a description.
     *
     * @param name the food name
     * @param expirationDate the expiration date
     * @param description the food description
     * @throws IllegalArgumentException if name or date is null
     */
    public Food(String name, LocalDate expirationDate,
        String description) {
        setName(name);
        setExpirationDate(expirationDate);
        setDescription(description);
    }

    /**
     * Checks whether the food expired before today.
     *
     * @return true if the food is expired
     */
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    /**
     * Gets the number of days left.
     *
     * @return days left, or zero if expired
     */
    public int getTimeLeft() {
        LocalDate today = LocalDate.now();

        if (expirationDate.isBefore(today)) {
            return 0;
        }

        return (int)ChronoUnit.DAYS.between(today, expirationDate);
    }

    /**
     * Gets the food name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the food name.
     *
     * @param name the new name
     * @throws IllegalArgumentException if name is null
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }

        if (name.trim().isEmpty()) {
            this.name = "Unknown food";
        }
        else {
            this.name = name;
        }
    }

    /**
     * Gets the expiration date.
     *
     * @return the expiration date
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Changes the expiration date.
     *
     * @param expirationDate the new expiration date
     * @throws IllegalArgumentException if the date is null
     */
    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        this.expirationDate = expirationDate;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            this.description = "Missing description";
        }
        else {
            this.description = description;
        }
    }
}
