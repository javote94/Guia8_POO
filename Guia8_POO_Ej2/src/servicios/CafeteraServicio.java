package servicios;

import console.Console;
import entidades.Cafetera;

public class CafeteraServicio {

    public Cafetera crearCafetera() {

        double capacidad = Console.inputDouble("Ingresar capacidad máxima de la cafetera: ");
        double cantidad = Console.inputDouble("Ingresar cantidad actual de café que contiene la cafetera: ");

        return new Cafetera(capacidad, cantidad);
    }

    public void llenarCafetera(Cafetera objeto) {
        
        Console.println("Llenando la cafetera hasta la capacidad máxima...");
        objeto.setCantidadActual(objeto.getCapacidadMaxima());
    }

    public void servirTaza(Cafetera objeto) {
        
        double capacidadTaza = Console.inputDouble("Indicar capacidad de la taza de café a servir: ");
        
        if (objeto.getCantidadActual() >= capacidadTaza) {
            Console.println("Se ha llenado la taza");
            objeto.setCantidadActual(objeto.getCantidadActual() - capacidadTaza);       
        }else{
            Console.println("El contenido de la cafetera no alcanzó para llenar la taza. "
                    + "La taza quedó en: " + objeto.getCantidadActual());
            objeto.setCantidadActual(0);
        }
        
        Console.println("Luego de servir la taza, en la cafetera quedó: " + objeto.getCantidadActual());
    }
    
    public void vaciarCafetera(Cafetera objeto){
        Console.println("Vaciando la cafetera...");
        objeto.setCantidadActual(0);
    }
    
    public void agregarCafe(Cafetera objeto){
        
        double cantidadCafe = Console.inputDouble("Indicar la cantidad de café a añadir en la cafetera: ");
        double faltanteCafe = objeto.getCapacidadMaxima() - objeto.getCantidadActual();
        
        if (cantidadCafe <= faltanteCafe) {
            Console.println("Recargando la cafetera...");
            objeto.setCantidadActual(objeto.getCantidadActual() + cantidadCafe);
        }else{
            Console.println("La recarga no puede hacer que la cantidad actual supere "
                    + "la capacidad de la cafetera");
        }
    }
}
