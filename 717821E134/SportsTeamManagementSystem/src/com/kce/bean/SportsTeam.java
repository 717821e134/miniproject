package com.kce.bean;


	 public class SportsTeam {
	 	private String sportsName;
	 	private String playerName;
	 	private int jerseyNumber;
	 	private String gameSchedule;
	 	public SportsTeam(String sportsName, String playerName,int jerseyNumber, String gameSchedule) {
	 		super();
	 		this.sportsName = sportsName;
	 		this.playerName = playerName;
	 		this.jerseyNumber = jerseyNumber;
	 		this.gameSchedule = gameSchedule;
	 	}
	 	public String getSportsName() {
	 		return sportsName;
	 	}
	 	public void setSportsName(String sportsName) {
	 		this.sportsName = sportsName;
	 	}
	 	public String getPlayerName() {
	 		return playerName;
	 	}
	 	public void setPlayerName(String playerName) {
	 		this.playerName = playerName;
	 	}
	 	public int getJerseyNumber() {
	 		return jerseyNumber;
	 	}
	 	public String getGameSchedule() {
			return gameSchedule;
		}
		public void setGameSchedule(String gameSchedule) {
			this.gameSchedule = gameSchedule;
		}
	 	@Override
		public String toString() {
			return "SportsTeam [SportsName=" + sportsName + ", playerName=" + playerName + ", JerseyNumber=" + jerseyNumber
					+ ", gameSchedule=" + gameSchedule + "]";
		}
	
		}
	 
	 	

