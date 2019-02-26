package com.example.usuario.trabajoprimertrimestre.BaseDeDatos;

import java.util.Date;

public class Incidencias {
    private String dni;
    private String fecha_incidencia;
    private String observaciones;
    private String dni_informatico;
    private String estado_incidencia;
    private String fecha_resolucion_incidencia;
    private String observaciones_informatico;

    public Incidencias(String dni, String fecha_incidencia, String observaciones, String dni_informatico, String estado_incidencia, String fecha_resolucion_incidencia, String observaciones_informatico) {
        this.dni = dni;
        this.fecha_incidencia = fecha_incidencia;
        this.observaciones = observaciones;
        this.dni_informatico = dni_informatico;
        this.estado_incidencia = estado_incidencia;
        this.fecha_resolucion_incidencia = fecha_resolucion_incidencia;
        this.observaciones_informatico = observaciones_informatico;
    }

    public Incidencias() {
        this.dni = "";
        this.fecha_incidencia = "";
        this.observaciones = "";
        this.dni_informatico = "";
        this.estado_incidencia = "";
        this.fecha_resolucion_incidencia = "";
        this.observaciones_informatico = "";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_incidencia() {
        return fecha_incidencia;
    }

    public void setFecha_incidencia(String fecha_incidencia) {
        this.fecha_incidencia = fecha_incidencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDni_informatico() {
        return dni_informatico;
    }

    public void setDni_informatico(String dni_informatico) {
        this.dni_informatico = dni_informatico;
    }

    public String getEstado_incidencia() {
        return estado_incidencia;
    }

    public void setEstado_incidencia(String estado_incidencia) {
        this.estado_incidencia = estado_incidencia;
    }

    public String getFecha_resolucion_incidencia() {
        return fecha_resolucion_incidencia;
    }

    public void setFecha_resolucion_incidencia(String fecha_resolucion_incidencia) {
        this.fecha_resolucion_incidencia = fecha_resolucion_incidencia;
    }

    public String getObservaciones_informatico() {
        return observaciones_informatico;
    }

    public void setObservaciones_informatico(String observaciones_informatico) {
        this.observaciones_informatico = observaciones_informatico;
    }

    @Override
    public String toString() {
        return "Incidencias{" +
                "dni='" + dni + '\'' +
                ", fecha_incidencia='" + fecha_incidencia + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", dni_informatico='" + dni_informatico + '\'' +
                ", estado_incidencia='" + estado_incidencia + '\'' +
                ", fecha_resolucion_incidencia='" + fecha_resolucion_incidencia + '\'' +
                ", observaciones_informatico='" + observaciones_informatico + '\'' +
                '}';
    }
}
