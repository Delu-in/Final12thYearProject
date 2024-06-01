package FinalProject;
import java.util.*;
import java.io.*;
public class ListaEnoteca {
    private Nodo head;
    private int elem;
    
    public ListaEnoteca() {
    	head = null;
    	elem = 0;
    }
    public ListaEnoteca(Nodo nodo) {
    	head = nodo;
    	elem = 1;
    }
    public Nodo getHead() {
    	return head;
    }
    public int getElem() {
    	return elem;
    }
    public void append(Nodo nodo) throws ProjectCustomException{
    	if(nodo == null) {
    		throw new ProjectCustomException("method append in ListaEnoteca: first node mustn't be null");
    	}
    	if(head == null) {
    		head = nodo;
    		head.setLink(null);
    		elem = 1;
    	}
    	else {
    		Nodo r = head;
        	while(r.getLink() != null) {
        		r = r.getLink();
        	}
        	r.setLink(nodo);
        	nodo.setLink(null);
        	elem++;
    	}
    }
    public void addHead(Nodo nodo) throws ProjectCustomException{
    	if(nodo == null) {
    		throw new ProjectCustomException("method addHead in ListaEnoteca: nodo = a null");
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
    public Nodo rmvHead() throws ProjectCustomException{
    	if(head == null) {
    		throw new ProjectCustomException("method rmvHead in ListaEnoteca: head is null");
    	}
    	Nodo a = head;
    	head = head.getLink();
    	a.setLink(null);
    	elem--;
    	return a;
    }
    public Nodo rmvTail() throws ProjectCustomException{
    	if(head == null) {
    		throw new ProjectCustomException("method rmvHead in ListaEnoteca: head is null");
    	}
    	Nodo a = null, b = head;
    	while(b.getLink() != null) {
    		a = b;
    		b = b.getLink();
    	}
    	a.setLink(null);
    	elem--;
    	return b;
    }
    public void FIFO(int n) throws ProjectCustomException{
    	if(n < 2) {
    		throw new ProjectCustomException("method FIFO in ListaEnoteca: elements to create (n) must be greater than 2 to use this method");
    	}
    	int pick;
    	Nodo a = null;
    	Scanner in = new Scanner(System.in);
    	for(int i=0; i<n; i++) {
    		System.out.println("Digita\n1: Se si vuole inserire un Vino\n2: Se si vuole inserire un Prosecco\n3: Se si vuole inserire uno Spumante");
    		pick = in.nextInt();
    		if(pick == 1) {
    			a = new Nodo(new Vino());
    		}
    		else if (pick == 2) {
    			a = new Nodo(new Prosecco());
    		}
    		else if (pick == 3) {
    			a = new Nodo(new Spumante());
    		}
    		else {
    			System.out.println("An empty node has been added!");
    		}
    		this.append(a);
    	}
    }
    public ListaEnoteche suddividiCantine() throws ProjectCustomException {
       if(head == null) {
            throw new ProjectCustomException("method suddividiCantine in ListaEnoteca : no elements");
        }
        ListaEnoteche Le = new ListaEnoteche();
        Nodo a = head;
        int pos = 0;
        while(a != null) {
            Cantina cantina = a.getInfo().getCantina();
            pos = Le.checkCantina(cantina);
            if(pos != -1) {
                Le.addCantina(pos, new Nodo(a));
            } 
            else { // se la posizione e' -1 non esiste una lista enoteca con quella cantina, dunque la aggiungo
                ListaEnoteca app = new ListaEnoteca(new Nodo(a));
                Le.append(new NodoEnoteca(app));
            }
            a = a.getLink();
        }
        return Le;
    }
    public void writeToCsv(ListaEnoteca list) throws ProjectCustomException {
    	Nodo app = head;
    	if(app == null) {
    		throw new ProjectCustomException("method writeToCsv in ListaEnoteca : list is empty");
    	}
        try{
        	PrintWriter writer = new PrintWriter("ListaEnoteca.csv");
	        while(app != null) {
	            writer.println(app.getInfo().csvFormat());
	            app = app.getLink();
	        }
	        writer.close();
	        System.out.println("Successfully written on file CSV");
        }
        catch(IOException e) {
        	throw new ProjectCustomException("method writeToCsv in ListaEnoteca "+e.toString());
        }
    }
    public void readFromCsv(ListaEnoteca list) throws ProjectCustomException {
    	try{
    		BufferedReader br = new BufferedReader(new FileReader("ListaEnoteca.csv"));
    		String line = "";
    		List<ListaEnoteca> StrList = new ArrayList<>();
    		while ((line = br.readLine()) != null) {
    			String[] FullLine = line.split(",");
    			if(FullLine[0].equals("Vino")) {
    	    	    list.append(new Nodo(new Vino(new Cantina(FullLine[1],FullLine[2],Integer.valueOf(FullLine[3])),Double.valueOf(FullLine[4]),FullLine[5])));
    			}
    			else if(FullLine[0].equals("Prosecco")) {
    				list.append(new Nodo(new Prosecco(new Cantina(FullLine[1],FullLine[2],Integer.valueOf(FullLine[3])),Double.valueOf(FullLine[4]),Double.valueOf(FullLine[5]))));
    			}
    			else if(FullLine[0].equals("Spumante")){
    				list.append(new Nodo(new Spumante(new Cantina(FullLine[1],FullLine[2],Integer.valueOf(FullLine[3])),Double.valueOf(FullLine[4]),FullLine[5])));
    			}
    			else {
    				throw new ProjectCustomException("method readFromCsv in ListaEnoteca : error in the .csv file");
    			}
    		}
    	}
    	catch(IOException e) {
    		throw new ProjectCustomException("method readFromCsv in ListaEnoteca : no idea");
    	}
    	System.out.println("Succesfully read from csv file");
    }
    public void addNodo(Nodo nodo, int pos) {
		Nodo a = null, b = head;
		if(pos>0 && pos<elem) {
			for(int i=0; i<pos; i++) {
				a = b;
				b = b.getLink();
			}
			nodo.setLink(b);
			a.setLink(nodo);
			elem++;
		}
		else {
			System.out.println("Error pos");
		}
	}
	public Nodo rmvNodo(int pos) {
		Nodo a = null, b = head;
		if(pos>0 && pos<elem) {
			for(int i=0; i<pos; i++) {
				a = b;
				b = b.getLink();
			}
			a.setLink(b.getLink());
			b.setLink(null);
			elem--;
		}
		else {
			System.out.println("! Errore pos !");
			b = a;
		}
		return b;
	}
	public String toString(){
    	String ris = "# # # # # Enoteca: # # # # #";
    	Nodo b = head;
    	while(b != null) {
    		ris += b.toString();
    		b = b.getLink();
    	}
    	ris += "# Fine Enoteca #\n\n";
    	return ris;
    }
    public static void main(String[] Args) {
    	ListaEnoteca A = new ListaEnoteca();
    	ListaEnoteca B = new ListaEnoteca();
    	ListaEnoteche R = new ListaEnoteche();
    	try{
    		A.FIFO(5);
    		System.out.println(A.toString());
    		R = A.suddividiCantine();
    		System.out.println(R.toString());
    		//A.writeToCsv(A);
    		//B.readFromCsv(B);
    		//System.out.println(B.toString());
    	}
    	catch(ProjectCustomException e) {
    		System.out.println(e.toString());
    	}
    }
}