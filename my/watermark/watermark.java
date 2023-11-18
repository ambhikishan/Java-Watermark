package my.watermark;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class watermark {
    watermark(String path, String text) throws IOException {
        int len = text.length();
        File f;
        BufferedImage img = ImageIO.read(f = new File(path));
        Graphics g = img.getGraphics();
        g.setColor(Color.WHITE);
        int x = img.getWidth(), y = img.getHeight();
        g.setFont(new Font("October Twilight",1,x*5/100));
        String file = f.getName();


        int count=0;

        for(int i = 0; i<file.length()-1; i++) {
            if (file.charAt(i) == '.') {
                count = i;
            }
        }
        StringBuilder format = new StringBuilder();

        for(int i =count+1;i<file.length();i++)
            format.append(file.charAt(i));
        String frm = format.toString();
        g.drawString(text,100,y-y*2/100);

        ImageIO.write(img,frm,new File(f.getParent()+"/w-"+f.getName()));
//        ImageIO.write(img,"jpg",new File(f.getParent()+"/w-"+f.getName()));
    }

}
