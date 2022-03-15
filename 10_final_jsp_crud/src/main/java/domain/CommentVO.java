package domain;

public class CommentVO {
	private long cno;
	private long pno;
	private String writer;
	private String content;
	private String regAt;
	private String modAt;
	
	public CommentVO() {}

	// 등록
	public CommentVO(long pno, String writer, String content) {
		this.pno = pno;
		this.writer = writer;
		this.content = content;
	}

	// 리스트
	public CommentVO(long cno, long pno, String writer, String content, String modAt) {
		this.cno = cno;
		this.pno = pno;
		this.writer = writer;
		this.content = content;
		this.modAt = modAt;
	}
	
	// 업데이트
	public CommentVO(long cno, String content) {
		this.cno = cno;
		this.content = content;
	}

	public final long getCno() {
		return cno;
	}

	public final void setCno(long cno) {
		this.cno = cno;
	}

	public final long getPno() {
		return pno;
	}

	public final void setPno(long pno) {
		this.pno = pno;
	}

	public final String getWriter() {
		return writer;
	}

	public final void setWriter(String writer) {
		this.writer = writer;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final String getRegAt() {
		return regAt;
	}

	public final void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public final String getModAt() {
		return modAt;
	}

	public final void setModAt(String modAt) {
		this.modAt = modAt;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", pno=" + pno + ", writer=" + writer + ", content=" + content + ", regAt="
				+ regAt + ", modAt=" + modAt + "]";
	}
	
}
