package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/api/coffee")
    public List<Coffee> index() {
        return coffeeService.index();
    }
    @GetMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id) {
        Coffee coffee = coffeeService.show(id);
        return (coffee!= null) ? ResponseEntity.status(HttpStatus.OK).body(coffee) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/coffee/new")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeForm dto) {
        System.out.println(dto);
        Coffee coffee = coffeeService.create(dto);
        return (coffee!= null) ? ResponseEntity.status(HttpStatus.OK).body(coffee) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        Coffee coffee = coffeeService.update(id, dto);
        return (coffee!= null) ? ResponseEntity.status(HttpStatus.OK).body(coffee) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee coffee = coffeeService.delete(id);
        return (coffee!= null) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
