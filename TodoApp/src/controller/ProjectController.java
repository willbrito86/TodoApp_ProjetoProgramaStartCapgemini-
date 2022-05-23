package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save (Project project) {
		
		String sql = "INSERT INTO projects (name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//criando conexão com o banco
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, project.getName()); 	
			statement.setString(2, project.getDescription()); 	
			statement.setDate(3, new Date(project.getCreatedAt() .getTime())); 	
			statement.setDate(4, new Date(project.getUpdatedAt() .getTime())); 	
		
		}catch (SQLException ex){
			throw new RuntimeException("Erro ao salvar o projeto", ex);
			
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
			
		}
	}
	
		public void update (Project project) {
		
		String sql = "UPDATE projects SET"
				+ "name = ?, "
				+ "description = ?, "
				+ "createdAt = ?, "
				+ "updatedAt = ?, "
				+ "WHERE id = ?";		
				
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);			
			statement.setString(1, project.getName()); 	
			statement.setString(2, project.getDescription()); 	
			statement.setDate(3, new Date(project.getCreatedAt() .getTime())); 	
			statement.setDate(4, new Date(project.getUpdatedAt() .getTime())); 
			statement.setInt(5, project.getId());
			
			statement.execute();			
		}catch{
			
		}
}
