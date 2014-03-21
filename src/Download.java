/**
 * Created by KaZimad on 17.03.14.
 */

import java.io.*;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Download {
    //    static DownloadThreads myThread1 = new DownloadThreads();
    static String StringLink;
    static String nameDir = "cats/";
    static File myDir = new File(nameDir);


    public static void main (String [] agrs) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<DownloadThreads> myThreadsArray = new ArrayList<DownloadThreads>();                   // we will take Threads for our "for each"
        makeDir();
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                             // reads links from file
        LinkedBlockingQueue <String> stringLinkQueue = new LinkedBlockingQueue();                       // queue of links
        while ((StringLink = br.readLine()) != null) {                                                  // while StringLink.hasNext we have some new link
            stringLinkQueue.add(StringLink);
        }

        while (true){
            if (!stringLinkQueue.isEmpty()){
                DownloadThreads myThread1 = new DownloadThreads();
                myThreadsArray.add(myThread1);
                myThread1.setLinkDownload(stringLinkQueue.take());                                          // transmits link to DownloadThreads
                myThread1.start();
            }
            else {break;}
        }
        for (DownloadThreads myThread1: myThreadsArray) {
            myThread1.join();
        }
        System.out.println("all done!");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }



    public static void makeDir(){
        if(!myDir.exists()){
            myDir.mkdir();
        }
    }


    protected static void saveImage(String link, String outFile, int countLinks) throws IOException {
        try {
            URL url = new URL(link);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(outFile);

            int length;
            while ((length = is.read()) != -1) {                                            // reads by bytes while it is possible
                os.write(length);
            }
            is.close();
            os.close();
            System.out.println("File # " + countLinks + " is written");
        }
        catch (UnknownHostException q){
            System.out.println("link #" + countLinks+ " is unavailable1 " );
        }
        catch (SocketException qq) {
            System.out.println("link #" + countLinks+ " is unavailable2" );
        }
        catch (Exception qqq){
            System.out.println("link #" + countLinks+ " is unavailable3" );
        }
    }
}
//////


