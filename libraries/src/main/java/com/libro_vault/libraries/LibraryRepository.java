package com.libro_vault.libraries;

import com.libro_vault.libraries.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {

    List<Library> findByUserId(String userId);
}
