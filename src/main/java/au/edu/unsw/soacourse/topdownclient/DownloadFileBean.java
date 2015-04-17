package au.edu.unsw.soacourse.topdownclient;

public class DownloadFileBean{
	
	private String eventSetID;
	
	public DownloadFileBean(){
		
	}
	
	public void setEventSetID(String eventSetID){
		this.eventSetID = eventSetID;
	}
	
	public String getEventSetID(){
		return eventSetID;
	}
}