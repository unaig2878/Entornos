
import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {
	private double importe;
	String codigoPago;



//atributos
	public PasarelaDePago() {
		this.importe = 0;
		this.codigoPago = String.valueOf((new Date()).getTime());
	}

//constructores
	public PasarelaDePago(double importe) {
		this.importe = importe;
		this.codigoPago = String.valueOf((new Date()).getTime());
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getCodigoPago() {
		return codigoPago;
	}

//generamos el codigo de pago
	public void CodigoPago(String codigoPago1) {
		codigoPago = String.valueOf((new Date()).getTime());
		codigoPago1 = codigoPago;
		System.out.println(codigoPago1);
	}

//metodo de pago efectivo
	public void pagoEfectivo(Scanner sc) {

		double total = 0;
		double vueltas;
		Integer c = 0, v = 0, d = 0, bc = 0, md = 0, u = 0;
		Integer m = 0, vc = 0, dc = 0, cc = 0, dic = 0, uc = 0;
		System.out.println("Indique la cantidad a pagar en efectivo:");
		double pago = sc.nextDouble();
		if (pago >= importe) {
			System.out.println("Pago realizado con éxito. Código de pago: " + codigoPago);
			importe = 0;
			codigoPago = String.valueOf((new Date()).getTime());
			System.out.println("Ha seleccionado pago en efectivo");
			System.out.println("Porfavor indique la cantidad de dinero que va a entregar");
			pago = sc.nextDouble();
			if (pago > total) {
				// calculamos las vueltas del pago en efectivo
				vueltas = pago - total;
				if (vueltas > 0) {
					while (vueltas >= 50) {
						vueltas = vueltas - 50;
						c++;
					}
					while (vueltas >= 20) {
						vueltas = vueltas - 20;
						v++;
					}
					while (vueltas >= 10) {
						vueltas = vueltas - 10;
						d++;
					}
					while (vueltas >= 5) {
						vueltas = vueltas - 5;
						bc++;
					}
					while (vueltas >= 2) {
						vueltas = vueltas - 2;
						md++;
					}
					while (vueltas >= 1) {
						vueltas = vueltas - 1;
						u++;
					}
					while (vueltas >= 0.5) {
						vueltas = (vueltas - 0.5);
						m++;
					}
					while (vueltas >= 0.2) {
						vueltas = vueltas - 0.2;
						vc++;
					}
					while (vueltas >= 0.1) {
						vueltas = vueltas - 0.1;
						dc++;
					}
					while (vueltas >= 0.05) {
						vueltas = vueltas - 0.05;
						cc++;
					}
					while (vueltas >= 0.02) {
						vueltas = vueltas - 0.02;
						dic++;
					}
					while (vueltas >= 0.01) {
						vueltas = vueltas - 0.01;
						uc++;
					}

					System.out.println("Se devuelven:");
					if (c >= 1) {
						System.out.println(+c + " Billetes de 50 ");
					} else {
					}
					if (v >= 1) {
						System.out.println(+v + " Billetes de 20 ");
					}
					if (d >= 1) {
						System.out.println(+d + " Billetes de 10 ");
					}
					if (bc >= 1) {
						System.out.println(+bc + " Billetes de 5 ");
					}
					if (md >= 1) {
						System.out.println(+md + " Monedas de 2 ");
					}
					if (u >= 1) {
						System.out.println(+u + " Monedas de 1 ");
					}
					if (m >= 1) {
						System.out.println(+m + " Monedas de 0.5 ");
					}
					if (vc >= 1) {
						System.out.println(+vc + " Monedas de 0.2 ");
					}
					if (dc >= 1) {
						System.out.println(+dc + " Monedas de 0.1 ");
					}
					if (cc >= 1) {
						System.out.println(+cc + " Monedas de 0.05 ");
					}
					if (dic >= 1) {
						System.out.println(+dic + " Monedas de 0.02 ");
					}
					if (uc >= 1) {
						System.out.println(+uc + " Monedas de 0.01 ");
					}
				}
			} else {
				System.out.println(
						"La cantidad ingresada es menor al importe a pagar. Por favor ingrese una cantidad válida.");
			}
		}
	}

	// metodo de pago tarjeta
	public void pagoTarjeta(Scanner sc) {
		System.out.println("Ha seleccionado pago en tarjeta");
		System.out.println("¿Cuanto quiere pagar?");
		double pago2 = sc.nextDouble();
		if (pago2 >= importe) {
			System.out.println("Ingrese los numeros de su tarjeta en su debido orden");
			String numerotar1 = sc.nextLine();
			numerotar1 = sc.nextLine();

			String numerotar = numerotar1.replaceAll("\\s", "");
			System.out.println(numerotar);
			int primer = Character.getNumericValue(numerotar.charAt(0));
			int tamaño = numerotar.length();
			// aplicamos restricciones al tipo de tarjeta
			if (primer == 3 && tamaño == 15) {
				System.out.println("Se ha realizado el pago con éxito. Código de pago: " + codigoPago);
				System.out.println("Su tarjeta es una American Express");
				importe = 0;
				codigoPago = String.valueOf((new Date()).getTime());
			} else {
				if (primer == 4 && tamaño == 16) {
					System.out.println("Se ha realizado el pago con éxito. Código de pago: " + codigoPago);
					System.out.println("Su tarjeta es una visa");
					importe = 0;
					codigoPago = String.valueOf((new Date()).getTime());
				} else {
					if (primer == 5 && tamaño == 16) {
						System.out.println("Su pago ha sido realizado con éxito. Código de pago: " + codigoPago);
						System.out.println("su tarjeta es una mastercard");
						importe = 0;
						codigoPago = String.valueOf((new Date()).getTime());
					} else {
						System.out.println("ERROR 404");
						System.out.println(
								"Recuerde que solo aceptamos: American Express, Visa y Mastercard y que todos los valores tienen que ser números");
					}
				}
			}
		} else {
			System.out.println("La cantidad tiene que ser igual o mayor a la del ticket");
			System.out.println("pruebe de nuevo");
		}
	}

	// metodo para que elijan que tipo de pago quieren
	public void elegirpago(int precfin1, int precfin2, int precfinfin, PasarelaDePago pago, Scanner sc) {
		precfinfin = precfin1 + precfin2;
		System.out.println("Su precio final es: " + precfinfin);
		System.out.println("Como desea pagar");
		System.out.println("1.Efectivo");
		System.out.println("2.Tarjeta");
		System.out.println("3.Pago a cuenta");
		int decision2 = sc.nextInt();



		switch (decision2) {
		// se le lleva al pago que haya decidido
		case 1:
			pago.pagoEfectivo(sc);
			System.out.println("Pago realizado con éxito. Código de pago: " + codigoPago);
			importe = 0;

			break;

		case 2:
			pago.pagoTarjeta(sc);
			System.out.println("Pago realizado con éxito. Código de pago: " + codigoPago);
			importe = 0;

			break;

		case 3:
			System.out.println("indique su numero de cuenta");
			String numcuenta = sc.nextLine();
			pago.pagoCuenta(numcuenta, sc);
			break;
		default:
			System.out.println("Valor no valido");
		}

	}

//metodo para pago Cuenta
	public void pagoCuenta(String numeroCuenta, Scanner sc) {
//generamos el codigo de pago
		System.out.println("Pago realizado con éxito. Código de pago: " + codigoPago);
		codigoPago = String.valueOf((new Date()).getTime());
	}


}

