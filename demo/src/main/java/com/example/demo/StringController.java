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

    @GetMapping("/{string}")
    public String geString(@PathVariable String string){

        if(stringList.contains(string))
            return string;
        else return "";

    }

    @PostMapping("/{newString}")
    public String createString(@PathVariable String newString) {

            stringList.add(newString);
            return "String "+newString+" added successfully";
    }

    @PutMapping("/{originalString}/{newString}")
    public String updateString(
            @PathVariable String originalString,
            @PathVariable String newString
    ) {
        if (stringList.contains(originalString)) {
            stringList.remove(originalString);
            stringList.add(newString);
            return "String " + originalString + " updated to " + newString;
        } else {
            return "String " + originalString + " not found for update";
        }
    }

    @DeleteMapping("/{string}")
    public String deleteString(@PathVariable String string) {
       
            stringList.remove(string);
            return "String "+string+" deleted successfully";

    }
}
