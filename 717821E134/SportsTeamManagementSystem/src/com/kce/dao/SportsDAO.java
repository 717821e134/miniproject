package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.SportsTeam;
import com.kce.util.DBUtil;

	public class SportsDAO{
	 static Scanner sc = new Scanner(System.in);
	
		public static void InsertData(int sports) {
			try {
				SportsTeam[] s = new SportsTeam[sports];

				for (int i = 0; i < sports; i++) {
					System.out.println("Enter the SportsName");
					String sportsName = sc.next();

					System.out.println("Enter the PlayerName");
					String playerName = sc.next();

					System.out.println("Enter the JerseyNumber");
					int jerseyNumber = sc.nextInt();

					System.out.println("Enter the GameSchedule");
					String gameSchedule = sc.next();
		

					s[i] = new SportsTeam(sportsName,playerName,jerseyNumber,gameSchedule);
				}

				Connection con = DBUtil.getConnection();
				PreparedStatement psmt = con.prepareStatement("INSERT INTO SportsTeam VALUES (?,?,?,?)");

				for (int i = 0; i < sports; i++) {
					psmt.setString(1, s[i].getSportsName());
					psmt.setString(2, s[i].getPlayerName());
					psmt.setInt(3, s[i].getJerseyNumber());
					psmt.setString(4, s[i].getGameSchedule());
					
					/*int affectedRows=psmt.executeUpdate();;
					if (affectedRows > 0) {
						System.out.println(" details added successfully...");
					} else {
						System.out.println("Failed to add  details...");
					}*/
					psmt.executeUpdate();
				}

				System.out.println("Data inserted successfully!!!");

			} catch (SQLException e) {
				System.out.println(e);
			} 
		}

		public static void updateData(String playerName, int jerseyNumber) {
			try {
				Connection con = DBUtil.getConnection();
				PreparedStatement psmt = con.prepareStatement("UPDATE SportsTeam SET PlayerName = ? WHERE JerseyNumber = ?");
				
				psmt.setString(1, playerName);
				psmt.setInt(2, jerseyNumber);
				int rows = psmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Data updated successfully...");
				} else {
					System.out.println("No record found with the provided");
				}

			} catch (SQLException e) {
				System.out.println(e);
			} 
		}

		public static void deleteData(int JerseyNumber) {
			try {
				Connection con = DBUtil.getConnection();
				PreparedStatement psmt = con.prepareStatement("DELETE FROM SportsTeam WHERE JerseyNumber = ?");
				psmt.setInt(1, JerseyNumber);
				int rows = psmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Data deleted successfully...");
				} else {
					System.out.println("No record found with the provided ");
				}

			} catch (SQLException e) {
				System.out.println(e);
			} 
		}

		public static void displayData(){
			try {
				Connection con = DBUtil.getConnection();
				PreparedStatement psmt = con.prepareStatement("SELECT * FROM SportsTeam");
				ResultSet rs = psmt.executeQuery();
				System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "sportsName","playerName","jerseyNumber","gameSchedule");
				while (rs.next()) {
			
					
					String sportsName = rs.getString("sportsName");
					String playerName = rs.getString("playerName");
					int jerseyNumber = rs.getInt("jerseyNumber");
					String gameSchedule = rs.getString("gameSchedule");
					

					System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",sportsName,playerName,jerseyNumber,gameSchedule);
				}

			} 
			catch (SQLException e) {
				System.out.println(e);
			} 
		}
		}