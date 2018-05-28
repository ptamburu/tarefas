package controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import dao.ConnectionFactory;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws InvalidKeyException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, CertificateException, KeyStoreException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, Exception {
		try {
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("command."+request.getParameter("command")).newInstance();
			comando.Executar(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doExecute(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doExecute(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init(){
		try {
			ConnectionFactory.obtemConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy(){
		try {
			ConnectionFactory.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
