package sena.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "report_vehicle")
@Getter
@Setter
public class ReportVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleReportId;

    @Temporal(TemporalType.DATE)
    private Date dateReport;

    @ManyToOne
    @JoinColumn(name = "municipality_id", referencedColumnName = "municipalitiesId")
    private Municipalities municipality;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "work_id", referencedColumnName = "workId")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activityId")
    private Activity activity;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    private Integer report;
}


