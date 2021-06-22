import javax.swing.JFrame;
//Sort 的 UI 介面，能由其他介面進入，功能待補充
public class SortUI {
	public void start() {
		SortFrame TestUI = new SortFrame();
		TestUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TestUI.setSize(1000, 800); // set frame size
		TestUI.setVisible(true); // display frame
	}
}