package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.exception.FlorNotContentException;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.exception.FlorNotFoundException;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public FlorDTO updateFlor (FlorDTO florDTO){
        Optional<FlorEntity> optionalFlor = florRepository.findById(convertToFlorEntity(florDTO).getPk_FlorID());
        if (optionalFlor.isPresent()){
            FlorEntity flor = optionalFlor.get();
            flor.setNom(florDTO.getNomFlor());
            flor.setPaisFlor(florDTO.getPaisFlor());
            return convertToFlorDTO(florRepository.save(convertToFlorEntity(florDTO)));
        } else {
            throw new FlorNotFoundException("Flor amb id: " + florDTO.getPk_FlorID() + ", no trobada a la base de dades");
        }
    }

    //delete
    public void deleteFlor (int id){
        Optional<FlorEntity> optionalFlor = florRepository.findById(id);
        if (optionalFlor.isPresent()){
            florRepository.deleteById(id);
        } else {
            throw new FlorNotFoundException("Flor amb id: " + id + ", no trobada a la base de dades");
        }
    }

    //getOne
    public FlorDTO getOne (int id){
        FlorEntity flor = florRepository.findById(id).orElse(null);
        if (flor == null){
            throw new FlorNotFoundException("Flor amb id: " + id + ", no trobada a la base de dades");
        }else {
            return convertToFlorDTO(flor);
        }
    }

    //getAll
    public List<FlorDTO> getAll (){
        List<FlorEntity> flors = florRepository.findAll();
        if (flors.isEmpty()){
            throw new FlorNotContentException("No hay flores registradas en la base de datos");
        } else {
            return flors.stream().map(this::convertToFlorDTO).toList();
        }
    }



}
