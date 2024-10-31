
package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import java.util.ArrayList;

public class ComboTest {

    private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new ProductoMenu("Hamburguesa", 10000);
        producto2 = new ProductoMenu("Papas", 5000);
        ArrayList<ProductoMenu> items = new ArrayList<>();
        items.add(producto1);
        items.add(producto2);
        combo = new Combo("Combo 1", 0.8, items); // 20% discount
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo 1", combo.getNombre(), "El nombre del combo no es el esperado");
    }

    @Test
    public void testGetPrecio() {
        int expectedPrice = (int) ((10000 + 5000) * (0.8)); // (Base price of items) * discount
        assertEquals(expectedPrice, combo.getPrecio(), "El precio del combo no es el esperado");
    }

    @Test
    public void testGenerarTextoFactura() {
        String expected = "Combo Combo 1\n Descuento: 0.8\n            12000\n";
        String actual = combo.generarTextoFactura();
        assertEquals(expected, actual, "El texto de la factura no es el esperado");
    }
}

