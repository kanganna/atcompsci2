package p9_1;

import java.text.NumberFormat;

public class CD {

	public String title, artist;
	private double cost;
	private int tracks;
	
	public CD()
	{
		title = "X";
		artist = "Y";
		cost = 0;
		tracks = 0;
	}
	
	public CD(String name, String singer, double price, int numTracks)
	{
		title = name;
		artist = singer;
		cost = price; 
		tracks = numTracks;
	}
	
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String description = fmt.format(cost) + "\t" + tracks + "\t" + title + "\t" + artist;
		return description;
	}
}
