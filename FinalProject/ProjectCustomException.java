package FinalProject;
public class ProjectCustomException extends Exception{
    private String msg;
    
    public ProjectCustomException(String msg){
    	this.msg = msg;
    }
    public String getMsg() {
    	return msg;
    }
    public void setMsg(String msg) {
    	this.msg = msg;
    }
    public String toString() {
    	return "!!!Errore: "+msg+"\n";
    }
}