
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Producto {
	private String nombre;
	private double precio;
	private int cantidad;
	public int id_producto;

//creamos los atributos
	public Producto() {

	}

//Instanciamos los atributos que vamos a necesitar en el constructor
	public Producto(String nombre, double precio, int cantidad, int id_producto) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		Random random = new Random();
		this.id_producto = random.nextInt(9000) + 1000;

	}

//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// funcion de stockage
	public void Stockage(int cantproducto1, int cantproducto2) {
		// revisamos a ver si ha escogido 2 productos o uno
		if (cantproducto1 > 0 && cantproducto2 > 0) {
			int i;
			// creamos un arraylist para que sea dinamico
			ArrayList<Integer> list = new ArrayList<>();
			// llenamos el stockage con un bucle
			for (i = 0; i <= 30; i++) {
				list.add(i);
			}
			System.out.println("###Menu Stockage###");
			System.out.println("Nos quedan 30 productos en stock del primer procucto");

			Scanner sc1 = new Scanner(System.in);
			System.out.print("Cuántos valores desea quitar del ArrayList? ");
			// usamos un bucle para restar la cantidad de productos que ha pedido del
			// stockage
			if (cantproducto1 > 0 && cantproducto1 < list.size()) {
				for (i = 0; i < cantproducto1; i++) {
					list.remove(list.size() - cantproducto1);
					System.out.println("Ha pedido: " + cantproducto1 + "unidades");
					System.out.println("En stock nos quedan disponibles " + list.size() + " de ese mismo producto");
				}

			} else {
				// si no tenemos suficientes productos le da error.
				System.out.println("No tenemos " + cantproducto1 + " de ese producto en Stock");
				System.out.println("Desea volver mas tarde 1.Si 2.No");
				int resp4 = sc1.nextInt();
				if (resp4 == 1) {
					while (i < 30) {
						list.add(i);
						System.out.println("ya tiene stock comienze de nuevo");
					}
				} else {
					System.out.println("Muchas gracias por su visita");
				}
			}
			// arraylist para el segundo cliente
			ArrayList<Integer> list2 = new ArrayList<>();
			for (i = 0; i <= 30; i++) {
				list2.add(i);
			}
			System.out.println("Nos quedan 30 productos en stock del segundo procucto");

			System.out.print("Cuántos valores desea quitar del ArrayList? ");

			if (cantproducto2 > 0 && cantproducto2 < list.size()) {
				for (i = 0; i < cantproducto2; i++) {
					list.remove(list.size() - cantproducto2);
					System.out.println("Ha pedido: " + cantproducto2 + "unidades");
					System.out.println("En stock nos quedan disponibles " + list.size() + " de ese mismo producto");
				}

			} else {
				System.out.println("No tenemos " + cantproducto2 + " de ese producto en Stock");
				System.out.println("Desea volver mas tarde 1.Si 2.No");
				int resp4 = sc1.nextInt();
				if (resp4 == 1) {
					while (i < 30) {
						list2.add(i);
						System.out.println("ya tiene stock comienze de nuevo");
					}
				} else {
					System.out.println("Muchas gracias por su visita");
				}
			}
		} else {
			if (cantproducto1 > 0) {
				int i;
				ArrayList<Integer> list = new ArrayList<>();
				for (i = 0; i <= 30; i++) {
					list.add(i);
				}
				System.out.println("Nos quedan 30 productos en stock del primer procucto");

				Scanner sc = new Scanner(System.in);
				System.out.print("Cuántos valores desea quitar del ArrayList? ");

				if (cantproducto1 > 0 && cantproducto1 < list.size()) {
					for (i = 0; i < cantproducto1; i++) {
						list.remove(list.size() - cantproducto1);
						System.out.println("Ha pedido: " + cantproducto1 + "unidades");
						System.out.println("En stock nos quedan disponibles " + list.size() + " de ese mismo producto");
					}

				} else {
					System.out.println("No tenemos " + cantproducto1 + " de ese producto en Stock");
					System.out.println("Desea volver mas tarde 1.Si 2.No");
					int resp4 = sc.nextInt();
					if (resp4 == 1) {
						while (i < 30) {
							list.add(i);
							System.out.println("ya tiene stock comienze de nuevo");
						}
					}
				}
			} else {
				System.out.println("Muchas gracias por su visita");
			}
		}
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	}


