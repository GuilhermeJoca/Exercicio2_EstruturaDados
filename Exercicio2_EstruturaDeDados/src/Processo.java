import javax.swing.JOptionPane;

public class Processo {

static Lista<Produto> lista = new Lista<Produto>();
	
	public static void cadastrarProduto() {
		String nome;
		
		nome = JOptionPane.showInputDialog(" Nome do produto: ");
		Produto produto = new Produto(nome);
		
		if(lista.pesquisar(produto) != null) {
			JOptionPane.showMessageDialog(null, "Esse produto já está cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			String validade;
			int estoque = 0;
			validade = JOptionPane.showInputDialog("Data de validade do produto(aaaa/mm/dd): ");
			estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de produtos:"));
			
			if(estoque <= 0) {
				estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade não compatível. \n Quantidade de produtos precisa ser maior que 0:"));
			}
	
			Produto produto_lista = new Produto(nome, validade, estoque);
			lista.inserir(produto_lista);
		}		
		
	}

	public static void listarProduto() {
		lista.imprimir(); 
		
	}

	public static void venderProduto() {
		String nome;
		String dataAtual = "2022/05/29";
		nome = JOptionPane.showInputDialog("Nome do produto: ");
		Produto produto = new Produto(nome);
		No aux = lista.pesquisar(produto);
		
		if(aux != null) {
			int quantidade;
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para vender: "));
			produto = (Produto)aux.dado;
			
			if(produto.checarEstoque(quantidade)) {
				produto.ajustarEstoque(quantidade);
				if(produto.qtdEstoque == 0) {
					lista.excluir(produto);
				}
			} else {
				if(quantidade <= 0) {
					JOptionPane.showMessageDialog(null, "Quantidade deve ser maior que 0!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
				}	
			}
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
public static String menu() {
		
		String aux = "Escolha uma opção: \n";
		aux += "1. Cadastrar produto \n";
		aux += "2. Listar produtos \n";
		aux += "3. Vender produto \n";
		aux += "4. Finalizar \n";
		return aux;
	}
}
