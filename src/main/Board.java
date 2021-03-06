/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import static main.StdDraw.setScale;
class Board {
    
    public int Boardsize = 0;
    public char[][] Board;
    
    public Board(int size){
        
        this.Boardsize = size;
        createBoard();
    }
    
    public void setBombs(int bombs){

        for(int i = 0;i<bombs;i++){
            double random = Math.random();
            int x = (int) random*Board.length;
            int y = (int) random*Board.length;
            Board[y][x]='X';
        }
       
    }

    private void createBoard() {
        
        Board = new char[Boardsize][Boardsize];
        
        for(int i = 0 ; i <Boardsize;i++) {
                    for(int j = 0; j<Boardsize;j++){
                        Board[i][j]=' ';    
                    }      
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Bombs should be on the Board ? : ");
        int bombs = sc.nextInt();
        if(bombs>Boardsize/2) createBoard();
        
        DrawBoard();
        setBombs(bombs); 
    
    }
    
    public void DrawBoard(){
   
        setScale(0, Boardsize); 
        double y = 0;
        double step = 1;
        Square[] square = new Square[Boardsize*2];
        int sq = 0;
        
        for(int i = 0;i<Boardsize;i++){     
            
                double x = 0;   
                for(int j = 0;j<Boardsize;j++){  
                    
                   square[sq]= new Square(i,j);
                   
                   StdDraw.square(x, y, 1);  
                   x+=step;
            } 
                 y+=step;
                 
        }
        
      
    }
    
}
