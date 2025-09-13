public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidad) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código inválido.");
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad negativa no permitida.");

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters con validación
    public String getCodigo() { return codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad negativa no permitida.");
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("Código: %s | Nombre: %s | Precio: %.2f | Cantidad: %d", codigo, nombre, precio, cantidad);
    }
}
