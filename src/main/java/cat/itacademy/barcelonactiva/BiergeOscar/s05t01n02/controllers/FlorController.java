package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    FlorService florService;

    //add
    public ResponseEntity<FlorDTO> createFlor (@RequestBody FlorDTO florDTO){

    }
    //update
    //delete/{id}
    //getOne/{id}
    //getAll
}
