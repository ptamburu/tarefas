package service;

import model.Usuario;
import dao.UsuarioDAO;

public class UsuarioService {
	
	UsuarioDAO dao = new UsuarioDAO();
	
	public boolean validar(Usuario usuario){
		return dao.validar(usuario);
	}
	
	public int criar(Usuario usuario){
		return dao.criar(usuario);
	}
}
