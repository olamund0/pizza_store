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
		String msg = "Quantidade de pedidos servidos: " + pedidosServidos;
		int maior = 0;
		String naoPedido = "\nIngredientes não escolhidos (";
		String maisPedido = "";
		
		for(String i : estatisticas.keySet()) {
			if(estatisticas.get(i) == 0) {
				naoPedido += i + " | ";
			}
			if(estatisticas.get(i) > maior) {
				maior = estatisticas.get(i);
				maisPedido = "\nIngrediente mais pedido (" + i;
			}
		}
		naoPedido += ")";
		
		if(maior > 0) {
			maisPedido += " | " + maior + " Vezes)";
		}
		
		return msg + naoPedido + maisPedido;
	}
	
}
