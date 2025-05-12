package INCOINT.demo.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import INCOINT.demo.model.Actividad;
import INCOINT.demo.model.Municipio;
import INCOINT.demo.model.Obra;
import INCOINT.demo.model.Personal;
import INCOINT.demo.model.Trayecto;
import INCOINT.demo.model.Vehiculo;

public class ReporteVehiculoDTO {

    private LocalDate fecha;
    private Vehiculo vehiculosId;
    private Municipio municipioId;
    private Obra obraId;
    private Actividad actividad;
    private Trayecto trayecto;
    private int cantidad;
    private BigDecimal valor;
    private BigDecimal galones;
    private BigDecimal combustible;
    private BigDecimal KMtanqueo;
    private BigDecimal rendimiento;
    private BigDecimal gps;
    private int velocidadMax;
    private String observaciones;
    private Personal personal;
    private int reporte;

    public ReporteVehiculoDTO(LocalDate fecha, Vehiculo vehiculosId, Municipio municipioId, Obra obraId, Actividad actividad, Trayecto trayecto, int cantidad, BigDecimal valor, BigDecimal galones, BigDecimal combustible, BigDecimal KMtanqueo, BigDecimal rendimiento, BigDecimal gps, int velocidadMax, String observaciones, Personal personal, int reporte) {
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
