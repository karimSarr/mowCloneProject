package com.objis.projet_java;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Projet {
	public static void insertion(String entrer_mot) {
		String url = "jdbc:mysql://localhost/projet_java";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO mot (mots) VALUES ('"+ entrer_mot +"')";
			st.executeUpdate(sql);
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
		System.out.println("Ecrire le mot à enregistrer");
		Scanner ins = new Scanner(System.in);
		String entre_mot = ins.nextLine();
		insertion(entre_mot);
	}

}
