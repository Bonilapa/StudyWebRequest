import web.WebRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        try {
            WebRequest webRequest = new WebRequest(scn.nextLine().trim());
            webRequest.connect();
            System.out.println(webRequest.getContentType());
            System.out.println(webRequest.getContent());
            System.out.println(webRequest.getResponseCode());
            System.out.println(webRequest.getAllContent());

        }catch (MalformedURLException e){

            e.printStackTrace();
        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
