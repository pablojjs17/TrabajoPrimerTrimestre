package com.example.usuario.trabajoprimertrimestre.BaseDeDatos;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String DNI;
    private String nombre_usuario;
    private String contraseña;
    private String foto;
    private boolean informatico;

    public Usuario(String nombre, String apellidos, String DNI, String nombre_usuario, String contraseña, String foto, boolean informatico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.foto = foto;
        this.informatico = informatico;
    }

    public Usuario() {
        this.nombre = "";
        this.apellidos = "";
        this.DNI = "";
        this.nombre_usuario = "";
        this.contraseña = "";
        this.foto = "";
        this.informatico = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isInformatico() {
        return informatico;
    }

    public void setInformatico(Boolean informatico) {
        this.informatico = informatico;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", foto='" + foto + '\'' +
                ", informatico=" + informatico +
                '}';
    }
}
