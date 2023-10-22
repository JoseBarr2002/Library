package com.libro_vault.libraries;

/**
 * Class that represents the data structure for transferring Library data
 * between processes or layers of application.
 */
public class LibraryDTO {

    // Fields

    /** Library's Id. */
    private String id;
    /** Library's name. */
    private String name;

    // Constrcutors

    // **Default Library Constructor. */
    public LibraryDTO() {
    }

    /**
     * Library Constructor
     * 
     * @param name Name of the Library.
     * @param id   Id of the Library.
     */
    public LibraryDTO(String name, String id) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

    /**
     * Retrieves the Library name.
     * 
     * @return The Library name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Library name.
     * 
     * @param name The new Library name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retreives the Library Id.
     * 
     * @return The Library Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Library Id.
     * 
     * @param id The new Library Id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
