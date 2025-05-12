package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.PersonalDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Personal;
import INCOINT.demo.repository.IPersonal;

@Service
public class PersonalService {

    @Autowired
    private IPersonal data;

    public List<Personal> findAll() {
        return data.findAll();
    }

    public Optional<Personal> findById(int personalId) {
        return data.findById(personalId);
    }

    public responseDTO save(PersonalDTO personalDTO) {
        Personal personal = new Personal(0, personalDTO.getPersonalNombre(), personalDTO.getIdentificacion(), personalDTO.getTipo());
        data.save(personal);
        return new responseDTO(HttpStatus.OK.toString(), "Personal registrado correctamente");
    }

    public responseDTO deletePersonal(int personalId) {
        if (!findById(personalId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El personal no existe");
        }
        data.deleteById(personalId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
