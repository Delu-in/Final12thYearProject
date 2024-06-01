package FinalProject;
import java.util.*;
public class Prosecco extends Bevanda {
    private double vinificazione;
    
    public Prosecco() {
    	super();
    	Scanner in = new Scanner(System.in);
    	System.out.println("Inserire durata di giorni per la vinificazione: ");
    	vinificazione = in.nextDouble();
    }
    public Prosecco(Cantina cantina, double tassoAlcolico, double vinificazione) {
    	super(cantina, tassoAlcolico);
    	this.vinificazione = vinificazione;
    }
    public Prosecco(Prosecco prosecco) {
    	super(prosecco);
    	vinificazione = prosecco.getVinificazione();
    }
    public double getVinificazione() {
    	return vinificazione;
    }
    public void setVinificazione(double vinificazione) {
    	this.vinificazione = vinificazione;
    }
    public String servizio() {
    	return "Viene servito con una temperatura non maggiore di 30 gradi Celsius";
    }
    public String csvFormat() {
    	return "Prosecco"+","+super.csvFormat()+","+vinificazione;
    }
    public String toString() {
    	return "\n-- Prosecco:\n"+super.toString()+" Durata vinificazione: "+vinificazione+"\n";
    }
    public boolean equals(Prosecco prosecco) {
    	return super.equals(prosecco) && vinificazione == prosecco.getVinificazione();
    }
}