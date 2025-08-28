package sena.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.backend.dto.RolePageDTO;
import sena.backend.model.Role;
import sena.backend.model.Page;
import sena.backend.model.RolePage;
import sena.backend.repository.IRolePage;
import sena.backend.repository.IRole;
import sena.backend.repository.IPage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolePageService {

    private final IRolePage rolePageRepository;
    private final IRole roleRepository;
    private final IPage pageRepository;

    public List<RolePage> findAll() {
        return rolePageRepository.findAll();
    }

    public Optional<RolePage> findById(Integer id) {
        return rolePageRepository.findById(id);
    }

    public RolePage save(RolePageDTO dto) {
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Page page = pageRepository.findById(dto.getPageId())
                .orElseThrow(() -> new RuntimeException("Page not found"));

        RolePage rolePage = RolePage.builder()
                .role(role)
                .page(page)
                .build();

        return rolePageRepository.save(rolePage);
    }

    public void deleteById(Integer id) {
        rolePageRepository.deleteById(id);
    }
}
