/**
 * Created by KaZimad on 17.03.14.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {
    public static void main (String [] agrs) throws IOException {
        String StringLink;
        int countNameFiles = 1;
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                         // reads links from file

        while ((StringLink = br.readLine())!=null){

//            File writeFile = new File("newfile" + countNameFiles++ + ".jpg");
//            if (writeFile.createNewFile()){
//                System.out.println("File is created");
//            }
            String link = StringLink;
            String outFile = "newfile_" + countNameFiles++ +".png";
            saveImage(link, outFile);

        }
    }

    private static void saveImage(String link, String outFile) throws IOException {

        URL url = new URL(link);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(outFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(length);
        }

        is.close();
        os.close();
        System.out.println("File is written");
    }
}
///////




//    }
//            BufferedReader brlink = new BufferedReader(new InputStreamReader(link.openStream()));

//    BufferedImage value = null;
//    URL link = new URL(StringLink);
//
//    value = ImageIO.read(link);
//    File writeFile = new File("newfile.jpg");
//    if (writeFile.createNewFile()){
//        System.out.println("File is created");
//    }
//    ImageIO.write(value,"jpg",writeFile);
//    System.out.println("File is written");
//}