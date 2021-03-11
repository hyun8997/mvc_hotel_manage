package vo;

public class RoomOfHotelVO {
	private int r_no;
	private int h_no;
	private String r_name;
	private int maxppl;
	private int price;
	
	public RoomOfHotelVO() {}
	public RoomOfHotelVO(int r_no, int h_no, String r_name, int maxppl, int price) {
		super();
		this.r_no = r_no;
		this.h_no = h_no;
		this.r_name = r_name;
		this.maxppl = maxppl;
		this.price = price;
	}
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getH_no() {
		return h_no;
	}
	public void setH_no(int h_no) {
		this.h_no = h_no;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getMaxppl() {
		return maxppl;
	}
	public void setMaxppl(int maxppl) {
		this.maxppl = maxppl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
