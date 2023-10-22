package com.libro_vault.libraries;

import com.libro_vault.libraries.LibraryDTO;
import com.libro_vault.libraries.Library;
import com.libro_vault.libraries.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class that provides mehtods for a User to interact with the DB.
 */
@Service
public class LibraryService {

    /** Instance of a LibraryRepository. */
    private final LibraryRepository libraryRepository;

    /**
     * Constructor for LibraryService
     * 
     * @param libraryRepository The LibraryRepository to use.
     */
    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    /**
     * Method that Retrieves Library(ies) associated with a User.
     * 
     * @param userId The associated User.
     * @return The associated Library(ies).
     */
    public List<Library> getAllLibrariesByUserId(String userId) {
        return libraryRepository.findByUserId(userId);
    }

    // public Library createLibrary(LibraryDTO libraryDTO) {
    // Library library = new Library(libraryDTO.getId(), libraryDTO.getName());
    // return libraryRepository.save(library);
    // }

    /**
     * Method that creates a Library.
     * 
     * @param libraryDTO The encapsulated data for a Library.
     * @param userId     The associated User.
     * @return The new Library instance.
     */
    public Library createLibrary(LibraryDTO libraryDTO, String userId) {
        Library library = new Library();
        library.setId(library.getId());
        library.setName(libraryDTO.getName());
        // library.setUser(userId);
        return libraryRepository.save(existingLibrary); // add save method to repo
    }

    // public Optional<Library> getLibraryById(String id) {
    // return libraryRepository.findById(id);
    // }

    /**
     * Method that allows Users to update the Libray.
     * 
     * @param libraryId        The Library to update.
     * @param updateLibraryDTO The updated LibraryDTO to input.
     * @return The updated Library.
     */
    public Library updateLibrary(String libraryId, LibraryDTO updateLibraryDTO) {
        Optional<Library> existingLibraryOpt = libraryRepository.findById(libraryId);
        if (existingLibraryOpt.isPresent()) {
            Library existingLibrary = existingLibraryOpt.get();
            existingLibrary.setName(updateLibraryDTO.getName());
            return libraryRepository.save(existingLibrary);
        }
        // Handle case where the Library does not exist. Throw an exception or return
        // null.
        return null;
    }

    // public Library updateLibrary(String id, LibraryDTO libraryDTO) {
    // Optional<Library> libraryOpt = libraryRepository.findById(id);
    // if (libraryOpt.isPresent()) {
    // Library library = libraryOpt.get();
    // library.setId(libraryDTO.getId());
    // library.setName(libraryDTO.getName());
    // return libraryRepository.save(library);
    // }
    // return null;
    // }

    /*****************************************************************
     ** Note: Might have to change this to delete by name later on. **
     *****************************************************************/

    /**
     * Method that deletes a selected Library.
     * 
     * @param libraryId The Library to delte.
     */
    public void deleteLibrary(String libraryId) {
        libraryRepository.deleteById(libraryId);
    }

    // public void deleteLibrary(String id) {
    // libraryRepository.deleteById(id);
    // }

}
