import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void testAgregarYBuscarProducto() {
        Inventario inv = new Inventario();
        Producto p = new Producto("X001", "Tablet", "Android", 300.0, 5);
        assertTrue(inv.agregarProducto(p));
        assertNotNull(inv.buscarPorCodigo("X001"));
    }

    @Test
    public void testEliminarProductoInexistente() {
        Inventario inv = new Inventario();
        assertFalse(inv.eliminarProducto("NOEXISTE"));
    }

    @Test
    public void testBuscarPorNombreParcial() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("M001", "Mouse", "Inalámbrico", 70, 4));
        assertEquals(1, inv.buscarPorNombre("mou").size());
    }

    @Test
    public void testCalcularValorInventario() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("A001", "SSD", "512GB", 100.0, 2));
        inv.agregarProducto(new Producto("A002", "HDD", "1TB", 80.0, 1));
        assertEquals(280.0, inv.calcularValorTotalInventario());
    }
}
