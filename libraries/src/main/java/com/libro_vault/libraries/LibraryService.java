package com.libro_vault.libraries;

import com.libro_vault.libraries.LibraryDTO;
import com.libro_vault.libraries.Library;
import com.libro_vault.libraries.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibrariesByUserId(String userId) {
        return libraryRepository.findByUserId(userId);
    }

    public Library createLibrary(LibraryDTO libraryDTO) {
        Library library = new Library(libraryDTO.getName(), libraryDTO.getDescription());
        return libraryRepository.save(library);
    }

    public Optional<Library> getLibraryById(String id) {
        return libraryRepository.findById(id);
    }

    public Library updateLibrary(String id, LibraryDTO libraryDTO) {
        Optional<Library> libraryOpt = libraryRepository.findById(id);
        if (libraryOpt.isPresent()) {
            Library library = libraryOpt.get();
            library.setName(libraryDTO.getName());
            library.setDescription(libraryDTO.getDescription());
            return libraryRepository.save(library);
        }
        return null;
    }

    public void deleteLibrary(String id) {
        libraryRepository.deleteById(id);
    }
}
