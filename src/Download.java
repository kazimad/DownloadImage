/**
 * Created by KaZimad on 17.03.14.
 */

import java.io.*;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;

public class Download {
    static DownloadThreads myThread1 = new DownloadThreads();
    static String StringLink;
//        static String nameDir = "cats/";
//        static File myDir = new File(nameDir);

    public static void main (String [] agrs) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
//        makeDir();
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                         // reads links from file
        LinkedBlockingQueue <String> stringLinkQueue = new LinkedBlockingQueue();

        while ((StringLink = br.readLine()) != null) {                 // пока буфер не пустой, присваиваем строку
            stringLinkQueue.add(StringLink);
        }

        while (true){
        if (!stringLinkQueue.isEmpty()){
            DownloadThreads.linkDownload =  stringLinkQueue.take();           // transmits link to DownloadThreads
            DownloadThreads myThread1 = new DownloadThreads();
                myThread1.start();

        }
            else break;
        }


        System.out.println("all done!");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println(stringLinkQueue.size());
    }

//    public static void makeDir(){
//        if(!myDir.exists()){
//            myDir.mkdir();
//        }
//    }


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


