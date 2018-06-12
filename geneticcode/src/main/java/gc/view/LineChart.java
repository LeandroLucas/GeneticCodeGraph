package gc.view;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import gc.Main;
import gc.data.Data;
import gc.genetic.Chromosome;

public class LineChart {

	private Data data;

	public LineChart(Data data) {
		this.data = data;
	}

	public LineChart() {}

	public LineChart withData(Data data) {
		return this;
	}

	private XYSeriesCollection generateXYDataset() {
		XYSeries series = new XYSeries("Generation " + this.data.getGeneration());
		for (int i = 0; i < this.data.getChromosomes().size(); i++) {
			Chromosome c = this.data.getChromosomes().get(i);
			series.add(c.getX(), c.getFitness());
		}

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(createFunctionXYSeries()); //função
        dataset.addSeries(series); //chromosomes
        return dataset;
	}

	public ChartPanel buildXYLineGraph() {
        XYSeriesCollection dataset = this.generateXYDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Genetic Code\n"
                + "Interval: " + Main.interval + "s",
                "x-axis",
                "y-axis",
                dataset, 
                PlotOrientation.VERTICAL,
                true,
                false,
                false
                );
        XYSplineRenderer renderer = new XYSplineRenderer(20);
        //Configurando a linha da função
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesItemLabelsVisible(0, false);
        //configurando a linha dos cromossomos
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesPaint(1, Color.WHITE);
		renderer.setSeriesItemLabelsVisible(1, true);
		renderer.setSeriesItemLabelPaint(1, Color.BLUE);
		renderer.setDefaultItemLabelGenerator(new XYItemLabelGenerator() {
			@Override
			public String generateLabel(XYDataset arg0, int arg1, int arg2) {
				return String.format("[%.5f]", arg2, arg0.getYValue(arg1, arg2));
			}
		});
        chart.getXYPlot().setRenderer(renderer);
        return new ChartPanel(chart);
    }
	
	private static XYSeries createFunctionXYSeries() {
	    return DatasetUtils.sampleFunction2DToSeries(new X2(), 0, 10, 20, "f(x)= cos(x + 2) cos(0.1 x)");
//	    return DatasetUtils.sampleFunction2DToSeries(new X2(), 0, 10, 30, "f(x)= sin(x) sin(0.4 x)  sin(3 x)");
	}
	
	static class X2 implements Function2D {

	    public double getValue(double x) {
	        return (float) (Math.cos(x + 2) * Math.cos(0.1f * x));
//	        return (float)(Math.sin(x) * Math.sin(0.4f * x) * Math.sin(3.0f * x));
	    }

	}

}
