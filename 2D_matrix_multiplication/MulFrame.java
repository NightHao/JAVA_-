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
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MulFrame extends JFrame {
	private Judge JJ = new Judge();//當有任何需要判斷的情況請盡量使用他
	private final JComboBox<String> imagesJComboBox,imagesJComboBox2; // hold icon names
	private static final String[] names = {"Naive","Sparse","Strassen"};
	private static final String[] names2 = {"RandomMatrix","ExampleMatrix"/*"ReadMatrix",*//*"InputMatrix"*/};
	private Boolean usingName = false,usingName2 = false;
	private String T1,T2;// 捕捉combobox的狀態
	private JButton increaseButton,decreaseButton,generateMatrix,RunButton; // button to decrease font size
	private JTextArea inputText,outputText; // displays example text
	private int fontSize = 20; // current font size
	private new2DArray Array,Array2;
	private ImageIcon gogofuck,gogojpg,errorfuck;//改成全域比較好應事件更改
	private JTextField changeIt = new JTextField("0");
	private JPanel bottomJPanel3, bottomJPanel4, sJPanel;

	public MulFrame() {
		super("Mul Frame Test");
		sJPanel= new JPanel();
		sJPanel.setLayout(new GridLayout(2,1));
		setLayout(new BorderLayout());
		imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
		imagesJComboBox2 = new JComboBox<String>(names2); // set up JComboBox
      	imagesJComboBox.setMaximumRowCount(3); // display three rows
		imagesJComboBox2.setMaximumRowCount(2); // display three rows
		ItemListener handler1 = new EventListner();
		ItemListener handler2 = new EventListner();
		imagesJComboBox.addItemListener(handler1); 
		imagesJComboBox2.addItemListener(handler2); 
		imagesJComboBox.setSelectedIndex(1); // 改變選項時才偵測,且一開始為0
		imagesJComboBox2.setSelectedIndex(1);// 直接改預設值先讓其跑一次
		EventListner handler = new EventListner();
		// create buttons and add action listeners
		generateMatrix = new JButton("Generate Matrix");
		gogofuck = new ImageIcon("fuck.png");
		errorfuck = new ImageIcon("fuck.png");
		gogojpg = new ImageIcon("GoGo.jpg");
		RunButton = new JButton(gogojpg);
		decreaseButton = new JButton("Decrease font size");
		increaseButton = new JButton("Increase font size");
		generateMatrix.addActionListener(handler);
		RunButton.addActionListener(handler);
		decreaseButton.addActionListener(handler);
		increaseButton.addActionListener(handler);
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
		bottomJPanel3 = new JPanel();
		bottomJPanel4 = new JPanel();
		outpanel.setLayout(new BorderLayout());
		inpanel.add(new JScrollPane(inputText));
		outpanel.add(new JScrollPane(outputText));
		bottomJPanel3.add(changeIt);
		panel.add(generateMatrix);
		panel.add(RunButton);
		panel.add(increaseButton);
		panel.add(decreaseButton);
		panel.add(imagesJComboBox); // add combobox to JFrame
		panel.add(imagesJComboBox2); // add combobox to JFrame
		setLayout(new BorderLayout());
		add(panel,BorderLayout.NORTH); // add buttons at top
		sJPanel.add(inpanel); // allow scrolling
		sJPanel.add(outpanel); // allow scrolling
		add(sJPanel);
	}

	private class EventListner implements ActionListener,ItemListener{
		public void judgeMulType(){
			System.out.println("You choose "+T1);
			if(Array==null||Array2==null){
				outputText.setText("Please generate 2 matrix first!");
				RunButton.setIcon(gogofuck);
			}
			else if(Array.getColSize()!=Array2.getRowSize()){
				outputText.setText("2矩陣行列無法相乘");
				RunButton.setIcon(gogofuck);
			}
			else if(T1=="Strassen"&&JJ.strassenCanRun(Array.get2DArray(),Array2.get2DArray())==false){
				outputText.setText("Strassen演算法需為方陣，且長度要是2的冪次!");
			}
			else{
				RunButton.setIcon(gogojpg);
				Mul Gogo;
				if(T1=="Naive"){
					Gogo = new NaiveMul();
				}
				else if(T1=="Sparse"){
					Gogo = new SparseMul();
				}
				else/*if(T1=="Strassen")*/{
					Gogo = new StrassenMul();
				}
				Gogo.MulMain(Array.get2DArray(),Array2.get2DArray());
				outputText.setText(Gogo.getOutput());
			}
		}
		public void judgeInput(){
			System.out.println("You choose "+T2);
			//"RandomMatrix","ExampleMatrix","ReadMatrix","InputMatrix"
			if(T2=="RandomMatrix"){
				//參考generateRandomArrayTest
				//int RowSize, int ColSize, int LowerRange, int UpperRange
				String sr=JOptionPane.showInputDialog("Input the row size of your matrix A");
				String sc=JOptionPane.showInputDialog("Input the col size of your matrix A");
				String slr=JOptionPane.showInputDialog("Input the lower bound of your matrix A");
				String sur=JOptionPane.showInputDialog("Input the upper bound of your matrix A");
				String sr2=JOptionPane.showInputDialog("Input the row size of your matrix B");
				String sc2=JOptionPane.showInputDialog("Input the col size of your matrix B");
				String slr2=JOptionPane.showInputDialog("Input the lower bound of your matrix B");
				String sur2=JOptionPane.showInputDialog("Input the upper bound of your matrix B");
				int rn=Integer.parseInt(sr);
				int cn=Integer.parseInt(sc);
				int lr=Integer.parseInt(slr);
				int ur=Integer.parseInt(sur);
				int rn2=Integer.parseInt(sr2);
				int cn2=Integer.parseInt(sc2);
				int lr2=Integer.parseInt(slr2);
				int ur2=Integer.parseInt(sur2);
				generate2DRandomArray tmp = new  generate2DRandomArray(rn,cn,lr,ur);
				generate2DRandomArray tmp2 = new  generate2DRandomArray(rn2,cn2,lr2,ur2);
				Array = new new2DArray(tmp.getArray(),lr,ur);
				Array2 = new new2DArray(tmp2.getArray(),lr2,ur2);
				String stText="";
				stText += "Matrix A:\n" + Array.toString() + "\nMatrix B:\n" + Array2.toString();
				inputText.setText(stText);
			}
			else if(T2=="ExampleMatrix"){
				//int[][] Example2DArray = {{1,50,66,-11,5}, {5,6,11,20,8}};
				int[][] Ex2 = {{5,6},{-3,8},{9,4},{6,3},{1,0}};
				generate2DExampleArray tmp = new generate2DExampleArray();
				Array = new new2DArray(tmp.getArray());
				Array2 = new new2DArray(Ex2);
				String stText="";
				stText += "Matrix A:\n" + Array.toString() + "\nMatrix B:\n" + Array2.toString();
				inputText.setText(stText);
			}
			/*else if(T2=="ReadMatrix"){
				findFile fd = new findFile();
				System.out.println(fd.getName());
				ReadArray tmp = new ReadArray(fd.getName()); 
				Array = new newArray(tmp.run());
				inputText.setText(Array.toString());
			}*/
			/*else if(T2=="InputMatrix"){
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
			}*/
		}
		public void actionPerformed(ActionEvent e){//當Button被按到時
			if(e.getSource()==generateMatrix){//產生陣列
				judgeInput();
			}
			if(e.getSource()==RunButton){//Mul
				judgeMulType();
			}
			//以下參考作業
			if(e.getSource()==increaseButton){
				if(fontSize>=160){
					JOptionPane.showMessageDialog(MulFrame.this,"No, it cannot be larger!");
				}
				else{
					fontSize+=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==decreaseButton){
				if(fontSize<=8){
					JOptionPane.showMessageDialog(MulFrame.this,"No, it cannot be smaller!");
				}
				else{
					fontSize-=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
		}

		@Override//捕捉combobox
		public void itemStateChanged(ItemEvent e){
			// determine whether item selected
			if(e.getSource()==imagesJComboBox){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println(e.getItem());
					T1 = (String) e.getItem();
					Mul Gogo;
					if(T1=="Naive"){
						Gogo = new NaiveMul();
					}
					else if(T1=="Sparse"){
						Gogo = new SparseMul();
					}
					else/*if(T1=="Strassen")*/{
						Gogo = new StrassenMul();
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
						if(T2=="RandomMatrix"){//doc 文件請改成回傳String
							JOptionPane.showMessageDialog(null,generate2DRandomArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="ExampleMatrix"){
							JOptionPane.showMessageDialog(null,generate2DExampleArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						/*else if(T2=="ReadArray"){
							JOptionPane.showMessageDialog(null,ReadArray.doc(),"輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="InputArray"){
							JOptionPane.showMessageDialog(null,"請先點擊一次'Generate Array'按鈕後，於input區域輸入格式正確的陣列(整數、數字間須有空格、可以有負數、不可換行)\n最後再點選'NEW Generate Array'即可輸入陣列","輸入說明",JOptionPane.INFORMATION_MESSAGE);
						}*/
					}
					else{
						usingName2=true;
					}
				}
			}
			
		}
	}
}