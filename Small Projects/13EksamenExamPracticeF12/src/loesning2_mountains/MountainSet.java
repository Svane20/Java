package loesning2_mountains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {

	private Set<Mountain> tree;

	public MountainSet() {
		tree = new TreeSet<Mountain>();
	}

	public void addMountain(Mountain m) {
		this.tree.add(m);
	}

	@Override
	public String toString() {
		return tree.toString();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainSet mic = new MountainSet();

		Scanner sc = null;
		try {
			sc = new Scanner(new File("FranskeBjerge.csv"));
			//System.out.println(sc.nextLine());
			String line;
			String[] items;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				items = line.split(";");
				mic.addMountain(new Mountain(items[0], items[1],
						items[2], items[3], items[4],
						items[5]));
			}

			System.out.println(mic);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

}
