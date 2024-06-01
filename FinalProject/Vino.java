package FinalProject;
import java.util.Scanner;
public class Vino extends Bevanda {
    private String colore;
    
    public Vino() {
    	super();
    	Scanner in = new Scanner(System.in);
    	System.out.println("Inserire colore: ");
    	colore = in.nextLine();
    }
    public Vino(Cantina cantina, double tassoAlcolico, String colore) {
    	super(cantina, tassoAlcolico);
    	this.colore = colore;
    }
    public String servizio() {
    	return "Viene servito con una temperatura non maggiore di 20 gradi Celsius";
    }
    public Vino(Vino vino) {
    	super(vino);
    	colore = vino.getColore();
    }
    public String getColore() {
    	return colore;
    }
    public void setColore(String colore) {
    	this.colore = colore;
    }
    public String csvFormat() {
    	return "Vino"+","+super.csvFormat()+","+colore;
    }
    public String toString() {
    	return "\n- - Vino:\n"+super.toString()+" Colore: "+colore+"\n";
    }
    public boolean equals(Vino vino) {
    	return super.equals(vino) && colore == vino.getColore();
    }
}