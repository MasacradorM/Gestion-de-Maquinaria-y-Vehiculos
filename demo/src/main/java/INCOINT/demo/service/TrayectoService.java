package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.TrayectoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Trayecto;
import INCOINT.demo.repository.ITrayecto;

@Service
public class TrayectoService {

    @Autowired
    private ITrayecto data;
    public List<Trayecto> findAll() {
        return data.findAll();
    }

    public Optional<Trayecto> findById(int trayectoId) {
        return data.findById(trayectoId);
    }

    public responseDTO save(TrayectoDTO trayectoDTO) {
        Trayecto trayecto = new Trayecto(0, trayectoDTO.getTrayectoNombre(), trayectoDTO.getMunicipioOrigenId(), trayectoDTO.getMunicipioDestinoId());
        data.save(trayecto);
        return new responseDTO(HttpStatus.OK.toString(), "Trayecto registrado correctamente");
    }

    public responseDTO deleteTrayecto(int trayectoId) {
        if (!findById(trayectoId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El trayecto no existe");
        }
        data.deleteById(trayectoId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
