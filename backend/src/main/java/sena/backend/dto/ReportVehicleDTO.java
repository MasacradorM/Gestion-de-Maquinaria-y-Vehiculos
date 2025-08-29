package sena.backend.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ReportVehicleDTO {

    private Integer vehicleReportId;
    private Date dateReport;
    private Integer municipalityId;
    private Integer vehicleId;
    private Integer workId;
    private Integer activityId;

    private Integer trip;
    private Integer quantity;
    private BigDecimal value;
    private BigDecimal gallons;
    private BigDecimal fuel;
    private BigDecimal fuelKilometer;
    private BigDecimal performance;
    private BigDecimal gps;
    private Integer maximumSpeed;
    private String observations;

    private Integer userId;
    private Integer report;
}

