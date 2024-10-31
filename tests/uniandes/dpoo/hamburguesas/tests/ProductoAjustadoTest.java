package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	
	private ProductoAjustado pa;
	private ProductoMenu pm;
	private Ingrediente ingrediente1;
    private Ingrediente ingrediente2;
	
	@BeforeEach
	public void setUp() {
		pm = new ProductoMenu("Hamburguesa", 10000);
		pa = new ProductoAjustado(pm);
		ingrediente1 = new Ingrediente("Queso", 2000);
        ingrediente2 = new Ingrediente("Tocineta", 3000);
        pa.agregados.add(ingrediente1);
        pa.agregados.add(ingrediente2);
        pa.eliminados.add(new Ingrediente("Cebolla", 0));

	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Hamburguesa", pa.getNombre(), "El nombre del producto no es el esperado");
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(15000, pa.getPrecio(), "El precio del producto no es el esperado es: "+pa.getPrecio());
	}
	
	@Test
    public void testGenerarTextoFactura() {
        String expected = "Hamburguesa    +Queso                2000    +Tocineta                3000    -Cebolla            15000\n";
        String actual = pa.generarTextoFactura();
        assertEquals(expected, actual, "El texto de la factura no es el esperado");
    }

}
