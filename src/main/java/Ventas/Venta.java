package Ventas;

import Entidades.Prenda;

import java.time.LocalDate;
//import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    List<Item> prendas = new ArrayList<Item>();
    LocalDate fecha;
//    LocalTime hora;

    public Venta(){
        ZoneId region =ZoneId.of("America/Argentina/Buenos_Aires");
        this.fecha= LocalDate.now(region);
//        this.hora= LocalTime.now(region);
    }

    Double recargo() {
        return 0.0;
    }

    public void agregarItem(Prenda prenda, int cantidad){
        Item item = new Item(prenda, cantidad);
        this.prendas.add(item);
    }

    public Double importe(){
        return prendas.stream().mapToDouble(item -> item.precio()).sum();
    }
    public Double importeFinal(){
        return this.importe()+ this.recargo();
    }

    public Boolean esDeFecha(LocalDate fechaAComparar){
        return fecha.toString().equals(fechaAComparar.toString());
    }
}

