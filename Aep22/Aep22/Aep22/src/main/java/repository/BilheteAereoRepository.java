package repository;

import java.util.List;

import model.BilheteAereo;

public interface BilheteAereoRepository {
	void inserir(BilheteAereo bilhete) throws Exception;
	List<BilheteAereo> obterTodos() throws Exception;
	void alterar(BilheteAereo bilhete) throws Exception;
	void excluir(int id) throws Exception;
}
