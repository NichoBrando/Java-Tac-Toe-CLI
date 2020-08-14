package myproject;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
  private char[][] field = {{'0', '0', '0'},{'0', '0', '0'},{'0', '0', '0'}};
  public int winner = 0;
  public TicTacToe() {
	  this.startField();
	  this.startGame();
  }
  
  private void startField() {
	  int x = 1, i, j;
	  while(x <= 9){
		  for(i = 0; i < 3; i++) {
		    for(j = 0; j < 3; j++) {
			  this.field[i][j] = (char)(x + '0');
			  x++;
			}  
		  }
		  
	  }
  }
  
  public char[][] getField() {
	  return this.field;
  }
  
  private void changeField(int choice, char icon){
	  int i, j;
	  for(i = 0; i < 3; i++) {
		  for(j = 0; j < 3; j++) {
			  if(this.field[i][j] == (char)(choice + '0')) {
				  this.field[i][j] = icon;
				  System.out.format("POSIÇÃO %d ALTERADA! VALOR: %c \n", choice, icon);
			  }
		  }
	  }
  }
  
  public void setWinner(char icon) {
	  if(icon == 'O') {
		  this.winner = 2;
	  }
	  else {
		  this.winner = 1;
	  }
  }
  private boolean checkField(char icon){
	  int i;
	  for(i = 0; i < 3; i++) {
		  if(this.field[i][0] == icon && this.field[i][1] == icon && this.field[i][2] == icon) {
			  this.setWinner(icon);
			  return true;
		  }
		  if(this.field[0][i] == icon && this.field[1][i] == icon && this.field[2][i] == icon) {
			  this.setWinner(icon);
			  return true;
		  }
	  }
	  if(this.field[0][0] == icon && this.field[1][1] == icon && this.field[2][2] == icon) {
		  this.setWinner(icon);
		  return true;
	  }
	  if(this.field[0][0] == icon && this.field[1][1] == icon && this.field[2][2] == icon) {
		  this.setWinner(icon);
		  return true;
	  }
	  if(this.field[0][0] != '1' && this.field[0][1] != '2' && this.field[0][2] != '3') {
		  if(this.field[1][0] != '4' && this.field[1][1] != '5' && this.field[1][2] != '6') {
			  if(this.field[2][0] != '7' && this.field[2][1] != '8' && this.field[2][2] != '9') {
				  return true;
			  }
		  }
	  }
	  return false;
  }
  
  private void startGame() {
	  boolean gameStatus = true;
	  Random myRandom = new Random();
	  int choice = 0;
	  int turn = myRandom.nextInt(2);
	  System.out.println("\n\n!O JOGO VAI COMEÇAR!\n");
	  if(turn == 1) {
		  System.out.println("PRIMEIRA RODADA É DO PLAYER 1!");
	  }
	  else {
		  System.out.println("PRIMEIRA RODADA É DO PLAYER 2!");
	  }
	  while(gameStatus) {
		  if(turn == 1) {
			  turn = 2;
			  choice = Player.play(getField());
			  this.changeField(choice, 'X');
			  if(this.checkField('X')){
				  gameStatus = false;
			  }
		  }else{
			  System.out.println("Vez do jogador 2\n");
			  turn = 1;
			  choice = Player.play(getField());
			  this.changeField(choice, 'O');
			  if(this.checkField('O')){
				  gameStatus = false;
			  }
		  }
	  }
	  System.out.println("\n\nO JOGO ACABOU!\n");
	  if(this.winner == 1 || this.winner == 2) {
		  System.out.printf("O Player %d VENCEU, PARABÉNS!\n", this.winner);
	  }
	  else{
		  System.out.println("Nenhum jogador venceu! :(");
	  }
  }
  public static void main(String[] args) {
	  int i = 0, rounds;
	  @SuppressWarnings("resource")
	  Scanner myScanner = new Scanner(System.in);
	  System.out.println("Seja bem vindo ao jogo da velha!");
	  System.out.println("Você irá jogar com um amigo próximo");
	  System.out.println("Quantas partidas irão jogar?");
	  rounds = myScanner.nextInt();
	  while(rounds < 1) {
		  System.out.println("\nOpção inválida! Digite quantas partidas irão jogar.");
		  rounds = myScanner.nextInt();
	  }
	  while(i < rounds){
		  System.out.printf("Rodada %d: \n\n", i + 1);
		  @SuppressWarnings("unused")
		  TicTacToe game = new TicTacToe();
		  i++;
	  }
	  System.out.println("O jogo acabou! Obrigado por jogar!");
  }
}