package FinalProject;
import java.util.Scanner;
public class Spumante extends Bevanda {
    private String spumaggio;
    
    public Spumante() {
    	super();
    	Scanner in = new Scanner(System.in);
    	System.out.println("Inserire modalita di spumaggio: ");
    	spumaggio = in.nextLine();
    }
    public Spumante(Cantina cantina, double tassoAlcolico, String spumaggio) {
    	super(cantina, tassoAlcolico);
    	this.spumaggio = spumaggio;
    }
    public Spumante(Spumante spumante) {
    	super(spumante);
    	spumaggio = spumante.getSpumaggio();
    }
    public String getSpumaggio() {
    	return spumaggio;
    }
    public void setSpumaggio(String spumaggio) {
    	this.spumaggio = spumaggio;
    }
    public String servizio() {
    	return "Viene servito con una temperatura non maggiore di 15 gradi Celsius";
    }
    public String csvFormat() {
    	return "Spumante"+","+super.csvFormat()+","+spumaggio;
    }
    public String toString() {
    	return "\n - - Spumante:\n"+super.toString()+" Tipo di spumaggio: "+spumaggio+"\n";
    }
    public boolean equals(Spumante spumante) {
    	return super.equals(spumante) && spumaggio == spumante.getSpumaggio();
    }
}