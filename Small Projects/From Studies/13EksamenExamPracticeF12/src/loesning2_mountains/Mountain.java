package loesning2_mountains;

import java.util.Arrays;

public class Mountain implements Comparable<Mountain>{

	private String name;
	private int height;
	private int prominence;
	private String latitude;
	private String longitude;
	private String range;

	
	public Mountain(String name, String height, String prominence, String latitude,
			String longitude, String range) {
		
		this.name = name;
		this.height = new Integer(height);
		this.prominence = new Integer(prominence);
		this.latitude = latitude;
		this.longitude = longitude;
		this.range = range;
	}

	@Override
	public String toString() {
		return name +" h=" + height
				+ ", pro=" + prominence + ", lat=" + latitude
				+ ", lon=" + longitude + ", ran=" + range + "\n";
	}


	@Override
	public int compareTo(Mountain o) {
//		int i = this.height - o.height;
		int i = this.prominence - o.prominence;
		if (i == 0){
			i = this.height - o.height;
		}
		return i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Til test af Mountain-klassen
		
		//Opg a Test af constructor og toString()
		Mountain m = new Mountain("Mont Ventoux","1909","1148","44°10'26\"","05°16'42\"","Alps");
	
		System.out.println(m);
		
		// Opg b Test af compareTo()
		Mountain[] testArray = new Mountain[4];
		testArray[0] = new Mountain("Pica d'Estats","3143","1281","42°42'43\"","00°57'23\"","Pyrenees"); 
		testArray[1] = new Mountain("Mont Chaberton", "3131", "1281", "44°57'53\"","06°45'06\"", "Alps" );
		testArray[2] = new Mountain("Pic de Bure","2709", "1268", "44°37'38\"", "05°56'07\"", "Alps" );
		testArray[3] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42°48'22\"", "-00°25'05\"", "Pyrenees");

		System.out.println("Usorteret: ");
		System.out.println(Arrays.toString(testArray));
		
		System.out.println("Sorteret: ");
		Arrays.sort(testArray);
		System.out.println(Arrays.toString(testArray));

	}

}
