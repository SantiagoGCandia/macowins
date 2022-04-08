package Ventas;

public class VentaTarjeta extends Venta{
    Integer cantidadCuotas;
    Double coeficienteTarjeta;

    public VentaTarjeta(int cuotas, Double coeficiente){
        super();
        this.cantidadCuotas=cuotas;
        this.coeficienteTarjeta=coeficiente;
    }

    @Override
    Double recargo(){
        return (this.importe())*((coeficienteTarjeta * cantidadCuotas) + 0.01);
    }
}