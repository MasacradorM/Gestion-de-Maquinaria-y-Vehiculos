package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.TipoVehiculoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.TipoVehiculo;
import INCOINT.demo.repository.ITipoVehiculo;

@Service
public class TipoVehiculoService {

    @Autowired
    private ITipoVehiculo data;

    public List<TipoVehiculo> findAll() {
        return data.findAll();
    }

    public Optional<TipoVehiculo> findById(int tipoVehiculoId) {
        return data.findById(tipoVehiculoId);
    }

    public responseDTO save(TipoVehiculoDTO tipoVehiculoDTO) {
        TipoVehiculo tipoVehiculo = new TipoVehiculo(0, tipoVehiculoDTO.getTipoVehiculo());
        data.save(tipoVehiculo);
        return new responseDTO(HttpStatus.OK.toString(), "Tipo de vehículo registrado correctamente");
    }

    public responseDTO deleteTipoVehiculo(int tipoVehiculoId) {
        if (!findById(tipoVehiculoId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El tipo de vehículo no existe");
        }
        data.deleteById(tipoVehiculoId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
