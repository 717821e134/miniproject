package com.kce.bean;


import com.kce.dao.*;

public class Players {
 public String playerName;
 public int teamMembers;
 public String gameSchedule;
 public double Scores;
 public Players(String playerName,int teamMembers,String gameSchedule,double Scores){
	 this.playerName=playerName;
	 this.teamMembers=teamMembers;
	 this.gameSchedule=gameSchedule;
	 this.Scores=Scores;
 }
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public int getTeamMembers() {
	return teamMembers;
}
public void setTeamMembers(int teamMembers) {
	this.teamMembers = teamMembers;
}
public String getGameSchedule() {
	return gameSchedule;
}
public double getScores() {
	// TODO Auto-generated method stub
	return Scores;
}
@Override
public String toString() {
	return "Players [playerName=" + playerName + ", teamMembers=" + teamMembers + ", gameSchedule=" + gameSchedule
			+ ", Scores=" + Scores + "]";
}
 
 
}