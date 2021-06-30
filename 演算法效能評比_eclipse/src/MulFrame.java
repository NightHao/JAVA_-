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
	private Judge JJ = new Judge();//������ݭn�P�_�����p�кɶq�ϥΥL
	private final JComboBox<String> imagesJComboBox,imagesJComboBox2; // hold icon names
	private static final String[] names = {"Naive","Sparse","Strassen"};
	private static final String[] names2 = {"RandomMatrix","ExampleMatrix"/*"ReadMatrix",*/,"InputMatrix"};
	private Boolean usingName = false,usingName2 = false;
	private String T1,T2;// ����combobox�����A
	private JButton increaseButton,decreaseButton,generateMatrix,RunButton; // button to decrease font size
	private JTextArea inputText,outputText; // displays example text
	private int fontSize = 20; // current font size
	private new2DArray Array,Array2;
	private ImageIcon gogofuck,gogojpg,errorfuck;//�令�������n���ƥ���
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
		imagesJComboBox2.setMaximumRowCount(3); // display three rows
		ItemListener handler1 = new EventListner();
		ItemListener handler2 = new EventListner();
		imagesJComboBox.addItemListener(handler1);
		imagesJComboBox2.addItemListener(handler2); 
		imagesJComboBox.setSelectedIndex(1); // ���ܿﶵ�ɤ~����,�B�@�}�l��0
		imagesJComboBox2.setSelectedIndex(1);// ������w�]�ȥ�����]�@��
		EventListner handler = new EventListner();
		// create buttons and add action listeners
		generateMatrix = new JButton("Generate Matrix");
		gogofuck = new ImageIcon(getClass().getClassLoader().getResource("fuck.png"));
		errorfuck = new ImageIcon(getClass().getClassLoader().getResource("fuck.png"));
		gogojpg = new ImageIcon(getClass().getClassLoader().getResource("GoGo.jpg"));
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
				outputText.setText("2�x�}��C�L�k�ۭ�");
				RunButton.setIcon(gogofuck);
			}
			else if(T1=="Strassen"&&JJ.strassenCanRun(Array.get2DArray(),Array2.get2DArray())==false){
				outputText.setText("Strassen�t��k�ݬ���}�A�B���׭n�O2������!");
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
				generateMatrix.setText("Generate Matrix");
				//�Ѧ�generateRandomArrayTest
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
				generateMatrix.setText("Generate Matrix");
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
			else if(T2=="InputMatrix"){
				if (generateMatrix.getText() == "NEW Generate A Matrix") {
					String words = inputText.getText();
					if(words.charAt(words.length()-1)!='\n')words+='\n';//�̫�ɴ���
					if(JJ.stringIsMatrix(words)){
						Array = new new2DArray(words);
						inputText.setText("");
						generateMatrix.setText("NEW Generate B Matrix");
					}
					else{
						inputText.setText("Input string is not a legal matrix! Please try again.");
					}
					//System.out.println(words);
				}
				else if(generateMatrix.getText() == "NEW Generate B Matrix"){
					String words = inputText.getText();
					if(words.charAt(words.length()-1)!='\n')words+='\n';//�̫�ɴ���
					if(JJ.stringIsMatrix(words)){
						Array2 = new new2DArray(words);
						inputText.setText("");
						generateMatrix.setText("Generate Matrix");
						String stText="";
						stText += "Matrix A:\n" + Array.toString() + "\nMatrix B:\n" + Array2.toString();
						inputText.setText(stText);
						inputText.setEditable(false);
					}
					else{
						inputText.setText("Input string is not a legal matrix! Please try again.");
					}
				}
				else if (generateMatrix.getText() == "Generate Matrix") {
					generateMatrix.setText("NEW Generate A Matrix");
					inputText.setText("");
					inputText.setEditable(true);
				}
			}
		}
		public void actionPerformed(ActionEvent e){//��Button�Q�����
			if(e.getSource()==generateMatrix){//���Ͱ}�C
				judgeInput();
			}
			if(e.getSource()==RunButton){//Mul
				judgeMulType();
			}
			//�H�U�Ѧҧ@�~
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

		@Override//����combobox
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
						JOptionPane.showMessageDialog(null,Gogo.doc(),"�t��k����",JOptionPane.INFORMATION_MESSAGE);
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
						if(T2=="RandomMatrix"){//doc ���Ч令�^��String
							JOptionPane.showMessageDialog(null,generate2DRandomArray.doc(),"��J����",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="ExampleMatrix"){
							JOptionPane.showMessageDialog(null,generate2DExampleArray.doc(),"��J����",JOptionPane.INFORMATION_MESSAGE);
						}
						/*else if(T2=="ReadArray"){
							JOptionPane.showMessageDialog(null,ReadArray.doc(),"��J����",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(T2=="InputArray"){
							JOptionPane.showMessageDialog(null,"�Х��I���@��'Generate Array'���s��A��input�ϰ��J�榡���T���}�C(��ơB�Ʀr�������Ů�B�i�H���t�ơB���i����)\n�̫�A�I��'NEW Generate Array'�Y�i��J�}�C","��J����",JOptionPane.INFORMATION_MESSAGE);
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