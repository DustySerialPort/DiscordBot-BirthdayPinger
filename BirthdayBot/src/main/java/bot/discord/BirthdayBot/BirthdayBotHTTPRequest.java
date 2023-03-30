package bot.discord.BirthdayBot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class BirthdayBotHTTPRequest {

	public void startConnection() throws Exception {
		// URL, von der Sie die Metadaten abrufen möchten
	    URL url = new URL("http://localhost:8080/birthday");

	    // Erstellen Sie eine Verbindung
	    HttpURLConnection getpersonjsondata = (HttpURLConnection) url.openConnection();

	    // Setzen Sie die Anfrage-Methode auf GET
	    getpersonjsondata.setRequestMethod("GET");

	    // Empfangen Sie die Antwort
	    int responseCode = getpersonjsondata.getResponseCode();
	    System.out.println("Response Code : " + responseCode);
	    
	      // Prüfen, ob die Verbindung erfolgreich war
        if (responseCode == HttpURLConnection.HTTP_OK) {

            // BufferedReader und InputStreamReader erstellen, um den Response auszulesen
        	BufferedReader in = new BufferedReader(new InputStreamReader(getpersonjsondata.getInputStream()));
            
            // Response in einen String umwandeln
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // ObjectMapper erstellen und den JSON-String in eine Liste von Person-Objekten umwandeln
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            List<Person> persons = mapper.readValue(response.toString(), mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            
            // Ausgabe der Personen-Liste
            for (Person person : persons) {
                System.out.println(person);
            }

        } else {
            // Ausgabe einer Fehlermeldung
            System.out.println("HTTP error code : " + responseCode);
        }
	}

	
}
