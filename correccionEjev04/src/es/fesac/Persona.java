package es.fesac;

import java.text.DecimalFormat;

/**
 * Created by thinway on 1/3/17.
 */
public class Persona {

    DecimalFormat formateador = new DecimalFormat("###.###");

    private String  nombre;
    private int     edad;
    private String  dni;
    private char    sexo;
    private double  peso;
    private int     altura;

    // Constructores

    public Persona() {
        this("", 0, 'H', 0.0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {

        this(nombre, edad, sexo, 0.0, 0);

    }

    public Persona(String nombre, int edad, char sexo, double peso, int altura) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setSexo(sexo);
        this.setPeso(peso);
        this.setAltura(altura);
        this.dni = generarDNI();
    }


    // Accesores


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if ( edad < 0 ){
            this.edad = 0;
        }else{
            this.edad = edad;
        }
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if ( sexo != 'H' && sexo != 'M' ){
            this.sexo = '-';
        }else{
            this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0){
            this.peso = 0;
        }else{
            this.peso = peso;
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura < 0){
            this.altura = 0;
        }else{
            this.altura = altura;
        }
    }

    // Métodos

    public double indiceMasaCorporal(){
        double imc;

        if ( altura == 0){
            imc = 0;
        }else{
            double alturaMetros = (double) altura / 100;
            imc = peso / (alturaMetros * alturaMetros);
        }


        return imc;
    }

    public boolean esMayorEdad(){
        return (getEdad()>=18)?true:false;
    }

    @Override
    public String toString() {
        String mayoria = (esMayorEdad())?"Es mayor ":"Es menor ";

        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", " + mayoria +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                ", IMC=" + formateador.format (indiceMasaCorporal()) +
                '}';
    }

    private String generarDNI(){
        String resultado = "";

        for (int i = 0; i < 8; i++) {
            int valor = (int)(Math.random()*10);
            resultado += valor;
        }

        return resultado + "-" + "TRWAGMYFPDXBNJZSQVHLCKE".charAt( Integer.parseInt(resultado) % 23 );
    }
}
