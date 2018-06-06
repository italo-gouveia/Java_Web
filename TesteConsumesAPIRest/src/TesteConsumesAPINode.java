import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteConsumesAPINode {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:3300/users");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
        con.setConnectTimeout(15000);
        con.connect();
        
		if (con.getResponseCode() != 200) {
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
        StringBuffer sb = new StringBuffer();
        String line;
		while((line = in.readLine()) != null) {
			sb.append(line);
		}
        
		in.close();
		System.out.println(sb.toString());
        con.disconnect();
	}

}
