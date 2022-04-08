package Entidades;

import Ventas.Venta;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {
    List<Venta> ventas = new ArrayList<Venta>();;

    public void registrarVenta(Venta venta){
        ventas.add(venta);
    }

    public Double gananciaDia(LocalDate fecha){
        return ventasDelDia(fecha).stream().mapToDouble(venta -> venta.importeFinal()).sum();
    }

    public List<Venta> ventasDelDia(LocalDate fecha){
        return (List<Venta>) ventas.stream().filter(venta -> venta.esDeFecha(fecha)).collect(Collectors.toList());
    }
}


