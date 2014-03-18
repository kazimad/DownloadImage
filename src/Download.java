/**
 * Created by KaZimad on 17.03.14.
 */

import java.io.*;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

public class Download {
    static Threads myThreadObject1;
    static Threads myThreadObject2;
    static Threads myThreadObject3;
    static Threads myThreadObject4;

    public static void main (String [] agrs) throws IOException {
        myThreadObject1 = new Threads();
        myThreadObject2 = new Threads();
        myThreadObject3 = new Threads();
        myThreadObject4 = new Threads();
        Thread myThread1 = new Thread(myThreadObject1);
        Thread myThread2 = new Thread(myThreadObject2);
        Thread myThread3 = new Thread(myThreadObject3);
        Thread myThread4 = new Thread(myThreadObject4);


        String StringLink;
        int countNameFiles = 1;
        int countLinks = 1;
        long start  = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                         // reads links from file

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        while ((StringLink = br.readLine())!=null){

            String outFile = ("newfile_" + countNameFiles++ + ".jpg");
            saveImage(StringLink, outFile,countLinks);
            countLinks++;

        }

        System.out.println("all done!");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

    }

    protected static void saveImage(String link, String outFile, int countLinks) throws IOException {

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
        catch (Exception qqq){
            System.out.println("link #" + countLinks+ " is unavailable" );
        }
    }


}
//////


