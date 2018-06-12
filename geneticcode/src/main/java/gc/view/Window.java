package gc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import gc.data.Data;

public class Window extends JFrame {

	private static final long serialVersionUID = 1895235010882627572L;

	/**
	 * Create the frame.
	 */
	public Window() {
		this.setupWindow();
	}

	private void setupWindow() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280, 624));
		this.setPreferredSize(new Dimension(1280, 624));

		this.add(this.createPanelInstance(), BorderLayout.CENTER);
		this.add(new Menu(), BorderLayout.PAGE_END);
	}

	public void updateGraph(Data data) {
		ChartPanel graph = new LineChart(data).buildXYLineGraph();
		panel.removeAll();
		panel.add(graph);
		panel.updateUI();
	}

	private static JPanel panel;

	private JPanel createPanelInstance() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(1280, 524));
			panel.setLayout(new BorderLayout());
		}
		return panel;
	}

}
