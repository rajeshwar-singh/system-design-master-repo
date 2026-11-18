package com.example.demo.MCP;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/chat")
    public ResponseEntity<String> startChat(@RequestBody String query)
    {
        return new ResponseEntity<>("This is your request : "+query, HttpStatus.OK);
    }
}
