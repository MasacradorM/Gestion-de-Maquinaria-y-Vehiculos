package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import INCOINT.demo.DTO.MaquinaDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Maquina;
import INCOINT.demo.repository.IMaquina;

@Service
public class MaquinaService {

    @Autowired
    private IMaquina data;


    public List<Maquina> findAll() {
        return data.findAll();
    }

    public Optional<Maquina> findById(int maquinaId) {
        return data.findById(maquinaId);
    }

    public responseDTO save(MaquinaDTO maquinaDTO) {
        Maquina maquina = new Maquina(0, maquinaDTO.getTipoMaquinariaId(), maquinaDTO.getMaquina(), LocalDateTime.now(), maquinaDTO.isEstatus());
        data.save(maquina);
        return new responseDTO(HttpStatus.OK.toString(), "Maquina registrada correctamente");
    }

    public responseDTO deleteMaquina(int maquinaId) {
        if (!findById(maquinaId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La máquina no existe");
        }
        data.deleteById(maquinaId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
