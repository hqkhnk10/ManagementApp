/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author DHC
 */
public class ClockThread extends Thread {
   private JButton button;

    public ClockThread(JButton button) {
        this.button = button;
    }
   
   
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        while(true){
            Date now = new Date();
            
            String st = sdf.format(now);
            button.setText(st);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){new Notification(""+ex,1);
            }
        }
    }
    
   
}
