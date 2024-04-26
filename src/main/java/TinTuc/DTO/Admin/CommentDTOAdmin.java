package TinTuc.DTO.Admin;

import java.sql.Date;

import TinTuc.Entity.BaseEntity;

public class CommentDTOAdmin extends BaseEntity{
	private String newTitle;
	private String contentComment;
	private String userComment;
	private Date commentDate;
	
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getContentComment() {
		return contentComment;
	}
	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
}
