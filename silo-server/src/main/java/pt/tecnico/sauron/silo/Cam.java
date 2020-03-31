package pt.tecnico.sauron.silo;

public class Cam {
	String name;
	Coordinates coor;
	public Cam(String name,int lat,int lon){
		this.name = name;
		this.coor = new Coordinates(lat,lon);
	}
	public Coordinates getCoordinates() {return this.coor;}
	public String getName() {return name;}
}
