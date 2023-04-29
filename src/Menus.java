import java.util.Scanner;

public class Menus {

	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public void decision1(String nomproducto1, String nomproducto2, String nomproducto3, String nomproducto4,
			String nomproducto5, int resp2, Scanner sc) {
		System.out.println("1." + nomproducto1);
		System.out.println("2." + nomproducto2);
		System.out.println("3." + nomproducto3);
		System.out.println("4." + nomproducto4);
		System.out.println("5." + nomproducto5);
		System.out.println("Escriba el numero de cual");
		resp2 = sc.nextInt();
	}

	public void princ(String nomproducto1, String nomproducto2, String nomproducto3, String nomproducto4,
			String nomproducto5, int resp1, int decision, Scanner sc) {
		System.out.println("Estas Registrado");
		System.out.println("Seleccione el producto que quiere en numero");
		System.out.println("1." + nomproducto1);
		System.out.println("2." + nomproducto2);
		System.out.println("3." + nomproducto3);
		System.out.println("4." + nomproducto4);
		System.out.println("5." + nomproducto5);
		resp1 = sc.nextInt();
		// le damos la opcion de elegir otro
		System.out.println("¿Quiere otro?(recuerde que solo le queda 1)");
		System.out.println("1.si ... 2.No");
		decision = sc.nextInt();
	}
}
