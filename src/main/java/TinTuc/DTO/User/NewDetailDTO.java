package TinTuc.DTO.User;

public class NewDetailDTO extends BaseDTO{
	private String content;
	private int authorID;
	private int countComment;
	private int likes;

	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getLikes() {
		return likes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getCountComment() {
		return countComment;
	}

	public void setCountComment(int countComment) {
		this.countComment = countComment;
	}

	public int getLike() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
