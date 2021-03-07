package loesning3_gui_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFile implements FileIOInterface {
	private static File file = new File("Opg4File.txt");

	@Override
	public void writeToFile(String text) {
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
			fw.write(text);
			fw.write("\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String readFromFile() {

		Scanner sc = null;
		String result = "";
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				result += sc.nextLine() + "\n";
			}
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return "Error in TextFile";
	}


}
