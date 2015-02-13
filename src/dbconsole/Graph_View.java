package dbconsole;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_View extends Frame implements ActionListener,WindowListener{

	public Graph_View(){
		addWindowListener(this);
		setTitle("Graph");
		
		int[] schoolname = new int[21];
		int[] people = new int[21];
		int[] year = new int[21];
		int i=1;
		ResultSet rs;
		
		MySQL mysql = new MySQL();
		
		rs = mysql.selectAll();
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		try{
			while(rs.next()){
			schoolname[i] = rs.getInt("schoolname");
			people[i] = rs.getInt("people");
			year[i] = rs.getInt("year");
			System.out.println("大学:"+schoolname[i]);
			System.out.println("志望者数:"+people[i]);
			System.out.println("年度:"+year[i]);
			i+=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			for(int j = 1;j<=20;j++){
			String s = String.valueOf(year[j]);
			String t = String.valueOf(schoolname[j]);
				data.addValue(people[j],t,s);   	
			}
			
			JFreeChart chart = 
		      ChartFactory.createLineChart("University Ranking",
		                                   "Year",
		                                   "A number of people",
		                              data,
		                              PlotOrientation.VERTICAL,
		                              true,
		                              false,
		                              false);

		    ChartPanel cpanel = new ChartPanel(chart);
		    add(cpanel, BorderLayout.CENTER);
		    setLayout(new FlowLayout(FlowLayout.CENTER));
		    add(new Label("University Name 1:Meiji 2:Waseda 3:Kinki 4:Nihon 5:Housei"));
		  }
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
