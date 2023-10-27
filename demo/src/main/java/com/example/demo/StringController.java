package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/strings")
public class StringController {

    private List<String> stringList = new ArrayList<>();

    @GetMapping
    public List<String> getAllStrings() {
        return stringList;
    }

    @PostMapping("/{newString}")
    public String createString(@PathVariable String newString) {

            stringList.add(newString);
            return "String "+newString+" added successfully";
    }

    @DeleteMapping("/{oldString}")
    public String deleteString(@PathVariable String oldString) {
       
            stringList.remove(oldString);
            return "String "+oldString+" deleted successfully";

    }
}
