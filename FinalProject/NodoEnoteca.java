package FinalProject;
public class NodoEnoteca {
    private ListaEnoteca info;
    private NodoEnoteca link;
    
    public NodoEnoteca() {
    	info = null;
    	link = null;
    }
    public NodoEnoteca(ListaEnoteca enoteca) {
    	info = enoteca;
    	link = null;
    }
    public NodoEnoteca(NodoEnoteca nodoenoteca) {
    	info = nodoenoteca.getInfo();
    	link = nodoenoteca.getLink();
    }
    public ListaEnoteca getInfo() {
    	return info;
    }
    public NodoEnoteca getLink() {
    	return link;
    }
    public void setInfo(ListaEnoteca enoteca) {
    	info = enoteca;
    }
    public void setLink(NodoEnoteca nodoenoteca) {
    	link = nodoenoteca;
    }
    public String toString() {
    	return info.toString();
    }
}