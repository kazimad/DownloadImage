/**
 * Created by KaZimad on 17.03.14.
 */

import java.io.*;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

public class Download {
    public static void main (String [] agrs) throws IOException {
        String StringLink;
        int countNameFiles = 1;
        int countLinks = 1;
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                         // reads links from file

        while ((StringLink = br.readLine())!=null){


        String outFile = ("newfile_" + countNameFiles++ + ".jpg");
        saveImage(StringLink, outFile,countLinks);
        countLinks++;

         }
        System.out.println("all done!");
    }

    private static void saveImage(String link, String outFile, int countLinks) throws IOException {

        try {
        URL url = new URL(link);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(outFile);


        int length;

        while ((length = is.read()) != -1) {
            os.write(length);
        }

        is.close();
        os.close();
        System.out.println("File # " + countLinks + " is written");
        }
        catch (UnknownHostException q){
            System.out.println("link #" + countLinks+ " is unavailable" );

        }
        catch (SocketException qq) {
            System.out.println("link #" + countLinks+ " is unavailable" );
    }
        catch (Exception qqq)
        { System.out.println("link #" + countLinks+ " is unavailable" );}
    }
}



