package pizzaria;

import javax.swing.JOptionPane;

import pizzaria.funcionalidades.*;
import pizzaria.entidade.*;

public class Main {
	public static void main(String[] args) {
		Funcionalidade.addIngredientes();
		Estatistica.ingredientesHash();

		String opcao = "1";

		while (!opcao.equals("7")) {

			opcao = JOptionPane.showInputDialog(null, Funcionalidade.menu(), "Pizzaria Bon Appetit",
					JOptionPane.QUESTION_MESSAGE);

			if (opcao.equals("1")) {
				Funcionalidade.addPizza(criarPizza());

			} else if (opcao.equals("2")) {
				Funcionalidade.addPedido(criarPizza(), JOptionPane.showInputDialog(null, "Digite sua mesa: "));

			} else if (opcao.equals("3")) {
				servirPedido();

			} else if (opcao.equals("4")) {
				adicionarIngrediente();

			} else if (opcao.equals("5")) {
				JOptionPane.showMessageDialog(null, Funcionalidade.pedidosCriados() + Funcionalidade.pizzasCriadas());

			} else if (opcao.equals("6")) {
				JOptionPane.showMessageDialog(null, Estatistica.printarEstatisticas(), "Estatísticas dos pedidos", 1);

			} else if (opcao.equals("7")) {
				JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema, volte sempre!");
			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	private static Pizza criarPizza() {

		Pizza novaPizza = null;

		String[] listaStr = new String[5];

		for (int i = 0; i < 5; i++) {

			String escolha = JOptionPane
					.showInputDialog(Funcionalidade.printarAtual(listaStr) + Funcionalidade.mostrarIngredientes()
							+ "\nSua pizza pode ter até 5 ingredientes, aperte OK para concluir a pizza"
							+ "\nEscolha um ingrediente ou digite 0 para remover o ultimo:");
			if (Funcionalidade.verificarEscolha(escolha, listaStr, i)) {
				i -= 2;

			} else {
				if (escolha.equals("")) {
					novaPizza = Funcionalidade.prepararPizza(listaStr);
					break;
				}

				if (Funcionalidade.verificacaoIngrediente(escolha)) {
					listaStr[i] = Funcionalidade.escolherIngredientes(escolha);


				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
					i--;
				}
			}
		}

		return novaPizza;
	}

	private static void servirPedido() {
		String msg = Funcionalidade.verificarPedido();
		if (!msg.equals("")) {
			JOptionPane.showMessageDialog(null, msg);

		} else {
			if (Funcionalidade.sizePedidos() == 0) {
				JOptionPane.showMessageDialog(null, "Crie pedidos para servir");
			} else {
				JOptionPane.showMessageDialog(null,
						"Não foi possível servir o pedido atual da fila, cadastre pizza equivalente", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}

	private static void adicionarIngrediente() {
		String ingrediente = JOptionPane.showInputDialog(null, "Digite o novo ingrediente: ");

		if (Funcionalidade.novoIngrediente(ingrediente)) {
			JOptionPane.showMessageDialog(null, "Ingrediente adicionado com sucesso");

		} else {
			JOptionPane.showMessageDialog(null, "Ingrediente já existente no cardápio");
		}
	}

}
