/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio34;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author tomas
 */
public class POJO {

    // Atributos qu contienen los datos del fichero.                                                                          
    private String nombre;
    private String dni_pasaporte;
    private String tipoPersonal;
    private String puestoTrabajo;
    private boolean horarioPersonalizado;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private String horasIniciales;
    private String totalHoras;
    private String activo;

    // CReo un constructor vacio para poder meter los datos que voy leyendo en este. 
    public POJO() {
    }
    
    // Getters y Setters. 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni_pasaporte() {
        return dni_pasaporte;
    }

    public void setDni_pasaporte(String dni_pasaporte) {
        this.dni_pasaporte = dni_pasaporte;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public boolean isHorarioPersonalizado() {
        return horarioPersonalizado;
    }

    public void setHorarioPersonalizado(boolean horarioPersonalizado) {
        this.horarioPersonalizado = horarioPersonalizado;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getHorasIniciales() {
        return horasIniciales;
    }

    public void setHorasIniciales(String horasIniciales) {
        this.horasIniciales = horasIniciales;
    }

    public String getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.dni_pasaporte);
        hash = 23 * hash + Objects.hashCode(this.tipoPersonal);
        hash = 23 * hash + Objects.hashCode(this.puestoTrabajo);
        hash = 23 * hash + (this.horarioPersonalizado ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.fechaAlta);
        hash = 23 * hash + Objects.hashCode(this.fechaBaja);
        hash = 23 * hash + Objects.hashCode(this.horasIniciales);
        hash = 23 * hash + Objects.hashCode(this.totalHoras);
        hash = 23 * hash + Objects.hashCode(this.activo);
        return hash;
    }

    // Equals y HashCode.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final POJO other = (POJO) obj;
        if (this.horarioPersonalizado != other.horarioPersonalizado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dni_pasaporte, other.dni_pasaporte)) {
            return false;
        }
        if (!Objects.equals(this.tipoPersonal, other.tipoPersonal)) {
            return false;
        }
        if (!Objects.equals(this.puestoTrabajo, other.puestoTrabajo)) {
            return false;
        }
        if (!Objects.equals(this.horasIniciales, other.horasIniciales)) {
            return false;
        }
        if (!Objects.equals(this.totalHoras, other.totalHoras)) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        if (!Objects.equals(this.fechaAlta, other.fechaAlta)) {
            return false;
        }
        return Objects.equals(this.fechaBaja, other.fechaBaja);
    }

    @Override
    public String toString() {
        return nombre + "," + dni_pasaporte + "," + tipoPersonal + "," + puestoTrabajo + "," + horarioPersonalizado + "," + fechaAlta + "," + fechaBaja + "," + horasIniciales + "," + totalHoras + "," + activo ;
    }
    
    
    
    
    

}
