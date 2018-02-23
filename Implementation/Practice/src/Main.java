import java.util.*;

public class Main {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("mama");
		set.add("mama");
		for(String s: set)
			System.out.println(s);
	}

}
