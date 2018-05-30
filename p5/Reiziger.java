package p5;

import java.util.*;

public class Reiziger {
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	private List<OV_Chipkaart> mijnChipkaarten = new ArrayList<OV_Chipkaart>();

	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum,
			ArrayList<OV_Chipkaart> mijnChipkaarten) {
		super();
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		this.mijnChipkaarten = mijnChipkaarten;
	}

	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
		super();
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
	}
	
	public Reiziger( String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
		super();
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
	}

	public List<OV_Chipkaart> getMijnChipkaarten() {
		return mijnChipkaarten;
	}

	public void setMijnChipkaarten(List<OV_Chipkaart> mijnChipkaarten) {
		this.mijnChipkaarten = mijnChipkaarten;
	}

	@Override
	public String toString() {
		return "Reiziger [naam=" + achternaam + ", gbdatum=" + gbdatum + "]";
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}


	
	
}
