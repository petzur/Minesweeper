/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import static main.StdDraw.setCanvasSize;
import static main.StdDraw.setXscale;
import static main.StdDraw.setYscale;
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
            Board[y][x]='!';
        }
       
    }

    private void createBoard() {
        
        Board = new char[Boardsize][Boardsize];
        
        for(int i = 0 ; i <Boardsize;i++) {
                    for(int j = 0; j<Boardsize;j++){
                        
                        if(i==0 || i+1==Boardsize && j <= Boardsize) Board[i][j]='*';
                        else if (j == 0 || j+1 == Boardsize && i<= Boardsize)Board[i][j]='*';
                        else Board[i][j]=' ';
                    }
                    
        
        }
        DrawBoard();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Bombs should be on the Board ? : ");
        int bombs = sc.nextInt();
        if(bombs>Boardsize/2) createBoard();
        
        setBombs(bombs); 
    
    }
    
    public void DrawBoard(){
        // 0.02
        setCanvasSize(1000, 1000);
        setXscale(0,100);
        setYscale(0,100);
        
        double y = 2.0;
        double step = 4.0;
        
        for(int i = 0;i<Boardsize;i++){                
                double x = 2.0;   
                StdDraw.square(x, y, 2.0);
        
                for(int j = 0;j<Boardsize;j++){
                    StdDraw.square(x, y, 2.0);
                    x+=step;
                   
            }
           
                 y+=step;
        }
        
      
    }
    
}
