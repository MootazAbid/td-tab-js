package td1;

public class mot_dict {
	private String Mot;
	private String Definition;

public mot_dict(String mot , String definition) {
	Definition=definition;
	Mot=mot;
}
public String getMot() {
	return Mot;
	
}
public String getDefinition() {
	return Definition;
	
}
public void setDefinition(String definition) {
	Definition=definition;
}
public void setMot(String mot) {
	Mot=mot;
}
public boolean synonyme(mot_dict mot) {
    if (Mot.equals(mot)) {
        return true;
    } else {
        return false;
    }
}
public String toString() {
	return 	"Mot:"+Mot+",Definition"+Definition;
}	
}

