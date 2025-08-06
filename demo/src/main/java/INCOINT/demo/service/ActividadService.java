package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.ActividadDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Actividad;
import INCOINT.demo.repository.IActividad;

@Service
public class ActividadService {

    @Autowired
    private IActividad data;

    public List<Actividad> findAll() {
        return data.findAll();
    }

    public Optional<Actividad> findById(int actividadId) {
        return data.findById(actividadId);
    }

    public responseDTO save(ActividadDTO actividadDTO) {
        Actividad actividad = new Actividad(0, actividadDTO.getActividad());
        data.save(actividad);
        return new responseDTO(HttpStatus.OK.toString(), "Actividad registrada correctamente");
    }

    public responseDTO deleteActividad(int actividadId) {
        if (!findById(actividadId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La actividad no existe");
        }
        data.deleteById(actividadId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
