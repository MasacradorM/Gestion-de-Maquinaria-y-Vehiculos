package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.DepartamentoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Departamento;
import INCOINT.demo.repository.IDepartamento;

@Service
public class DepartamentoService {

    @Autowired
    private IDepartamento data;

    public List<Departamento> findAll() {
        return data.findAll();
    }

    public Optional<Departamento> findById(int departamentoId) {
        return data.findById(departamentoId);
    }

    public responseDTO save(DepartamentoDTO departamentoDTO) {
        Departamento departamento = new Departamento(0, departamentoDTO.getDepartamentoNombre(), departamentoDTO.getCodigoDane());
        data.save(departamento);
        return new responseDTO(HttpStatus.OK.toString(), "Departamento registrado correctamente");
    }

    public responseDTO deleteDepartamento(int departamentoId) {
        if (!findById(departamentoId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El departamento no existe");
        }
        data.deleteById(departamentoId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
