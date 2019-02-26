package com.example.usuario.trabajoprimertrimestre.utilidades;

public class Utilidades {


    //constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_USUARIO_DNI="dni";
    public static final String CAMPO_USUARIO_NOMBRE="nombre";
    public static final String CAMPO_USUARIO_APELLIDOS="apellidos";
    public static final String CAMPO_USUARIO_NOMBRE_USUARIO="nombre_usuario";
    public static final String CAMPO_USUARIO_CONTRASEÑA="contrasenya";
    public static final String CAMPO_USUARIO_FOTO="foto";
    public static final String CAMPO_USUARIO_INFORMATICO="es_informatico";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_USUARIO_NOMBRE+" TEXT,"+CAMPO_USUARIO_APELLIDOS+" TEXT,"+CAMPO_USUARIO_DNI+" TEXT,"+CAMPO_USUARIO_NOMBRE_USUARIO+" TEXT,"+CAMPO_USUARIO_CONTRASEÑA+" TEXT,"+CAMPO_USUARIO_FOTO+" TEXT,"+CAMPO_USUARIO_INFORMATICO+" BOOLEAN)";


    //constantes campos tabla incidencias

    public static final String TABLA_INCIDENCIAS="incidencias";
    public static final String CAMPO_INCIDENCIAS_DNI="dni";
    public static final String CAMPO_INCIDENCIAS_FECHA_INCIDENCIA="fecha_incidencia";
    public static final String CAMPO_INCIDENCIAS_OBSERVACIONES="observaciones";
    public static final String CAMPO_INCIDENCIAS_DNI_INFORMATICO="dni_informatico";
    public static final String CAMPO_INCIDENCIAS_ESTADO_INCIDENCIAS="estado_incidencia";
    public static final String CAMPO_INCIDENCIAS_FECHA_RESOLUCION_INCIDENCIA="fecha_resolucion_incidencia";
    public static final String CAMPO_INCIDENCIAS_OBSERVACIONES_INFORMATICO="observaciones_informatico";

    public static final String CREAR_TABLA_INCIDENCIAS="CREATE TABLE "+TABLA_INCIDENCIAS+"("+CAMPO_INCIDENCIAS_DNI+" TEXT,"+CAMPO_INCIDENCIAS_FECHA_INCIDENCIA+" TEXT,"+CAMPO_INCIDENCIAS_OBSERVACIONES+" TEXT,"+CAMPO_INCIDENCIAS_DNI_INFORMATICO+" TEXT,"+CAMPO_INCIDENCIAS_ESTADO_INCIDENCIAS+" TEXT,"+CAMPO_INCIDENCIAS_FECHA_RESOLUCION_INCIDENCIA+" TEXT,"+CAMPO_INCIDENCIAS_OBSERVACIONES_INFORMATICO+" TEXT)";

}
