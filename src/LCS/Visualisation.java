package LCS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Visualisation extends Application{
	
	public static void initialize(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	Map<String, Map<String, Object>> champions = new HashMap<>(); 
	
	int amountAssassineNiedrig = 0;
	int amountAssassineModerat = 0;
	int amountAssassineHoch = 0;
	int amountKämpferNiedrig = 0;
	int amountKämpferModerat = 0;
	int amountKämpferHoch = 0;
	int amountMagierNiedrig = 0;
	int amountMagierModerat = 0;
	int amountMagierHoch = 0;
	int amountSchützeNiedrig = 0;
	int amountSchützeModerat = 0;
	int amountSchützeHoch = 0;
	int amountSupporterNiedrig = 0;
	int amountSupporterModerat = 0;
	int amountSupporterHoch = 0;
	int amountTankNiedrig = 0;
	int amountTankModerat = 0;
	int amountTankHoch = 0;
	
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoLChampStatistics","root","");
			Statement stmt = myConn.createStatement();
			
			String query = "Select * from champions";
			
			ResultSet result = stmt.executeQuery(query);
			
			while(result.next()) {
				
				champions.put((result.getString("champions.Champion_Name")), new HashMap<String, Object>());
				champions.get(result.getString("champions.Champion_Name")).put("Category",(result.getString("champions.Champion_Category")));
				champions.get(result.getString("champions.Champion_Name")).put("Difficulty",(result.getString("champions.Champion_Difficulty")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		for(String champion : champions.keySet()) {
		if(((String)champions.get(champion).get("Category")).equals("Assassine") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountAssassineNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Assassine") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountAssassineModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Assassine") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountAssassineHoch++;}
		if(((String)champions.get(champion).get("Category")).equals("Kämpfer") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountKämpferNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Kämpfer") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountKämpferModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Kämpfer") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountKämpferHoch++;}
		if(((String)champions.get(champion).get("Category")).equals("Magier") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountMagierNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Magier") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountMagierModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Magier") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountMagierHoch++;}
		if(((String)champions.get(champion).get("Category")).equals("Schütze") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountSchützeNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Schütze") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountSchützeModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Schütze") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountSchützeHoch++;}
		if(((String)champions.get(champion).get("Category")).equals("Supporter") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountSupporterNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Supporter") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountSupporterModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Supporter") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountSupporterHoch++;}
		if(((String)champions.get(champion).get("Category")).equals("Tank") && ((String)champions.get(champion).get("Difficulty")).equals("Niedrig")){amountTankNiedrig++;}
		if(((String)champions.get(champion).get("Category")).equals("Tank") && ((String)champions.get(champion).get("Difficulty")).equals("Moderat")){amountTankModerat++;}
		if(((String)champions.get(champion).get("Category")).equals("Tank") && ((String)champions.get(champion).get("Difficulty")).equals("Hoch")){amountTankHoch++;}
		}
		
		CategoryAxis xAxis= new CategoryAxis();
		xAxis.setLabel("Categories");
		
		NumberAxis yAxis= new NumberAxis();
		yAxis.setLabel("Champions");
		
		BarChart<String, Number> barChart = new BarChart<String,Number>(xAxis,yAxis);

		XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
		dataSeries1.setName("Difficulty: Niedrig");
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Assassine", amountAssassineNiedrig));
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Kämpfer", amountKämpferNiedrig));
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Magier", amountMagierNiedrig));
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Schütze", amountSchützeNiedrig));
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Supporter", amountSupporterNiedrig));
	    dataSeries1.getData().add(new XYChart.Data<String, Number>("Tank", amountTankNiedrig));
	    
	    XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
		dataSeries2.setName("Difficulty: Moderat");
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Assassine", amountAssassineModerat));
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Kämpfer", amountKämpferModerat));
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Magier", amountMagierModerat));
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Schütze", amountSchützeModerat));
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Supporter", amountSupporterModerat));
	    dataSeries2.getData().add(new XYChart.Data<String, Number>("Tank", amountTankModerat));
	    
	    XYChart.Series<String, Number> dataSeries3 = new XYChart.Series<String, Number>();
		dataSeries3.setName("Difficulty: Hoch");
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Assassine", amountAssassineHoch));
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Kämpfer", amountKämpferHoch));
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Magier", amountMagierHoch));
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Schütze", amountSchützeHoch));
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Supporter", amountSupporterHoch));
	    dataSeries3.getData().add(new XYChart.Data<String, Number>("Tank", amountTankHoch));
	
	    barChart.getData().add(dataSeries1);
	    barChart.getData().add(dataSeries2);
	    barChart.getData().add(dataSeries3);
	    
		VBox vbox = new VBox(barChart);
	    
		primaryStage.setTitle("LoL-Champion-Statistics");
		Scene scene = new Scene(vbox, 400, 200);
		
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(1000);
        
        primaryStage.show();
	}
}
