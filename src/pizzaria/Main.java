package pizzaria;

import javax.swing.JOptionPane;

import pizzaria.funcionalidades.*;
import pizzaria.entidade.*;

public class Main {
	public static void main(String[] args) {

		String opcao = "1";

		while (!opcao.equals("6")) {
				Funcionalidade.addIngredientes();		
				
				opcao = JOptionPane.showInputDialog(null, Funcionalidade.menu(), 
						"Pizzaria Bon Appetit", JOptionPane.QUESTION_MESSAGE);

				if (opcao.equals("1")) {
					Funcionalidade.addPizza(criarPizza());
					JOptionPane.showMessageDialog(null, Funcionalidade.pizzasCriadas());

				} else if (opcao.equals("2")) {
					Funcionalidade.addPedido(criarPizza(), Integer.parseInt(JOptionPane.showInputDialog(
							null, "Digite sua mesa: ")));
					JOptionPane.showMessageDialog(null, Funcionalidade.pedidosCriados());
					
				} else if (opcao.equals("3")) {
					servirPedido();
					
				} else if (opcao.equals("4")) {
					adicionarIngrediente();
					
				} else if (opcao.equals("5")) {

				} else if (opcao.equals("6")) {
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema, volte sempre!");

				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
				}


		}

	}

	private static Pizza criarPizza() {

		int quantidade = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Deseja uma pizza com quantos ingredientes? Escolha até 5"));

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
						JOptionPane.showMessageDialog(null, "Ingrediente inválido", "Erro", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, msg);
		
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível servir o pedido atual da fila, crie pedido e pizza equivalentes", 
					"Message", JOptionPane.INFORMATION_MESSAGE);		
			
		}
		
	}
	
	private static void adicionarIngrediente() {
		String ingrediente = JOptionPane.showInputDialog(null, "Digite o novo ingrediente: ");
		
		if(Funcionalidade.novoIngrediente(ingrediente)) {
			JOptionPane.showMessageDialog(null, "Ingrediente adicionado com sucesso");
		
		} else {
			JOptionPane.showMessageDialog(null, "Ingrediente já existente no cardápio");
		}
	}
	
}
