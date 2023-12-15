package pizzaria;

import javax.swing.JOptionPane;

import pizzaria.funcionalidades.Funcionalidade;

public class Main {
	public static void main(String[] args) {
		
		int opcao = 1;
		
		while(opcao != 6) {
			String opcaoStr = JOptionPane.showInputDialog(Funcionalidade.menu());
			opcao = Integer.parseInt(opcaoStr);
			
			try {
				if(opcao == 1) {
					Funcionalidade.addIngredientes();
										
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Deseja uma pizza com quantos ingredientes?"));
					
					String[] listaStr = new String[5];
					
					int i = 0;
					
					for(; i < quantidade; i++) {
						
						int escolha = Integer.parseInt(JOptionPane.showInputDialog(Funcionalidade.printarAtual(listaStr) + 
								Funcionalidade.mostrarIngredientes() +
								"Escolha um ingrediente ou digite 0 para remover o ultimo: "));
						
						String ingrediente = Funcionalidade.escolherIngredientes(escolha);
						
						if(Funcionalidade.verificacao(escolha)) {
						
						} else {
							JOptionPane.showMessageDialog(null, "Ingrediente inválido");
							i--;
						}
						
					}
					
					
				} else if(opcao == 2) {
					
				
				
				
				} else if(opcao == 3) {
					
					
				} else if(opcao == 4) {
					
					
					
				} else if(opcao == 5) {
					
					
					
				} else if(opcao == 6) {
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
