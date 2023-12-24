package pizzaria.entidade;

public class Pedido {
	private String lista[];
	private String mesa;
	
	public Pedido() {
		lista = new String[5];
	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	
	
}
