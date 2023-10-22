package com.libro_vault.libraries;

import com.libro_vault.libraries.LibraryDTO;
import com.libro_vault.libraries.Library;
import com.libro_vault.libraries.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that defines the RESTful API endpoints fot the Library. It uses
 * LibraryService to handle business logic and interacts with the client
 * through HTTP request and responses.
 */
@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    /** Creating an object LibraryService. */
    private final LibraryService libraryService;

    /**
     * Constructor that creates a LibraryController.
     * 
     * @param libraryService The LibraryService to use.
     */
    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // @PostMapping
    // public ResponseEntity<Library> createLibrary(@RequestBody LibraryDTO
    // libraryDTO) {
    // Library library = libraryService.createLibrary(libraryDTO);
    // return ResponseEntity.ok(library);
    // }

    /**
     * Method that creates an actual Library.
     * 
     * @param userId     The associated User acoount.
     * @param libraryDTO The encapsulated information to tranfer from one end point
     *                   to another.
     * @return A brand, spankin' new Library.
     */
    @PostMapping({ "/{userId}" })
    public ResponseEntity<Library> createLibrary(@PathVariable String userId, @RequestBody LibraryDTO libraryDTO) {
        Library createdLibrary = libraryService.createLibrary(libraryDTO, userId); // add to parameter for service class
        return new ResponseEntity<Library>(createdLibrary, HttpStatus.CREATED);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Library> getLibraryById(@PathVariable String id) {
    // return libraryService.getLibraryById(id)
    // .map(library -> ResponseEntity.ok(library))
    // .orElse(ResponseEntity.notFound().build());
    // }

    /**
     * Method that allows the user to access all of their existing Library(ies).
     * 
     * @param userId The associated User account.
     * @return The assoociated Library(ies).
     */
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Library>> getAllLibrariesByUserId(@PathVariable String userId) {
        List<Library> libraries = libraryService.getAllLibrariesByUserId(userId);
        return new ResponseEntity<>(libraries, HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Library> updateLibrary(@PathVariable String id,
    // @RequestBody LibraryDTO libraryDTO) {
    // Library library = libraryService.updateLibrary(id, libraryDTO);
    // if (library != null) {
    // return ResponseEntity.ok(library);
    // }
    // return ResponseEntity.notFound().build();
    // }

    /**
     * Method that allows the User to update their Library.
     * 
     * @param libraryId         The associated Library to update.
     * @param updatedLibraryDTO The encapsulated data to send.
     * @return The updated Library.
     */
    @PutMapping("/{libraryId}")
    public ResponseEntity<Library> updateLibrary(@PathVariable String libraryId,
            @RequestBody LibraryDTO updatedLibraryDTO) {
        Library updatedLibrary = libraryService.updateLibrary(libraryId, updatedLibraryDTO);
        return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);

    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteLibrary(@PathVariable String id) {
    // libraryService.deleteLibrary(id);
    // return ResponseEntity.noContent().build();
    // }

    /**
     * Method that allows the User to delete a Library.
     * 
     * @param libraryId The associated Library.
     * @return A message saying that there is nothing.
     */
    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable String libraryId) {
        libraryService.deleteLibrary(libraryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
