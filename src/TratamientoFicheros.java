import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TratamientoFicheros {
	// declaramos las rutas de los ficheros txt
	public static final String Clienteruta = "C:\\Users\\unaig\\eclipse-workspace\\PracticaTema4\\TratamientoFIcheros\\Clientes.txt";
	public static final String Productoruta = "C:\\Users\\unaig\\eclipse-workspace\\PracticaTema4\\TratamientoFIcheros\\Productos.txt";
	public static final String Ticketruta = "C:\\Users\\unaig\\eclipse-workspace\\PracticaTema4\\TratamientoFIcheros\\Tiquet.txt";

	public TratamientoFicheros() {
	}

	public void clientes(int telefono1, int telefono2, int telefono3, Cliente cliente1, Cliente cliente2,
			Cliente cliente3) {
		try {
			File myObj = new File(Clienteruta);
			Scanner sc5 = new Scanner(myObj);
			// cambiamos los valores de int a string
			String tele1 = String.valueOf(telefono1);
			String tele2 = String.valueOf(telefono2);
			String tele3 = String.valueOf(telefono3);
			boolean telefono1Encontrado = false;
			boolean telefono2Encontrado = false;
			boolean telefono3Encontrado = false;

			// Buscamos si los teléfonos ya existen en el arit chivo
			while (sc5.hasNextLine()) {
				String data = sc5.nextLine();
				String[] words = data.split(" ");
				if (words.length >= 1) {
					String telefono = words[0];
					if (telefono.equals(tele1)) {
						telefono1Encontrado = true;
					} else if (telefono.equals(tele2)) {
						telefono2Encontrado = true;
					} else if (telefono.equals(tele3)) {
						telefono3Encontrado = true;
					}
				}
			}

			// Escribimos los clientes que no están en el archivo
			FileWriter escritor = new FileWriter(Clienteruta, true);
			if (!telefono1Encontrado) {
				escritor.write(cliente1.getTelefono() + " " + cliente1.getNombre() + " " + cliente1.getApellidos() + " "
						+ cliente1.getFechaDeAlta() + " " + cliente1.getDireccion() + "\n");
				System.out.println("Se ha guardado de forma efectiva los datos del cliente 1");
			}
			if (!telefono2Encontrado) {
				escritor.write(cliente2.getTelefono() + " " + cliente2.getNombre() + " " + cliente2.getApellidos() + " "
						+ cliente2.getFechaDeAlta() + " " + cliente2.getDireccion() + "\n");
				System.out.println("Se ha guardado de forma efectiva los datos del cliente 2");
			}
			if (!telefono3Encontrado) {
				escritor.write(cliente3.getTelefono() + " " + cliente3.getNombre() + " " + cliente3.getApellidos() + " "
						+ cliente3.getFechaDeAlta() + " " + cliente3.getDireccion() + "\n");
				System.out.println("Se ha guardado de forma efectiva los datos del cliente 3");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("No se han podido guardar los datos");
			e.printStackTrace();
		}
	}

	public void Productos(Producto... productos) {
		try {
			File myObj = new File(Productoruta);
			FileWriter escritor = new FileWriter(Productoruta, true);

			for (Producto producto : productos) {
				// Verificar si el producto ya está en el archivo
				boolean alreadyExists = false;
				Scanner sc6 = new Scanner(myObj);
				while (sc6.hasNextLine()) {
					String data = sc6.nextLine();
					String[] words = data.split(" , ");
					List<String> list = Arrays.asList(words);
					if (list.contains(String.valueOf(producto.getId_producto()))) {
						alreadyExists = true;
						break;
					}
				}
				sc6.close();

				// Si el producto no está en el archivo, escribirlo
				if (!alreadyExists) {
					escritor.write(producto.getId_producto() + " , " + producto.getNombre() + " , "
							+ producto.getCantidad() + " , " + producto.getPrecio() + "\n");
					System.out.println("Se ha guardado de forma efectiva el producto: " + producto.getNombre());
				} else {
					System.out.println("El producto " + producto.getNombre() + " ya existe en el archivo.");
				}
			}

			escritor.close();

		} catch (IOException e) {
			System.out.println("No se han podido guardar");
			e.printStackTrace();
		}
	}

	public void generarTicket(int precfin1, int precfin2, String nomproductof1, String nomproductof2) {
		// Generar ID de pedido aleatorio
		Random rand = new Random();
		int id_pedido = rand.nextInt(1000000);

		// Crear el contenido del ticket en la misma línea
		StringBuilder ticket = new StringBuilder();
		ticket.append("ID de Pedido: ").append(id_pedido).append(" | ");
		ticket.append("Productos: ");
		ticket.append(nomproductof1).append(": ").append(precfin1).append(" | ");
		if (nomproductof2 != null) {
			ticket.append(nomproductof2).append(": ").append(precfin2).append(" | ");
		}
		int precioTotal = precfin1 + precfin2;
		ticket.append("Precio total: ").append(precioTotal);

		// Escribir el ticket en un archivo
		try (FileWriter writer = new FileWriter(Ticketruta)) {
			writer.write(ticket.toString());
		} catch (IOException e) {
			System.out.println("Error al escribir el ticket: " + e.getMessage());
		}
	}

}





