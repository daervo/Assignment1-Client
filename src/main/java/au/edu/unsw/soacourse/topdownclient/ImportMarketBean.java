package au.edu.unsw.soacourse.topdownclient;

public class ImportMarketBean{
	
	private String sec;
	private String startDate;
	private String endDate;
	private String dataSourceURL;
	
	public ImportMarketBean(){
		
	}
	
	public void setSec(String sec){
		this.sec = sec;
	}
	
	public String getSec(){
		return this.sec;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public String getStartDate(){
		return this.startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	public String getEndDate(){
		return endDate;
	}
	
	public void setDataSourceURL(String dataSourceURL){
		this.dataSourceURL = dataSourceURL;
	}
	
	public String getDataSourceURL(){
		return dataSourceURL;
	}
}