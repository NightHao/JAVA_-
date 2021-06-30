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
public class SortFrame extends JFrame {
	
	private Judge JJ = new Judge();//當有任何需要判斷的情況請盡量使用他
	private final JComboBox<String> imagesJComboBox,imagesJComboBox2; // hold icon names
	private static final String[] names = {"BubbleSort","InsertionSort","MergeSort","QuickSort","SelectionSort"};
	private static final String[] names2 = {"RandomArray","ExampleArray","ReadArray","InputArray"};
	private Boolean usingName = false,usingName2 = false,showImg = false;
	private String T1,T2;// 捕捉combobox的狀態
	private JButton increaseButton,decreaseButton,generateArray,RunButton,animation,left,right,changeSpeedL,goToIt,changeSpeedR, recordTime; // button to decrease font size
	private JTextArea inputText,outputText; // displays example text
	private int fontSize = 20, index = 0, it = 0, sizeOfAnimateArray,nTime = 500; // current font size
	private newArray Array;
	private JPanel animate,tmpPic;//tmpPic表示animate內的當前圖片panel
	private newArray[] animateArray;
	private ImageIcon gogofuck,gogojpg,errorfuck;//改成全域比較好應事件更改
	private JLabel speed = new JLabel("0.5");
	private JTextField changeIt = new JTextField("0");
	private JLabel nowTime = new JLabel("/0"), sec = new JLabel("Seconds"), step = new JLabel("Step");
	private JPanel bottomJPanel1, bottomJPanel2, bottomJPanel3, bottomJPanel4, sJPanel;
	private String[] rT = new String[10]; 
	private int records;
	public SortFrame() {
		super("Sort Frame Test");
		sJPanel= new JPanel();
		sJPanel.setLayout(new GridLayout(3,1));
		setLayout(new BorderLayout());
		imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
		imagesJComboBox2 = new JComboBox<String>(names2); // set up JComboBox
      	imagesJComboBox.setMaximumRowCount(5); // display three rows
		imagesJComboBox2.setMaximumRowCount(4); // display three rows
		ItemListener handler1 = new EventListner();
		ItemListener handler2 = new EventListner();
		imagesJComboBox.addItemListener(handler1); 
		imagesJComboBox2.addItemListener(handler2); 
		imagesJComboBox.setSelectedIndex(1); // 改變選項時才偵測,且一開始為0
		imagesJComboBox2.setSelectedIndex(2);// 直接改預設值先讓其跑一次
		EventListner handler = new EventListner();
		// create buttons and add action listeners
		generateArray = new JButton("Generate Array");
		gogofuck = new ImageIcon("fuck.png");
		errorfuck = new ImageIcon("fuck.png");
		gogojpg = new ImageIcon("GoGo.jpg");
		RunButton = new JButton(gogojpg);
		decreaseButton = new JButton("Decrease font size");
		increaseButton = new JButton("Increase font size");
		goToIt = new JButton("Click to see the step or press 'Enter'");
		changeSpeedL = new JButton("－");
		changeSpeedR = new JButton("＋");
		recordTime = new JButton("Record");
		recordTime.addActionListener(handler);
		generateArray.addActionListener(handler);
		RunButton.addActionListener(handler);
		changeSpeedL.addActionListener(handler);
		changeSpeedR.addActionListener(handler);
		decreaseButton.addActionListener(handler);
		increaseButton.addActionListener(handler);
		goToIt.addActionListener(handler);
		goToIt.addKeyListener(handler);
		animation = new JButton("Run"); //這是下面圖片的RUN
		left = new JButton("<=");
		right = new JButton("=>");
		// create text area and set initial font
		inputText = new JTextArea("Test");
		inputText.setFont(new Font("Consolos", Font.PLAIN, fontSize));
		inputText.setEditable(false);
		outputText = new JTextArea("Test");
		outputText.setFont(new Font("Consolos", Font.PLAIN, fontSize));
		outputText.setEditable(false);

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		JPanel inpanel = new JPanel();
		inpanel.setLayout(new BorderLayout());
		JPanel outpanel = new JPanel();
		bottomJPanel1 = new JPanel();
		bottomJPanel2 = new JPanel();
		bottomJPanel3 = new JPanel();
		bottomJPanel4 = new JPanel();
		outpanel.setLayout(new BorderLayout());
		inpanel.add(new JScrollPane(inputText));
		outpanel.add(new JScrollPane(outputText));
		tmpPic = new JPanel();
		animate = new JPanel();//animate 之後會改變，所以設成全域
		bottomJPanel1.add(left);
		bottomJPanel1.add(animation);
		bottomJPanel1.add(right);
		bottomJPanel2.add(changeSpeedL);
		bottomJPanel2.add(speed);
		bottomJPanel2.add(changeSpeedR);
		bottomJPanel2.add(sec);
		bottomJPanel3.add(step);
		bottomJPanel3.add(changeIt);
		bottomJPanel3.add(nowTime);
		bottomJPanel3.add(goToIt);
		animate.setLayout(new GridLayout(1,3));
		animate.add(bottomJPanel1);
		animate.add(bottomJPanel2);
		animate.add(bottomJPanel3);
		/*animate.add(left);
		animate.add(animation);
		animate.add(right);
		animate.add(changeSpeedL);
		animate.add(speed);
		animate.add(changeSpeedR);
		animate.add(changeIt);
		animate.add(nowTime);
		animate.add(goToIt);*/
		left.addActionListener(handler);
		animation.addActionListener(handler);
		right.addActionListener(handler);
		panel.add(generateArray);
		panel.add(RunButton);
		panel.add(increaseButton);
		panel.add(decreaseButton);
		panel.add(imagesJComboBox); // add combobox to JFrame
		panel.add(imagesJComboBox2); // add combobox to JFrame
		panel.add(recordTime);
		sJPanel.add(panel); // add buttons at top
		sJPanel.add(inpanel); // allow scrolling
		sJPanel.add(outpanel); // allow scrolling
		bottomJPanel4.setLayout(new BorderLayout());
		bottomJPanel4.add(animate,BorderLayout.NORTH);
		bottomJPanel4.add(tmpPic,BorderLayout.CENTER);
		setLayout(new GridLayout(2,1));
		add(sJPanel);
		add(bottomJPanel4);
	}

	private class EventListner implements ActionListener,ItemListener,KeyListener {
		public void setAnimateImg(){//重製新圖片(把舊圖看掉放新的)
			changeIt.setText(String.format("%d",it));
			nowTime.setText(String.format("/%d",sizeOfAnimateArray));
			if(showImg==true){
				Chart chart = new Chart(animateArray[it]);
				bottomJPanel4.remove(tmpPic);
				tmpPic = chart.getChartPanel();
				bottomJPanel4.add(tmpPic);
			}
			else{
				bottomJPanel4.remove(tmpPic);
				JLabel tmpLab = new JLabel(new ImageIcon("NO_IMAGE.png"));
				tmpPic = new JPanel();
				tmpPic.add(tmpLab);
				bottomJPanel4.add(tmpPic);
			}
			bottomJPanel4.revalidate();

		}
		public void judgeSortType(){
			System.out.println("You choose "+T1);
			if(Array==null){
				outputText.setText("Please generate array first!");
				RunButton.setIcon(gogofuck);
			}
			else{
				it = 0;
				RunButton.setIcon(gogojpg);
				Sort Gogo;
				if(T1=="BubbleSort"){
					Gogo = new BubbleSort();
				}
				else if(T1=="InsertionSort"){
					Gogo = new InsertionSort();
				}
				else if(T1=="MergeSort"){
					Gogo = new MergeSort();
				}
				else if(T1=="QuickSort"){
					Gogo = new QuickSort();
				}
				else /*if(T1=="SelectionSort")*/{
					Gogo = new SelectionSort();
				}
				Gogo.SortMain(Array.getArray());
				sizeOfAnimateArray = Gogo.swapTime();
				it=0;
				if(JJ.canDraw(sizeOfAnimateArray,Array.getArraySize())==true){
					animateArray = Gogo.getsortStep();
					showImg = true;
				}
				else{
					showImg = false;
				}
				outputText.setText(Gogo.getOutput());
				setAnimateImg();
				Double totalTime = Gogo.getTime();
				int aSwap = Gogo.swapTime();
				int aSize = Array.getArraySize();
				if(records < 10){
					rT[records] = String.format("Type: %s   Size: %d   SwapTime: %d   Time: %f milliseconds",T1,aSize,aSwap,totalTime);
					records++;
				}
				else{
					records = 0;
					for(int i = 0; i < 10; ++i){
						rT[i] = "";
					}
				}
			}
		}
		public void judgeInput(){
			System.out.println("You choose "+T2);
			if(T2=="RandomArray"){
				//參考generateRandomArrayTest
				String sn=JOptionPane.showInputDialog("Input the size of your array");
				String slr=JOptionPane.showInputDialog("Input the lower bound of your array");
				String sur=JOptionPane.showInputDialog("Input the upper bound of your array");
				int n=Integer.parseInt(sn);
				int lr=Integer.parseInt(slr);
				int ur=Integer.parseInt(sur);
				generateRandomArray tmp = new  generateRandomArray(n,lr,ur);
				Array = new newArray(tmp.getArray(),lr,ur);
				inputText.setText(Array.toString());
			}
			else if(T2=="ExampleArray"){
				generateExampleArray tmp = new generateExampleArray();
				Array = new newArray(tmp.getArray());
				inputText.setText(Array.toString());
			}
			else if(T2=="ReadArray"){
				findFile fd = new findFile();
				System.out.println(fd.getName());
				ReadArray tmp = new ReadArray(fd.getName()); 
				Array = new newArray(tmp.run());
				inputText.setText(Array.toString());
			}
			else if(T2=="InputArray"){
				if (generateArray.getText() == "NEW Generate Array") {
					String words = inputText.getText();
					if(JJ.stringIsArray(words)){
						Array = new newArray(words);
						inputText.setText(Array.toString());
						generateArray.setText("Generate Array");
						inputText.setEditable(false);
					}
					else{
						inputText.setText("Input string is not an array! Please try again.");
					}
					//System.out.println(words);
				}
				else if (generateArray.getText() == "Generate Array") {
					generateArray.setText("NEW Generate Array");
					inputText.setText("");
					inputText.setEditable(true);
				}
			}
		}
		public void actionPerformed(ActionEvent e){//當Button被按到時
			
			if(e.getSource()==left){
				if(it>0){
					--it;
					setAnimateImg();
				}
			}
			if(e.getSource()==right){
				if(it<sizeOfAnimateArray){
					++it;
					setAnimateImg();
				}
			}
			if(e.getSource()==generateArray){//產生陣列
				judgeInput();
			}
			if(e.getSource()==RunButton){//Sort
				judgeSortType();
			}
			//以下參考作業
			if(e.getSource()==increaseButton){
				if(fontSize>=160){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be larger!");
				}
				else{
					fontSize+=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==decreaseButton){
				if(fontSize<=8){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be smaller!");
				}
				else{
					fontSize-=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==animation){
				if(index == 0){
					animation.setText("pause");
					left.setEnabled(false);
					right.setEnabled(false);
					index = 1;
					if(it<sizeOfAnimateArray){
						RunChart r1 = new RunChart();
						Thread thr = new Thread(r1);
						thr.start();
					}
				}
				else if(index == 1){
					animation.setText("Run");
					left.setEnabled(true);
					right.setEnabled(true);
					index = 0;
				}
			}
			if(e.getSource()==changeSpeedL){
				if(Double.parseDouble(speed.getText()) > 0.1){
					nTime -= 100;
					speed.setText(String.format("%.1f",(double)nTime/1000));
				}
			}
			if(e.getSource() == changeSpeedR){
				if(Double.parseDouble(speed.getText()) < 10.0){
					nTime += 100;
					speed.setText(String.format("%.1f",(double)nTime/1000));
				}	
			}
			if(e.getSource()==goToIt){
				checkGo();
			}
			if(e.getSource()==recordTime){
				RecordFrame recordUI = new RecordFrame(rT,records);
				recordUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				recordUI.setSize(600, 450); // set frame size
				recordUI.setVisible(true); // display frame
			}
		}

		//捕捉keyPress
		public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
                checkGo();
        }
		@Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}

		public void checkGo(){
			if(JJ.stringIsArray(changeIt.getText())){
				int tmp = Integer.parseInt(changeIt.getText());
				if((tmp<=sizeOfAnimateArray&&tmp>=0)&&sizeOfAnimateArray!=0){
					it = tmp;
					setAnimateImg();
				}
				else{
					JOptionPane.showMessageDialog(null, "輸入格式錯誤!(請輸入範圍內的正整數)", "格式輸入錯誤", JOptionPane.ERROR_MESSAGE);
					changeIt.setText(Integer.toString(it));
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "輸入格式錯誤!(請輸入範圍內的正整數)", "格式輸入錯誤", JOptionPane.ERROR_MESSAGE);
				changeIt.setText(Integer.toString(it));
			}
		}

		@Override//捕捉combobox
		public void itemStateChanged(ItemEvent e){
			// determine whether item selected
			if(e.getSource()==imagesJComboBox){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println(e.getItem());
					T1 = (String) e.getItem();
					Sort Gogo;
					if(T1=="BubbleSort"){
						Gogo = new BubbleSort();
					}
					else if(T1=="InsertionSort"){
						Gogo = new InsertionSort();
					}
					else if(T1=="MergeSort"){
						Gogo = new MergeSort();
					}
					else if(T1=="QuickSort"){
						Gogo = new QuickSort();
					}
					else{
						Gogo = new SelectionSort();
					}
					if(usingName==true){
						JOptionPane.showMessageDialog(null,Gogo.doc(),"演算法說明",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						usingName=true;
					}
				}
			}
			else if(e.getSource()==imagesJComboBox2){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println(e.getItem());
					T2 = (String) e.getItem();
					if(usingName2==true){
						if(T2=="RandomArray"){//doc 文件請改成回傳String
							JOptionPane.showMessageDialog(null,generateRandomArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="ExampleArray"){
							JOptionPane.showMessageDialog(null,generateExampleArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="ReadArray"){
							JOptionPane.showMessageDialog(null,ReadArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="InputArray"){
							JOptionPane.showMessageDialog(null,"請先點擊一次'Generate Array'按鈕後，於input區域輸入格式正確的陣列(整數、數字間須有空格、可以有負數、不可換行)\n最後再點選'NEW Generate Array'即可輸入陣列","輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else{
						usingName2=true;
					}
				}
			}
			
		} 
		public class RunChart implements Runnable{
			public void run(){
				while(it<sizeOfAnimateArray && index == 1){
					++it;
					nowTime.setText(String.format("%d/%d",it,sizeOfAnimateArray));
					setAnimateImg();
					try{
						Thread.sleep(nTime);
					}catch (InterruptedException e) {
      				return;
					}
				}
			}
		}
	}
}