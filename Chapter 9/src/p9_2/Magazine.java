package p9_2;

public class Magazine implements Comparable<Magazine>{

		private String title;
		
		/**
		 * Constructor
		 * @param newTitle title for the magazine
		 */
		public Magazine(String newTitle)
		{
			title = newTitle;
		}
		
		/**
		 * Returns the title
		 */
		public String toString()
		{
			return title;
		}
		
		/**
		 * Returns the title
		 * @return title
		 */
		public String getTitle()
		{
			return title;
		}

		/**
		 * Compares this title with the magazine's title
		 */
		public int compareTo(Magazine mag) 
		{	
		  return title.compareTo(mag.getTitle());
		}

}
