package servicios;

import console.Console;
import entidades.CuentaBancaria;

public class CuentaBancariaServicio {

    /**
     * La función retorna un objeto de la clase CuentaBancaria con los atributos
     * inicializados por el usuario. Se solicita número de cuenta, dni y saldo.
     *
     * @return objeto de la clase CuentaBancaria
     */
    public CuentaBancaria crearCuenta() {

        int num = Console.inputInt("Ingresar número de cuenta: ");
        int dni = Console.inputInt("Ingresar DNI del cliente: ");
        double saldo = Console.inputDouble("Ingresar saldo actual de la cuenta: ");

        return new CuentaBancaria(num, dni, saldo);
    }

    /**
     * La función le solicita al usuario la cantidad a depositar. Los fondos
     * depositados tienen como destino la cuenta que se pasa como argumento.
     *
     * @param objeto
     */
    public void ingresarEfectivo(CuentaBancaria objeto) {
        
        double deposito = Console.inputDouble("Ingresar cantidad de dinero a depositar en la cuenta: ");
        double saldoFinal = objeto.getSaldoActual() + deposito;

        objeto.setSaldoActual(saldoFinal);
    }
    
    /**
     * La función le solicita al usuario la cantidad a retirar. Los fondos
     * se deducen del saldo actual de la cuenta que se pasa como argumento.
     * @param objeto 
     */
    public void retirarEfectivo(CuentaBancaria objeto) {
        double retiro = Console.inputDouble("Ingresar cantidad de dinero a retirar de la cuenta: ");

        double saldoFinal;
        if (retiro <= objeto.getSaldoActual()) {
            saldoFinal = objeto.getSaldoActual() - retiro;
        } else {
            saldoFinal = 0;
        }

        objeto.setSaldoActual(saldoFinal);
    }
    
    /**
     * La función le solicita al usuario retirar hasta un 20% del saldo actual.
     * @param objeto
     */
    public void extraccionRapida(CuentaBancaria objeto){
        
        double limite = 0.2 * objeto.getSaldoActual();
        double extraccion = Console.inputDouble("Ingresar cantidad de dinero a "
                + "retirar de la cuenta (hasta un 20% del saldo = "+limite+"): ");
        
        double saldoFinal;
        if(extraccion <= limite){
            saldoFinal = objeto.getSaldoActual() - extraccion;
            objeto.setSaldoActual(saldoFinal);
        }else{
            Console.println("No puede retirar más del 20% del saldo actual");
        }
    }
    
    public void consultarDatos(CuentaBancaria objeto){
        Console.println("Número de cuenta: " + objeto.getNumeroCuenta());
        Console.println("DNI del cliente: " + objeto.getDniCliente());
        Console.println("Saldo actual: " + objeto.getSaldoActual());
    }
}
