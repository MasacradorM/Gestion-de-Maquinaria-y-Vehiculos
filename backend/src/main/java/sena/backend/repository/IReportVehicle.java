package sena.backend.repository;

import sena.backend.model.ReportVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReportVehicle extends JpaRepository<ReportVehicle, Integer> {
    List<ReportVehicle> findByDateReport(Date dateReport);
}


