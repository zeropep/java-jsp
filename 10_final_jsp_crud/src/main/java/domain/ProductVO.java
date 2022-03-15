package domain;

public class ProductVO {
	private long pno;
	private String pname;
	private int price;
	private String madeBy;
	private String regAt;
	private String writer;
	private String category;
	private String description;
	private String modAt;
	private int readCount;
	private String imageFile;
	
	public ProductVO() {}

	// 상품 등록
	public ProductVO(String pname, int price, String madeBy, String writer, String category, String description,
			String imageFile) {
		this.pname = pname;
		this.price = price;
		this.madeBy = madeBy;
		this.writer = writer;
		this.category = category;
		this.description = description;
		this.imageFile = imageFile;
	}
	// 리스트
	public ProductVO(long pno, String pname, int price, String writer, String modAt, int readCount, String imageFile) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.writer = writer;
		this.modAt = modAt;
		this.readCount = readCount;
		this.imageFile = imageFile;
	}

	// 상품 수정
	public ProductVO(long pno, String pname, int price, String madeBy, String category, String description,
			String imageFile) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.madeBy = madeBy;
		this.category = category;
		this.description = description;
		this.imageFile = imageFile;
	}
	
	// 삭제
	// 사실 생성자가 필요없긴 한데 이미지파일을 별도로 관리할때는 이 생성자가 필요함.
//	public ProductVO(long pno, String imageFile) {
//		this.pno = pno;
//		this.imageFile = imageFile;
//	}

	// 상품 디테일
	public ProductVO(long pno, String pname, int price, String madeBy, String regAt, String writer, String category,
			String description, String modAt, int readCount, String imageFile) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.madeBy = madeBy;
		this.regAt = regAt;
		this.writer = writer;
		this.category = category;
		this.description = description;
		this.modAt = modAt;
		this.readCount = readCount;
		this.imageFile = imageFile;
	}

	public final long getPno() {
		return pno;
	}

	public final void setPno(long pno) {
		this.pno = pno;
	}

	public final String getPname() {
		return pname;
	}

	public final void setPname(String pname) {
		this.pname = pname;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	}

	public final String getMadeBy() {
		return madeBy;
	}

	public final void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public final String getRegAt() {
		return regAt;
	}

	public final void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public final String getWriter() {
		return writer;
	}

	public final void setWriter(String writer) {
		this.writer = writer;
	}

	public final String getCategory() {
		return category;
	}

	public final void setCategory(String category) {
		this.category = category;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final String getModAt() {
		return modAt;
	}

	public final void setModAt(String modAt) {
		this.modAt = modAt;
	}

	public final int getReadCount() {
		return readCount;
	}

	public final void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public final String getImageFile() {
		return imageFile;
	}

	public final void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", madeBy=" + madeBy + ", regAt="
				+ regAt + ", writer=" + writer + ", category=" + category + ", description=" + description + ", modAt="
				+ modAt + ", readCount=" + readCount + ", imageFile=" + imageFile + "]";
	}
	
}
