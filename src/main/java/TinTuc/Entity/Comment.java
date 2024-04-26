package TinTuc.Entity;

import java.sql.Date;

public class Comment extends BaseEntity{
	private String content;
	private Date comment_date;
	private boolean status;
	private int id_user;
	private int id_new;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_new() {
		return id_new;
	}

	public void setId_new(int id_new) {
		this.id_new = id_new;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
}
