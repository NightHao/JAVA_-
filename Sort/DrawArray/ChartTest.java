import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.List;
import java.applet.*;
import java.awt.*;
import javax.swing.JFrame;
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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ChartTest {
    public static void main(String[] args) {
		JFrame frame = new JFrame("Java資料統計圖");
        int [] tmp = new int[100];
            for(int i=0;i<100;++i){
                tmp[i]=100 - i;
        }
        newArray tmp2 = new newArray(tmp, 0, 100);
        Chart chart = new Chart(tmp2);
		frame.add(chart.getChartPanel()); // 新增柱形圖
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 1000, 800);
		frame.setVisible(true);
	}
}
