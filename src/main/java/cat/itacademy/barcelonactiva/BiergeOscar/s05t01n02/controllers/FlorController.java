package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    FlorService florService;

    //add
    @PostMapping("/add")
    @Operation(summary = "Crea una nova sucursal", description = "Aquesta API et permet crear una flor")
    public ResponseEntity<FlorDTO> createFlor (@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florService.createFlor(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFlor);
    }
    //update
    @PutMapping("/update")
    public ResponseEntity<FlorDTO> updateFlor (@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florService.updateFlor(florDTO);
        return ResponseEntity.ok(newFlor);
    }

    //delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor (@PathVariable("id") int id){
        florService.deleteFlor(id);
        return ResponseEntity.ok("Flor eliminada");
    }

    //getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getFlor (@PathVariable("id") int id){
        FlorDTO newFlor = florService.getOne(id);
        return ResponseEntity.ok(newFlor);
    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getFlors (){
        List<FlorDTO> flors = florService.getAll();
        return ResponseEntity.ok(flors);
    }

}
