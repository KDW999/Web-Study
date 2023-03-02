package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DataBaseConnector;
import database.Entity.UserEntity;

public class UserDAO {

	// DB에서 User 테이블 중 id가 입력받은 값에 해당하는 레코드의 모든 컬럼을 선택해서 반환
	// SQL : SELECT * FROM User WHERE id = ?
	// 예상되는 반환 값 : 0 or 1개의 레코드
	
	// find~~ : 결과의 인스턴스를 반환하는 메서드
	// exists~~ : 결과의 존재여부를 boolean 형태로 반환하는 메서드
	public UserEntity findById(Integer id) {
		UserEntity result = null;
		
		final String SQL = "SELECT * FROM User WHERE id = ?";
		
		Connection connection = null; // 연결 객체
		PreparedStatement preparedStatement = null; // SQL에 물음표 있으면 동적 작용을 위해
		ResultSet resultSet = null; // SELECT 선택?
		
		try {
			
			connection = DataBaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery(); // select은 query 나머진 update
			
			if(resultSet.next()) {
				String password = resultSet.getString(2);
				String name = resultSet.getString(3);
				String telNumber = resultSet.getString(4);
				
				result = new UserEntity(id, password, name, telNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(resultSet != null && !resultSet.isClosed()) resultSet.close();
				if(preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
				if(connection != null && !connection.isClosed()) connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return result;
	}
}
