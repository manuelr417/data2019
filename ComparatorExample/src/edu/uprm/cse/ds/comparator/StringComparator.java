package edu.uprm.cse.ds.comparator;

public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		if ((a.length() == 1) || (b.length() ==1)){
			return a.charAt(0) - b.charAt(0);
		}
		
		if (a.equals(b)) {
			return 0;
		}
		else {
			char c1 = a.charAt(0);
			char c2 = b.charAt(0);
			if (c1 < c2) {
				return -1;
			}
			else if (c1 > c2) {
				return 1;
			}
			else {
				return compare(a.substring(1), b.substring(1));
			}
		}
	}

}
