package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteTest {
	
	private Restaurante restaurantePrueba;
	private ArrayList<ProductoMenu> productos;
	private ArrayList<Combo> combos;
	private ArrayList<Ingrediente> ingredientes;
	

@BeforeEach
public void setUp() {
    restaurantePrueba = new Restaurante();
    productos = new ArrayList<>();
    combos = new ArrayList<>();
    ingredientes = new ArrayList<>();

    // Create products
    ProductoMenu corral = new ProductoMenu("corral", 14000);
    ProductoMenu corralQueso = new ProductoMenu("corral queso", 16000);
    ProductoMenu corralPollo = new ProductoMenu("corral pollo", 15000);
    ProductoMenu corralita = new ProductoMenu("corralita", 13000);
    ProductoMenu todoterreno = new ProductoMenu("todoterreno", 25000);
    ProductoMenu mediaLibra = new ProductoMenu("1/2 libra", 25000);
    ProductoMenu especial = new ProductoMenu("especial", 24000);
    ProductoMenu casera = new ProductoMenu("casera", 23000);
    ProductoMenu mexicana = new ProductoMenu("mexicana", 22000);
    ProductoMenu criolla = new ProductoMenu("criolla", 22000);
    ProductoMenu costeña = new ProductoMenu("costeña", 20000);
    ProductoMenu hawaiana = new ProductoMenu("hawaiana", 20000);
    ProductoMenu wrapPollo = new ProductoMenu("wrap de pollo", 15000);
    ProductoMenu wrapLomo = new ProductoMenu("wrap de lomo", 22000);
    ProductoMenu ensaladaMexicana = new ProductoMenu("ensalada mexicana", 20900);
    ProductoMenu papasMedianas = new ProductoMenu("papas medianas", 5500);
    ProductoMenu papasGrandes = new ProductoMenu("papas grandes", 6900);
    ProductoMenu papasCascoMedianas = new ProductoMenu("papas en casco medianas", 5500);
    ProductoMenu papasCascoGrandes = new ProductoMenu("papas en casco grandes", 6900);
    ProductoMenu aguaSinGas = new ProductoMenu("agua cristal sin gas", 5000);
    ProductoMenu aguaConGas = new ProductoMenu("agua cristal con gas", 5000);
    ProductoMenu gaseosa = new ProductoMenu("gaseosa", 5000);

    // Add products to the list
    productos.add(corral);
    productos.add(corralQueso);
    productos.add(corralPollo);
    productos.add(corralita);
    productos.add(todoterreno);
    productos.add(mediaLibra);
    productos.add(especial);
    productos.add(casera);
    productos.add(mexicana);
    productos.add(criolla);
    productos.add(costeña);
    productos.add(hawaiana);
    productos.add(wrapPollo);
    productos.add(wrapLomo);
    productos.add(ensaladaMexicana);
    productos.add(papasMedianas);
    productos.add(papasGrandes);
    productos.add(papasCascoMedianas);
    productos.add(papasCascoGrandes);
    productos.add(aguaSinGas);
    productos.add(aguaConGas);
    productos.add(gaseosa);


    // Create combos
    ArrayList<ProductoMenu> itemsComboCorral = new ArrayList<>();
    itemsComboCorral.add(corral);
    itemsComboCorral.add(papasMedianas);
    itemsComboCorral.add(gaseosa);
    Combo comboCorral = new Combo("combo corral", 0.10, itemsComboCorral);

    ArrayList<ProductoMenu> itemsComboCorralQueso = new ArrayList<>();
    itemsComboCorralQueso.add(corralQueso);
    itemsComboCorralQueso.add(papasMedianas);
    itemsComboCorralQueso.add(gaseosa);
    Combo comboCorralQueso = new Combo("combo corralqueso", 0.10, itemsComboCorralQueso);

    ArrayList<ProductoMenu> itemsComboTodoterreno = new ArrayList<>();
    itemsComboTodoterreno.add(todoterreno);
    itemsComboTodoterreno.add(papasGrandes);
    itemsComboTodoterreno.add(gaseosa);
    Combo comboTodoterreno = new Combo("combo todoterreno", 0.07, itemsComboTodoterreno);

    ArrayList<ProductoMenu> itemsComboEspecial = new ArrayList<>();
    itemsComboEspecial.add(especial);
    itemsComboEspecial.add(papasMedianas);
    itemsComboEspecial.add(gaseosa);
    Combo comboEspecial = new Combo("combo especial", 0.095, itemsComboEspecial);

    // Add combos to the list
    combos.add(comboCorral);
    combos.add(comboCorralQueso);
    combos.add(comboTodoterreno);
    combos.add(comboEspecial);

    // Add ingredients to the list
    ingredientes.add(new Ingrediente("queso", 2000));
    ingredientes.add(new Ingrediente("tocineta", 3000));
    ingredientes.add(new Ingrediente("cebolla", 1000));
    ingredientes.add(new Ingrediente("pepinillos", 500));
    ingredientes.add(new Ingrediente("salsa especial", 1500));
    ingredientes.add(new Ingrediente("lechuga", 1000));
    ingredientes.add(new Ingrediente("tomate", 1000));
    ingredientes.add(new Ingrediente("queso mozzarella", 2500));
    ingredientes.add(new Ingrediente("huevo", 2500));
    ingredientes.add(new Ingrediente("queso americano", 2500));
    ingredientes.add(new Ingrediente("tocineta express", 2500));
    ingredientes.add(new Ingrediente("papa callejera", 2000));
    ingredientes.add(new Ingrediente("pepinillos", 2500));
    ingredientes.add(new Ingrediente("cebolla grille", 2500));
    ingredientes.add(new Ingrediente("suero costeño", 3000));
    ingredientes.add(new Ingrediente("frijol refrito", 4500));
    ingredientes.add(new Ingrediente("queso fundido", 4500));
    ingredientes.add(new Ingrediente("tocineta picada", 6000));
    ingredientes.add(new Ingrediente("piña", 2500));

    restaurantePrueba.getMenuBase().addAll(productos);
    restaurantePrueba.getMenuCombos().addAll(combos);
    restaurantePrueba.getIngredientes().addAll(ingredientes);
}

	@Test
	public void testIniciarPedido() {
		try {
			restaurantePrueba.iniciarPedido("Juan", "Calle 1");
			assertEquals(1, restaurantePrueba.getPedidos().size(), "El pedido no se ha iniciado correctamente");
		} catch (YaHayUnPedidoEnCursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
        
    
	}
	
	@Test
	public void testIniciarPedidoCuandoYaHayUnPedidoEnCurso() {
		try {
			restaurantePrueba.iniciarPedido("Juan", "Calle 1");
			restaurantePrueba.iniciarPedido("Pedro", "Calle 2");
			assertEquals(1, restaurantePrueba.getPedidos().size(), "El pedido no se ha iniciado correctamente");
		} catch (YaHayUnPedidoEnCursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testCerrarYGuardarPedido( ) throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException {
		
		
			
            restaurantePrueba.iniciarPedido("Juan", "Calle 1");
          
            restaurantePrueba.cerrarYGuardarPedido();
           
            assertNull(restaurantePrueba.getPedidoEnCurso(), "El pedido no se ha cerrado correctamente");
            
       
    
	}
	
	@Test
	public void testCerrarYGuardarPedidoCuandoNoHayPedidoEnCurso() {
		try {
			restaurantePrueba.cerrarYGuardarPedido();
		} catch (NoHayPedidoEnCursoException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
    public void testGetMenuBase() {
        // Verify the size of the menu base
        assertEquals(22, restaurantePrueba.getMenuBase().size(), "El menú base no se ha cargado correctamente");
    }
	
	@Test
	public void testGetMenuCombos() {
		// Verify the size of the menu combos
		assertEquals(4, restaurantePrueba.getMenuCombos().size(), "El menú de combos no se ha cargado correctamente");
	}
	
	@Test
	public void testGetIngredientes() {
		// Verify the size of the ingredients
		assertEquals(19, restaurantePrueba.getIngredientes().size(),
				"Los ingredientes no se han cargado correctamente");
	}
	
	@Test
	public void TestcargarInformacionRestaurante() throws NumberFormatException, HamburguesaException, IOException {
		File archivoCombos = new File("./data/combos.txt");
	    File archivoIngredientes = new File("./data/ingredientes.txt");
	    File archivoMenu = new File("./data/menu.txt");
	    Restaurante restaurante = new Restaurante();
	    restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

	    List<Ingrediente> actualIngredientes = restaurante.getIngredientes();
	    List<ProductoMenu> actualMenu = restaurante.getMenuBase();
	    List<Combo> actualCombos = restaurante.getMenuCombos();

	    // Debug statements
	    System.out.println("Expected Ingredientes: " + ingredientes);
	    System.out.println("Actual Ingredientes: " + actualIngredientes);
	    System.out.println("Expected Menu: " + productos);
	    System.out.println("Actual Menu: " + actualMenu);
	    System.out.println("Expected Combos: " + combos);
	    System.out.println("Actual Combos: " + actualCombos);

	    // Assertions
	    assertAll("Cargar Informacion Restaurante",
	        () -> assertEquals(ingredientes, actualIngredientes, "Los ingredientes no se cargaron correctamente"),
	        () -> assertEquals(productos, actualMenu, "El menu base no se cargo correctamente"),
	        () -> assertEquals(combos, actualCombos, "El menu de combos no se cargo correctamente")
	    );	
			
			
	}
	
	@Test 
	public void TestIngredienteRepetido() throws NumberFormatException, HamburguesaException, IOException {
		//Usa el archivo IngredientesRepetidos.txt
		
			File archivoIngredientes = new File("data/IngredientesRepetidos.txt");
			
			boolean error = false;
			
			try {
				restaurantePrueba.cargarInformacionRestaurante(null, null, archivoIngredientes);
			} catch (HamburguesaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			}
			assertTrue(error, "El archivo tiene ingredientes repetidos");
		
    
		
	}
	
	@Test
	public void TestProductoFaltante() throws NumberFormatException, HamburguesaException, IOException {
	

		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos2.txt");
		File archivoIngredientes = new File("data/ingredientes.txt");
		

		boolean error = false;

		try {
			restaurantePrueba.cargarInformacionRestaurante(archivoMenu, archivoCombos, archivoIngredientes);
		} catch (ProductoFaltanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error = true;
		}
		assertTrue(error, "El archivo tiene un producto faltante");

	}
	
	

}
