package FinalProject;
public class ListaEnoteche {
    private NodoEnoteca head;
    private int elem;
    
    public ListaEnoteche() {
    	head = null;
    	elem = 0;
    }
    public ListaEnoteche(NodoEnoteca nodo) {
    	head = nodo;
    	elem = 1;
    }
    public NodoEnoteca getHead() {
    	return head;
    }
    public int getElem() {
    	return elem;
    }
    public void append(NodoEnoteca nodoEnoteca) throws ProjectCustomException {
    	if(nodoEnoteca == null) {
    		throw new ProjectCustomException("method append in ListaEnoteche: first node mustn't be null");
    	}
    	if(head == null) {
    		head = nodoEnoteca;
    		head.setLink(null);
    		elem = 1;
    	}
    	else {
    		NodoEnoteca r = head;
        	while(r.getLink() != null) {
        		r = r.getLink();
        	}
        	nodoEnoteca.setLink(null);
        	r.setLink(nodoEnoteca);
        	elem++;
    	}
    }
    public void addHead(NodoEnoteca nodo) throws ProjectCustomException{
    	if(nodo == null) {
    		throw new ProjectCustomException("method addHead in ListaEnoteche: nodo = a null");
    	}
    	if(head == null) {
    		head = nodo;
    		nodo.setLink(null);
    		elem = 1;
    	}
    	else {
    		nodo.setLink(head);
    		head = nodo;
    		elem++;
    	}
    }
    public NodoEnoteca rmvHead() throws ProjectCustomException{
    	if(head == null) {
    		throw new ProjectCustomException("method rmvHead in ListaEnoteca: head is null");
    	}
    	NodoEnoteca a = head;
    	head = head.getLink();
    	a.setLink(null);
    	elem--;
    	return a;
    }
    public NodoEnoteca rmvTail() throws ProjectCustomException{
    	if(head == null) {
    		throw new ProjectCustomException("method rmvHead in ListaEnoteca: head is null");
    	}
    	NodoEnoteca a = null, b = head;
    	while(b.getLink() != null) {
    		a = b;
    		b = b.getLink();
    	}
    	a.setLink(null);
    	elem--;
    	return b;
    }
    public int checkCantina(Cantina cantina) { //Se esiste una lista con quella cantina ritorna la pos (dove si trova, 0 = head && so on) else ritorna -1
    	int ris = -1, cont = 0;
    	NodoEnoteca NE = head;
    	while(NE != null && ris == -1) {
    		if(NE.getInfo().getHead().getInfo().getCantina().equals(cantina)) {
    			ris = cont;
    		}
    		else{
    			NE = NE.getLink();
    			cont++;
    		}
    	}
    	return ris;
    }
    public void addCantina(int pos, Nodo nodo) { //Quando e' presente gia una lista con quella cantina (pos trovata != -1) faccio append sulla lista che ha quella cantina del nodo che la ha
    	NodoEnoteca app = head;
    	for(int i=0; i<pos; i++) {
    		app = app.getLink();
    	}
    	try{
    		app.getInfo().append(nodo); // una volta che il nodo appoggio sta sul'enoteca con quelle cantine, aggiungo l'elemento con quella cantina a quell'enoteca
    	}
    	catch(ProjectCustomException e) {
    		System.out.println(e.toString()+" SUPER ERRORE GRAVEEE");
    	}
    }
    public String toString() {
    	String ris = "------- Enoteche: -------\n";
    	NodoEnoteca a = head;
    	if(a == null) {
    		System.out.println("method toString in ListaEnoteche : head mustn't be null");
    		return ris;
    	}
    	while(a != null) {
    		ris += a.toString();
    		a = a.getLink();
    	}
    	ris += "------- Fine Enoteche -------\n";
    	return ris;
    }
    public static void main(String[] Args) {
    	ListaEnoteche A;
    	ListaEnoteca A1 = new ListaEnoteca(), B1 = new ListaEnoteca();
    	try{
    		A1.FIFO(2);
    		A = new ListaEnoteche(new NodoEnoteca(A1));
    		B1.FIFO(3);
    		A.append(new NodoEnoteca(B1));
    		System.out.println("||||||||\n"+A.toString());
    	}
    	catch(ProjectCustomException e) {
    		System.out.println(e.toString());
    	}
    }
}