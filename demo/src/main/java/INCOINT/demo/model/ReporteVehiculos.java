package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name="reporte_vehiculos")
public class ReporteVehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reporte_vehiculos_id")
    private int reporteVehiculosId;

    @Column(name="fecha", nullable = false)
    private LocalDate fecha;

    @Column(name="vehiculos_id", nullable = false)
    private Vehiculo vehiculosId;

    @Column(name="municipio_id", nullable = false)
    private Municipio municipioId;

    @Column(name="obra_id", nullable = false)
    private Obra obraId;

    @Column(name="actividad", nullable = false)
    private Actividad actividad;

    @Column(name="trayecto", nullable = true)
    private Trayecto trayecto;

    @Column(name="cantidad", nullable = false)
    private int cantidad;

    @Column(name="valor", nullable = false)
    private BigDecimal valor;

    @Column(name="galones", nullable = true)
    private BigDecimal galones;

    @Column(name="combustible", nullable = false)
    private BigDecimal combustible;

    @Column(name="KMtanqueo", nullable = true)
    private BigDecimal KMtanqueo;

    @Column(name="rendimiento", nullable = true)
    private BigDecimal rendimiento;

    @Column(name="gps", nullable = true)
    private BigDecimal gps;

    @Column(name="velocidad_max", nullable = true)
    private int velocidadMax;

    @Column(name="observaciones", length = 150, nullable = true)
    private String observaciones;

    @Column(name="personal", nullable = false)
    private Personal personal;

    @Column(name="reporte", nullable = true)
    private int reporte;

    public ReporteVehiculos(int reporteVehiculosId, LocalDate fecha, Vehiculo vehiculosId, Municipio municipioId, Obra obraId, Actividad actividad, Trayecto trayecto, int cantidad, BigDecimal valor, BigDecimal galones, BigDecimal combustible, BigDecimal KMtanqueo, BigDecimal rendimiento, BigDecimal gps, int velocidadMax, String observaciones, Personal personal, int reporte) {
        this.reporteVehiculosId = reporteVehiculosId;
        this.fecha = fecha;
        this.vehiculosId = vehiculosId;
        this.municipioId = municipioId;
        this.obraId = obraId;
        this.actividad = actividad;
        this.trayecto = trayecto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.galones = galones;
        this.combustible = combustible;
        this.KMtanqueo = KMtanqueo;
        this.rendimiento = rendimiento;
        this.gps = gps;
        this.velocidadMax = velocidadMax;
        this.observaciones = observaciones;
        this.personal = personal;
        this.reporte = reporte;
    }

    public int getReporteVehiculosId() {
        return reporteVehiculosId;
    }

    public void setReporteVehiculosId(int reporteVehiculosId) {
        this.reporteVehiculosId = reporteVehiculosId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculosId() {
        return vehiculosId;
    }

    public void setVehiculosId(Vehiculo vehiculosId) {
        this.vehiculosId = vehiculosId;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Obra getObraId() {
        return obraId;
    }

    public void setObraId(Obra obraId) {
        this.obraId = obraId;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getGales() {
        return galones;
    }

    public void setGales(BigDecimal galones) {
        this.galones = galones;
    }

    public BigDecimal getCombustible() {
        return combustible;
    }

    public void setCombustible(BigDecimal combustible) {
        this.combustible = combustible;
    }

    public BigDecimal getKMtanqueo() {
        return KMtanqueo;
    }

    public void setKMtanqueo(BigDecimal KMtanqueo) {
        this.KMtanqueo = KMtanqueo;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }

    public BigDecimal getGps() {
        return gps;
    }

    public void setGps(BigDecimal gps) {
        this.gps = gps;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public int getReporte() {
        return reporte;
    }

    public void setReporte(int reporte) {
        this.reporte = reporte;
    }
}
