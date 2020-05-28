package LCS;
import java.sql.*;
import java.util.Map;

public class Databank {
	public static void eintragen(Map<String, Map<String, Object>> champions) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lolchampstatistics","root","");
			Statement stmt = myConn.createStatement();
			/*for(int i=1;i<=champions.size();i++) {
				stmt.executeUpdate("Insert into champions(Champion_ID) values("+i+")");
			}*/
			for(String champion : champions.keySet()) {
				stmt.executeUpdate("Insert into champions(Champion_Name) values('"+champion+"')");
				stmt.executeUpdate("Insert into champions(Champion_Category) values('"+((Map)champions.get(champion)).get("Category")+"')");
				stmt.executeUpdate("Insert into champions(Champion_Name) values('"+((Map)champions.get(champion)).get("Difficulty")+"')");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


