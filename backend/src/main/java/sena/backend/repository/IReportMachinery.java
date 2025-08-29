package sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

import sena.backend.model.ReportMachinery;

@Repository
public interface IReportMachinery extends JpaRepository<ReportMachinery, Integer> {
    List<ReportMachinery> findByDateReport(Date dateReport);
}

