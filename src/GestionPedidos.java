
import java.util.Scanner;

public class GestionPedidos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// aqui esta instanciado el primer cliente

		int telefono2, telefono3;
		int resp2 = 0, cant1 = 0, cant2 = 0;
		int cantproducto1 = 0, cantproducto2 = 0, cantproducto3 = 0, cantproducto4 = 0, cantproducto5 = 0;
		int precfin1 = 0, precfin2 = 0, precfinfin = 0, precp1 = 0, precp2 = 0, precp11 = 0, precp21 = 0, precp12 = 0,
				precp22 = 0, precp13 = 0, precp23 = 0;
		// instanciamos todas las clases que vamos a necesitar
		String codigoPago1 = null;
		PasarelaDePago pago = new PasarelaDePago();
		Pedido pedido = new Pedido();
		Producto producto = new Producto();
		TratamientoFicheros trat = new TratamientoFicheros();
		String nomproductof11 = null, nomproductof21 = null, nomproductof12 = null, nomproductof22 = null,
				nomproductof13 = null, nomproductof23 = null, nomproductof1 = null, nomproductof2 = null;
		String nomenc1, apellenc1, fechaenc1, direccenc1;
		// Empezamos creando los clientes y metiendo los valores en los objetos con los
		// setters
		Cliente cliente1 = new Cliente();



		System.out.println("Cliente 1");
		System.out.println("Escriba su Nombre");
		String nombre1 = sc.nextLine();
		cliente1.setNombre(nombre1);

		System.out.println("Escriba su apellido");
		String apellido1 = sc.nextLine();
		cliente1.setApellidos(apellido1);

		System.out.println("Escriba su telefono");
		int telefono1 = sc.nextInt();
		cliente1.revisartel(telefono1);

		sc.nextLine();
		System.out.println("Escriba su Direccion");
		String direccion1 = sc.nextLine();
		cliente1.setDireccion(direccion1);

		String historial1 = null;
		cliente1.setHistorial(historial1);

		// segundo cliente
		// instanciamos el cliente
		Cliente cliente2 = new Cliente();
		System.out.println("Cliente 2");
		System.out.println("Escriba su Nombre");
		String nombre2 = sc.nextLine();
		cliente2.setNombre(nombre2);

		System.out.println("Escriba su apellido");
		String apellido2 = sc.nextLine();

		cliente2.setApellidos(apellido2);

		// bucle para verificar que el numero de telefono insertado no esta siendo usado
		while (true) {
			System.out.println("Escriba su telefono");
			telefono2 = sc.nextInt();
			if (telefono1 != telefono2) {
				cliente2.setTelefono(telefono2);
				break;

			}
			System.out.println("Ya hay una cuenta con su numero");
			System.out.println("pruebe de nuevo");
		}
		sc.nextLine();
		System.out.println("Escriba su Direccion");
		String direccion2 = sc.nextLine();
		cliente2.setDireccion(direccion2);

		String historial2 = null;
		cliente2.setHistorial(historial2);

		// cliente 3
		Cliente cliente3 = new Cliente();
		System.out.println("Cliente 3");
		System.out.println("Escriba su Nombre");
		String nombre3 = sc.nextLine();
		cliente3.setNombre(nombre3);

		System.out.println("Escriba su apellido");
		String apellido3 = sc.nextLine();
		cliente3.setApellidos(apellido3);

		// bucle para verificar que el numero no este siendo usado por ningun otro
		// cliente
		while (true) {
			System.out.println("Escriba su telefono");
			telefono3 = sc.nextInt();
			if (telefono1 != telefono3 && telefono2 != telefono3) {
				cliente3.setTelefono(telefono2);
				break;
			}
			System.out.println("Ya hay una cuenta con su numero");
			System.out.println("pruebe de nuevo");
		}
		sc.nextLine();
		System.out.println("Escriba su Direccion");
		String direccion3 = sc.nextLine();
		cliente3.setDireccion(direccion3);

		String historial3 = null;
		cliente3.setHistorial(historial3);
		trat.clientes(telefono1, telefono2, telefono3, cliente1, cliente2, cliente3);

		// instanciamos todos los productos que vamos a usar
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		Producto producto4 = new Producto();
		Producto producto5 = new Producto();

		// Pedir Creacion de Productos
		// con los setters metemos los valores dentro de los objetos
		System.out.println("Indique el nombre de su Producto 1");
		String nomproducto1 = sc.nextLine();
		producto1.setNombre(nomproducto1);

		System.out.println("Indica el precio del Producto 1");
		int precproducto1 = sc.nextInt();
		producto1.setPrecio(precproducto1);

		producto1.setCantidad(cantproducto1);

		sc.nextLine();
		System.out.println("Indique el nombre de su Producto 2");
		String nomproducto2 = sc.nextLine();
		producto2.setNombre(nomproducto2);

		System.out.println("Indica el precio del Producto 2");
		int precproducto2 = sc.nextInt();
		producto2.setPrecio(precproducto2);

		producto2.setCantidad(cantproducto2);
		sc.nextLine();
		System.out.println("Indique el nombre de su Producto 3");
		String nomproducto3 = sc.nextLine();
		producto3.setNombre(nomproducto3);

		System.out.println("Indica el precio del Producto 3");
		int precproducto3 = sc.nextInt();
		producto3.setPrecio(precproducto3);

		producto3.setCantidad(cantproducto3);
		sc.nextLine();
		System.out.println("Indique el nombre de su Producto 4");
		String nomproducto4 = sc.nextLine();
		producto4.setNombre(nomproducto4);

		System.out.println("Indica el precio del Producto 4");
		int precproducto4 = sc.nextInt();
		producto4.setPrecio(precproducto4);

		producto1.setCantidad(cantproducto4);
		sc.nextLine();
		System.out.println("Indique el nombre de su Producto 5");
		String nomproducto5 = sc.nextLine();
		producto5.setNombre(nomproducto5);

		System.out.println("Indica el precio del Producto 5");
		int precproducto5 = sc.nextInt();
		producto5.setPrecio(precproducto5);

		producto5.setCantidad(cantproducto5);
		trat.Productos(producto1, producto2, producto3, producto4, producto5);

		// empezamos con el menu de pedidos
		System.out.println("#####MENU PEDIDOS#####");
		System.out.println("Diga que cliente es indicando su numero de telefono");
		int telefonocliente = sc.nextInt();
		System.out.println(telefonocliente);
		if (telefonocliente == telefono1) {
			// llamamos al metodo para realizar el pedido que pedira tanto como que producto
			// desea como la cantidad
			cliente1.realizarPedido(telefonocliente, precproducto1, precproducto2, precproducto3, precproducto4,
					precproducto5, nomproducto1, nomproducto2, nomproducto3, nomproducto4, nomproducto5, telefono1,
					telefono2, telefono3, resp2, cant1, cant2, precfin1, precfin2, precfinfin, producto1, producto2,
					producto3, producto4, producto5, pago, precp1, precp2, nomproductof1, nomproductof2, nomproductof11,
					nomproductof21, nomproductof22, nomproductof21, nomproductof13, nomproductof23, telefonocliente,
					telefonocliente, telefonocliente, telefonocliente, telefonocliente, telefonocliente);
			// el metodo toString viene de la clase pedido y nos imprime el pedido en
			// pantalla
			pedido.toString();
			// cambiamos los valores usados previamente para usarlos en otro metodo
			cantproducto1 = cliente1.getCant1();
			cantproducto2 = cliente1.getCant2();

			// Calculamos si el pedido es valido con una funcion de stockage
			producto.Stockage(cantproducto1, cantproducto2);
			// llamamos al metodo para pagar en el que te da la opcion de pedir pago
			pago.elegirpago(precfin1, precfin2, precfinfin, pago);
			// Generamos el codigo de pago
			pago.CodigoPago(codigoPago1);
			trat.Tiquets(nomproductof11, nomproductof21, nomproductof12, nomproductof22, nomproductof13, nomproductof23,
					precp11, precp12, precp13, precp21, precp22, precp23, cliente1, cliente2, cliente3, producto1,
					producto2, producto3, producto4, producto5);
		} else {
			if (telefonocliente == telefono2) {
				// sigue el mismo proceso que la anterior solo que con otro cliente
				cliente2.realizarPedido(telefonocliente, precproducto1, precproducto2, precproducto3, precproducto4,
						precproducto5, nomproducto1, nomproducto2, nomproducto3, nomproducto4, nomproducto5, telefono1,
						telefono2, telefono3, resp2, cant1, cant2, precfin1, precfin2, precfinfin, producto1, producto2,
						producto3, producto4, producto5, pago, precp1, precp2, nomproductof1, nomproductof2,
						nomproductof11, nomproductof21, nomproductof22, nomproductof21, nomproductof13, nomproductof23,
						telefonocliente, telefonocliente, telefonocliente, telefonocliente, telefonocliente,
						telefonocliente);
				pedido.toString();
				cantproducto1 = cliente1.getCant1();
				cantproducto2 = cliente1.getCant2();

				producto.Stockage(cantproducto1, cantproducto2);
				pago.elegirpago(precfin1, precfin2, precfinfin, pago);
				pago.CodigoPago(codigoPago1);
				trat.Tiquets(nomproductof11, nomproductof21, nomproductof12, nomproductof22, nomproductof13,
						nomproductof23, precp11, precp12, precp13, precp21, precp22, precp23, cliente1, cliente2,
						cliente3, producto1, producto2, producto3, producto4, producto5);
			} else {
			}

			if (telefonocliente == telefono3) {
				// sigue el proceso de las dos anteriores solo que con otro cliente
				cliente3.realizarPedido(telefonocliente, precproducto1, precproducto2, precproducto3, precproducto4,
						precproducto5, nomproducto1, nomproducto2, nomproducto3, nomproducto4, nomproducto5, telefono1,
						telefono2, telefono3, resp2, cant1, cant2, precfin1, precfin2, precfinfin, producto1, producto2,
						producto3, producto4, producto5, pago, precp1, precp2, nomproductof1, nomproductof2,
						nomproductof11, nomproductof21, nomproductof22, nomproductof22, nomproductof13, nomproductof23,
						precp11, precp12, precp13, precp21, precp22, precp23);
				pedido.toString();
				cantproducto1 = cliente1.getCant1();
				cantproducto2 = cliente1.getCant2();
				producto.Stockage(cantproducto1, cantproducto2);

				pago.elegirpago(precfin1, precfin2, precfinfin, pago);

				pago.CodigoPago(codigoPago1);
				trat.Tiquets(nomproductof11, nomproductof21, nomproductof12, nomproductof22, nomproductof13,
						nomproductof23, precp11, precp12, precp13, precp21, precp22, precp23, cliente1, cliente2,
						cliente3, producto1, producto2, producto3, producto4, producto5);
			} else {
				// si el numero no esta registrado le da error y le avisa
				System.out.println("Tu telefono no esta registrado");
			}
		}


	}

}

