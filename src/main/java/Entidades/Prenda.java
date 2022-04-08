package Entidades;

import EstadosPrendas.*;


public class Prenda {
    Double precioPropio;
    TipoPrenda tipoPrenda;
    Estado estadoPrenda;

    public Prenda(Double precio, TipoPrenda tipo, Estado estado){
        this.precioPropio=precio;
        this.tipoPrenda=tipo;
        this.estadoPrenda=estado;
    }

    public TipoPrenda getTipo() {
        return tipoPrenda;
    }

    public Double precio(){
        return this.estadoPrenda.precioPrenda(this.precioPropio);
    }
}

