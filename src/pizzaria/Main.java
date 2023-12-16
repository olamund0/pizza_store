package pizzaria;

import javax.swing.JOptionPane;

import pizzaria.funcionalidades.Funcionalidade;

public class Main {
	public static void main(String[] args) {

		int opcao = 1;

		while (opcao != 6) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(Funcionalidade.menu()));

				if (opcao == 1) {
					Funcionalidade.addIngredientes();

					int quantidade = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Deseja uma pizza com quantos ingredientes?"));

					String[] listaStr = new String[5];

					int i = 0;

					for (; i < quantidade; i++) {

						int escolha = Integer.parseInt(JOptionPane.showInputDialog(
								Funcionalidade.printarAtual(listaStr) + Funcionalidade.mostrarIngredientes()
										+ "Escolha um ingrediente ou digite 0 para remover o ultimo: "));

						if (Funcionalidade.verificarEscolha(escolha, listaStr, i)) {
							i -= 2;

						} else {

							if (Funcionalidade.verificacaoIngrediente(escolha)) {
								String ingrediente = Funcionalidade.escolherIngredientes(escolha);
								listaStr[i] = ingrediente;

								if (i == quantidade - 1) {
									Funcionalidade.criarPizza(listaStr);
								}

							} else {
								JOptionPane.showMessageDialog(null, "Ingrediente inválido");
								i--;
							}
						}
					}

				} else if (opcao == 2) {

				} else if (opcao == 3) {

				} else if (opcao == 4) {

				} else if (opcao == 5) {

				} else if (opcao == 6) {
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema, volte sempre!");

				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		}

	}
}
