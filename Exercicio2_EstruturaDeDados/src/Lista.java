import javax.swing.JOptionPane;

public class Lista <T>{
	No<T> inicio, fim;
	int total;
	
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado);
		Produto auxProduto = (Produto) aux.dado;

		if(inicio == null){
			inicio = aux;
			fim = aux;
		} else {
			Produto fimProduto = (Produto) fim.dado;
			Produto inicioProduto = (Produto) inicio.dado;
			
			No auc = inicio;
			Produto aucProduto = (Produto) auc.dado;
			
			if(auxProduto.dataValidade.compareTo(fimProduto.dataValidade) >= 0){ 
				fim.dir = aux;
				aux.esq = fim;
				fim = aux;
				
			} else if (auxProduto.dataValidade.compareTo(inicioProduto.dataValidade) < 0) {
				inicio.esq = aux;
				aux.dir = inicio;
				inicio = aux;
				
			} else {
				while(auc != null){ 
					Produto aucDireita = (Produto) auc.dir.dado;
					if (auxProduto.dataValidade.compareTo(aucDireita.dataValidade) <= 0 && auxProduto.dataValidade.compareTo(aucProduto.dataValidade) >= 0){
						aux.esq = auc;
						auc.dir.esq = aux;
						aux.dir = auc.dir;
						auc.dir = aux;
						break;
					}
					auc = auc.dir;
				}
			}
		}
		total ++;	
	}
	
	public No<T> pesquisar(T dado) {
		No<T> aux = inicio;
		boolean encontrou = false;
		while(encontrou == false && aux != null) {
			if(aux.dado.equals(dado)) {
				encontrou = true;
				break;
			} 
			aux = aux.dir; 
			
		}
		return aux;
	}
	
	
	public void excluir(T dado) {
		No<T> aux = pesquisar(dado);
		
		if(aux != null) {
			if(total == 1) {
				inicio = null;
				fim = null;	
			} else if(aux == inicio) { 
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if(aux == fim){
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
			
			total--;
		}
	}
	
	public void imprimir() {
		No<T> aux = inicio;
		String auc = "";
		while(aux != null) {
			auc += aux.dado;
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, "impressão: \n" + auc);
	}
}