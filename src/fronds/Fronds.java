package fronds;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * This program will be there for you, when the rain starts to pour, like it's been there before, 
 * cause you're there for it too.
 * 
 * @author John Gibson
 */
public class Fronds {
    
    public static int windowCount = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initalize JFXPanel so JFX stuff works
        JFXPanel fxPanel = new JFXPanel();
        
        // acquire screen resolution
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        // load images of each cast member as ImageIcons
        ImageIcon ross = new ImageIcon(Fronds.class.getResource("/images/ross.png"));
        ImageIcon rachel = new ImageIcon(Fronds.class.getResource("/images/rachel.png"));
        ImageIcon monica = new ImageIcon(Fronds.class.getResource("/images/monica.png"));
        ImageIcon joey = new ImageIcon(Fronds.class.getResource("/images/joey.png"));
        ImageIcon chandler = new ImageIcon(Fronds.class.getResource("/images/chandler.png"));
        ImageIcon phoebe = new ImageIcon(Fronds.class.getResource("/images/phoebe.png"));
        
        // assign the images to 6 slots in an array
        Image[] images = new Image[6];
        images[0] = ross.getImage();
        images[1] = rachel.getImage();
        images[2] = monica.getImage();
        images[3] = joey.getImage();
        images[4] = chandler.getImage();
        images[5] = phoebe.getImage();
        
        Random rand = new Random();
        boolean done = false;
        
        JFrame frame = new JFrame("FRONDS");
        ImageIcon fronds = new ImageIcon(Fronds.class.getResource("/images/fronds.jpg"));
        Image im = fronds.getImage().getScaledInstance(775, 400, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(im);
        JLabel label = new JLabel(icon2);
        frame.add(label);
        frame.setDefaultCloseOperation(2);
        frame.pack();
        int x = rand.nextInt(d.width - frame.getWidth());
        int y = rand.nextInt(d.height - frame.getHeight());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        windowCount++;
        
        class WindowListener implements ActionListener {
            
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowCount < 300) {
                    int n = rand.nextInt(6);
                    int windowSize = rand.nextInt(400) + 200;
                    JFrame frame = new JFrame("FRONDS");
                    Image im = images[n].getScaledInstance(windowSize, windowSize, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon2 = new ImageIcon(im);
                    JLabel label = new JLabel(icon2);
                    frame.add(label);
                    frame.setDefaultCloseOperation(2);
                    frame.pack();
                    int x = rand.nextInt(d.width - frame.getWidth());
                    int y = rand.nextInt(d.height - frame.getHeight());
                    frame.setLocation(x, y);
                    frame.setVisible(true);
                    windowCount++;
                }
            }
        }
        
        class MusicListener implements ActionListener {
            
            int musicCount = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (musicCount < 10) {
                    // create a separate thread that plays friendsmidi.mp3
                    String musicpath = Fronds.class.getResource("/music/friendsmidi.mp3").toString();
                    Media media = new Media(musicpath);
                    MediaPlayer mp = new MediaPlayer(media);
                    mp.play();
                    musicCount++;
                }
            }
        }
        
        WindowListener wListener = new WindowListener();
        MusicListener mListener = new MusicListener();
        Timer wTimer = new Timer(100, wListener);
        Timer mTimer = new Timer(10, mListener);
        wTimer.start();
        mTimer.start();
    }
}