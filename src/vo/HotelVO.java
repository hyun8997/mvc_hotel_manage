package vo;

public class HotelVO {
	private int h_no;
	private int ad_no;
	private String h_name;
	private String loc;
	private String h_conv;
	private String h_comment;
	
	public HotelVO() {}

	public HotelVO(int h_no, int ad_no, String h_name, String loc, String h_conv, String h_comment) {
		super();
		this.h_no = h_no;
		this.ad_no = ad_no;
		this.h_name = h_name;
		this.loc = loc;
		this.h_conv = h_conv;
		this.h_comment = h_comment;
	}

	public int getH_no() {
		return h_no;
	}

	public void setH_no(int h_no) {
		this.h_no = h_no;
	}

	public int getAd_no() {
		return ad_no;
	}

	public void setAd_no(int ad_no) {
		this.ad_no = ad_no;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getH_conv() {
		return h_conv;
	}

	public void setH_conv(String h_conv) {
		this.h_conv = h_conv;
	}

	public String getH_comment() {
		return h_comment;
	}

	public void setH_comment(String h_comment) {
		this.h_comment = h_comment;
	}
}
