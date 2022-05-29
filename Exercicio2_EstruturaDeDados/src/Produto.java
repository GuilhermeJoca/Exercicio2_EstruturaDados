
public class Produto {

	String nome;
	String dataValidade;
	int qtdEstoque;
	
	
	public Produto(String nome, String dataValidade, int qtdEstoque) {
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.qtdEstoque = qtdEstoque;
	}
	
	public Produto(String nome) {
		this.nome = nome;
	}
	
	public boolean checarEstoque(int qtdEstoque) {
		if(this.qtdEstoque >= qtdEstoque && qtdEstoque > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void ajustarEstoque(int qtdEstoque) {
		this.qtdEstoque = this.qtdEstoque - qtdEstoque;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Produto aux = (Produto) obj; 
		
		if(aux.nome.equals(nome)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String imprimir = "";
		imprimir += "Nome: " + this.nome + "\n";
		imprimir += "Data Valdiade:  " + this.dataValidade + "\n";
		imprimir += "Estoque do Produto:  " + this.qtdEstoque + "\n";
		imprimir += "-x- " + "\n";
		return imprimir;
	}
}
