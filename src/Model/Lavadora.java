package Model;

/**
 * Created by joaquinjimenezgarcia on 17/4/17.
 */
public class Lavadora extends Electrodomestico{
    private String tipoCarga;
    private int velocidadCentrifugado;
    private boolean secadora;

    public Lavadora() {
        super();
    }

    public Lavadora(String marca, String modelo, double precioBase, char consumoEnergetico, double altura, double anchura, double peso, String tipoCarga, int velocidadCentrifugado, boolean secadora) {
        super(marca, modelo, precioBase, consumoEnergetico, altura, anchura, peso);
        this.setTipoCarga(tipoCarga);
        this.setVelocidadCentrifugado(velocidadCentrifugado);
        this.setSecadora(secadora);
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        if (tipoCarga.equals("Superior") || tipoCarga.equals("Frontal")) {
            this.tipoCarga = tipoCarga;
        } else {
            this.tipoCarga = "No especificado";
        }
    }

    public int getVelocidadCentrifugado() {
        return velocidadCentrifugado;
    }

    public void setVelocidadCentrifugado(int velocidadCentrifugado) {
        if (velocidadCentrifugado > 0) {
            this.velocidadCentrifugado = velocidadCentrifugado;
        }else{
            this.velocidadCentrifugado = 0;
        }
    }

    public boolean isSecadora() {
        return secadora;
    }

    public void setSecadora(boolean secadora) {
        this.secadora = secadora;
    }

    @Override
    public String toString() {
        return super.toString() + " ####> Lavadora{" +
                "tipoCarga='" + tipoCarga + '\'' +
                ", velocidadCentrifugado=" + velocidadCentrifugado +
                ", secadora=" + secadora +
                '}';
    }

    public double ingresoTotalLavadoras(Lavadora...lavadoras){
        double totalIngresoLavadoras = 0.0;

        for (Lavadora lavadora: lavadoras){
            totalIngresoLavadoras += lavadora.pvp();
        }

        return totalIngresoLavadoras;
    }
}
