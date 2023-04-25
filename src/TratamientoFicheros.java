import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TratamientoFicheros {
	// declaramos las rutas de los ficheros txt
	public static final String Clienteruta = "C:\\Users\\unaig\\OneDrive\\Escritorio\\TratamientoFIcheros\\Clientes.txt";
	public static final String Productoruta = "C:\\Users\\unaig\\OneDrive\\Escritorio\\TratamientoFIcheros\\Productos.txt";
	public static final String Ticketruta = "C:\\Users\\unaig\\OneDrive\\Escritorio\\TratamientoFIcheros\\Tiquet.txt";

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

			// Buscamos si los teléfonos ya existen en el archivo
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

	public void Productos(Producto producto1, Producto producto2, Producto producto3, Producto producto4,
			Producto producto5) {
		try {
			File myObj = new File(Productoruta);
			Scanner sc6 = new Scanner(myObj);
			// pasamos todos los int a String
			String pro1 = String.valueOf(producto1.getId_producto());
			String pro2 = String.valueOf(producto2.getId_producto());
			String pro3 = String.valueOf(producto3.getId_producto());
			String pro4 = String.valueOf(producto4.getId_producto());
			String pro5 = String.valueOf(producto5.getId_producto());
			while (sc6.hasNextLine()) {
				// se meten los valores en una lista para ver si coinciden
				String data = sc6.nextLine();
				String[] words = data.split(" ");
				List<String> list = Arrays.asList(words);
				if (list.contains(pro1) || list.contains(pro2) || list.contains(pro3) || list.contains(pro4)
						|| list.contains(pro5)) {
					// El producto ya existe en el archivo
					continue;
				}
				// Escribir los productos que no están en el archivo
				FileWriter escritor = new FileWriter(Productoruta, true);
				escritor.write(producto1.getId_producto() + " , " + producto1.getNombre() + " , "
						+ producto1.getCantidad() + " , " + producto1.getPrecio() + "\n");
				escritor.write(producto2.getId_producto() + " , " + producto2.getNombre() + " , "
						+ producto2.getCantidad() + " , " + producto2.getPrecio() + "\n");
				escritor.write(producto3.getId_producto() + " , " + producto3.getNombre() + " , "
						+ producto3.getCantidad() + " , " + producto3.getPrecio() + "\n");
				escritor.write(producto4.getId_producto() + " , " + producto4.getNombre() + " , "
						+ producto4.getCantidad() + " , " + producto4.getPrecio() + "\n");
				escritor.write(producto5.getId_producto() + " , " + producto5.getNombre() + " , "
						+ producto5.getCantidad() + " , " + producto5.getPrecio() + "\n");
				escritor.close();
				System.out.println("Se ha guardado de forma efectiva los datos");
				break;
			}

		} catch (IOException e) {
			System.out.println("No se han podido guardar");
			e.printStackTrace();
		}
	}

	public void Tiquets(String nomproductof11, String nomproductof21, String nomproductof12, String nomproductof22,
			String nomproductof13, String nomproductof23, int precp11, int precp12, int precp13, int precp21,
			int precp22, int precp23, Cliente cliente1, Cliente cliente2, Cliente cliente3, Producto producto1,
			Producto producto2, Producto producto3, Producto producto4, Producto producto5) {

		int id_pedido = 0;
		// si se ha rellenado el producto del primer cliente
		if (nomproductof11 != null) {
			// sumamos el precio total y lo pasamos a String
			int precf9 = precp11 + precp21;
			String precf1 = String.valueOf(precf9);

			try {
				File myObj = new File(Ticketruta);
				Scanner sc7 = new Scanner(myObj);
				// Pasamos id_pedido a String
				String id_pedidof = String.valueOf(id_pedido);
				while (sc7.hasNextLine()) {

					String data = sc7.nextLine();
					String[] words = data.split(" , ");
					List<String> list = Arrays.asList(words);
					for (String word : words) {
						try {
							int num = Integer.parseInt(word);
							System.out.println("First : " + num);
							if (!list.contains(id_pedidof)) {
								try {
									FileWriter escritor = new FileWriter(Clienteruta);
									// Escribimos los atributos al fichero
									escritor.write(
											id_pedidof + " " + cliente1.getTelefono() + " " + cliente1.getApellidos()
													+ " " + nomproductof11 + " " + nomproductof21 + " " + precf1);
									escritor.close();
									System.out.println("Se ha guardado de forma efectiva los datos");
								} catch (IOException e) {
									System.out.println("No se han podido guardar los datos");
									e.printStackTrace();
								}
							}

							return;
						} catch (NumberFormatException e) {
						}
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println("Ha habido un error");
				e.printStackTrace();
			}
		} else {
			// si el producto no es nulo en el segundo cliente
			if (nomproductof12 != null) {
				int precf9 = precp12 + precp22;
				String precf1 = String.valueOf(precf9);

				try {
					File myObj = new File(Ticketruta);
					Scanner sc8 = new Scanner(myObj);

					String id_pedidof = String.valueOf(id_pedido);
					while (sc8.hasNextLine()) {

						String data = sc8.nextLine();
						String[] words = data.split(" , ");
						List<String> list = Arrays.asList(words);
						for (String word : words) {
							try {
								int num = Integer.parseInt(word);
								System.out.println("First : " + num);
								if (!list.contains(id_pedidof)) {
									try {
										FileWriter escritor = new FileWriter(Clienteruta);
										escritor.write(id_pedidof + " " + cliente2.getTelefono() + " "
												+ cliente2.getApellidos() + " " + nomproductof12 + " " + nomproductof22
												+ " " + precf1);
										escritor.close();
										System.out.println("Se ha guardado de forma efectiva los datos");
									} catch (IOException e) {
										System.out.println("No se han podido guardar los datos");
										e.printStackTrace();
									}
								}

								return;
							} catch (NumberFormatException e) {
							}
						}
					}

				} catch (FileNotFoundException e) {
					System.out.println("Ha habido un error");
					e.printStackTrace();
				}
			} else {
				// si el producto no es nulo en el tercer cliente
				if (nomproductof13 != null) {

					int precf9 = precp12 + precp22;
					String precf1 = String.valueOf(precf9);

					try {
						File myObj = new File(Ticketruta);
						Scanner sc9 = new Scanner(myObj);

						String id_pedidof = String.valueOf(id_pedido);
						while (sc9.hasNextLine()) {

							String data = sc9.nextLine();
							String[] words = data.split(" , ");
							List<String> list = Arrays.asList(words);
							for (String word : words) {
								try {
									int num = Integer.parseInt(word);
									System.out.println("First : " + num);
									if (!list.contains(id_pedidof)) {
										try {
											FileWriter escritor = new FileWriter(Clienteruta);
											escritor.write(id_pedidof + " " + cliente3.getTelefono() + " "
													+ cliente3.getApellidos() + " " + nomproductof13 + " "
													+ nomproductof23 + " " + precf1);
											escritor.close();
											System.out.println("Se ha guardado de forma efectiva los datos");
										} catch (IOException e) {
											System.out.println("No se han podido guardar los datos");
											e.printStackTrace();
										}
									}

									return;
								} catch (NumberFormatException e) {
								}
							}
						}

					} catch (FileNotFoundException e) {
						System.out.println("Ha habido un error");
						e.printStackTrace();
					}

				}
			}
		}

	}

	public static Cliente rellenarCliente(int telefono1, String nomenc1, String apellenc1, String fechaenc1,
			String direccenc1) {
		// Ruta del archivo a leer
		String rutaArchivo = "clienteruta.txt";
		File archivo = new File(Clienteruta);

		Scanner sce = new Scanner(Clienteruta);

		// Recorremos todas las líneas del archivo
		while (sce.hasNextLine()) {
			String linea = sce.nextLine();
			String[] partes = linea.split(",");

			// Si el primer elemento de la línea coincide con el teléfono,
			// creamos un objeto Cliente con los datos correspondientes y lo devolvemos
			if (partes[0].equals(String.valueOf(telefono1))) {
				nomenc1 = partes[1];
				apellenc1 = partes[2];
				fechaenc1 = partes[3];
				direccenc1 = partes[4];

			}
		}

		// Si no se encuentra el cliente, devolvemos null
		return null;
	}

}

