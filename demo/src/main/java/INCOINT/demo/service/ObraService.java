package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.ObraDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Obra;
import INCOINT.demo.repository.IObra;

@Service
public class ObraService {

    @Autowired
    private IObra data;

    public List<Obra> findAll() {
        return data.findAll();
    }

    public Optional<Obra> findById(int obraId) {
        return data.findById(obraId);
    }

    public responseDTO save(ObraDTO obraDTO) {
        Obra obra = new Obra(0, obraDTO.getObra());
        data.save(obra);
        return new responseDTO(HttpStatus.OK.toString(), "Obra registrada correctamente");
    }

    public responseDTO deleteObra(int obraId) {
        if (!findById(obraId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La obra no existe");
        }
        data.deleteById(obraId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
