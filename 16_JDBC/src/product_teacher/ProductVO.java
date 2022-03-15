package product_teacher;

public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private String regDate;
	private String madeBy;
	
	public ProductVO() {	}

	// insert용 생성자
	public ProductVO(String pname, int price, String madeBy) {
		this.pname = pname;
		this.price = price;
		this.madeBy = madeBy;
	}
	// list용 생성자
	public ProductVO(int pno, String pname, int price) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}
	
	// update용 생성자
	public ProductVO(int pno, String pname, int price, String madeBy) {
		this(pno, pname, price);
		this.madeBy = madeBy;
	}

	public ProductVO(int pno, String pname, int price, String regDate, String madeBy) {
		this(pno, pname, price, madeBy);
		this.regDate = regDate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", regDate=" + regDate + ", madeBy="
				+ madeBy + "]";
	}
}
