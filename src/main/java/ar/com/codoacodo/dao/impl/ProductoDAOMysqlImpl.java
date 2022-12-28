package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.dao.IProductoDao;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDao {

	@Override
	public Producto getById(Long id) throws Exception {

		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// verifico si hay datos
		if (resultSet.next()) {
			return this.crearProducto(resultSet);
		}
		// flata cerrar la connection!!!
		return null;
	}

	@Override
	public List<Producto> findAll() throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO";
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Producto> productos = new ArrayList<Producto>();

		// verifico si hay datos
		while (resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}

		return productos;
	}

	@Override
	public void delete(Long id) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "DELETE FROM PRODUCTO WHERE ID= " + id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		statement.executeUpdate(sql);// 1 o 2
	}

	@Override
	public void update(Producto producto) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement

		Statement statement = connection.createStatement();

		String updateSql = "UPDATE producto  SET titulo = ? , precio = ? , autor= ? , img= ?  WHERE id = ?";
		try {
			PreparedStatement updateStmt = connection.prepareStatement(updateSql);
			updateStmt.setString(1, producto.getTitulo());
			updateStmt.setDouble(2, producto.getPrecio());
			updateStmt.setString(3, producto.getAutor());
			updateStmt.setString(4, producto.getImg());
			updateStmt.setLong(5, producto.getId());
			updateStmt.execute();
	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	private Producto crearProducto(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo id
		Long idDb = resultSet.getLong("id");
		String codigo = resultSet.getString("codigo");
		String titulo = resultSet.getString("titulo");
		Double precio = resultSet.getDouble("precio");
		Date fechaAlta = resultSet.getDate("fecha_alta");
		String autor = resultSet.getString("autor");
		String img = resultSet.getString("img");

		return new Producto(idDb, codigo, titulo, precio, fechaAlta, autor, img);
	}

	@Override
	public Long create(Producto newProduct) throws SQLException {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "INSERT INTO PRODUCTO (codigo,titulo,precio,fecha_alta,autor,img) values(?,?,?,?,?,?) ";
		String generationColumns[] = { "id" };
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, newProduct.getCodigo());
		statement.setString(2, newProduct.getTitulo());
		statement.setDouble(3, newProduct.getPrecio());
		statement.setDate(4, new Date(newProduct.getFechaAlta().getTime()));
		statement.setString(5, newProduct.getAutor());
		statement.setString(6, newProduct.getImg());

		// 3 - resultset

		statement.executeUpdate();

		ResultSet resultSet = statement.getGeneratedKeys();

		if (resultSet.next()) {
			long resultado = resultSet.getInt(1);
			// connection.close();

			return resultado;

		}
		return null;
	}

	@Override
	public List<Producto> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO WHERE TITULO LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		// setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Producto> productos = new ArrayList<Producto>();

		// verifico si hay datos
		while (resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}

		return productos;
	}

}
