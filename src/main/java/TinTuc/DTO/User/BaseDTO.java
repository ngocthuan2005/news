package TinTuc.DTO.User;

import java.sql.Date;

public abstract class BaseDTO {
	private String image;
	private String author;
	private String newTitle;
	private String propertyTitle;
	private Date approvalDate;
	private String propertySlug;
	private String categorySlug;
	private String categoryTitle;
	private int view;
	private String newSlug;
	private int idProperty;
	private Date postingDate;
	
	public Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}
	public String getNewSlug() {
		return newSlug;
	}
	public void setNewSlug(String newSlug) {
		this.newSlug = newSlug;
	}
	public int getIdProperty() {
		return idProperty;
	}
	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getPropertyTitle() {
		return propertyTitle;
	}
	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getPropertySlug() {
		return propertySlug;
	}
	public void setPropertySlug(String propertySlug) {
		this.propertySlug = propertySlug;
	}
	public String getCategorySlug() {
		return categorySlug;
	}
	public void setCategorySlug(String categorySlug) {
		this.categorySlug = categorySlug;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}
