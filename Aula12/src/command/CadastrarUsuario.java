package command;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;
import utils.CryptoAES;

public class CadastrarUsuario implements Command {

	@Override
	public void Executar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		
		bMsgClara = senha.getBytes("ISO-8859-1"); 
		CryptoAES caes = new CryptoAES();
		caes.geraChave(new File("chave.simetrica"));
		caes.geraCifra(bMsgClara, new File("chave.simetrica")); 
		bMsgCifrada = caes.getTextoCifrado();
		// Converte o texto byte[] no equivalente String

		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		usuario.setPassword((new String(bMsgCifrada, "ISO-8859-1")));
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+usuario);
		} else {
			System.out.println("Não Logou "+usuario);
			throw new ServletException("Usuário/Senha inválidos");
		}
		response.sendRedirect("index.jsp");
	}

}