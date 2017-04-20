package Model;

/**
 * Created by joaquinjimenezgarcia on 17/4/17.
 * Clase padre de la jerarquía de electrodomésticos
 */
public abstract class Electrodomestico {
    private String marca;
    private String modelo;
    private double precioBase;
    private char consumoEnergetico;
    private double altura;
    private double anchura;
    private double peso;

    public Electrodomestico() {

    }

    public Electrodomestico(String marca, String modelo, double precioBase, char consumoEnergetico, double altura, double anchura, double peso) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecioBase(precioBase);
        this.setConsumoEnergetico(consumoEnergetico);
        this.setAltura(altura);
        this.setAnchura(anchura);
        this.setPeso(peso);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.equals(" ")){
            this.marca = "Sin marca";
        }else {
            this.marca = marca;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo.equals("")) {
            this.modelo = "Sin modelo";
        }else {
            this.modelo = modelo;
        }
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase < 0) {
            this.precioBase = 0.0;
        } else {
            this.precioBase = precioBase;
        }
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        switch (consumoEnergetico){
            case 'A':
                this.consumoEnergetico = 'A';
                break;
            case 'B':
                this.consumoEnergetico = 'B';
                break;
            case 'C':
                this.consumoEnergetico = 'C';
                break;
            case 'D':
                this.consumoEnergetico = 'D';
                break;
            case 'E':
                this.consumoEnergetico = 'E';
                break;
            case 'F':
                this.consumoEnergetico = 'F';
                break;
            default:
                this.consumoEnergetico = 'F';
                break;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if(altura>0) {
            this.altura = altura;
        }else{
            this.altura = 0;
        }
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        if(anchura>0) {
            this.anchura = anchura;
        }else{
            this.anchura = 0;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso>0) {
            this.peso = peso;
        }else{
            this.peso = 0;
        }
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precioBase=" + precioBase +
                ", consumoEnergetico=" + consumoEnergetico +
                ", altura=" + altura +
                ", anchura=" + anchura +
                ", peso=" + peso +
                '}';
    }

    public double precioBruto(){
        double resultado = this.precioBase;

        switch (this.consumoEnergetico){
            case 'A':
                resultado += 100.0;
                break;
            case 'B':
                resultado += 80.0;
                break;
            case 'C':
                resultado += 60.0;
                break;
            case 'D':
                resultado += 50.0;
                break;
            case 'E':
                resultado += 30.0;
                break;
            case 'F':
                resultado += 10.0;
                break;
            default:
                break;
        }

        return resultado;
    }

    public double precioTransporte(){
        double precio = 0.0;

        if (peso < 20){
            precio = 10.0;
        }else if (peso >= 20 && peso < 50){
            precio = 50.0;
        }else if (peso >= 50 && peso < 80){
            precio = 80.0;
        }else{
            precio = 100.0;
        }

        return precio;
    }

    public double pvp(){
        return this.precioBruto() + precioTransporte();
    }
}
