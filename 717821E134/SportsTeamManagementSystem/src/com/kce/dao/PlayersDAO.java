package com.kce.dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.bean.Players;
import com.kce.service.PlayersDetails;
import com.kce.util.DBUtil;
	public class PlayersDAO {
		

		
		
			public static void addPlayer(PlayersDetails p)throws InvalidDateException {
				try {
					Connection con = DBUtil.getConnection();
					PreparedStatement psmt = con.prepareStatement("INSERT INTO Players VALUES (?,?,?,?)");
					
					psmt.setString(1, p.getPlayerName());
					
					psmt.setInt(2, p.getTeamMembers());
					
					psmt.setString(3, p.getGameSchedule());
					psmt.setDouble(4, p.getScores());
					
					int affectedRows = psmt.executeUpdate();
					if (affectedRows > 0) {
						System.out.println("Players details added successfully...");
					} else {
						System.out.println("Failed to add Players details...");
					}
				psmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}

			public static void displayData() {
				try {
					Connection con= DBUtil.getConnection();
					PreparedStatement psmt = con.prepareStatement("SELECT  PlayerName,  TeamMembers, gameSchedule,  Scores FROM Players");
					ResultSet rs = psmt.executeQuery();
					
System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n","PlayerName","  TeamMembers"," gameSchedule","  Scores");
					while (rs.next()) {
						String PlayerName = rs.getString("PlayerName");
						int TeamMembers = rs.getInt("TeamMembers");
						String gameSchedule = rs.getString("gameSchedule");
						Double Scores = rs.getDouble("Scores");
						

						System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",PlayerName,  TeamMembers, gameSchedule,  Scores);
					}

					rs.close();
					psmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				} 
			}

			public static void deleteDetails()  {
				try {
					Connection con = DBUtil.getConnection();
					Statement st = con.createStatement();
					int affectedRows = st.executeUpdate("TRUNCATE TABLE Players");
					if (affectedRows > 0) {
						System.out.println("Details are deleted successfully!");
					} else {
						System.out.println("Failed to delete details...");
					}

					st.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}

			public void addPlayers(Players p) {
				// TODO Auto-generated method stub
				
			}

		}

