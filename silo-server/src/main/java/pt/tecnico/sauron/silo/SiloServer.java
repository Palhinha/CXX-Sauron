package pt.tecnico.sauron.silo;

import java.util.ArrayList;

public class SiloServer {
	ArrayList <Cam> Cams;
	public SiloServer() {
		Cams = new ArrayList<Cam>();
	}
	public Coordinates RequestCamInfo(String name) throws NoSuchCam {
		for(Cam a : Cams){
			if(a.getName().equals(name)){
				return a.getCoordinates();
			}
		}
		throw new NoSuchCam();
		
	}
	public CamJoinResult NewCamera(String name,int lat,int lon){
		if(name.length()<3||name.length()>15)return OUT_OF_BOUNDS_NAME;
		for(Cam a : Cams){
			if(a.getName().equals(name)){
				if(a.getCoordinates().getLatitude() != lat){return USED_NAME;}
				if(a.getCoordinates().getLongitude() != lon){return USED_NAME;}
				return REPEATED_CAM;
			}
		}
		this.Cams.add(new Cam(name , lat, lon));
		return JOINED;
	}


}
