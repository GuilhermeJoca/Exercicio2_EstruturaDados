import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(Processo.menu()));
			if(opcao < 1 || opcao > 6) {
				JOptionPane.showMessageDialog(null, "Opc�o inv�lida");
			}else {
				Lista aux = new Lista();
				switch(opcao) {
				case 1:
					Processo.cadastrarProduto();
					break;
				case 2:
					Processo.listarProduto();
					break;
				case 3:
					Processo.venderProduto();
					break;
				}
			}
		} while(opcao != 4);

	}

}
