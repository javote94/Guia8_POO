package main;

import entidades.CuentaBancaria;
import servicios.CuentaBancariaServicio;
import console.Console;

public class Main {

    public static void main(String[] args) {

        int opcion;
        String confirma = "N";

        //Instanciación de objeto de la Clase Servicios para acceder a los métodos
        CuentaBancariaServicio cs = new CuentaBancariaServicio();

        //Instanciación de objeto de la Clase CuentaBancaria
        CuentaBancaria cuenta1 = cs.crearCuenta();

        do {
            Console.println("\n\t.:MENÚ:."
                    + "\n1. Depositar efectivo en la cuenta"
                    + "\n2. Retirar efectivo de la cuenta"
                    + "\n3. Extracción rápida (hasta 20% del saldo)"
                    + "\n4. Consultar datos de la cuenta"
                    + "\n5. Salir del menú");

            opcion = Console.inputInt("Por favor, ingrese una opción: ");

            switch (opcion) {
                case 1:
                    cs.ingresarEfectivo(cuenta1);
                    break;
                case 2:
                    cs.retirarEfectivo(cuenta1);
                    break;
                case 3:
                    cs.extraccionRapida(cuenta1);
                    break;
                case 4:
                    cs.consultarDatos(cuenta1);
                    break;
                case 5:
                    Console.println("Está saliendo del menú");
                    break;
                default:
                    Console.println("Opción incorrecta. Por favor, digite opción entre 1 y 5.");
            }

            if (opcion >= 1 && opcion <= 4) {
                confirma = Console.inputStr("Desea volver al menú?(Y/N): ");
                if (confirma.equalsIgnoreCase("Y")) {
                    continue;
                }else{
                    break;
                }
            }

        } while (opcion != 5);

        Console.println("Ha salido del programa");

    }
}
