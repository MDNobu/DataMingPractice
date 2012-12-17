package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Movie {
	private String name;
	public Movie(String name) {
		this.name = name;
	}
}

class MovieGenerator {
	private int i = 0;
	private static final String[] movies = new String[]{
		"Snow White", "The Dark Knight", "The Dark Knight Rises", "Batman Begins",
		"Star Wars", "The lord of ring",
	};
	
	public String next() {
		String name = movies[i];
		i = (i + 1) % movies.length;
		return name;
	}
}

public class Exercise4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MovieGenerator mg = new MovieGenerator();
		List<String> alm = new ArrayList<String>();
		List<String> tlm = new LinkedList<String>();
		Collection<String> hsm = new HashSet<String>();
		LinkedHashSet<String> lhsm = new LinkedHashSet<String>();
		TreeSet<String> tsm = new TreeSet<String>();
		for (int i = 0; i < 12; i++) {
			alm.add(mg.next());
		}
		tlm.addAll(alm);
		hsm.addAll(alm);
		lhsm.addAll(alm);
		tsm.addAll(alm);
		print(alm);
		//print(tlm);
		/*print(hsm);
		print(lhsm);
		print(tsm);*/
		List<String> subMovieList = alm.subList(5, 9);
		alm.retainAll(subMovieList);
		print(alm);
	}

}
