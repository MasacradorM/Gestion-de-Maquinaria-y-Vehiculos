package INCOINT.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import INCOINT.demo.DTO.VehiculoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.Vehiculo;
import INCOINT.demo.repository.IVehiculo;

@Service
public class VehiculoService {

    @Autowired
    private IVehiculo data;

    public List<Vehiculo> findAll() {
        return data.findAll();
    }

    public Optional<Vehiculo> findById(int vehiculoId) {
        return data.findById(vehiculoId);
    }

    public responseDTO save(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = new Vehiculo(0, vehiculoDTO.getTipoVehiculoId(), vehiculoDTO.getVehiculo(), LocalDateTime.now(), vehiculoDTO.isEstatus());
        data.save(vehiculo);
        return new responseDTO(HttpStatus.OK.toString(), "Vehículo registrado correctamente");
    }

    public responseDTO deleteVehiculo(int vehiculoId) {
        if (!findById(vehiculoId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El vehículo no existe");
        }
        data.deleteById(vehiculoId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
