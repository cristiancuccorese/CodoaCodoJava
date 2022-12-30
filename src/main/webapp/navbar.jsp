<nav class="navbar navbar-expand-lg navbar-light bg-dark  ">
	<div class="container-fluid ">
		<img src="https://cdn-icons-png.flaticon.com/512/92/92031.png" height="80" class="d-inline-block " style="margin-left: 10px;">
        <a class="navbar-brand text-danger  " style="margin-left: 25px;"
			href="<%=request.getContextPath()%>">El Cuervo</a>
		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
				<li class="nav-item"><a class="nav-link active text-white"
					aria-current="page" href="<%=request.getContextPath()%>/nuevo.jsp">Nuevo
						Libro</a></li>
				<li class="nav-item "><a class="nav-link text-white"
					href="<%=request.getContextPath()%>/FindAllProductoController">Listado</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-white" href="#"
					id="navbarDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> Tiendas Asociadas </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="https://www.tematika.com/">Tematika</a></li>
						<li><a class="dropdown-item"
							href="https://www.penguinlibros.com/">Penguin</a></li>
						<li><a class="dropdown-item"
							href="https://www.bookshop.com.uy/">bookshop</a></li>
						<li><hr class="dropdown-divider"></li>

					</ul></li>
			</ul>
			<form class="d-flex"
				action="<%=request.getContextPath()%>/SearchProductosController">
				<input class="form-control me-2" name="ItemBuscar" type="search"
					placeholder="Buscar Titulo" aria-label="Search">
				<button class="btn btn-outline-danger" type="submit">Buscar</button>
			</form>
		</div>
	</div>
</nav>