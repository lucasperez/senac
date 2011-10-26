package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DataUtil {
	
	/**
	 * Método Estático para a conversão de datas
	 * @param dataBrasileira
	 * @return
	 */
	public static Date stringBrToDate(String dataBrasileira) {  
		   
		Date data = null;  
		
		try 
		{  
			DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
			data = dtOutput.parse(dataBrasileira);
		}
		catch (ParseException e) 
		{
			e.printStackTrace();  
		}
		return data;  
	}
	/**
	 * Método Estático para a conversão de datas
	 * @param dataBrasileira
	 * @return
	 */
	public static String dateUsToStringBr(Date data) {  
		 
		String dataString = "";
	    
	    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
	    dataString = out.format(data);
	    
	    return dataString;	    
	} 
	
}
