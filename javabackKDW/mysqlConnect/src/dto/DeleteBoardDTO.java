package dto;

public class DeleteBoardDTO {
	private Integer id; // DB에선 int형태라도 null값이 올 수 있어서 Integer로 해줌

	
	public DeleteBoardDTO(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DeleteBoardDTO [id=" + id + "]";
	}
	
	

}
