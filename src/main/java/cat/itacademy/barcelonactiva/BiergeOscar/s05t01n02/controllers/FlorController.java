package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    FlorService florService;

    //add
    @PostMapping("/add")
    public ResponseEntity<FlorDTO> createFlor (@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florService.createFlor(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFlor);
    }
    //update
    //delete/{id}
    //getOne/{id}
    //getAll
}
