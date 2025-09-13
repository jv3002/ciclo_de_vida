import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    public void testCrearProducto() {
        Producto p = new Producto("P001", "Teclado", "Mecánico", 120.5, 10);
        assertEquals("Teclado", p.getNombre());
        assertEquals(10, p.getCantidad());
    }

    @Test
    public void testSetPrecioInvalido() {
        Producto p = new Producto("P002", "Mouse", "Óptico", 50.0, 5);
        assertThrows(IllegalArgumentException.class, () -> p.setPrecio(-10.0));
    }

    @Test
    public void testSetCantidadNegativa() {
        Producto p = new Producto("P003", "Monitor", "24 pulgadas", 200.0, 3);
        assertThrows(IllegalArgumentException.class, () -> p.setCantidad(-1));
    }
}
