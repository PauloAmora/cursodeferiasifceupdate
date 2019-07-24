package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Mercadoria;

public class MercadoriaDAOImpl implements MercadoriaDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/deposito";
	static final String USER = "root";
	static final String PASS = "1234";
	
	static final String INSERT = "INSERT INTO mercadoria (nome, quantidade, entrada, saida, preco) VALUES (?, ?, ?, ?, ?)";
	static final String UPDATE = "UPDATE mercadoria SET quantidade=?, entrada=?, saida=?,preco=? where nome=?";
	static final String FIND_BY_NAME = "SELECT * FROM mercadoria WHERE nome=?";
	static final String FIND_ALL = "SELECT * FROM mercadoria";
	
	@Override
	public int create(Mercadoria m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, m.getNome());
			stmt.setInt(2, m.getQuantidade());
			stmt.setString(3, m.getEntrada());
			stmt.setString(4, m.getSaida());
			stmt.setFloat(5, m.getPreco());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(conn);
		}
		return 0;
	}

	@Override
	public int update(Mercadoria m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1, m.getQuantidade());
			stmt.setString(2, m.getEntrada());
			stmt.setString(3, m.getSaida());
			stmt.setFloat(4, m.getPreco());
			stmt.setString(5, m.getNome());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(conn);
		}
		return 0;
	}

	@Override
	public Mercadoria findByName(String nome) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Mercadoria m = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_BY_NAME);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				m = new Mercadoria();
				m.setNome(rs.getString(1));
				m.setQuantidade(rs.getInt(2));
				m.setEntrada(rs.getString(3));
				m.setSaida(rs.getString(4));
				m.setPreco(rs.getFloat(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(conn);
		}
		return m;
	}

	@Override
	public List<Mercadoria> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Mercadoria> l = new ArrayList<Mercadoria>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Mercadoria m = new Mercadoria();
				m.setNome(rs.getString(1));
				m.setQuantidade(rs.getInt(2));
				m.setEntrada(rs.getString(3));
				m.setSaida(rs.getString(4));
				m.setPreco(rs.getFloat(5));
				l.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(conn);
		}
		return l;
	}
	
	Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(
					DB_URL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	void close (Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	void close (Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
