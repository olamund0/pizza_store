package pizzaria.funcionalidades;

import java.util.HashMap;

public class Estatistica {
	
	static HashMap<String, Integer> estatisticas = new HashMap<String, Integer>();
	static int pedidosServidos = 0;
	static double ingredientesporPizza = 0;
	static int pedidosCriados = 0;
	
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
			if(i != null) {
				ingredientesporPizza++;
			}
		}
		
	}
	
	public static String printarEstatisticas() {
		String msg = "Estatísticas dos pedidos:"
				+ "\n\nQuantidade de pedidos servidos: " + pedidosServidos;
		int maior = 0;
		String naoPedido = "\n\nIngredientes não escolhidos: (";
		String maisPedido = "";
		String media = "";
		
		for(String i : estatisticas.keySet()) {
			if(estatisticas.get(i) == 0) {
				naoPedido += i + " | ";
			}
			
			if(estatisticas.get(i) > maior) {
				maior = estatisticas.get(i);
				maisPedido = "\nIngrediente mais pedido (" + i;
			}
		}
		naoPedido+= ")";
		
		if(pedidosCriados > 0) {
			media = String.format("\nQuant. média de ingredientes por pizza: %.1f", ingredientesporPizza/pedidosCriados);
			maisPedido += " | " + maior + " Vezes)";
		}
		msg += maisPedido + media + naoPedido;
		
		return msg;
	}
	
}
