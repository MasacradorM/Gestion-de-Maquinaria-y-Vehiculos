package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.ReportMachineryDTO;
import sena.backend.model.Activity;
import sena.backend.model.Machines;
import sena.backend.model.Municipalities;
import sena.backend.model.ReportMachinery;
import sena.backend.model.User;
import sena.backend.model.Work;
import sena.backend.repository.IReportMachinery;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportMachineryService {

    private final IReportMachinery repository;

    // Obtener todos como DTO
    public List<ReportMachineryDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID como DTO
    public Optional<ReportMachineryDTO> findById(Integer reportMachineryId) {
        return repository.findById(reportMachineryId).map(this::convertToDTO);
    }

    // Filtrar por fecha como DTO
    public List<ReportMachineryDTO> filterForDate(Date filterDate) {
        return repository.findByDateReport(filterDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Guardar desde DTO y devolver DTO
    public ReportMachineryDTO save(ReportMachineryDTO dto) {
        ReportMachinery entity = convertToModel(dto);
        return convertToDTO(repository.save(entity));
    }

    // Eliminar
    public void deleteReportMachinery(Integer reportMachineryId) {
        repository.deleteById(reportMachineryId);
    }

    // ================== CONVERSIONES ==================

    // Entity -> DTO
    public ReportMachineryDTO convertToDTO(ReportMachinery entity) {
        return ReportMachineryDTO.builder()
                .reportMachineryId(entity.getReportMachineryId())
                .dateReport(entity.getDateReport())
                .municipalityId(entity.getMunicipality().getMunicipalitiesId()) // OJO: municipalitiesId
                .machineId(entity.getMachine().getMachineId())
                .workId(entity.getWork().getWorkId())
                .activityId(entity.getActivity().getActivityId())
                .userId(entity.getUser().getUserId())
                .initialHourmeter(entity.getInitialHourmeter())
                .finalHourmeter(entity.getFinalHourmeter())
                .totalHours(entity.getTotalHours())
                .hourRate(entity.getHourRate())
                .totalCost(entity.getTotalCost())
                .gallons(entity.getGallons())
                .gallonCost(entity.getGallonCost())
                .refuelHour(entity.getRefuelHour())
                .fuelEfficiency(entity.getFuelEfficiency())
                .gps(entity.getGps())
                .remarks(entity.getRemarks())
                .report(entity.getReport())
                .build();
    }

    // DTO -> Entity
    public ReportMachinery convertToModel(ReportMachineryDTO dto) {
        ReportMachinery entity = new ReportMachinery();
        entity.setReportMachineryId(dto.getReportMachineryId());
        entity.setDateReport(dto.getDateReport());

        // Asociaciones mínimas por ID (sin cargar de BD)
        Municipalities mun = new Municipalities();
        mun.setMunicipalitiesId(dto.getMunicipalityId()); // OJO: municipalitiesId
        entity.setMunicipality(mun);

        Machines machine = new Machines();
        machine.setMachineId(dto.getMachineId());
        entity.setMachine(machine);

        Work work = new Work();
        work.setWorkId(dto.getWorkId());
        entity.setWork(work);

        Activity activity = new Activity();
        activity.setActivityId(dto.getActivityId());
        entity.setActivity(activity);

        User user = new User();
        user.setUserId(dto.getUserId());
        entity.setUser(user);

        // Campos propios
        entity.setInitialHourmeter(dto.getInitialHourmeter());
        entity.setFinalHourmeter(dto.getFinalHourmeter());
        entity.setTotalHours(dto.getTotalHours());
        entity.setHourRate(dto.getHourRate());
        entity.setTotalCost(dto.getTotalCost());
        entity.setGallons(dto.getGallons());
        entity.setGallonCost(dto.getGallonCost());
        entity.setRefuelHour(dto.getRefuelHour());
        entity.setFuelEfficiency(dto.getFuelEfficiency());
        entity.setGps(dto.getGps());
        entity.setRemarks(dto.getRemarks());
        entity.setReport(dto.getReport());

        return entity;
    }
}

