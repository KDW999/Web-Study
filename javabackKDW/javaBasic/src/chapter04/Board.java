package chapter04;

import java.util.*;

public class Board {
	private Integer boardNum;
	private String boardTitel;
	private String boatdWriter;
	private Date registDate;
    private String boardContent;
    
	public Board(Integer boardNum, String boardTitel, String boatdWriter, Date registDate, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardTitel = boardTitel;
		this.boatdWriter = boatdWriter;
		this.registDate = registDate;
		this.boardContent = boardContent;
	}
	
    
}
