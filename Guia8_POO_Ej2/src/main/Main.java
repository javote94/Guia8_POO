package main;

import console.Console;
import entidades.Cafetera;
import servicios.CafeteraServicio;

public class Main {

    public static void main(String[] args) {

        int opcion;
        String confirma;

        CafeteraServicio cs = new CafeteraServicio();

        Cafetera cafetera1 = cs.crearCafetera();
        Console.println(cafetera1);

        do {
            Console.println("\n\t.:CAFETERÍA:."
                    + "\n1. Servir taza del cliente"
                    + "\n2. Recargar la cafetera"
                    + "\n3. LLenar la cafetera"
                    + "\n4. Vaciar la cafetera"
                    + "\n5. Finalizar servicio");

            opcion = Console.inputInt("Elegir una opción: ");

            switch (opcion) {
                case 1:
                    cs.servirTaza(cafetera1);
                    break;
                case 2:
                    cs.agregarCafe(cafetera1);
                    break;
                case 3:
                    cs.llenarCafetera(cafetera1);
                    break;
                case 4:
                    cs.vaciarCafetera(cafetera1);
                    break;
                case 5:
                    Console.println("Ha finalizado el servicio de atención al ciente");
                    break;
                default:
                    ;
            }

            if (opcion >= 1 && opcion <= 4) {
                confirma = Console.inputStr("Desea realizar otra acción?(Y/N)");
                if (confirma.equalsIgnoreCase("Y")) {
                    continue;
                } else {
                    break;
                }
            }

        } while (opcion != 5);

        Console.println("Se cierra la cafetería");
    }

}
