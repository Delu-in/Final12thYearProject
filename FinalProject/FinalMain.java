package FinalProject;
import java.util.*;
public class FinalMain {
    public static void main(String[] Args){
        Scanner in = new Scanner(System.in);
        int pick = 1; Vino vino = null; Spumante spumante = null; Prosecco prosecco = null; Nodo app = new Nodo(); ListaEnoteca enoteca = null; ListaEnoteche enoteche= null;
        while(pick != 0) {
        	System.out.println("- - - - - INSERIRE - - - - -\n0. Per terminare il programma\n1. Per creare un nuovo elemento\n2. Per creare una lista di Vini, Spumanti o Prosecchi\n"
        			+ "3. Per creare una lista di liste di Enoteche\n4. Per popolare un'Enoteca con n elementi\n5. Per suddividere in Cantine le Enoteche e visualizzarle\n"
        			+ "6. Per Salvare l'Enoteca creata sul file (ListaEnoteca.csv)\n7. Per Caricare dal file (ListaEnoteca.csv) l'Enoteca\n8. Per stampare l'Enoteca\n"
        			+ "9. Per stampare la lista delle Enoteche\n10. Per vedere i servizi delle bevande\n11. Per aggiungere un elemento all'Enoteca\n12 Per rimuovere un elemento dall'Enoteca\n"
        			+ "13. Per visualizzare quanti elementi sono presenti nell'Enoteca\n14. Per stampare un elemento vino/spumante/prosecco\n- - - - - - - - - - - - - -");
        	try{
        		System.out.println("Inserire input: ");
        		pick = in.nextInt();
        		if(pick == 0) {
        			System.out.println("GRAZIE ED ARRIVEDERCI!");
        		}
        		else if(pick == 1) {
        			System.out.println("Inserire:\n0. Per terminare il programma\n1. Per creare un Vino\n2. Per creare uno Spumante\n3. Per creare un Prosecco\nInserire: ");
        			pick = in.nextInt();
        			if(pick == 1) {
        				vino = new Vino();
        			}
        			else if(pick == 2) {
        				spumante = new Spumante();
        			}
        			else if(pick == 3){
        				prosecco = new Prosecco();
        			}
        		}
        		else if(pick == 2) {
        			System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire gia un primo elemento\n2. Per crearne una vuota\nInserire: ");
        			pick = in.nextInt();
        			if(pick == 1) {
        				System.out.println("Inserire:\n0. Per terminare il programma\n1. Per aggiungere un Vino gia' creato\n2. Per aggiungere uno Spumante gia' creato\n3. Per aggiungere un Prosecco gia' creato\nInserire: ");
        				pick = in.nextInt();
        				if(pick == 1) {
        					if(vino != null) {
        						enoteca = new ListaEnoteca(new Nodo(vino));
        					}
        					else {
        						System.out.println("! Creare un Vino prima !");
        					}
        				}
        				else if(pick == 2) {
        					if(spumante != null) {
        						enoteca = new ListaEnoteca(new Nodo(spumante));
        					}
        					else {
        						System.out.println("! Creare uno Spumante prima !");
        					}
        				}
        				else if(pick == 3) {
        					if(prosecco != null) {
        						enoteca = new ListaEnoteca(new Nodo(prosecco));
        					}
        					else {
        						System.out.println("! Creare un prosecco prima! ");
        					}
        				}
        			}
        			else if(pick == 2) {
        				enoteca = new ListaEnoteca();
        			}
        		}
        		else if(pick == 3) {
        			System.out.println("Inserire:\n0. Per terminare il programma\n1. Per aggiungere come primo elemento l'Enoteca gia creata\n2. Per crearne una vuota\nInserire: ");
        			pick = in.nextInt();
        			if(pick == 1) {
        				if(enoteca != null) {
        					enoteche = new ListaEnoteche(new NodoEnoteca(enoteca));
        				}
        				else {
        					System.out.println("! Creare un Enoteca prima !");
        				}
        			}
        			else {
        				enoteche = new ListaEnoteche();
        			}
        		}
        		else if(pick == 4) {
        			System.out.println("Inserire quantita di elementi da aggiungere all'Enoteca: ");
        			pick = in.nextInt();
        			if(pick > 0) {
        				enoteca = new ListaEnoteca();
        				enoteca.FIFO(pick);
        			}
        			else {
        				System.out.println("! Quantita incalcolabile !");
        			}
        		}
        		else if(pick == 5) {
        			if(enoteca != null) {
        				enoteche = enoteca.suddividiCantine();
        				System.out.println(enoteche.toString());
        			}
        			else {
        				System.out.println("! Creare un Enoteca prima !");
        			}
        		}
        		else if(pick == 6) {
        			if(enoteca != null) {
        				enoteca.writeToCsv(enoteca);
        			}
        			else {
        				System.out.println("! Creare un Enoteca prima !");
        			}
        		}
        		else if(pick == 7) {
        			if(enoteca == null) {
        				enoteca = new ListaEnoteca();
        			}
        			enoteca.readFromCsv(enoteca);
        		}
        		else if(pick == 8) {
        			if(enoteca != null) {
        				System.out.println(enoteca.toString());
        			}
        			else {
        				System.out.println("! Creare prima un Enoteca !");
        			}
        		}
        		else if(pick == 9) {
        			if(enoteche != null) {
        				System.out.println(enoteche.toString());
        			}
        			else {
        				System.out.println("! Creare prima la lista di Enoteche !");
        			}
        		}
        		else if(pick == 10) {
        			if(vino == null) {
        				System.out.println("Creare prima il Vino per le specifiche");
        				vino = new Vino();
        			}
        			if(spumante == null) {
        				System.out.println("Creare prima lo Spumante per le specifiche");
        				spumante = new Spumante();
        			}
        			if(prosecco == null) {
        				System.out.println("Creare prima il Prosecco per le specifiche");
        				prosecco = new Prosecco();
        			}
    				System.out.println("Servizi bevande:\nVino: "+vino.servizio()+"\nSpumante: "+spumante.servizio()+"\nProsecco: "+prosecco.servizio());
        		}
        		else if(pick == 11) {
        			if(enoteca != null) {
        				System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire un Vino\n2. Per inserire uno Spumante\n3. Per inserire un Prosecco\nInserire: ");
            			pick = in.nextInt();
            			if(pick == 1) {
            				System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire il vino gia creato\n2. Per inserire un nuovo Vino\nInserire: ");
            				pick = in.nextInt();
            				if(pick == 1) {
            					if(vino != null) {
            						System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire in testa\n2. Per inserire in coda\n3. Per inserire in una posizione\nInserire: ");
            						pick = in.nextInt();
            						if(pick == 1) {
            							enoteca.addHead(new Nodo(vino));
            						}
            						else if(pick == 2) {
            							enoteca.append(new Nodo(vino));
            						}
            						else {
            							System.out.println("Inserire\n0. Per terminare il programma\nInserire la posizione: ");
            							pick = in.nextInt();
            							if(pick > 0) {
            								enoteca.addNodo(new Nodo(vino), pick);
            							}
            							else {
            								System.out.println("! Posizione non raggiungibile !");
            							}
            						}
            					}
            				}
            			}
            			else if(pick == 2) {
            				if(spumante != null) {
        						System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire in testa\n2. Per inserire in coda\n3. Per inserire in una posizione\nInserire: ");
        						pick = in.nextInt();
        						if(pick == 1) {
        							enoteca.addHead(new Nodo(spumante));
        						}
        						else if(pick == 2) {
        							enoteca.append(new Nodo(spumante));
        						}
        						else {
        							System.out.println("Inserire\n0. Per terminare il programma\nInserire la posizione: ");
        							pick = in.nextInt();
        							if(pick > 0) {
        								enoteca.addNodo(new Nodo(spumante), pick);
        							}
        							else {
        								System.out.println("! Posizione non raggiungibile !");
        							}
        						}
        					}
            			}
            			else if(pick == 3) {
            				if(prosecco != null) {
        						System.out.println("Inserire:\n0. Per terminare il programma\n1. Per inserire in testa\n2. Per inserire in coda\n3. Per inserire in una posizione\nInserire: ");
        						pick = in.nextInt();
        						if(pick == 1) {
        							enoteca.addHead(new Nodo(prosecco));
        						}
        						else if(pick == 2) {
        							enoteca.append(new Nodo(prosecco));
        						}
        						else {
        							System.out.println("Inserire\n0. Per terminare il programma\nInserire la posizione: ");
        							pick = in.nextInt();
        							if(pick > 0) {
        								enoteca.addNodo(new Nodo(prosecco), pick);
        							}
        							else {
        								System.out.println("! Posizione non raggiungibile !");
        							}
        						}
        					}
            			}
            		}
        			else {
        				System.out.println("! Creare un Enoteca prima !");
        			}
        		}
        		else if(pick == 12) {
        			System.out.println("Inserire:\n0. Per terminare il programma\n1. Per rimuovere l'elemento in testa\n2. Per rimuovere l'elemento in coda\n3. Per rimuovere un elemento in mezzo\nInserire: ");
        			pick = in.nextInt();
        			if(pick == 1) {
        				app = enoteca.rmvHead();
        				System.out.println("Elemento recuperato: "+app.getInfo().toString());
        			}
        			else if(pick == 2) {
        				app = enoteca.rmvTail();
        				System.out.println("Elemento recuperato: "+app.getInfo().toString());
        			}
        			else if(pick == 3) {
        				System.out.println("Inserire\n0. per terminare il programma\nInserire posizione dell'elemento da togliere: ");
        				pick = in.nextInt();
        				if(pick > 0) {
        					app = enoteca.rmvNodo(pick);
        					System.out.println("Elemento recuperato: "+app.getInfo().toString());
        				}
        			}
        		}
        		else if(pick == 13) {
        			System.out.println("Elementi nell'Enoteca: ");
        			if(enoteca != null) {
        				System.out.println(enoteca.getElem());
        			}
        			else {
        				System.out.println("Nessun Enoteca creata");
        			}
        		}
        		else if(pick == 14) {
        			System.out.println("Inserire:\n0. Per terminare il programma\n1. Per stampare il vino\n2. Per stampare lo spumante\n3. Per stampare il prosecco\nInserire: ");
        			pick = in.nextInt();
        			if(pick == 1) {
        				if(vino != null) {
        					System.out.println(vino.toString());
        				}
        				else {
        					System.out.println("! Creare un Vino prima !");
        				}
        			}
        			else if(pick == 2) {
        				if(spumante != null) {
        					System.out.println(spumante.toString());
        				}
        				else {
        					System.out.println("! Creare uno Spumante prima !");
        				}
        			}
        			else if(pick == 3) {
        				if(prosecco != null) {
        					System.out.println(prosecco.toString());
        				}
        				else {
        					System.out.println("! Creare un Prosecco prima !");
        				}
        			}
        		}
        		else {
        			System.out.println("Opzione non disponibile, ritenta");
        		}
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Input inserito incorretto: "+e.toString());
        	}
        	catch(ProjectCustomException e) {
        		System.out.println("! ERROR ! : "+e.toString());
        	}
        	catch(NoSuchElementException e) {
        		System.out.println("! ERROR ! : "+e.toString());
        	}
        	
        }
        return;
    }
}