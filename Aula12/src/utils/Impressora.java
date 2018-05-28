package utils;
public class Impressora {
	public String hexBytesToString(byte[] b) {
		String sOut = "";
		String sBgn = "";
		String sMdl = "";
		String sEnd = "";
		String sSpc = "                                                "; 
																			

		for (int i = 0; i < b.length; i++) {

			
			if (i % 16 == 0){
				int num = i & 0xFFFF;
			    int num1 = i & 0xFFFF | 0x10000;
			    String s1 = Integer.toHexString(i & 0xFFFF | 0x10000);
			    String s2 = Integer.toHexString(i);
				sBgn += Integer.toHexString(i & 0xFFFF | 0x10000).substring(1,
						5)
						+ " - ";
			}
			
			sMdl += Integer.toHexString(b[i] & 0xFF | 0x100).substring(1, 3)
					+ " ";

		
			if (b[i] >= 32 && b[i] <= 126)
				sEnd += (char) b[i];
			else
				sEnd += ".";

			
			if ((i % 16 == 15) || (i == b.length - 1)) {
				sOut += sBgn + sMdl
						+ sSpc.substring(3 * ((i % 16) + 1), sSpc.length())
						+ " - " + sEnd + "\n";
				sBgn = sMdl = sEnd = "";
			}
		}
		return sOut;
	}
}