package site.algernoon.entity;

public class Mail {
	
	private String from;
	
	private String to;
	
	private String subject;
	
	private String content;

	public final String getFrom() {
		return from;
	}

	public final void setFrom(String from) {
		this.from = from;
	}

	public final String getTo() {
		return to;
	}

	public final void setTo(String to) {
		this.to = to;
	}

	public final String getSubject() {
		return subject;
	}

	public final void setSubject(String subject) {
		this.subject = subject;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

}
