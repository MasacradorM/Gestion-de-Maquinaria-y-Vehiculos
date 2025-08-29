package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.ReportVehicleDTO;
import sena.backend.model.*;
import sena.backend.repository.IReportVehicle;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportVehicleService {

    private final IReportVehicle repository;

    // Obtener todos
    public List<ReportVehicleDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public Optional<ReportVehicleDTO> findById(Integer vehicleReportId) {
        return repository.findById(vehicleReportId).map(this::convertToDTO);
    }

    // Filtrar por fecha
    public List<ReportVehicleDTO> filterForDate(Date filterDate) {
        return repository.findByDateReport(filterDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Guardar
    public ReportVehicleDTO save(ReportVehicleDTO dto) {
        ReportVehicle report = convertToModel(dto);
        return convertToDTO(repository.save(report));
    }

    // Eliminar
    public void deleteVehicleReport(Integer vehicleReportId) {
        repository.deleteById(vehicleReportId);
    }

    // ----------------- CONVERSIONES -----------------
    public ReportVehicleDTO convertToDTO(ReportVehicle report) {
        return ReportVehicleDTO.builder()
                .vehicleReportId(report.getVehicleReportId())
                .dateReport(report.getDateReport())
                .municipalityId(report.getMunicipality().getMunicipalitiesId())
                .vehicleId(report.getVehicle().getVehicleId())
                .workId(report.getWork().getWorkId())
                .activityId(report.getActivity().getActivityId())
                .trip(report.getTrip())
                .quantity(report.getQuantity())
                .value(report.getValue())
                .gallons(report.getGallons())
                .fuel(report.getFuel())
                .fuelKilometer(report.getFuelKilometer())
                .performance(report.getPerformance())
                .gps(report.getGps())
                .maximumSpeed(report.getMaximumSpeed())
                .observations(report.getObservations())
                .userId(report.getUser().getUserId())
                .report(report.getReport())
                .build();
    }

    public ReportVehicle convertToModel(ReportVehicleDTO dto) {
        ReportVehicle report = new ReportVehicle();
        report.setVehicleReportId(dto.getVehicleReportId());
        report.setDateReport(dto.getDateReport());

        Municipalities municipality = new Municipalities();
        municipality.setMunicipalitiesId(dto.getMunicipalityId());
        report.setMunicipality(municipality);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        report.setVehicle(vehicle);

        Work work = new Work();
        work.setWorkId(dto.getWorkId());
        report.setWork(work);

        Activity activity = new Activity();
        activity.setActivityId(dto.getActivityId());
        report.setActivity(activity);

        User user = new User();
        user.setUserId(dto.getUserId());
        report.setUser(user);

        report.setTrip(dto.getTrip());
        report.setQuantity(dto.getQuantity());
        report.setValue(dto.getValue());
        report.setGallons(dto.getGallons());
        report.setFuel(dto.getFuel());
        report.setFuelKilometer(dto.getFuelKilometer());
        report.setPerformance(dto.getPerformance());
        report.setGps(dto.getGps());
        report.setMaximumSpeed(dto.getMaximumSpeed());
        report.setObservations(dto.getObservations());
        report.setReport(dto.getReport());

        return report;
    }
}
