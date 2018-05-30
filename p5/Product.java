package p5;

import java.util.ArrayList;
import java.util.List;

import p5.OV_Chipkaart;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private List<OV_Chipkaart> mijnChipkaarten = new ArrayList<OV_Chipkaart>();
	
	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		super();
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public List<OV_Chipkaart> getMijnChipkaarten() {
		return mijnChipkaarten;
	}

	public void setMijnChipkaarten(List<OV_Chipkaart> mijnChipkaarten) {
		this.mijnChipkaarten = mijnChipkaarten;
	}

	@Override
	public String toString() {
		return "Product [productNummer=" + productNummer + ", productNaam=" + productNaam + ", beschrijving="
				+ beschrijving + ", prijs=" + prijs + ", mijnChipkaarten=" + mijnChipkaarten + "]";
	}
	
	
	
}
