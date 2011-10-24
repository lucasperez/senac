package teste;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestaInternacionalizacao {
	
	public static void main(String[] args) throws IOException {

		Properties p = new Properties();
		p.load(TestaInternacionalizacao.class.getClassLoader().getResourceAsStream("consultorio.properties"));
		
		Locale locale = new Locale(p.getProperty("idiomaPadrao"),p.getProperty("paisPadrao"));
		ResourceBundle rb = ResourceBundle.getBundle("resources.MessagesBundle", locale);
		
		System.out.println(rb.getString("labelLogin"));	
		

	}

}
