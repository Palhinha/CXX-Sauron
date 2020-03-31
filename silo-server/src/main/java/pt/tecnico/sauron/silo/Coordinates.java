package pt.tecnico.sauron.silo;

public class Coordinates {
	int latitude;
	int longitude;
	public Coordinates(int lat,int lon) {
		this.latitude = lat;
		this.longitude = lon;
	}
	public int getLatitude() {return this.latitude;}
	public int getLongitude() {return this.longitude;}
}
