package sena.backend.service;

import sena.backend.dto.WorkDTO;
import sena.backend.model.Work;
import sena.backend.repository.IWork;
import sena.backend.dto.ResponseDTO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkService {

    @Autowired
    private IWork workRepository;

    public List<WorkDTO> findAll() {
        return workRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<WorkDTO> findById(Integer id) {
        return workRepository.findById(id).map(this::convertToDTO);
    }

    public List<WorkDTO> findByName(String filter) {
        return workRepository.findByWorkContainingIgnoreCase(filter)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void save(WorkDTO dto) {
        Work work = convertToModel(dto);
        workRepository.save(work);
    }

    public ResponseDTO deleteWork(Integer id) {
        workRepository.deleteById(id);
        return new ResponseDTO(HttpStatus.BAD_REQUEST.toString(), "Work deleted successfully");
    }

    // ----------- CONVERSIÓN ----------
    private WorkDTO convertToDTO(Work work) {
        return WorkDTO.builder()
                .work(work.getWork())
                .build();
    }

    private Work convertToModel(WorkDTO dto) {
        return Work.builder()
                .work(dto.getWork())
                .build();
    }
}
