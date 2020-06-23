package LCS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Webscrape 
{
	static String URL = "https://euw.leagueoflegends.com/de-de/champions/";
	public static void extractData() {
		
		Map<String, Map<String, Object>> champions = new HashMap<>(); 
		try
		{
			Document doc = Jsoup.connect(URL).get();
			for(Element c : doc.select("span.style__Text-sc-12h96bu-3.gPUACV")) {
				String champ = c.text();
				if(champ.equals("Aurelion Sol")) { champ = "aurelion-sol";}
				if(champ.equals("Nunu & Willump")) { champ = "nunu";}
				if(champ.equals("Cho'Gath")) { champ = "cho-gath";}
				if(champ.equals("Dr. Mundo")) { champ = "dr-mundo";}
				if(champ.equals("Jarvan IV.")) { champ = "jarvan-iv";}
				if(champ.equals("Kai'Sa")) { champ = "kai-sa";}
				if(champ.equals("Kha'Zix")) { champ = "kha-zix";}
				if(champ.equals("Kog'Maw")) { champ = "kog-maw";}
				if(champ.equals("Lee Sin")) { champ = "lee-sin";}
				if(champ.equals("Master Yi")) { champ = "master-yi";}
				if(champ.equals("Miss Fortune")) { champ = "miss-fortune";}
				if(champ.equals("Rek'Sai")) { champ = "rek-sai";}
				if(champ.equals("Tahm Kench")) { champ = "tahm-kench";}
				if(champ.equals("Twisted Fate")) { champ = "twisted-fate";}
				if(champ.equals("Vel'Koz")) { champ = "vel-koz";}
				if(champ.equals("Xin Zhao")) { champ = "xin-zhao";}
				champ = champ.toLowerCase();
				champions.put(champ, new HashMap<String, Object>());
				extractCategoryAndDifficulty(champions,champ);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(champions);
		Databank.eintragen(champions);
	}

	private static void extractCategoryAndDifficulty(Map<String, Map<String, Object>> champions, String champ) {

		String Category = "";
		try {
			Category = Jsoup.connect(URL+champ).get().select("li.hwEUco.style__SpecsItem-sc-1o884zt-12 > .ieHviE.style__SpecsItemValue-sc-1o884zt-15").text();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		champions.get(champ).put("Category", Category);
		String Difficulty = "";
		try {
			Difficulty = Jsoup.connect(URL+champ).get().select("li.TZXkX.style__SpecsItem-sc-1o884zt-12 > .ieHviE.style__SpecsItemValue-sc-1o884zt-15").text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		champions.get(champ).put("Difficulty", Difficulty);
		System.out.println(champ+": Check!");
	}
}
