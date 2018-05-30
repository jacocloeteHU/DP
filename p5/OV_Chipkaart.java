package p5;

import java.util.*;


public class OV_Chipkaart {

	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	private List<Product> mijnProducten = new ArrayList<Product>();

	public OV_Chipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo, int reizigerID) {
		super();
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerID = reizigerID;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	

	public List<Product> getMijnProducten() {
		return mijnProducten;
	}

	public void setMijnProducten(List<Product> mijnProducten) {
		this.mijnProducten = mijnProducten;
	}

	@Override
	public String toString() {
		return "OV_Chipkaart [kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse
				+ ", saldo=" + saldo + ", reizigerID=" + reizigerID + ", mijnProducten=" + mijnProducten + "]";
	}

}
