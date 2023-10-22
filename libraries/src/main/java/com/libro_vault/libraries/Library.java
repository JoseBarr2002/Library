package com.libro_vault.libraries;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Class that represents the data structure for the Library in MongoDB.
 */
@Document(collection = "libraries")
public class Library {

    // Fields

    @Id
    /** Library Id */
    private String id;
    /** Library name */
    private String name;
    // /** Library description */
    // private String description;

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
    public Library(String id, String name) {
        this.id = id;
        this.name = name;
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

    // public List<Book> getBooks() {
    // return books;
    // }

    // public void setBooks(List<Book> books) {
    // this.books = books;
    // }

    // public User getUser() {
    // return user;
    // }

    // public void setUser(User user) {
    // this.user = user;
    // }
}
