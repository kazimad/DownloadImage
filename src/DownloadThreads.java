import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by KaZimad on 18.03.14.
 */

public class DownloadThreads  extends Thread{
    static Object myMutex = new Object();
    static int countNameFiles = 0;
    static int countLinks = 0;
    public  String linkDownload;

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }
    @Override
    public void run() {
        System.out.println(this.getName() + " started");
        synchronized (myMutex){
            countNameFiles++;
            countLinks++;
        }
        String outFile = ("cats/newfile_" + countNameFiles + ".jpg");
        try {
            Download.saveImage(linkDownload, outFile, countLinks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() +  " stopped");
    }

}
