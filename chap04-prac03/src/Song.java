
public class Song {
        private String title;
        private String artist;
        private int year;
        private String country;
        
        public Song() { }
        public Song(String title, String artist, int year, String country) {
        	    this.title = title;
        	    this.artist = artist;
        	    this.year = year;
        	    this.country = country;
        }
        
        public void show() {
        	    System.out.print(year + " " );
                System.out.print(country + " ");
                System.out.print(artist +" ");
                System.out.println(title);
        }
        public static void main(String[] args) {
        	    Song myFavorite = new Song("Dancing Queen", "ABBA" 1978, )
                myFavorite.show();
        }
			
}