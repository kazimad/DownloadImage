/**
 * Created by KaZimad on 17.03.14.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Download {
    public static void main (String [] agrs) throws IOException {
        String StringLink;
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));                         // reads links from file

        while ((StringLink = br.readLine())!=null){

            BufferedImage value = null;
            URL link = new URL(StringLink);

            value = ImageIO.read(link);
            File writeFile = new File("newfile.jpg");
            if (writeFile.createNewFile()){
                System.out.println("File is created");
            }
            ImageIO.write(value,"jpg",writeFile);
            System.out.println("File is written");
        }

    }
}////////