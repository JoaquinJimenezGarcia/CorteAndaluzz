package es.fesac;

public class Main {

    public static void main(String[] args) {
        Persona fran = new Persona(
                "Fran",
                34,
                'H',
                85,
                192);

        Persona maria = new Persona(
                "Maria",
                30,
                'M');

        Persona amidala = new Persona();

        System.out.println(fran);
        System.out.println(maria);
        System.out.println(amidala);

    }
}
