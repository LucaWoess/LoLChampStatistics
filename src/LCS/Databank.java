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
			int i=0;
			for(String champion : champions.keySet()) {
				i++;
				stmt.executeUpdate("Insert into champions(Champion_ID,Champion_Name,Champion_Category,Champion_Difficulty) values('"+i+"','"+champion+"','"+((Map)champions.get(champion)).get("Category")+"','"+((Map)champions.get(champion)).get("Difficulty")+"')");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


