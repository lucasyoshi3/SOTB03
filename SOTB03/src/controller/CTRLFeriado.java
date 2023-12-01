package controller;

import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CTRLFeriado {   
    
	public static void lerEApresentarData(String nomeFeriado) throws IllegalArgumentException {
    	String os = System.getProperty("os.name");
        try {
        FileReader fileReader;

        	if (!os.equals("Linux")) {
        	    fileReader = new FileReader("C:\\TEMP\\hol.json");
        	} else {
        	    fileReader = new FileReader("/tmp/hol.json");
        	}
        	
            StringBuilder content = new StringBuilder();
            int data;
            while ((data = fileReader.read()) != -1) {
                content.append((char) data);
            }
            fileReader.close();

            JSONArray jsonArray = new JSONArray(content.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String date = jsonObject.getString("date");
                String localName = jsonObject.getString("localName");
                String name = jsonObject.getString("name");
                if(nomeFeriado.equals(name) || nomeFeriado.equals(localName)) {
                	System.out.println("Data do feriado: "+date);
                	break;
                }
                if(i==jsonArray.length()-1) {
                	throw new IllegalArgumentException("Feriado não encontrado: " + nomeFeriado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Não foi possível ler o arquivo JSON");
        }
    }
}
