package utils;
import java.io.File;

import utils.CryptoRSA;
import utils.Impressora;



public class TesteCrypto {
	public static void main(String[] args) throws Exception {
		String sMsgClara = "Oi, alunos da USJT!";
		String sMsgCifrada = null;
		String sMsgDecifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;

		Impressora prn = new Impressora();

		System.out
				.println("-------------------------------------------------------------- -");

		System.out.println(">>> Imprimindo mensagem original...");
		System.out.println("");

		bMsgClara = sMsgClara.getBytes("ISO-8859-1"); 
		System.out.println("Mensagem Clara (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgClara));
		System.out.println("");
		
		System.out.println("Mensagem Clara (String):");
		
		System.out.println(sMsgClara);
		System.out.println("");
		
		System.out.println(">>> Cifrando com o algoritmo Dummy...");
		System.out.println("");
		
		CryptoDummy cdummy = new CryptoDummy();
		
		cdummy.geraChave(new File("chave.dummy"));
		
		cdummy.geraCifra(bMsgClara, new File("chave.dummy"));
																
		bMsgCifrada = cdummy.getTextoCifrado();
		
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); 
		
		System.out.println("Mensagem Cifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgCifrada));
		System.out.println("");
		
		System.out.println("Mensagem Cifrada (String):");
		
		System.out.println(sMsgCifrada);
		System.out.println("");
		
		System.out.println(">>> Decifrando com o algoritmo Dummy...");
		System.out.println("");
		
		cdummy.geraDecifra(bMsgCifrada, new File("chave.dummy")); 
		
		bMsgDecifrada = cdummy.getTextoDecifrado();
		
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1")); 
		
		System.out.println("Mensagem Decifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgDecifrada));
		System.out.println();
		
		System.out.println("Mensagem Decifrada (String):");
		
		System.out.println(sMsgDecifrada);
		System.out.println("");
		
		System.out.println(">>> Cifrando com o algoritmo AES...");
		System.out.println("");
		
		CryptoAES caes = new CryptoAES();
		
		caes.geraChave(new File("chave.simetrica"));
		
		caes.geraCifra(bMsgClara, new File("chave.simetrica")); 
		
		bMsgCifrada = caes.getTextoCifrado();
		
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); 
		
		System.out.println("Mensagem Cifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgCifrada));
		System.out.println("");
		
		System.out.println("Mensagem Cifrada (String):");
		
		System.out.println(sMsgCifrada);
		System.out.println("");
		
		System.out.println(">>> Decifrando com o algoritmo AES...");
		System.out.println("");
		
		caes.geraDecifra(bMsgCifrada, new File("chave.simetrica")); 
		
		bMsgDecifrada = caes.getTextoDecifrado();

		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1")); 
		
		System.out.println("Mensagem Decifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgDecifrada));
		System.out.println();
		
		System.out.println("Mensagem Decifrada (String):");
		
		System.out.println(sMsgDecifrada);
		System.out.println("");
		
		System.out.println(">>> Cifrando com o algoritmo RSA...");
		System.out.println("");
		
		CryptoRSA crsa = new CryptoRSA();
		
		crsa.geraParDeChaves(new File("chave.publica"), new File(
				"chave.privada")); 
		
		crsa.geraCifra(bMsgClara, new File("chave.publica")); 
		
		bMsgCifrada = crsa.getTextoCifrado();
		
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); 
		
		System.out.println("Mensagem Cifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgCifrada));
		System.out.println("");
		
		System.out.println("Mensagem Cifrada (String):");

		System.out.println(sMsgCifrada);
		System.out.println("");

		System.out.println(">>> Decifrando com o algoritmo RSA...");
		System.out.println("");
		
		crsa.geraDecifra(bMsgCifrada, new File("chave.privada")); 
																	
		bMsgDecifrada = crsa.getTextoDecifrado();
		
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1")); 
																	
		System.out.println("Mensagem Decifrada (Hexadecimal):");
		
		System.out.print(prn.hexBytesToString(bMsgDecifrada));
		System.out.println();
		
		System.out.println("Mensagem Decifrada (String):");
		
		System.out.println(sMsgDecifrada);
		System.out.println("");
	}
}