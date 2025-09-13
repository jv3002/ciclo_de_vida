import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1 -> agregarProducto(scanner, inventario);
                case 2 -> eliminarProducto(scanner, inventario);
                case 3 -> buscarPorCodigo(scanner, inventario);
                case 4 -> buscarPorNombre(scanner, inventario);
                case 5 -> listarProductos(inventario);
                case 6 -> inventario.generarInforme();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU DE INVENTARIO ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Buscar por codigo");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Listar productos");
        System.out.println("6. Generar informe");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void agregarProducto(Scanner scanner, Inventario inv) {
        scanner.nextLine(); // limpiar buffer
        try {
            System.out.print("Codigo: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Descripcion: ");
            String desc = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            Producto p = new Producto(codigo, nombre, desc, precio, cantidad);
            if (inv.agregarProducto(p)) {
                System.out.println("✅ Producto agregado correctamente.");
            } else {
                System.out.println("⚠️ Producto ya existe o invalido.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al ingresar datos: " + e.getMessage());
            scanner.nextLine(); // limpiar buffer
        }
    }

    private static void eliminarProducto(Scanner scanner, Inventario inv) {
        scanner.nextLine();
        System.out.print("Codigo del producto a eliminar: ");
        String codigo = scanner.nextLine();
        if (inv.eliminarProducto(codigo)) {
            System.out.println("✅ Producto eliminado.");
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
    }

    private static void buscarPorCodigo(Scanner scanner, Inventario inv) {
        scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        Producto p = inv.buscarPorCodigo(codigo);
        System.out.println((p != null) ? p : "⚠️ Producto no encontrado.");
    }

    private static void buscarPorNombre(Scanner scanner, Inventario inv) {
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        var resultados = inv.buscarPorNombre(nombre);
        if (resultados.isEmpty()) {
            System.out.println("⚠️ No se encontraron productos.");
        } else {
            resultados.forEach(System.out::println);
        }
    }

    private static void listarProductos(Inventario inv) {
        var lista = inv.listarProductos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay productos en el inventario.");
        } else {
            lista.forEach(System.out::println);
        }
    }
}
