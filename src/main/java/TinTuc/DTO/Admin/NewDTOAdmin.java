package TinTuc.DTO.Admin;

import java.sql.Date;

public class NewDTOAdmin {
	private int idNew;
	private String newTitle;
	private int idUser;
	private String property;
	private String category;
	private String author;
	private boolean status;
	private Date approvalDate;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	/*
	public int getCountComent() {
		return countComent;
	}
	public void setCountComent(int countComent) {
		this.countComent = countComent;
	}
	*/
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public int getIdNew() {
		return idNew;
	}
	public void setIdNew(int idNew) {
		this.idNew = idNew;
	}
}
