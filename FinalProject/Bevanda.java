package FinalProject;
import java.util.*;
public abstract class Bevanda implements InterFaccia{
    private Cantina cantina;
    private double tassoAlcolico;
    
    public Bevanda(){
        Scanner in = new Scanner(System.in);
        System.out.print("Cantina: ");
        cantina = new Cantina();
        System.out.println("Inserire Tasso Alcolico: ");
        tassoAlcolico = in.nextDouble();
    }
    public Bevanda(Cantina cantina, double tassoAlcolico){
        this.cantina = cantina;
        this.tassoAlcolico = tassoAlcolico; 
    }
    public Bevanda(Bevanda bevanda){
        cantina = bevanda.getCantina();
        tassoAlcolico = getTassoAlcolico();
    }
    public Cantina getCantina(){
        return cantina;
    }
    public double getTassoAlcolico(){
        return tassoAlcolico;
    }
    public void setCantina(Cantina cantina){
        this.cantina = cantina;
    }
    public void setTassoAlcolico(double tassoAlcolico){
        this.tassoAlcolico = tassoAlcolico;
    }
    public String toString(){
        return ("prodotta in: "+cantina.toString()+"Tasso Alcolico: "+tassoAlcolico);
    }
    public String csvFormat() {
    	return cantina.csvFormat()+","+tassoAlcolico;
    }
    public boolean equals(Bevanda bevanda){
        return (cantina.equals(bevanda.getCantina()) && tassoAlcolico == bevanda.getTassoAlcolico());
    }
}