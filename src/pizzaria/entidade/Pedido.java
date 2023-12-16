package pizzaria.entidade;

public class Pedido {
	private String lista[];
	private int mesa;
	
	public Pedido() {
		lista = new String[5];
	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	
}
