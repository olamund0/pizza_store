package pizzaria.funcionalidades;

public class Pizza {
	private String lista[];
	
	public Pizza() {
		lista = new String[5];
	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}
	
	
}
