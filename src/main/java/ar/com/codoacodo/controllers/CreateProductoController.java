package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDao;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/CreateProductoController")
public class CreateProductoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturo parametros q vienen en el request eviado x el form
		String titulo = req.getParameter("titulo");// name del input
		String codigo = req.getParameter("codigo");// name del input
		String precio = req.getParameter("precio");// name del input
		String fechaAlta = req.getParameter("fechaAlta");// name del input
		String autor = req.getParameter("autor");// name del input
		// validaciones!
		List<String> errores = new ArrayList<>();
		if (titulo == null || titulo.trim().isEmpty()) {
			  errores.add("Título requerido");
			}

			if (codigo == null || codigo.trim().isEmpty()) {
			  errores.add("Código requerido");
			}

			if (precio == null || precio.trim().isEmpty()) {
			  errores.add("Precio requerido");
			}

			if (fechaAlta == null || fechaAlta.trim().isEmpty()) {
			  errores.add("Fecha requerida");
			}

			if (autor == null || autor.trim().isEmpty()) {
			  errores.add("Autor requerida");
			}
			if (errores.size() == 5) {
				  errores.clear();
				  errores.add("Completar los campos necesarios");
				}
		
			// agrego las demas validaciones!!!! (uds)
		if (!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			// vuelvo a la jsp con la lista de errores cargadas
			getServletContext().getRequestDispatcher("/nuevo.jsp").forward(req, resp);
			return;
		}
		// TODO ver de armar logica para cargar binario
		String img = req.getParameter("img");// name del input(tratamiento especial)

		IProductoDao dao = new ProductoDAOMysqlImpl();

		// facil
		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);

		try {
			dao.create(newProducto);
			// si todo ok ir a listado.jsp
			// agregar mensaje de exito
			req.setAttribute("success", List.of("Alta de producto exitosa" +" " + titulo));
		} catch (Exception e) {
			// si falla volver al nuevo.jsp
			e.printStackTrace();
		}

		// ahora donde vamos

		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);

	}

	public static void main(String[] args) throws Exception {

		IProductoDao dao = new ProductoDAOMysqlImpl();

		// facil
		Producto newProducto = new Producto("codigo08", "Codo a Codo FullStack ", 1D, new Date(), "Autor124", null);

		dao.create(newProducto);

		System.out.println("id generado para el nuevo producto: " + newProducto.getId());

	}

}
