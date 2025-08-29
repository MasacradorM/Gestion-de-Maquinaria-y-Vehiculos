package sena.backend.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportMachineryDTO {
    private Integer reportMachineryId;
    private Date dateReport;
    private Integer municipalityId;
    private Integer machineId;
    private Integer workId;
    private Integer activityId;
    private Integer userId;

    private BigDecimal initialHourmeter;
    private BigDecimal finalHourmeter;
    private BigDecimal totalHours;
    private BigDecimal hourRate;
    private BigDecimal totalCost;
    private BigDecimal gallons;
    private BigDecimal gallonCost;
    private BigDecimal refuelHour;
    private BigDecimal fuelEfficiency;
    private BigDecimal gps;
    private String remarks;
    private Integer report;
}



