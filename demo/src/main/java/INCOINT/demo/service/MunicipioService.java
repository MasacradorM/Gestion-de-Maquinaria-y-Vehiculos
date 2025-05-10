package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.MunicipioDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Departamento;
import INCOINT.demo.model.Municipio;
import INCOINT.demo.repository.IDepartamento;
import INCOINT.demo.repository.IMunicipio;

@Service
public class MunicipioService {

    @Autowired
    private IMunicipio data;

    @Autowired
    private IDepartamento departamentoRepository;

    public List<Municipio> findAll() {
        return data.findAll();
    }

    public Optional<Municipio> findById(int municipioId) {
        return data.findById(municipioId);
    }

    public responseDTO save(MunicipioDTO municipioDTO) {
        Optional<Departamento> departamento = departamentoRepository.findById(municipioDTO.getDepartamentoId());
        if (!departamento.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El departamento no existe");
        }
        
        Municipio municipio = new Municipio(0, departamento.get(), municipioDTO.getMunicipioNombre(), municipioDTO.getCodigoDane());
        data.save(municipio);
        return new responseDTO(HttpStatus.OK.toString(), "Municipio registrado correctamente");
    }

    public responseDTO deleteMunicipio(int municipioId) {
        if (!findById(municipioId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El municipio no existe");
        }
        data.deleteById(municipioId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
