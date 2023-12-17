package pizzaria;

import javax.swing.JOptionPane;

import pizzaria.funcionalidades.*;
import pizzaria.entidade.*;

public class Main {
	public static void main(String[] args) {

		int opcao = 1;

		while (opcao != 6) {
			//try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(Funcionalidade.menu()));

				if (opcao == 1) {
					Funcionalidade.addPizza(criarPizza());
					JOptionPane.showMessageDialog(null, Funcionalidade.pizzasCriadas());

				} else if (opcao == 2) {
					Funcionalidade.addPedido(Integer.parseInt(JOptionPane.showInputDialog(
							null, "Digite sua mesa: ")), criarPizza());
					JOptionPane.showMessageDialog(null, Funcionalidade.pedidosCriados());
					
				} else if (opcao == 3) {
					servirPedido();
					
				} else if (opcao == 4) {

				} else if (opcao == 5) {

				} else if (opcao == 6) {
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema, volte sempre!");

				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}

			//} catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Opção inválida");
			//}

		}

	}

	private static Pizza criarPizza() {
		Funcionalidade.addIngredientes();

		int quantidade = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Deseja uma pizza com quantos ingredientes? " + "Escolha até 5"));

		Pizza novaPizza = null;

		if (quantidade < 1 || quantidade > 5) {
			JOptionPane.showMessageDialog(null, "Quantidade inválida");

		} else {

			String[] listaStr = new String[5];

			int i = 0;

			for (; i < quantidade; i++) {

				int escolha = Integer.parseInt(JOptionPane
						.showInputDialog(Funcionalidade.printarAtual(listaStr) + Funcionalidade.mostrarIngredientes()
								+ "Escolha um ingrediente ou digite 0 para remover o ultimo: "));

				if (Funcionalidade.verificarEscolha(escolha, listaStr, i)) {
					i -= 2;

				} else {

					if (Funcionalidade.verificacaoIngrediente(escolha)) {
						listaStr[i] = Funcionalidade.escolherIngredientes(escolha);

						if (i == quantidade - 1) {
							novaPizza = Funcionalidade.prepararPizza(listaStr);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Ingrediente inválido");
						i--;
					}
				}
			}
		}
		return novaPizza;
	}
	
	private static void servirPedido() {
		String msg = Funcionalidade.verificarPedido();
		if(!msg.equals("")) {
			System.out.println(Funcionalidade.verificarPedido());
		} else {
			System.out.println("erro");
		}
		
	}
	
}
