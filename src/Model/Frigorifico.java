package Model;

import java.util.Arrays;

/**
 * Created by joaquinjimenezgarcia on 17/4/17.
 */
public class Frigorifico extends Electrodomestico{
    private int capacidadTotal;
    private int capacidadCongelador;
    private String[] caracteristicas;

    public Frigorifico() {
        super();
    }

    public Frigorifico(String marca, String modelo, double precioBase, char consumoEnergetico, double altura, double anchura, double peso, int capacidadTotal, int capacidadCongelador, String[] caracteristicas) {
        super(marca, modelo, precioBase, consumoEnergetico, altura, anchura, peso);
        this.setCapacidadTotal(capacidadTotal);
        this.setCapacidadCongelador(capacidadCongelador);
        this.setCaracteristicas(caracteristicas);
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        if(capacidadTotal>0){
            this.capacidadTotal = capacidadTotal;
        }else{
            this.capacidadTotal = 0;
        }
    }

    public int getCapacidadCongelador() {
        return capacidadCongelador;
    }

    public void setCapacidadCongelador(int capacidadCongelador) {
        if(capacidadCongelador > 0 && capacidadCongelador < capacidadTotal){
            this.capacidadCongelador = capacidadCongelador;
        }else{
            this.capacidadCongelador = 0;
        }
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return super.toString() + " ####> Frigorifico{" +
                "capacidadTotal=" + capacidadTotal +
                ", capacidadCongelador=" + capacidadCongelador +
                ", caracteristicas=" + Arrays.toString(caracteristicas) +
                '}';
    }

    public static double ingresoTotalFrigorifico(Frigorifico...frigorificos){
        double ingresoTotalFrigorifico = 0.0;

        for (Frigorifico frigorifico: frigorificos){
            ingresoTotalFrigorifico += frigorifico.pvp();
        }

        return ingresoTotalFrigorifico;
    }
}
