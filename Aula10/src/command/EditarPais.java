package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class EditarPais implements Command {

	@Override
	public void Executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		try {
		id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}
		Pais pais = new Pais();
		pais.setId(id);
		PaisService Ps = new PaisService();
		RequestDispatcher view = null;
		pais = Ps.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("AlterarPais.jsp");
		view.forward(request, response);
		}
	
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == pais.getId()){
				return i;
			}
		}
		return -1;
	}

	}


