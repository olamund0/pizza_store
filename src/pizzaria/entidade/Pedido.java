package pizzaria.entidade;

public class Pedido {
	private String lista[];
	private String mesa;
	private int id;
	private static int contador = 0;
	
	public Pedido() {
		lista = new String[5];
		id = ++contador;
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

	public int getId() {
		return id;
	}
	
	
}
