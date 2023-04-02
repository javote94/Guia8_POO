
package servicios;

import console.Console;
import entidades.Persona;

public class PersonaServicio {
    
    public Persona crearPersona(){
        
        String nombre = Console.inputStr("Ingresar nombre: ");
        int edad = Console.inputInt("Ingresar edad: ");
        
        char sexo;
        do {
            sexo = Console.inputChr("Ingresar sexo (H/M/O): ");
        } while (sexo != 'H' && sexo != 'M' && sexo != 'O');

        double peso = Console.inputDouble("Ingresar peso: ");
        double altura = Console.inputDouble("Ingresar altura: ");

        return new Persona(nombre, edad, sexo, peso, altura);   
    }
    
    public boolean esMayorDeEedad(Persona x){
        return x.getEdad() >= 18;
    }
    
    public int calcularIMC(Persona x){
        double formulaIMC = x.getPeso() / (Math.pow(x.getAltura(), 2));
        if (formulaIMC < 20) {
            return -1;
        }else if(formulaIMC >= 20 && formulaIMC <= 25){
            return 0;
        }else{
            return 1;
        }
    }
    
    public void mostrarVectorPersona(Persona[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("[" + vector[i] + "]");
        }
    }
    
    public void mostrarVectorEdad(boolean[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("[" + vector[i] + "]");
        }
    }
    
    public void mostrarVectorIMC(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("[" + vector[i] + "]");
        }
    }
    
}
