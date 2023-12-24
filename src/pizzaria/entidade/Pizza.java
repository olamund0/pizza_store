package pizzaria.entidade;

public class Pizza {
	private String lista[];
	private int id;
	private static int contador = 0;
	
	public Pizza() {
		lista = new String[5];
		id = contador++;
	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}

	public int getId() {
		return id;
	}
	
}
