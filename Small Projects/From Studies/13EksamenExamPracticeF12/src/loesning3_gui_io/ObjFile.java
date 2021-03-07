package loesning3_gui_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjFile implements FileIOInterface, Serializable {
	private static File  file = new File("Opg4File.obj");
	
	private String text;
	
	@Override
	public void writeToFile(String text) {
		this.text = text;
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	@Override
	public String readFromFile() {
		ObjectInputStream ois = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			ObjFile obj = (ObjFile) ois.readObject();
			return obj.getText();
		}
		catch (ClassNotFoundException ex){
			ex.printStackTrace();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "Error in ObjFile";
	}
	
	private String getText(){
		return text;
	}
	

}
