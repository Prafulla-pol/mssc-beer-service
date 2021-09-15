package com.prafulla.msscbeerservice.web.controller;

import com.prafulla.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity createNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID uuid, @Valid @RequestBody BeerDto beerDto) {
        return ResponseEntity.ok().build();
    }
}