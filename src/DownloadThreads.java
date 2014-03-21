import java.io.IOException;

/**
 * Created by KaZimad on 18.03.14.
 */

public class DownloadThreads  extends Thread{
    static Object myMutex = new Object();
    static int countNameFiles = 0;
    static int countLinks = 0;
    static int countThreads = 1;



    public String getLinkDownload(String linkDownload){
        return linkDownload;
    }

    @Override
    public void run() {

        System.out.println("Thread_ "+countThreads+ " started");

        synchronized (myMutex){
            countNameFiles++;
            countLinks++;
        }

        String outFile = ("newfile_" + countNameFiles + ".jpg");
        try {
            Download.saveImage(linkDownload, outFile, countLinks);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Thread_"+countThreads+  " stopped");
        countThreads++;
    }



}
