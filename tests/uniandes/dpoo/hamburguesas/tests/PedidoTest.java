package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido;
	private ProductoAjustado productoAjustado;
	private ProductoMenu productoMenu;
	private Ingrediente ingrediente1;
    private Ingrediente ingrediente2;
    private int idPedido;
	
	@BeforeEach
	void setUp() {
		pedido= new Pedido("Juan", "Calle 1");
		idPedido=1;
		productoMenu= new ProductoMenu("Hamburguesa", 10000);
		productoAjustado= new ProductoAjustado(productoMenu);
		ingrediente1 = new Ingrediente("Queso", 2000);
        ingrediente2 = new Ingrediente("Tocineta", 3000);
        productoAjustado.agregados.add(ingrediente1);
        productoAjustado.agregados.add(ingrediente2);
        productoAjustado.eliminados.add(new Ingrediente("Cebolla", 0));
			

	}
	
	@Test
	public void testgetIdPedido() {
        assertEquals(1, pedido.getIdPedido(), "El id del pedido no es el esperado");
    
	}
	
	@Test
	public void testGetNombreCliente() {
		assertEquals("Juan", pedido.getNombreCliente(), "El nombre del cliente no es el esperado");

	}
	
	@Test
	public void testGetProductos() {
		assertEquals(0, pedido.getProductos().size(), "El pedido no debería tener productos");
	}
	
	@Test
	public void testAgregarProducto() {
		pedido.agregarProducto(productoAjustado);
		assertEquals(productoAjustado, pedido.getProductos().get(0), "El producto agregado no es el esperado");
	}
	
	@Test
	public void testGetPrecioTotalPedido() {
		pedido.agregarProducto(productoAjustado);
		assertEquals(17850, pedido.getPrecioTotalPedido(), "El precio total del pedido no es el esperado");
	}
	
	@Test
	public void testGenerarTextoFactura() {
		pedido.agregarProducto(productoAjustado);
        String expected = "Cliente: Juan\n" +
                          "Dirección: Calle 1\n" +
                          "----------------\n" +
                          "Hamburguesa" +
                    
                          "----------------\n" +
                          "Precio Neto:  15000\n" +
                          "IVA:          2850\n" +
                          "Precio Total: 17850\n";
        String actual = pedido.generarTextoFactura();
        assertEquals(expected, actual, "El texto de la factura no es el esperado");
    }
	
	@Test
    public void testGuardarFactura() throws IOException {
        pedido.agregarProducto(productoAjustado);
        Path tempFile = Files.createTempFile("factura", ".txt");
        File archivo = tempFile.toFile();

        try {
            pedido.guardarFactura(archivo);
            String expected = "Cliente: Juan\n" +
                              "Dirección: Calle 1\n" +
                              "----------------\n" +
                              "Hamburguesa" +
                              
                              "----------------\n" +
                              "Precio Neto:  15000\n" +
                              "IVA:          2850\n" +
                              "Precio Total: 17850\n";
            String actual = Files.readString(tempFile);
            assertEquals(expected, actual, "El contenido de la factura no es el esperado");
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

}
