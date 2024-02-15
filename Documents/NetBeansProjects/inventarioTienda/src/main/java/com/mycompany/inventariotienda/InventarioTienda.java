/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventariotienda;

/**
 *
 * @author Deiner Coral Samuel Betancourt
 */

    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class InventarioTienda {

    private List<Producto> productos;

    public InventarioTienda() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, double precio, int cantidad) {
        Producto producto = new Producto(nombre, precio, cantidad);
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void organizarProductosPorCantidad() {
        Collections.sort(productos, (p1, p2) -> p1.getCantidad() - p2.getCantidad());
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.getNombre().equals(nombre));
    }

    public static void main(String[] args) {
        InventarioTienda inventario = new InventarioTienda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Obtener inventario");
            System.out.println("3. Organizar productos por cantidad");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    inventario.agregarProducto(nombre, precio, cantidad);
                    break;
                case 2:
                    System.out.println("Inventario:");
                    for (Producto producto : inventario.obtenerProductos()) {
                        System.out.println(producto);
                    }
                    break;
                case 3:
                    inventario.organizarProductosPorCantidad();
                    System.out.println("Productos organizados por cantidad:");
                    for (Producto producto : inventario.obtenerProductos()) {
                        System.out.println(producto);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.next();
                    inventario.eliminarProducto(nombreEliminar);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " - " + cantidad + " unidades";
    }
}

   
