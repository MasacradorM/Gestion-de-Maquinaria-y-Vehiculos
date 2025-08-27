package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.MachinesDTO;
import sena.backend.model.Machines;
import sena.backend.model.TypeMachinery;
import sena.backend.repository.IMachines;
import sena.backend.repository.ITypeMachinery;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachinesService {

    private final IMachines machinesRepository;
    private final ITypeMachinery typeMachineryRepository;

    public List<Machines> findAll() {
        return machinesRepository.findAll();
    }

    public List<Machines> findByPlate(String filter) {
        return machinesRepository.findByPlateContainingIgnoreCase(filter);
    }

    public Optional<Machines> findById(Integer id) {
        return machinesRepository.findById(id);
    }

    public MachinesDTO save(MachinesDTO dto) {
        Machines machine = convertToModel(dto);
        Machines saved = machinesRepository.save(machine);
        return convertToDTO(saved);
    }

    public void deleteMachines(Integer id) {
        machinesRepository.deleteById(id);
    }

    // Conversión DTO -> Entidad
    private Machines convertToModel(MachinesDTO dto) {
        TypeMachinery typeMachinery = typeMachineryRepository.findById(dto.getTypeMachineryId())
                .orElseThrow(() -> new RuntimeException("Tipo de maquinaria no encontrado"));

        return Machines.builder()
                .plate(dto.getPlate())
                .typeMachinery(typeMachinery)
                .status(true) // siempre se crea activa
                .build();
    }

    // Conversión Entidad -> DTO
    private MachinesDTO convertToDTO(Machines machine) {
        return MachinesDTO.builder()
                .plate(machine.getPlate())
                .typeMachineryId(machine.getTypeMachinery().getTypeMachineryId())
                .build();
    }

}
