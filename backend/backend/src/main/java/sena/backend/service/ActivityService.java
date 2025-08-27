package sena.backend.service;

import sena.backend.dto.ActivityDTO;
import sena.backend.model.Activity;
import sena.backend.repository.IActivity;
import sena.backend.dto.ResponseDTO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private IActivity activityRepository;

    public List<ActivityDTO> findAll() {
        return activityRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ActivityDTO> findById(Integer id) {
        return activityRepository.findById(id).map(this::convertToDTO);
    }

    public List<ActivityDTO> findByName(String filter) {
        return activityRepository.findByActivityNameContainingIgnoreCase(filter)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void save(ActivityDTO dto) {
        Activity activity = convertToModel(dto);
        activityRepository.save(activity);
    }

    public ResponseDTO deleteActivity(Integer id) {
        activityRepository.deleteById(id);
        return new ResponseDTO(HttpStatus.BAD_REQUEST.toString(), "Work deleted successfully");
    }

    // ----------- CONVERSIÓN ----------
    private ActivityDTO convertToDTO(Activity activity) {
        return ActivityDTO.builder()
                .activityName(activity.getActivityName())
                .build();
    }

    private Activity convertToModel(ActivityDTO dto) {
        return Activity.builder()
                .activityName(dto.getActivityName())
                .build();
    }
}

