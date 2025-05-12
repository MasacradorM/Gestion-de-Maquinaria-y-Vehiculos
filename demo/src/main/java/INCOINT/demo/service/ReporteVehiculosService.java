package INCOINT.demo.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import INCOINT.demo.DTO.ReporteVehiculoDTO;
import INCOINT.demo.DTO.responseDTO;
import INCOINT.demo.model.ReporteVehiculos;
import INCOINT.demo.repository.IReporteVehiculos;

@Service
public class ReporteVehiculosService {

    @Autowired
    private IReporteVehiculos data;

    public Optional<ReporteVehiculos> findById(int reporteVehiculosId) {
        return data.findById(reporteVehiculosId);
    }
    public List<ReporteVehiculos> findAll() {
        return data.findAll();
    }


    public responseDTO save(ReporteVehiculoDTO reporteVehiculoDTO) {
        ReporteVehiculos reporteVehiculo = 
        new ReporteVehiculos(
            0,
            reporteVehiculoDTO.getFecha(), 
            reporteVehiculoDTO.getVehiculosId(), 
            reporteVehiculoDTO.getMunicipioId(), 
            reporteVehiculoDTO.getObraId(), 
            reporteVehiculoDTO.getActividad(), 
            reporteVehiculoDTO.getTrayecto(), 
            reporteVehiculoDTO.getCantidad(), 
            reporteVehiculoDTO.getValor(), 
            reporteVehiculoDTO.getGales(), 
            reporteVehiculoDTO.getCombustible(), 
            reporteVehiculoDTO.getKMtanqueo(), 
            reporteVehiculoDTO.getRendimiento(), 
            reporteVehiculoDTO.getGps(), 
            reporteVehiculoDTO.getVelocidadMax(), 
            reporteVehiculoDTO.getObservaciones(), 
            reporteVehiculoDTO.getPersonal(),
            reporteVehiculoDTO.getReporte()
        );
        data.save(reporteVehiculo);
        return new responseDTO(HttpStatus.OK.toString(), "Reporte Vehículos registrado correctamente");
    }

    public responseDTO deleteReporteVehiculos(int reporteVehiculosId) {
        if (!findById(reporteVehiculosId).isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El reporte no existe");
        }
        data.deleteById(reporteVehiculosId);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
}
