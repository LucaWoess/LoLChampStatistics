package LCS;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Visualisation extends Application{
	
	public static void initialize(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		Scene scene = new Scene(root, 1000, 700);
		CategoryAxis xAxis= new CategoryAxis();
		NumberAxis yAxis= new NumberAxis();
		xAxis.setLabel("Categories");
		yAxis.setLabel("Champions");
		BarChart<String, Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
		XYChart.Series series = new XYChart.Series();
		//series.getData().add(new XYChart.Data(, ));
        //series.getData().add(new XYChart.Data(, ));
		primaryStage.setTitle("LoL-Champion-Statistics");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
