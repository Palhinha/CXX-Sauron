package pt.tecnico.sauron.silo;


import io.grpc.BindableService;
import io.grpc.stub.StreamObserver;

public class SiloServerImpl extends SSGrpc.SSImplBase {
	private SiloServer server = new SiloServer();
	@Override
	public void cam_join(CamJoinRequest request, StreamObserver<CamJoinResponse> responseObserver){
		CamJoinResponse response = CamJoinResponse.newBuilder().setResult(server.NewCamera(request.getName(),request.getLatitude(),request.getLongitude())).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}


	public void cam_info(CamInfoRequest request, StreamObserver<CamInfoResponse> responseObserver){
		Coordinates coor = server.RequestCamInfo(request.getName());
		CamInfoResponse response = CamInfoResponse.newBuilder().setLatitude(coor.getLatitude()).setLongitude(coor.getLongitude()).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
