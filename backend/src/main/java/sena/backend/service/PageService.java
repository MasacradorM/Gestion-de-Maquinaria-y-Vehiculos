package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.PageDTO;
import sena.backend.model.Page;
import sena.backend.repository.IPage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageService {

    private final IPage repository;

    public List<PageDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PageDTO> findById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public Page save(PageDTO dto) {
        Page page = convertToModel(dto);
        return repository.save(page);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<PageDTO> findByName(String filter) {
        return repository.findByNameContainingIgnoreCase(filter)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PageDTO convertToDTO(Page page) {
        return PageDTO.builder()
                .name(page.getName())
                .description(page.getDescription())
                .url(page.getUrl())
                .build();
    }

    private Page convertToModel(PageDTO dto) {
        return Page.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .build();
    }
}
