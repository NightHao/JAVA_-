
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Chart {
	ChartPanel frame1;
    private static int[] Array;
    private static int arraySize,lowerBound,upperBound,dif;
    
	public Chart(newArray arr) {
        Chart.Array = arr.getArray();
        Chart.arraySize = arr.getArraySize();
        Chart.lowerBound = arr.getLowerRange();
        Chart.upperBound = arr.getUpperRange();
        dif = upperBound-lowerBound;  
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D("�}�C", // �Ϫ���D
				"�}�C����", // �ؿ��b����ܼ���
				"��", // �ƭȶb����ܼ���
				dataset, // ��ƶ�
				PlotOrientation.VERTICAL, // �Ϫ��V�G�����B����
				true, // �O�_��ܹϨ�(���²�檺�W���ϥ����Ofalse)
				false, // �O�_�ͦ��u��
				false // �O�_�ͦ�URL�s��
				);
		// �q�o�̶}�l
		CategoryPlot plot = chart.getCategoryPlot();// ����Ϫ�ϰ쪫��
		BarRenderer3D renderer = new BarRenderer3D(); //��Ϫ�3D�ק�
		CategoryAxis domainAxis = plot.getDomainAxis(); // ���������C��
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14)); // �����������D
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // �������D
		ValueAxis rangeAxis = plot.getRangeAxis();// ����W��
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// �]�w���D�r��
		// ��o�̵����A���M�{���X���I�h�A���u���@�ӥت��A�ѨM�~�r�ýX���D

		frame1 = new ChartPanel(chart, true); // �o�̤]�i�H��chartFrame,�i�H�����ͦ��@�ӿW�ߪ�Frame

	}

    private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		double value =0;
		String rowKeys=null;
		String columnKeys=null;
		for (int i = 0; i < arraySize; ++i) {
			value = Array[i];
			if(i%10== 0)rowKeys = String.format("%d",0);
			else if(i%10 == 1)rowKeys = String.format("%d",1);
			else if(i%10 == 2)rowKeys = String.format("%d",2);
			else if(i%10 == 3)rowKeys = String.format("%d",3);
			else if(i%10 == 4)rowKeys = String.format("%d",4);
			else if(i%10 == 5)rowKeys = String.format("%d",5);
			else if(i%10 == 6)rowKeys = String.format("%d",6);
			else if(i%10 == 7)rowKeys = String.format("%d",7);
			else if(i%10 == 8)rowKeys = String.format("%d",8);
			else rowKeys = String.format("%d",9);  //�C�Q�ӴN���@���C��
			columnKeys =  String.format("%d",i);
			dataset.addValue(value, rowKeys, columnKeys);
			System.out.println(value+"  "+rowKeys+"  "+columnKeys);
		}
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;
	}
}