import java.util.*;

public class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    // Agrega un nuevo producto si el código no existe
    public boolean agregarProducto(Producto p) {
        if (p == null || productos.containsKey(p.getCodigo())) return false;
        productos.put(p.getCodigo(), p);
        return true;
    }

    // Elimina producto por código
    public boolean eliminarProducto(String codigo) {
        return productos.remove(codigo) != null;
    }

    // Buscar por código exacto
    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    // Buscar por nombre (parcial o exacto)
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos.values()) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Listar todos los productos
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

    // Informe de inventario
    public void generarInforme() {
        System.out.println("\n--- INFORME DE INVENTARIO ---");
        System.out.println("Productos en stock: " + productos.size());
        System.out.println("Valor total estimado: $" + calcularValorTotalInventario());
    }

    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto p : productos.values()) {
            total += p.getPrecio() * p.getCantidad();
        }
        return total;
    }

    public boolean contieneProducto(String codigo) {
        return productos.containsKey(codigo);
    }
}
