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

public class demoUI extends JFrame{
    private JButton sortButton, mulButton;
    public demoUI(){
        super("Demo");
        EventListner handler = new EventListner();
        sortButton = new JButton("SORT");
        mulButton = new JButton("MUL");
        sortButton.addActionListener(handler);
        mulButton.addActionListener(handler);
        setLayout(new GridLayout(1,2));
        add(sortButton);
        add(mulButton);
    }
    private class EventListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == sortButton){
                SortUI test = new SortUI();
                test.start();
            }
            else{
                MulUI test = new MulUI();
                test.start();
            }
        }
        
    }
}
