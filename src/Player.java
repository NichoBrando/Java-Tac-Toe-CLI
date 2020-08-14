package myproject;
import java.util.Scanner;

public class Player {
	
  public static boolean verifyPlay(char[][] field, char choice) {
	  int i, j;
	  for(i = 0; i < 3; i++) {
		  for(j = 0; j < 3; j++) {
			  if(field[i][j] == choice){
				  return true;
			  }
		  }
	  }
	  return false;
  }
  
  public static int play(char[][] field) {
	  int choice, i;
	  @SuppressWarnings("resource")
	Scanner myScanner = new Scanner(System.in);
	  boolean validPlay;
	  System.out.println("Vez do jogador! \n");
	  System.out.println("Escolha uma posição válida");
	  for(i = 0; i < 3; i++) {
		System.out.format("%c | %c | %c \n", field[i][0], field[i][1], field[i][2]);
	  }
	  //System.out.println("\n" + displayField.toString());
	  System.out.println("Posição: ");
	  choice = myScanner.nextInt();
	  validPlay = verifyPlay(field, (char)(choice + '0'));
	  while(!validPlay) {
		System.out.println("\nNão entendi! Escolha uma posição válida");
		System.out.println("Posição: ");
		choice = myScanner.nextInt();
		validPlay = verifyPlay(field, (char)(choice + '0'));
		}
	  return choice;
  }
}
