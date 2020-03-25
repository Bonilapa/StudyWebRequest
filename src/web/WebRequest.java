package web;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class WebRequest {

    private URL url;
    private HttpURLConnection urlConnection;

    public WebRequest(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public WebRequest(URL url) {
        this.url = url;
    }

    public void connect() throws IOException{
        urlConnection = (HttpURLConnection) url.openConnection();
    }

    public String getContentType(){
        return urlConnection.getContentType();
    }
    public String getContent() throws IOException{
        return urlConnection.getContent().toString();
    }
    public int getResponseCode() throws IOException{
        return urlConnection.getResponseCode();
    }
    public String getAllContent() throws IOException {
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scn = new Scanner(inputStream);

        StringBuilder stringBuilder = new StringBuilder();
        while(scn.hasNextLine()){
            stringBuilder.append(scn.nextLine());
        }
        return stringBuilder.toString();
    }
}
