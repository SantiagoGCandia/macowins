package EstadosPrendas;

public class EnPromocion implements Estado {
    Double descuento;

    public EnPromocion(Double descuentoAAplicar){
        this.descuento=descuentoAAplicar;
    }

    public Double precioPrenda(Double precio) {
        return precio - descuento;
    }
}
