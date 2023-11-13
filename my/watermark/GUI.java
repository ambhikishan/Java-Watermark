package my.watermark;
import javax.swing.*;;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI {
    public String path;
    public GUI(){
    JFrame w1 = new JFrame("WaterMark");

    JFrame w2 = new JFrame("Select File");

    w1.setSize(400,400);
    w1.setVisible(true);

    w1.setDefaultCloseOperation(3);
    JLabel l1 = new JLabel("No file selected");
        JButton b1 = new JButton("ADD Watermark");
        b1.setVisible(true);
        b1.setBounds(200,200,150,20);
        l1.setVisible(true);
        JButton b2 = new JButton("Browse");
        b2.setBounds(50,200,100,20);
        b2.setVisible(true);
        w1.add(b2);
        l1.setBounds(300,250,30,20);
        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileChooser = new FileDialog(w2,"Choose Img file",FileDialog.LOAD);
                fileChooser.setDirectory("");
                fileChooser.setVisible(true);
                path = fileChooser.getDirectory()+ fileChooser.getFile();
                System.out.println("file selected");

            }
        };
        b2.addActionListener(a1);
    w1.add(l1);
    w1.add(b1);
    JTextField t1 = new JTextField();
    t1.setVisible(true);
    t1.setSize(400,50);
    w1.add(t1);
ActionListener a2 = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String t = t1.getText();


        try {

            new watermark(path,t);

        } catch (IOException ex) {
            System.out.println("Hua hei nahi");
        }

    }
};
 b1.addActionListener(a2);
    }

    public static void main(String[] args) throws IOException {
        new GUI();
//        String str = "C:/Users/ambhi/OneDrive/Pictures/Screenshots/S.png";
//        new watermark(str,"You Hoo");
    }
}
