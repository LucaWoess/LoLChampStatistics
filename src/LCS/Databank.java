package LCS;
import java.sql.*;
import java.util.Map;

public class Databank {
	public static void eintragen(Map<String, Map<String, Object>> champions) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			Statement stmt = myConn.createStatement();
			int i=0;
			stmt.executeUpdate("Drop Database if exists LoLChampStatistics;");
			stmt.executeUpdate("Create Database LoLChampStatistics;");
			stmt.executeUpdate("Use LolChampStatistics;");
			stmt.executeUpdate("Create table champions(Champion_ID int(10), Champion_Name varchar(255), Champion_Category varchar(255), Champion_Difficulty varchar(255), primary key (Champion_ID));");
			for(String champion : champions.keySet()) {
				i++;
				stmt.executeUpdate("Insert into champions(Champion_ID,Champion_Name,Champion_Category,Champion_Difficulty) values('"+i+"','"+champion+"','"+((Map)champions.get(champion)).get("Category")+"','"+((Map)champions.get(champion)).get("Difficulty")+"')");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*public void getData() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lolchampstatistics","root","");
			Statement stmt = myConn.createStatement();
			stmt.executeUpdate("Select");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}


