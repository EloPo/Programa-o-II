package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Aep22.Aep22.CriarConexao;
import model.BilheteAereo;

public class BilheteAereoRepositoryJDBC implements BilheteAereoRepository{ 
	
	@Override
	public void inserir(BilheteAereo bilhete) throws Exception {
		String sql = "INSERT INTO BilheteAereo(voo,origem,destino,data)values(?,?,?,?)";
		
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setInt(1,bilhete.getVoo());
		statement.setString(2, bilhete.getOrigem());
		statement.setString(3, bilhete.getDestino());
		statement.setDate(4, (java.sql.Date) bilhete.getData());
		
		statement.execute();
		statement.close();
	}

	@Override
	public List<BilheteAereo> obterTodos() throws Exception {
		List<BilheteAereo> bilhetes = new ArrayList<>();
		String sql = "SELECT voo,origem,destino,data FROM BilheteAereo";
		Statement statement = CriarConexao.conexao().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next())  {
			int voo = resultSet.getInt("voo");
			String origem = resultSet.getString("origem");
			String destino = resultSet.getString("destino");
			Date data = new java.util.Date(resultSet.getDate("data").getTime());
			BilheteAereo recuperado = new BilheteAereo(voo, origem, destino, data);
			bilhetes.add(recuperado);
		}
		resultSet.close();
		statement.close();
		
		return bilhetes;
	}

	@Override
	public void alterar(BilheteAereo bilhete) throws Exception {
		String sql = "update BilheteAereo set origem = ?, destino = ?, data = ? where voo = ?";
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setInt(4,bilhete.getVoo());
		statement.setString(1, bilhete.getOrigem());
		statement.setString(2, bilhete.getDestino());
		statement.setDate(3, (java.sql.Date) bilhete.getData());
		
		statement.execute();
		statement.close();	
	}

	@Override
	public void excluir(int id) throws Exception {
		String sql = "delete from BilheteAereo where voo = ?";
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setInt(1,id);
		statement.execute();
		statement.close();	
	}
	
}
