package com.libro_vault.libraries;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "libraries")
public class Library {

    // Fields

    @Id
    /** Library Id */
    private String id;
    /** Library name */
    private String name;
    /** Library description */
    private String description;

    /** Books associated with the Library. */
    // @DBRef private List<Book> books; // Uncomment when Book entity is ready
    /** User associated with the Library. */
    // @DBRef private User user; // Uncomment when User entity is ready

    // Constuctors

    /** Default constructor for a Library. */
    public Library() {
    }

    /**
     * Constructor for a Library with variables.
     * 
     * @param name        The name of the Library.
     * @param description The description of a Library.
     */
    public Library(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters

    /**
     * Retrieves the Library's Id.
     * 
     * @return The Library's Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Library's Id.
     * 
     * @param id The Library's Id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retreives the Library's name.
     * 
     * @return The Library's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Library's name.
     * 
     * @param name The Library's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retreives the description of the Library.
     * 
     * @return The description of the Library.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Library.
     * 
     * @param description The description of the Library.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
