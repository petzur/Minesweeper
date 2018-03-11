/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
class Board {
    
    public int Boardsize = 0;
    public char[][] Board;
    double[] x = { 0.1, 0.2, 0.3, 0.2 };
    double[] y = { 0.2, 0.3, 0.2, 0.1 };
    
    
    public Board(int size){
        
        this.Boardsize = size;
        createBoard();
    }
    
    public void setBombs(int bombs){

        for(int i = 0;i<bombs;i++){
            double random = Math.random();
            int x = (int) random*Board.length;
            int y = (int) random*Board.length;
            Board[y][x]='!';
        }
       
    }

    private void createBoard() {
        // NASSIM
        
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Bombs should be on the Board ? : ");
        int bombs = sc.nextInt();
        if(bombs>Boardsize/2) createBoard();
        
        setBombs(bombs);
    }
}
