package FinalProject;
import java.util.*;
public class Cantina {
    private String citta;
    private String nome;
    private int anno;
    
    public Cantina(){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci Citta: ");
        citta = in.nextLine();
        System.out.println("Inserisci Nome: ");
        nome = in.nextLine();
        System.out.println("Inserisci Anno: ");
        anno = in.nextInt();
    }
    public Cantina(String citta, String nome, int anno){
        this.citta = citta;
        this.nome = nome;
        this.anno = anno;
    }
    public Cantina(Cantina cantina){
        citta = cantina.getCitta();
        nome = getNome();
        anno = getAnno();
    }
    public String getCitta(){
        return citta;
    }
    public String getNome(){
        return nome;
    }
    public int getAnno(){
        return anno;
    }
    public void setCitta(String citta){
        this.citta = citta;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAnno(int anno){
        this.anno = anno;
    }
    public String csvFormat() {
    	return citta+","+nome+","+anno;
    }
    public String toString(){
        return "\n>> Cantina "+nome+"  Situata a "+citta+"\n  Nell'anno: "+anno+"\n";
    }
    public boolean equals(Cantina cantina){
        return (citta.equals(cantina.getCitta()) && nome.equals(cantina.getNome()) && anno == cantina.getAnno());
    }
}