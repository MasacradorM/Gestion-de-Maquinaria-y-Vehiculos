package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "report_machinery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportMachinery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportMachineryId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateReport;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "municipalitiesId", nullable = false)
    private Municipalities municipality;

    @ManyToOne
    @JoinColumn(name = "machineId", nullable = false)
    private Machines machine;

    @ManyToOne
    @JoinColumn(name = "workId", nullable = false)
    private Work work;

    @ManyToOne
    @JoinColumn(name = "activityId", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Atributos propios
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal initialHourmeter;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal finalHourmeter;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalHours;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal hourRate;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal totalCost;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal gallons;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal gallonCost;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal refuelHour;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal fuelEfficiency;

    @Column(precision = 10, scale = 6)
    private BigDecimal gps;

    @Column(length = 500)
    private String remarks;

    @Column(nullable = false)
    private Integer report;
}

