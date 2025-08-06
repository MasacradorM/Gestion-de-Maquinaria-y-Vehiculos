package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.TipoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Tipo;
import INCOINT.demo.repository.ITipo;

@Service
public class TipoService {

    @Autowired
    private ITipo data;

    public List<Tipo> findAll() {
        return data.findAll();
    }

    public Optional<Tipo> findById(int tipoId) {
        return data.findById(tipoId);
    }

    public responseDTO save(TipoDTO tipoDTO) {
        Tipo tipo = new Tipo(0, tipoDTO.getTipo());
        data.save(tipo);
        return new responseDTO(HttpStatus.OK.toString(), "Tipo registrado correctamente");
    }

    public responseDTO deleteTipo(int tipoId) {
        if (!findById(tipoId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El tipo no existe");
        }
        data.deleteById(tipoId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
