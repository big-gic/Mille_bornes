package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class GestionCartes {
	
	private GestionCartes() {
		throw new IllegalStateException("Utility class");
	}

	public static <T> T extraire(List<T> liste) {
		int index = ThreadLocalRandom.current().nextInt(liste.size());
		return liste.remove(index);
	}
		
//	public static <T> T extraire(List<T> liste) {
//		int index = ThreadLocalRandom.current().nextInt(liste.size());
//		for (ListIterator<T> iterator = liste.listIterator(); iterator.hasNext();) {
//			T t = iterator.next();
//			if (index == 0) {
//				iterator.remove();
//				return t;
//			}
//			index--;
//			
//		}
//	}
	
	public static <T> List<T> melanger(List<T> liste){
		List<T> newListe = new ArrayList<>();
		while (!liste.isEmpty()){
			T t = extraire(liste);
			newListe.add(t);
		}
		return newListe;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
	    if (liste1.size() != liste2.size()) {
	        return false;
	    }
	    for (Iterator<T> it = liste1.iterator(); it.hasNext();) {
	        T element = it.next();
	        if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> newListe = new ArrayList<>();
		while (!liste.isEmpty()) {
			ListIterator<T> it = liste.listIterator();
			T t = it.next();
			it.remove();
			newListe.add(t);
			while (it.hasNext()) {
				T t1 = it.next();
				if (t1.equals(t)) {
					it.remove();
					newListe.add(t1);
				}
			}
		}
		return newListe;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it1 = liste.listIterator();
		T current = null;
		if (it1.hasNext()) {
			current = it1.next();
		}
		while (it1.hasNext()) {
			T next = it1.next();
			if (!current.equals(next)) {
				ListIterator<T> it2 = liste.listIterator(liste.indexOf(next));
				while (it2.hasNext()) {
					if (it2.next().equals(current)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
}
