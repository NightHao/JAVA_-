import javax.swing.JFrame;
//Sort �� UI �����A��Ѩ�L�����i�J�A�\��ݸɥR
public class MulUI {
	public void start() {
		MulFrame TestUI = new MulFrame();
		TestUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TestUI.setSize(1000, 800); // set frame size
		TestUI.setVisible(true); // display frame
	}
}