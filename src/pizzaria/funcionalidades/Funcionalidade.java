package pizzaria.funcionalidades;

import java.util.ArrayDeque;
import java.util.ArrayList;

import pizzaria.entidade.*;

public class Funcionalidade {

	static ArrayList<String> listaIngredientes = new ArrayList<String>();
	static ArrayDeque<Pedido> listaPedidos = new ArrayDeque<Pedido>();
	static ArrayList<Pizza> listaPizzas = new ArrayList<Pizza>();

	public static void addIngredientes() {
			listaIngredientes.add("Queijo");
			listaIngredientes.add("Cebola");
			listaIngredientes.add("Tomate");
			listaIngredientes.add("Calabresa");
			listaIngredientes.add("Azeitona");
			listaIngredientes.add("Orégano");
			listaIngredientes.add("Pepperoni");
	}

	public static String escolherIngredientes(int opcao) {
		String ingrediente = null;
		if (verificacaoIngrediente(opcao)) {
			ingrediente = listaIngredientes.get(opcao - 1);
		}
		return ingrediente;
	}

	public static boolean verificarEscolha(int opcao, String[] lista, int i) {
		if (opcao == 0 && lista[i - 1] != null) {
			lista[i - 1] = null;
			return true;

		} else {
			return false;
		}
	}

	public static String printarAtual(String[] lista) {

		String msg = "Ingredientes escolhidos: ";

		for (String i : lista) {
			if (i != null) {
				msg += i + " | ";
			}

		}
		return msg;
	}

	public static boolean verificacaoIngrediente(int opcao) {
		boolean verificar = true;

		if (opcao < 0 || opcao > listaIngredientes.size()) {
			verificar = false;
		}

		return verificar;
	}

	public static String menu() {
		String msg = """
					1) Criar uma pizza
					2) Criar um novo pedido
					3) Servir um pedido
					4) Adicionar ingredientes
					5) Olhar pedidos e pizzas atuais
					6) Estatísticas dos pedidos
					7) Sair do programa\n
					Digite uma opção:
				""";
		return msg;
	}

	public static String mostrarIngredientes() {
		String msg = "\nIngredientes: \n";

		int num = 1;

		for (String i : listaIngredientes) {
			msg += num + ") " + i + "\n";
			num++;
		}

		return msg;
	}

	public static Pizza prepararPizza(String[] lista) {
		Pizza novaPizza = new Pizza();
		novaPizza.setLista(lista);

		return novaPizza;
	}

	public static String pizzasCriadas() {
		String msg = "\nPizzas: \n";

		for (Pizza i : listaPizzas) {
			msg += "Pizza " + i.getId();

			for (String s : i.getLista()) {
				if (s != null) {
					msg += " | " + s;
				}
			}
			msg += "\n";
		}
		return msg;
	}

	public static void addPizza(Pizza pizza) {
		if (pizza != null) {
			listaPizzas.add(pizza);
		}
	}

	public static void addPedido(Pizza pizza, String mesa) {
		if (pizza != null) {
			Pedido pedido = new Pedido();
			String[] lista = pizza.getLista();
			pedido.setLista(lista);
			pedido.setMesa(mesa);
			listaPedidos.addLast(pedido);
			Estatistica.ingredientesEscolhidos(lista);
			Estatistica.pedidosCriados++;
		}
	}

	public static String pedidosCriados() {
		String msg = "Pedidos: \n";

		for (Pedido i : listaPedidos) {
			msg += "Pedido " + i.getId();

			for (String s : i.getLista()) {
				if (s != null) {
					msg += " | " + s;
				}
			}
			msg += " (Mesa : " + i.getMesa() + ")\n";
		}
		return msg;
	}

	public static String verificarPedido() {
		String msg = "";
		if (!listaPedidos.isEmpty()) {
			Pedido pedido = listaPedidos.getFirst();	
			int num = 0;
			
			for(Pizza pizza : listaPizzas) {
				num = 0;
				for(int i = 0; i < 5; i++) {		
					if(pizza.getLista()[i] == (pedido.getLista()[i])) {
						num++;
					}			
				}
				if(num == 5) {
					Estatistica.pedidosServidos++;
					msg += "Pedido " + pedido.getId() + " servido na mesa: " + pedido.getMesa();
					listaPizzas.remove(pizza);
					listaPedidos.remove(pedido);
					break;
				}						
			}
		}
		return msg;

	}
	
	public static boolean novoIngrediente(String ingrediente) {
		for(String i : listaIngredientes) {
			if(i.equalsIgnoreCase(ingrediente.replace(" ", ""))) {
				return false;
			}
		}
		listaIngredientes.add(ingrediente);
		Estatistica.estatisticas.put(ingrediente, 0);
		return true;
	}

}
