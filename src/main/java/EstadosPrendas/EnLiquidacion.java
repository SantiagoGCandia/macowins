package EstadosPrendas;

public class EnLiquidacion implements Estado {

    @Override
    public Double precioPrenda(Double precio) {
        return precio * 0.5;
    }

}
