package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/jpa")
@CrossOrigin(origins = "*") // DON'T DO THIS :-)
public class JPAController {

    // NO MORE INTERNAL STATE private List<String> stringList = new ArrayList<>();

    @Autowired
    StringRepository stringRepository;

    //READ ALL
    @Operation(summary = "Get all strings")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping
    public ResponseEntity<List<StringEntity>> getAllStrings() {

        List<StringEntity> stringList = stringRepository.findAll();

        if (stringList.isEmpty()) {
            // Return a "Not Found" response (HTTP 404) when the list is empty.
            return ResponseEntity.notFound().build();
        } else {
            // Return the list of strings with a "OK" response (HTTP 200).
            return ResponseEntity.ok(stringList);
        }
    }

    //READ ONE
    @Operation(summary = "Get one string in particular")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping("/{string}")
    public ResponseEntity<String> geString(@PathVariable String string){

        Optional<StringEntity> entity = this.stringRepository.findById(string);
        StringEntity stringEntity = entity.orElse(new StringEntity());

        return ResponseEntity.ok(stringEntity.getContent());

    }

    //CREATE NEW
    // @PostMapping("/{newString}")
    // public String createString(@PathVariable String newString) {

    //         stringList.add(newString);
    //         return "String "+newString+" added successfully";
    // }

    @Operation(summary = "Create a new string")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "String created successfully"),
        @ApiResponse(responseCode = "409", description = "String already exists")
    })  
    @PostMapping("/{newString}")
    public ResponseEntity<String> createString(@PathVariable String newString) {

        stringRepository.save(new StringEntity(newString));
        return ResponseEntity.ok(newString);

    }

    //UPDATE EXISTING
    @Operation(summary = "Update an existing string")
    @PutMapping("/{originalString}/{newString}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "String updated successfully"),
        @ApiResponse(responseCode = "404", description = "Original string not found")
    })
    public ResponseEntity<String> updateString(
            @PathVariable String originalString,
            @PathVariable String newString
    ) {

            return ResponseEntity.notFound().build();

    }

    //DELETE
    @Operation(summary = "Delete a string")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "String deleted successfully"),
        @ApiResponse(responseCode = "404", description = "String not found")
    })
    @DeleteMapping("/{string}")
    public ResponseEntity<String> deleteString(@PathVariable String string) {

        stringRepository.deleteById(string);

        return ResponseEntity.ok(string);

    }

    
}
