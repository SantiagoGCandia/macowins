import Entidades.Prenda;
import Entidades.Tienda;
import Entidades.TipoPrenda;
import EstadosPrendas.EnLiquidacion;
import EstadosPrendas.EnPromocion;
import EstadosPrendas.Nueva;
import Ventas.Venta;
import Ventas.VentaTarjeta;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  private Prenda pantalonEnPromocion(int precioBase, int descuento) {
    return new Prenda((double) precioBase, TipoPrenda.PANTALON, new EnPromocion((double) descuento));
  }


  private Prenda camisaNueva(int precioBase) {
    return new Prenda((double) precioBase, TipoPrenda.CAMISA, new Nueva());
  }

  private Prenda sacoEnLiquidacion(int precioBase) {
    return new Prenda((double) precioBase, TipoPrenda.SACO, new EnLiquidacion());
  }

  @Test
  public void ventasDeUnDia(){
    LocalDate hoy = LocalDate.now(ZoneId.of("America/Argentina/Buenos_Aires"));
    assertEquals(unaTiendaConVentas().gananciaDia(hoy), 5607.0, 0.0);
  }

  private Tienda unaTiendaConVentas(){
    Tienda miTienda = new Tienda();
    Venta ventaEfectivo = new Venta();
    VentaTarjeta ventaTarjeta = new VentaTarjeta(12, 0.5);

    ventaEfectivo.agregarItem(sacoEnLiquidacion(200),2);
    ventaEfectivo.agregarItem(camisaNueva(100),5);

    ventaTarjeta.agregarItem(sacoEnLiquidacion(200),2);
    ventaTarjeta.agregarItem(camisaNueva(100),5);

    miTienda.registrarVenta(ventaEfectivo);
    miTienda.registrarVenta(ventaTarjeta);

    return miTienda;

  }




}
