
package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

	 private ProductoMenu pm;
	
	 @BeforeEach
	 @DisplayName("Inicialización ProductoMenu")
	 public void setUp() {
	  pm = new ProductoMenu("Hamburguesa", 10000);
	 }
	
	 @Test
	 @DisplayName("Nombre correcto ProductoMenu")
	 public void testGetNombre() {
	  assertEquals("Hamburguesa", pm.getNombre(), "El nombre del producto no es el esperado");
	 }
	
	 @Test
	 @DisplayName("Precio correcto ProductoMenu")
	 public void testGetPrecio() {
	  assertEquals(10000, pm.getPrecio(), "El precio del producto no es el esperado");
	 }
	 
	 @Test
	 @DisplayName("Generar texto factura ProductoMenu")
		public void testGenerarTextoFactura() {
			assertEquals("Hamburguesa\n            10000\n", pm.generarTextoFactura(),
					"El texto de la factura no es el esperado");
		}

}

