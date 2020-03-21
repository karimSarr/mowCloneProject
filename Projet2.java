package com.objis.projet_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Projet2 {
	public static void lecture() {
		String url = "jdbc:mysql://localhost/projet_java";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM mot";
			rs = st.executeQuery(sql);
			while (rs.next()){
				System.out.println(rs.getString("mots"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			try{
				cn.close();
				st.close();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		lecture();

	}

}
