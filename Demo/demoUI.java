import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

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
        sortButton.setForeground(Color.white);
        sortButton.setBackground(Color.blue);
        Font f = new Font("微軟正黑體",Font.BOLD, 36);
        sortButton.setFont(f);
        mulButton.setForeground(Color.white);
        mulButton.setBackground(Color.red);
        mulButton.setFont(f);
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