package FinalProject;
public class Nodo {
    private Bevanda info;
    private Nodo link;
    
    public Nodo() {
    	info = null;
    	link = null;
    }
    public Nodo(Bevanda bevanda) {
    	info = bevanda;
    	link = null;
    }
    public Nodo(Nodo nodo) {
    	info = nodo.getInfo();
    	link = null;
    }
    public void setLink(Nodo nodo) {
    	link = nodo;
    }
    public Nodo getLink(){
    	return link;
    }
    public void setInfo(Bevanda bevanda) {
    	info = bevanda;
    }
    public Bevanda getInfo() {
    	return info;
    }
    public String toString() {
    	return info.toString();
    }
}