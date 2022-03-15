package hotel;

public class RoomVO {
	private String rno;
	private UserVO user;
	private boolean isAvail;
	private String checkInTime;
	private String checkOutTime;
	
	public RoomVO() {}

	// create hotel room or checkout
	public RoomVO(String rno) {
		this.rno = rno;
	}
	
	// room list
	public RoomVO(String rno, boolean isAvail) {
		this.rno = rno;
		this.isAvail = isAvail;
	}
	
	// check in
	public RoomVO(String rno, UserVO user) {
		this.rno = rno;
		this.user = user;
	}
	
	// room detail
	public RoomVO(String rno, UserVO user, boolean isAvail, String checkInTime, String checkOutTime) {
		this.rno = rno;
		this.user = user;
		this.isAvail = isAvail;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public boolean isAvail() {
		return isAvail;
	}

	public void setAvail(boolean isAvail) {
		this.isAvail = isAvail;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	@Override
	public String toString() {
		return "RoomVO [rno=" + rno + ", user=" + user + ", isAvail=" + isAvail + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + "]";
	}
	
}
