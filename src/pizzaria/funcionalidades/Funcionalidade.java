package pizzaria.funcionalidades;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Funcionalidade {
	
	static ArrayList<String> listaIngredientes = new ArrayList<String>();
	static ArrayDeque<Pedido> listaPedidos = new ArrayDeque<Pedido>();
	static ArrayList<Pizza> pizzasCriadas = new ArrayList<Pizza>();
	
	
	public static void addIngredientes() {
		if(listaIngredientes.isEmpty()) {
			listaIngredientes.add("Queijo");
			listaIngredientes.add("Cebola");
			listaIngredientes.add("Tomate");
			listaIngredientes.add("Calabresa");
			listaIngredientes.add("Azeitona");
			listaIngredientes.add("Orégano");
			listaIngredientes.add("Pepperoni");
			
		}
	}
	
	public static String escolherIngredientes(int opcao) {
		String ingrediente = null;
		if(verificacao(opcao)) {
			ingrediente = listaIngredientes.get(opcao - 1);
		}
		return ingrediente;
	}
	
	
	public static String printarAtual(String[] lista) {
		
		String msg = "Pizza atual: ";
		
		for(String i : lista) {
			if(i != null) {
				msg += i + " | ";	
			}
			
		}
		return msg;
	}
	
	
	
	public static Pizza criarPizza(int opcao) {
		String[] opcoes = new String[5];
		Pizza novaPizza = null;
		
		if(verificacao(opcao)) {
			for(int i = 0; i < 5; i++) {
				opcoes[i] = listaIngredientes.get(opcao - 1);
				
			}
			novaPizza = new Pizza();
			novaPizza.setLista(opcoes);
			
		}
		
		return novaPizza;
		}
		
	
	public static boolean verificacao(int opcao) {
		boolean verificar = true;
		
			if(opcao < -1 && opcao > listaIngredientes.size()) {
				verificar = false;
			}
		
			return verificar;
	}
	
	
	public int[] converterInt(String input) {
		String[] lista = input.split(" ");
		int[] listaInt = new int[5];
		
		for(int i = 0; i < 5; i++) {
			listaInt[i] = Integer.parseInt(lista[i]);
		}
		return listaInt;
	}
	
	public static String menu() {
		String msg = 
		"""
			1) Criar uma pizza 
			2) Criar um novo pedido
			3) Preparar uma pizza 	
			4) Adicionar ingredientes 
			5) Estatísticas dos pedidos 
			6) Sair do programa\n
			Digite uma opção:
		""";
		return msg;
	}
	
	public static String mostrarIngredientes() {
		String msg = "\nIngredientes: \n";
		
		int num = 1;
		
		for(String i : listaIngredientes) {
			msg += num + ") "+ i + "\n";
			num++;
		}
		
		return msg;
	}
	
	public static Pizza criarPizza(String[] lista) {
		Pizza novaPizza = new Pizza();
		novaPizza.setLista(lista);
		
		return novaPizza;
	}
	
	public static void addPizza(Pizza pizza) {
		pizzasCriadas.add(pizza);
	}
	
	
}

