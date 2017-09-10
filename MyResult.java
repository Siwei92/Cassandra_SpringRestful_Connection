package hello;

import com.datastax.driver.core.*;



public class MyResult {
	
	private LocalDate dispatch_date;
	private Long dispatch_time;
	private String location_block;
	private int dc_dist;
	private double dc_key;
	private double lat;
	private double lon;
	private String police_districts;
	private String psa;
	private String text_general_code;
	private int ucr_general;

	MyResult(LocalDate dispatch_date,Long dispatch_time,String location_block,int dc_dist,double dc_key,double lat,double lon,String police_districts,String psa,String text_general_code,int ucr_general){

		this.dispatch_date=dispatch_date;
		this.dispatch_time=dispatch_time;
		this.location_block=location_block;
		this.dc_dist=dc_dist;
		this.dc_key=dc_key;
		this.lat=lat;
		this.lon=lon;
		this.police_districts=police_districts;
		this.psa=psa;
		this.text_general_code=text_general_code;
		this.ucr_general=ucr_general;
	}

	public LocalDate getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(LocalDate dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	public Long getDispatch_time() {
		return dispatch_time;
	}

	public void setDispatch_time(Long dispatch_time) {
		this.dispatch_time = dispatch_time;
	}

	public String getLocation_block() {
		return location_block;
	}

	public void setLocation_block(String location_block) {
		this.location_block = location_block;
	}

	public int getDc_dist() {
		return dc_dist;
	}

	public void setDc_dist(int dc_dist) {
		this.dc_dist = dc_dist;
	}

	public double getDc_key() {
		return dc_key;
	}

	public void setDc_key(double dc_key) {
		this.dc_key = dc_key;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getPolice_districts() {
		return police_districts;
	}

	public void setPolice_districts(String police_districts) {
		this.police_districts = police_districts;
	}

	public String getPsa() {
		return psa;
	}

	public void setPsa(String psa) {
		this.psa = psa;
	}

	public String getText_general_code() {
		return text_general_code;
	}

	public void setText_general_code(String text_general_code) {
		this.text_general_code = text_general_code;
	}

	public int getUcr_general() {
		return ucr_general;
	}

	public void setUcr_general(int ucr_general) {
		this.ucr_general = ucr_general;
	}
}
