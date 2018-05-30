package p5;

import java.sql.SQLException;
//import java.awt.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import java.util.Date;

public class ServiceMain {
	
	public static void main(String[] args) throws ParseException, SQLException {
//		ArrayList<Reiziger> localReizigers= new ArrayList<Reiziger>();
		
		
//		ReizigerOracleDaolmpl k = new ReizigerOracleDaolmpl();
//		k.getConnection();
		
		
//		Aanmaken van variabelen voor producten en gelijk vullen met FINDALL()
		List<Product> localProducten = new ArrayList<Product>();
		ProductDao interface3 = new ProductOracleDaolmpl();
		localProducten = interface3.findAll();
		
//		Aanmaken van variabelen voor ovchipkaarten en gelijk vullen met FINDALL()
		List<OV_Chipkaart> localChipkaarten = new ArrayList<OV_Chipkaart>();
		OV_ChipkaartDao interface2 = new OV_ChipkaartOracleDaolmpl();
		localChipkaarten = interface2.findAll(); // lokaal vullen van chipkaarten
		
//		controlleren of er data in zit in de variable 
		System.out.println(interface3.findAll());
		
//		Een nummer ophalen van een product
		System.out.println(localProducten.get(0).getProductNummer());
//		Een chipkaarten toevoegen aan de product
		localProducten.get(0).setMijnChipkaarten(interface2.findOVByProductPrimaryKey(localProducten.get(0).getProductNummer()));
//		controleren of het ering staat
		System.out.println(localProducten.get(0).getMijnChipkaarten());

		
//		controlleren of er data in zit in de variable 
		System.out.println(localChipkaarten);
		
//		Een nummer ophalen van een product
		System.out.println(localChipkaarten.get(0).getKaartNummer());
//		Een chipkaarten toevoegen aan de product
		localChipkaarten.get(1).setMijnProducten(interface3.findProductByOVPrimaryKey(localChipkaarten.get(1).getKaartNummer()));
//		controleren of het ering staat	
		System.out.println("test ::::::::::::::::::::::::::::::::::::::::::::" + localChipkaarten.get(1).getKaartNummer());
		System.out.println("test ::::::::::::::::::::::::::::::::::::::::::::" + localChipkaarten.get(1).getMijnProducten());
		
//		Het zelfde maar dan in een forloop
		localProducten = interface3.findAll();
		for(Product p :  localProducten) {
			p.setMijnChipkaarten(interface2.findOVByProductPrimaryKey(p.getProductNummer()));
			System.out.println(p.getMijnChipkaarten());
		}
//		Check of er niks mis is gegaan
		System.out.println("ALL test" + localProducten);
		
//		Het zelfde maar dan in een forloop	
		localChipkaarten = interface2.findAll();
		for(OV_Chipkaart ov :  localChipkaarten) {
			ov.setMijnProducten(interface3.findProductByOVPrimaryKey(ov.getKaartNummer()));
			System.out.println(ov.getMijnProducten());
		}
//		Check of er niks mis is gegaan
		System.out.println("ALL test" + localChipkaarten);
		
		
//		List<String> kaartnums = interface3.findOVchipkaarByPrimaryKey(localProducten.get(0).getProductNummer());
		
		
//		System.out.println(kaartnums);
//		List<OV_Chipkaart> tempChips = new ArrayList<OV_Chipkaart>();
//		for (String nmr : kaartnums) {
//			System.out.println(nmr);
//			tempChips.add(localChipkaarten.equals(nmr));
//		}
//		
//		
		
		
		
		
		
		
		List<Reiziger> localReizigers = new ArrayList<Reiziger>(); // ik zet de lijst even in een locale lijst zodat ik hem makkelijker kan benaderen.
//		
//		List<OV_Chipkaart> localChipkaarten = new ArrayList<OV_Chipkaart>();
////		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // Hiermee kan ik de data strings formatten naaar DATE values
////		
		ReizigerDao interface1 = new ReizigerOracleDaolmpl();  // interface constructen 
////		
//		OV_ChipkaartDao interface2 = new OV_ChipkaartOracleDaolmpl();
//		localChipkaarten = interface2.findAll(); // lokaal vullen van chipkaarten
//		System.out.println(interface2.findAll()); // checks
//		System.out.println(interface2.findByReiziger(2)); // chipkaarten ophalen van reiziger
//		System.out.println(interface2.findByPrimaryKey(18326)); // chipkaart ophalen met primary key
//		java.sql.Date aDate = java.sql.Date.valueOf("2003-03-18"); 
//		interface2.save(new OV_Chipkaart(33333 ,aDate ,1 ,18.3 ,4)); // een ov chipkaart aanmaken met een reiziger id 4
//		System.out.println(interface2.findByReiziger(4));  // chipkaart ophalen opbasis van reizigersID
//		System.out.println(interface2.findByPrimaryKey(33333)); // chipkaart ophalen opbasis van primarykey
//
////		interface2.save(new OV_Chipkaart(1234 ,aDate ,1 ,18.3 ,4));
//		
//		for (OV_Chipkaart o : interface2.findAll()) { // loopje over alle chipkaarten
//			System.out.println("ov in loop: " + o); // kijken wat er voorbij komt
//			if(o.getKaartNummer() == 33333) { // Als de chipkaart de kaartnummer 33333
//				// Verandert naam naar Karel 
//				o.setSaldo(50.96); // een saldo toe kennen aan chipkaart lokaal
//				o.setReizigerID(5); // een nieuwe reiziger toekennnen aan chipkaart lokaal
//				//                    maar dit had eingelijks de sql code moeten uitvoeren en dan de wijzigingen doorvoeren
//				interface2.update(o ); // chipkaart updaten in de database
//			}
//			
//			System.out.println("Ov in einde loop: " + o);  // Checken wat er verandert is aan de chipkaart
//		}
		
		for (Reiziger r : interface1.findAll()) { // Een loopje door alle chipkaart uit de database
			r.setMijnChipkaarten(interface2.findByReiziger(r.getReizigerID())); // chipkaarten koppelen aan reiziger
			System.out.println("check:" + r.getMijnChipkaarten());
		}
//		
//	
//		
//		System.out.println(interface2.findByReiziger(4)); //  chip ophalen checken
//		System.out.println("check" + interface2.findByPrimaryKey(33333));  //  chip ophalen checken
//		
//		interface2.delete(interface2.findByPrimaryKey(33333));//  chip verwijderen 
//		System.out.println(interface2.findByReiziger(4)); //  chip ophalen checken of verwijdert is.
//		System.out.println("end");
//		
//		
//		
//		
//		
//		
//		
//		System.out.println(interface1.findAll()); // haalt alles op
//		localReizigers = interface1.findAll();// zet alles in een lokale reiziger.
//		String findDate = localReizigers.get(0).getGbdatum().toString(); // data vertaling naar van data naar string
//		System.out.println("Find by date " + interface1.findByGBdatum(findDate)); // Kijken welke er opgehaald wordt. hij kijkt uit de arraylist met reizigers of de datum nog in de database staat
//		
//
//		System.out.println(localReizigers); // Kijken welke data er in zit
//		java.sql.Date utilDate = java.sql.Date.valueOf("2003-09-17");
//		interface1.save(new Reiziger("James","","ERIKSEN", utilDate)); // Niewe Reiziger toevoegen aan de database
////		
//////		localReizigers = interface1.findAll();
//		System.out.println(localReizigers); // Checken of de nieuwe reiziger erbij staat 
////		
//		 // Checken of de nieuwe reiziger erbij staat op basis van datum
////
//		
//		for (Reiziger r : interface1.findAll()) { // Een loopje door alle reizigers uit de database
//			System.out.println("reiziger in loop: " + r); // laat zien welke reiziger er in de loop zit
//			if(r.getAchternaam().equals("ERIKSEN")) { // Als de reiziger de naam ericsen heet
//				r.setAchternaam("Karel");  // Verandert naam naar Karel 
//				interface1.update(r); // Nu update ik de reiziger met de database
//				//                    maar dit had eingelijks de sql code moeten uitvoeren en dan de wijzigingen doorvoeren
//			}
//			System.out.println("reiziger in einde loop: " + r);  // Checken wat er verandert is aan de reiziger
//		}
////		
//		System.out.println("id verwijderde reiziger:" + interface1.findByGBdatum("2003-09-17").getReizigerID()); // hier test ik wat er opgehaald wordt
//		interface1.delete(interface1.findByGBdatum("2003-09-17")); // ik verwijder de zojuist toegevoegde reiziger uit het lijstje
//		System.out.println(interface1.findAll()); // Controlle of die verwijdert is
	}
}
