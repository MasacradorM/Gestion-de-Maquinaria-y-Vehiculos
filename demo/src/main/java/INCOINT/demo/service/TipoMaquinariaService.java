package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.TipoMaquinariaDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.TipoMaquinaria;
import INCOINT.demo.repository.ITipoMaquinaria;

@Service
public class TipoMaquinariaService {

    @Autowired
    private ITipoMaquinaria data;

    public List<TipoMaquinaria> findAll() {
        return data.findAll();
    }

    public Optional<TipoMaquinaria> findById(int tipoMaquinariaId) {
        return data.findById(tipoMaquinariaId);
    }

    public void save(TipoMaquinariaDTO tipoMaquinariaDTO) {
        TipoMaquinaria tipoMaquinaria = new TipoMaquinaria(0, tipoMaquinariaDTO.getTipoMaquinaria());
        data.save(tipoMaquinaria);
    }

    public responseDTO deleteTipoMaquinaria(int tipoMaquinariaId) {
        if (!findById(tipoMaquinariaId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El tipo de maquinaria no existe");
        }
        data.deleteById(tipoMaquinariaId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
