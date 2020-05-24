package h;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String a = "*";
		int i = 0;
		List<String> list = new ArrayList<String>();
		while (i < 100) {
			list.add(a); // First Loop la oru element. Second Loop la rendu element and So on
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(i));
			}
			System.out.println();
			i++;
		}
	}
}