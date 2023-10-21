package com.libro_vault.libraries;

import com.libro_vault.libraries.LibraryDTO;
import com.libro_vault.libraries.Library;
import com.libro_vault.libraries.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        Library library = libraryService.createLibrary(libraryDTO);
        return ResponseEntity.ok(library);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable String id) {
        return libraryService.getLibraryById(id)
                .map(library -> ResponseEntity.ok(library))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable String id, @RequestBody LibraryDTO libraryDTO) {
        Library library = libraryService.updateLibrary(id, libraryDTO);
        if (library != null) {
            return ResponseEntity.ok(library);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable String id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}
