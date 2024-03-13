package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlorService {
    @Autowired
    FlorRepository florRepository;

    //convert to florentity
    private FlorEntity convertToFlorEntity (FlorDTO florDTO){
        FlorEntity flor = new FlorEntity(florDTO.getNomFlor(), florDTO.getPaisFlor());
        flor.setPk_FlorID(florDTO.getPk_FlorID());
        return flor;
    }

    //convert to flordto
    private FlorDTO convertToFlorDTO (FlorEntity flor){
        FlorDTO florDTO = null;
        if (flor != null) florDTO = createFlorDTO(flor);
        return florDTO;
    }

    //create flordto
    private FlorDTO createFlorDTO (FlorEntity flor){
        return  new FlorDTO(flor.getPk_FlorID(), flor.getNom(), flor.getPaisFlor());
    }

    //create flor
    public FlorDTO createFlor(FlorDTO florDTO){
        return  convertToFlorDTO(florRepository.save(convertToFlorEntity(florDTO)));
    }

    //update
    //delete
    //getOne
    //getAll



}
