package td1;

public class Dictionnaire {
	private int nb_mots;
	private mot_dict[] tab;
	private String Nom;
public Dictionnaire(int taille , String nom) {
	tab= new mot_dict[taille];
	Nom=nom;
	nb_mots=0;
}
public void Ajouter_Mot(mot_dict mot) {
	int i= nb_mots -1;
	   while (i >= 0 && tab[i].getMot().compareTo(mot.getMot()) > 0) {
	        tab[i + 1] = tab[i];
	        i--;
	    }

	    tab[i + 1] = mot;
	    nb_mots++;
	}
public void Trier() {
	int i , j ;
	mot_dict temp;
	for (i=0; i<nb_mots -1  ;i++ ) {
		for (j = i + 1; j < nb_mots; j++) {
			if(tab[i].getMot().compareTo(tab[j].getMot())>0) {
				temp=tab[i];
				tab[i]=tab[j];
				tab[j]=temp;
			}
		}
	}
	
}
void Supprimer_Mot(mot_dict mot) {
	int i=0;
    while (i<nb_mots && !tab[i].getMot().equals(mot.getMot())) {
    	i++;
    }
    if(i<nb_mots) {
    	for(int j=i; j<nb_mots -1;j++) {
    		tab[j]=tab[j+1];
    		}
    	nb_mots--;
    }

	
}
public String Recherche_dicho(String mot) {
	int debut=0;
	int fin=nb_mots-1;
	int milieu= (debut+fin)/2;
	while (debut<=fin) {
		if (tab[milieu].getMot().equals(mot)){
			return tab[milieu].getDefinition();
			}
		if (tab[milieu].getMot().compareTo(mot)<0) {
			debut=milieu+1;
			
		}else {
			fin=milieu-1;
		}
		
	}
	return null;
}
public void Lister_dictionnaire() {
	System.out.println("dictionnaire:"+Nom+"("+nb_mots+"mots)");
	for(int i=0 ;i<nb_mots;i++) {
		System.out.println(tab[i]);
		
	}
}
public int Nombre_synonyme(mot_dict m) {
    int count = 0;
    for (int i = 0; i < nb_mots; i++) {
        if (tab[i].synonyme(m)) {
            count++;
        }
    }
    return count;
}

public class Main {
    public static void main(String[] args) {
        Dictionnaire e = new Dictionnaire(10, "ahla bik");

        e.Ajouter_Mot(new mot_dict("voiture", "golf"));
        e.Ajouter_Mot(new mot_dict("chat", "animal "));
        e.Ajouter_Mot(new mot_dict("auto", "polo"));
        e.Ajouter_Mot(new mot_dict("sayara", "rs6"));
        e.Ajouter_Mot(new mot_dict("voiture", "rs7"));
        e.Ajouter_Mot(new mot_dict("chat", "gat "));
        e.Lister_dictionnaire();
        System.out.println("Recherche 'chat' : " + e.Recherche_dicho("chat"));
        System.out.println("Recherche 'table' : " + e.Recherche_dicho("table"));
        mot_dict voiture = new mot_dict("voiture", "golf");
        System.out.println("Synonymes de voiture : " + e.Nombre_synonyme(voiture));
        e.Supprimer_Mot(new mot_dict("chat", ""));
        e.Lister_dictionnaire();
    }
}
}



