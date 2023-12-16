package pizzaria.funcionalidades;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Funcionalidade {

	static ArrayList<String> listaIngredientes = new ArrayList<String>();
	static ArrayDeque<Pedido> listaPedidos = new ArrayDeque<Pedido>();
	static ArrayList<Pizza> pizzasCriadas = new ArrayList<Pizza>();

	public static void addIngredientes() {
		if (listaIngredientes.isEmpty()) {
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
		if (verificacaoIngrediente(opcao)) {
			ingrediente = listaIngredientes.get(opcao - 1);
		}
		return ingrediente;
	}

	public static boolean verificarEscolha(int opcao, String[] lista, int i) {
		boolean verificacao = false;

		if (opcao == 0 && lista[i - 1] != null) {
			lista[i - 1] = null;
			verificacao = true;

		} else {
			verificacao = false;
		}
		return verificacao;
	}

	public static String printarAtual(String[] lista) {

		String msg = "Pizza atual: ";

		for (String i : lista) {
			if (i != null) {
				msg += i + " | ";
			}

		}
		return msg;
	}

	public static boolean verificacaoIngrediente(int opcao) {
		boolean verificar = true;

		if (opcao < 0 && opcao > listaIngredientes.size()) {
			verificar = false;
		}

		return verificar;
	}

	public static String menu() {
		String msg = """
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

		for (String i : listaIngredientes) {
			msg += num + ") " + i + "\n";
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
