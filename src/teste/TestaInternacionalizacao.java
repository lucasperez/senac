package teste;

import java.util.*;



public class TestaInternacionalizacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Locale locale = new Locale("pt","br");
			ResourceBundle rb = ResourceBundle.getBundle("resources.MessagesBundle", locale);
			
			System.out.println(rb.getString("localeInfo"));	
		

	}

}
