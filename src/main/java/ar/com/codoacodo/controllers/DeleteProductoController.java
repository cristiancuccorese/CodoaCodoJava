package ar.com.codoacodo.controllers;

import java.sql.Connection;
import java.sql.Statement;
import ar.com.codoacodo.dao.IProductoDao;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.db.AdministradorDeConexiones;

public class DeleteProductoController {

	public static void main(String[] args) throws Exception{

		IProductoDao dao = new ProductoDAOMysqlImpl();}
		
		public void delete(Long id) throws Exception{
			// 1 - necesito la Connection
			Connection connection = AdministradorDeConexiones.getConnection();

			// 2 - arma el statement
			String sql = "DELETE FROM PRODUCTO WHERE ID="+id;
			Statement statement = connection.createStatement();

			// 3 - resultset
			int eliminado = statement.executeUpdate(sql);//1 o 2
			System.out.println(eliminado);
		}


}
