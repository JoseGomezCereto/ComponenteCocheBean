/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.io.Serializable;

/**
 *
 * @author josegomez
 */
public class Coche implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private int kilometros;
    private int anoMatriculacion;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, int kilometros, int anoMatriculacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
        this.anoMatriculacion = anoMatriculacion;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public int getAnoMatriculacion() {
        return anoMatriculacion;
    }

    public void setAnoMatriculacion(int anoMatriculacion) {
        this.anoMatriculacion = anoMatriculacion;
    }

}
