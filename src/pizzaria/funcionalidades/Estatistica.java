package pizzaria.funcionalidades;

import java.util.HashMap;

public class Estatistica {
	
	static HashMap<String, Integer> estatisticas = new HashMap<String, Integer>();
	static int pedidosServidos = 0;
	static int mediaIngredientes = 0;
	
	public static void ingredientesHash() {
		for(String i : Funcionalidade.listaIngredientes) {
			estatisticas.put(i, 0);
		}
	}
	
	public static void ingredientesEscolhidos(String[] lista) {
		for(String i : lista) {
			if(estatisticas.containsKey(i)) {
				estatisticas.put(i, estatisticas.get(i) + 1);
			}
		}
	}
	
	public static String printarEstatisticas() {
		String msg = "";
		for(String i : estatisticas.keySet()) {
			msg += "\nIngrediente: " + i + " Quantidade: " + estatisticas.get(i);
		}
		return msg;
	}
	
}
