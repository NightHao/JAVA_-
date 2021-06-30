import javax.swing.JFrame;
public class demo {
    public static void main(String args[]) {
		demoUI TestUI = new demoUI();
		TestUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TestUI.setSize(500, 300); // set frame size
		TestUI.setVisible(true); // display frame
	}
}
