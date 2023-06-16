package com.kce.service;

	import com.kce.dao.*;
	import com.kce.bean.*;

	import java.time.LocalDate;
	import java.time.format.DateTimeParseException;
	import java.util.Scanner;
import java.io.*;
		public class SportsTeamManagement_Main {
			


			public static void main(String[] args) throws InvalidDateException,ClassNotFoundException  {
				
				Scanner sc = new Scanner(System.in);
				SportsDAO sd= new SportsDAO();
				PlayersDAO pd = new PlayersDAO();

				System.out.println("Enter 1 for Updatements");
				System.out.println("Enter 2 for Entry Players Details");
				int choice = sc.nextInt();

				if (choice == 1) {
					while (true) {
						System.out.println("Choose an operation:");
						System.out.println("1. Insert Data");
						System.out.println("2. Update Data");
						System.out.println("3. Delete Data");
						System.out.println("4. Display Data");
						System.out.println("5. Exit");
						System.out.println("Enter the Operation:");
						int operation = sc.nextInt();

						switch (operation) {
						case 1:
							System.out.println("Enter the number sports to be insert:");
							int numteams = sc.nextInt();
							sd.InsertData(numteams);
							break;

						case 2:
							System.out.println("Enter the PlayerName:");
							String PlayerName = sc.next();
							System.out.println("Enter the JerseyNumber:");
							int JerseyNumber = sc.nextInt();
							sd.updateData(PlayerName, JerseyNumber);
							break;

						case 3:
							System.out.println("Enter the JerseyNumber:");
							
							int deleteJerseyNumber=sc.nextInt();
							SportsDAO.deleteData(deleteJerseyNumber);
							break;

						case 4:
							SportsDAO.displayData();
							break;

						case 5:
							System.out.println("Exit...Thank you!!!");
							sc.close();
							System.exit(0);
							break;

						default:
							System.out.println("Wrong choice..Please try again!");
							break;
						}
					}
				} else if (choice == 2) {
					while (true) {
						System.out.println("Enter the choice:");
						System.out.println("1. Choose the TeamMembers:");
						System.out.println("2. Display  the PlayersDetails");
						System.out.println("3. Delete the PlayersDetails ");
						System.out.println("4. Exit");
						int TeamChoice = sc.nextInt();
						sc.nextLine();

						switch (TeamChoice) {
						case 1:
							SportsDAO.displayData();
							
							System.out.println("Enter the PlayerName:");
							String PlayerName = sc.next();
							
							System.out.println("Enter the TeamMembers:");
							int TeamMembers = sc.nextInt();
							
							System.out.println("Enter the gameSchedule (yyyy-MM-dd):");
							String gameSchedule = sc.next();
							String returngameSchedule=sc.next();
							if (!isValidDate(returngameSchedule)) {
								throw new InvalidDateException("Invalid date format!");
							}
						
							System.out.println("Enter the scores:");
							Double scores = sc.nextDouble();
							
							PlayersDetails p = new PlayersDetails(PlayerName,  TeamMembers, gameSchedule,  scores);
							pd.addPlayers(p);
							break;

						case 2:
							
						    PlayersDAO.displayData();
							break;

						case 3:
						    
							PlayersDAO.deleteDetails();						
							break;
							
						case 4:
							
							System.out.println("Exit!!!");
							sc.close();
							System.exit(0);
							break;

						default:
							System.out.println("Invalid choice...Please try again!!!");
							break;
						}
					}
				} else {
					System.out.println("Invalid choice...Please try again!!!");
				}
			}

			
			private static boolean isValidDate(String date) {
				try {
					LocalDate.parse(date);
					return true;
				} catch (DateTimeParseException e) {
					return false;
				}
			
		}

	}

