package TinTuc.DTO.Admin;

public class New {
	private String title;
	private String slug;
	private String tomtat;
	private String content;
	private int id_role;
	private int author;
	private String hinhanh;
	private int thuoctinh;
	private int danhmuc;
	private String base64String;
	
	@Override
	public String toString() {
		return "New [title=" + title + ", slug=" + slug + ", tomtat=" + tomtat + ", content=" + content + ", id_role="
				+ id_role + ", author=" + author + ", hinhanh=" + hinhanh + ", thuoctinh=" + thuoctinh + ", danhmuc="
				+ danhmuc + ", base64String=" + base64String + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTomtat() {
		return tomtat;
	}
	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getThuoctinh() {
		return thuoctinh;
	}
	public void setThuoctinh(int thuoctinh) {
		this.thuoctinh = thuoctinh;
	}
	public int getDanhmuc() {
		return danhmuc;
	}
	public void setDanhmuc(int danhmuc) {
		this.danhmuc = danhmuc;
	}
	public String getBase64String() {
		return base64String;
	}
	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}
}
