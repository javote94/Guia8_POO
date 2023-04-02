package main;

import console.Console;
import entidades.Persona;
import servicios.PersonaServicio;

public class Main {

    public static void main(String[] args) {
        
        //Instanciación del objeto (cs) de la clase Servicios para acceder a los métodos
        PersonaServicio cs = new PersonaServicio();
        
        //Declaración y dimensión de los vectores de tipo Persona, boolean e int.
        int nTotal = Console.inputInt("Cuántos objetos de tipo Persona desea crear: ");
        Persona[] vectorPersona = new Persona[nTotal];
        boolean[] vectorEdad = new boolean[nTotal];
        int[] vectorIMC = new int[nTotal];
        
        //Inicialización de contadores
        double nMayor = 0;
        double nMenor = 0;
        double nFlaco = 0;
        double nIdeal = 0;
        double nGordo = 0;
        
        //Bucle for para resolución de consigna
        for (int i = 0; i < nTotal; i++) {

            //Instanciación de los objetos de clase Persona y asignados a cada elemento del vector de tipo Persona[]
            Console.println("\t.:Creando persona n°" + (i + 1) + ":.");
            vectorPersona[i] = cs.crearPersona();
            
            //La función retorna valor booleano y se asigna a cada elemento del vector de tipo boolean[]
            //El parámetro de la función es un objeto de clase Persona
            vectorEdad[i] = cs.esMayorDeEedad(vectorPersona[i]);
            if (vectorEdad[i]) {  //si es mayor
                nMayor++;
            } else {              //si es menor
                nMenor++;
            }
            
            //La función retorna un valor entero (-1, 0, 1) y se asigna a cada elemento del vector de tipo int[]
            //El parámetro de la función es un objeto de clase Persona
            vectorIMC[i] = cs.calcularIMC(vectorPersona[i]);
            switch (vectorIMC[i]) {
                case -1:         //debajo del peso ideal
                    nFlaco++;
                    break;
                case 0:          //peso ideal
                    nIdeal++;
                    break;
                default:         //sobrepeso
                    nGordo++;
                    break;
            }
        }
        
        //Chequeamos los tres vectores que armamos antes de acudir a los resultados
        cs.mostrarVectorPersona(vectorPersona);  //atributos
        cs.mostrarVectorEdad(vectorEdad);        //true o false
        cs.mostrarVectorIMC(vectorIMC);          //(-1), (0), (1)
        
        //Resultados (en porcentajes)
        Console.println("\t.:ESTADÍSTICAS:."
                + "\nPersonas flacas: " + ((nFlaco / nTotal) * 100)
                + "\nPersonas con peso ideal: " + ((nIdeal / nTotal) * 100)
                + "\nPersonas con sobrepeso: " + ((nGordo / nTotal) * 100)
                + "\nPersonas mayores de edad: " + ((nMayor / nTotal) * 100)
                + "\nPersonas menores de edad: " + ((nMenor / nTotal) * 100));

    }
}
