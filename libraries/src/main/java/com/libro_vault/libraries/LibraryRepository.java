package com.libro_vault.libraries;

import com.libro_vault.libraries.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that provides a way to program CRUD operations on data without the
 * boilerplate code.
 */
@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {

    /**
     * Method that finds all Library(ies) nby a User's Id.
     * 
     * @param userId The associated User.
     * @return The associated Library(ies).
     */
    List<Library> findByUserId(String userId);

    /**
     * Method that finds a Library by the specified name.
     * 
     * @param name The name of the Library to look for.
     * @return The Library with the matching name.
     */
    Library findByName(String name);

    // Finds Library(ies) that have books.
    // List<Library> findByBooksIsNotEmpty(String name);

    /**
     * Method that deletes a Library by the specified name.
     * 
     * @param name The name of the Library to be deleted.
     */
    void deletByName(String name);

}
