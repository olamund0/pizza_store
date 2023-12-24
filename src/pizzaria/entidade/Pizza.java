package pizzaria.entidade;

public class Pizza {
	private String lista[];
	private int id;
	
	public Pizza() {
		lista = new String[5];
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
	
	public void setId(int id) {
		this.id = id;
	}
}
