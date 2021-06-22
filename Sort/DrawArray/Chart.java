
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
		JFreeChart chart = ChartFactory.createBarChart3D("陣列", // 圖表標題
				"陣列索引", // 目錄軸的顯示標籤
				"值", // 數值軸的顯示標籤
				dataset, // 資料集
				PlotOrientation.VERTICAL, // 圖表方向：水平、垂直
				true, // 是否顯示圖例(對於簡單的柱狀圖必須是false)
				false, // 是否生成工具
				false // 是否生成URL連結
				);
		// 從這裡開始
		CategoryPlot plot = chart.getCategoryPlot();// 獲取圖表區域物件
		BarRenderer3D renderer = new BarRenderer3D(); //對圖的3D修改
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑體", Font.BOLD, 14)); // 水平底部標題
		domainAxis.setTickLabelFont(new Font("宋體", Font.BOLD, 12)); // 垂直標題
		ValueAxis rangeAxis = plot.getRangeAxis();// 獲取柱狀
		rangeAxis.setLabelFont(new Font("黑體", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑體", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋體", Font.BOLD, 20));// 設定標題字型
		// 到這裡結束，雖然程式碼有點多，但只為一個目的，解決漢字亂碼問題

		frame1 = new ChartPanel(chart, true); // 這裡也可以用chartFrame,可以直接生成一個獨立的Frame

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
			else rowKeys = String.format("%d",9);  //每十個就換一個顏色
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