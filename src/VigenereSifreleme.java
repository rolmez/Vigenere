import java.util.Scanner;
public class VigenereSifreleme {
	private String anahtar;
	public VigenereSifreleme(String anahtar) {
		setAnahtar(anahtar);
	}
	public void setAnahtar(String anahtar) {
		if (anahtar == null) {
			this.anahtar = "";
			return;
		}
		char[] x = anahtar.toUpperCase().toCharArray();
		StringBuilder sb = new StringBuilder(x.length);
		for (char c : x) {
			if (c >= 'A' && c <= 'Z')
				sb.append(c);
		}
		this.anahtar = sb.toString();
	}
	public String sifre(String b) {
		if (b == null)
			return "";
		if (anahtar.length() == 0)
			return b.toUpperCase();
		char[] x = b.toLowerCase().toCharArray();
		String uanahtar = anahtar;
		while(uanahtar.length() < b.length())
			uanahtar += anahtar;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < 'a' || x[i] > 'z')
				continue;
		char d = uanahtar.charAt(i);
		int s = d - 'A';
		x[i] = Character.toUpperCase(x[i]);
		x[i] += s;
		if (x[i] > 'Z') {
			x[i] -= 'Z';
			x[i] += ('A' - 1);
			}
		}
		return new String(x);
	}
	
	public static void main(String[] args) {
		
		VigenereSifreleme vigenere = new VigenereSifreleme("");
		String alfabe = "abcdefghijklmnopqrstuvwxyz";
		String mesaj2 = vigenere.sifre(alfabe);
		Scanner scan = new Scanner(System.in);
		System.out.print("Anahtarý giriniz: ");
		String anahtar = scan.nextLine();
		VigenereSifreleme vigenere2 = new VigenereSifreleme(anahtar);
		System.out.print("Mesajýnýzý giriniz: ");
		String mesaj = scan.nextLine();
		mesaj2 = vigenere2.sifre(mesaj);
		System.out.println("Þifrelenmiþ Mesajýnýz: " + mesaj2);
	}
}