import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class RecordFrame extends JFrame {
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,error;
    private int index = 0;
    public RecordFrame(String[] record,int time){
        super("Record");
        if(time ==0){
            error = new JTextField("No Record");
            error.setEnabled(false);
            add(error);
        }
        else{
            setLayout(new GridLayout(10,1));
            System.out.println(time);
            t1=new JTextField();
            t2=new JTextField();
            t3=new JTextField();
            t4=new JTextField();
            t5=new JTextField();
            t6=new JTextField();
            t7=new JTextField();
            t8=new JTextField();
            t9=new JTextField();
            t10=new JTextField();
            System.out.println(time);
            if(time == 1){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
            }
            if(time == 2){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
            }
            if(time == 3){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
            }
            if(time == 4){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
            }
            if(time == 5){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
            }
            if(time == 6){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
                t6.setText(record[5]);
                t6.setEditable(false);
                add(t6);
            }
            if(time == 7){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
                t6.setText(record[5]);
                t6.setEditable(false);
                add(t6);
                t7.setText(record[6]);
                t7.setEditable(false);
                add(t7);
            }
            if(time == 8){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
                t6.setText(record[5]);
                t6.setEditable(false);
                add(t6);
                t7.setText(record[6]);
                t7.setEditable(false);
                add(t7);
                t8.setText(record[7]);
                t8.setEditable(false);
                add(t8);
            }
            if(time == 9){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
                t6.setText(record[5]);
                t6.setEditable(false);
                add(t6);
                t7.setText(record[6]);
                t7.setEditable(false);
                add(t7);
                t8.setText(record[7]);
                t8.setEditable(false);
                add(t8);
                t9.setText(record[8]);
                t9.setEditable(false);
                add(t9);
            }
            if(time == 10){
                t1.setText(record[0]);
                t1.setEditable(false);
                add(t1);
                t2.setText(record[1]);
                t2.setEditable(false);
                add(t2);
                t3.setText(record[2]);
                t3.setEditable(false);
                add(t3);
                t4.setText(record[3]);
                t4.setEditable(false);
                add(t4);
                t5.setText(record[4]);
                t5.setEditable(false);
                add(t5);
                t6.setText(record[5]);
                t6.setEditable(false);
                add(t6);
                t7.setText(record[6]);
                t7.setEditable(false);
                add(t7);
                t8.setText(record[7]);
                t8.setEditable(false);
                add(t8);
                t9.setText(record[8]);
                t9.setEditable(false);
                add(t9);
                t10.setText(record[9]);
                t10.setEditable(false);
                add(t10);
            }
        }
    }
}
