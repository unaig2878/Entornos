
class Pedido {
	private Cliente cliente;
	private Producto producto1;
	private Producto producto2;
	private double importeTotal;
	private PasarelaDePago pago;
	private Estado estado;
//creamos los atributos

	// creamos el metodo para el estado de pago
	public void pagar(int tipoPago) {
		if (estado != Estado.PAGADO) {
			setPago(new PasarelaDePago(tipoPago));
			if (producto1 != null && producto2 != null) {
				setImporteTotal(producto1.getPrecio() + producto2.getPrecio());
			} else if (producto1 != null) {
				setImporteTotal(producto1.getPrecio());
			} else if (producto2 != null) {
				setImporteTotal(producto2.getPrecio());
			}
			estado = Estado.PAGADO;
		} else {
			System.out.println("El pedido ya ha sido pagado.");
		}
	}

	public void agregarCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//metodo para agegar producto
	public void agregarProducto1(Producto producto) {
		if (producto1 == null) {
			producto1 = producto;
		} else {
			System.out.println("El producto 1 ha sido agregado.");
		}
	}

	public void agregarProducto2(Producto producto) {
		if (producto2 == null) {
			producto2 = producto;
		} else {
			System.out.println("El producto 2 ha sido agregado.");
		}
	}

//metodo para eliminar producto
	public void eliminarProducto(Producto producto) {
		if (producto1 != null && producto1.equals(producto)) {
			producto1 = null;
			setImporteTotal(producto2 != null ? producto2.getPrecio() : 0);
		} else if (producto2 != null && producto2.equals(producto)) {
			producto2 = null;
			setImporteTotal(producto1 != null ? producto1.getPrecio() : 0);
		} else {
			System.out.println("El producto ha sido eliminado del pedido.");
		}
	}

	// metodo que imprime los productos del pedido ya realizados
	public String toString(int precp1, int precp2, int cant1, int cant2, int precfin1, int precfin2) {
		String productos = "";
		double total = 0;
		if (producto1 != null) {
			productos = producto1.getNombre() + " x " + producto1.getCantidad() + ": "
					+ producto1.getPrecio() * producto1.getCantidad() + "€\n";
			total = producto1.getPrecio() * producto1.getCantidad();
		}
		if (producto2 != null) {
			productos = producto2.getNombre() + " x " + producto2.getCantidad() + ": "
					+ producto2.getPrecio() * producto2.getCantidad() + "€\n";
			total = producto2.getPrecio() * producto2.getCantidad();
		}
		return "CANT.\tPRODUCTO\tPRECIO UD.\tTOTAL\n " + cant1 + "\t" + producto1 + "\t" + precp1 + "\t" + precfin1
				+ "\n" + cant2 + "\t" + producto2 + "\t" + precp2 + "\t" + precfin2;
	}

//getters y setters
	public PasarelaDePago getPago() {
		return pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.pago = pago;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}


	class PasarelaDePago {
		private int tipoPago;

		public PasarelaDePago(int tipoPago) {
			this.tipoPago = tipoPago;
		}

		public int getTipoPago() {
			return tipoPago;
		}

		public void setTipoPago(int tipoPago) {
			this.tipoPago = tipoPago;
		}
	}

	// estado de producto
	enum Estado {
		PAGADO, PREPARANDO, LISTO, SERVIDO
	}
}
