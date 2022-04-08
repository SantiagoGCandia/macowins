package Ventas;

import Entidades.Prenda;

public class Item {
    Prenda prenda;
    int cantidad;

    Item(Prenda prenda, int cantidad){
        this.prenda=prenda;
        this.cantidad=cantidad;
    }

    public Double precio() {
        return prenda.precio()*cantidad;
    }
}
