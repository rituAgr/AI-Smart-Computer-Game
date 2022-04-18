package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMoves {
    // take postion from user and validate to make move; Later it check it player won
    boolean make_move(block[][] gameBoard, ArrayList<position> playerMoves) throws IOException
    {
        while(true) {
            System.out.println(" Enter row and column (1-3) sequential Numbering separated by comma");
            Scanner reader = new Scanner(System.in);
            String entry = reader.nextLine();
            String[] splitValues = entry.split(",");
            int r = Integer.parseInt(splitValues[0].trim());
            int c = Integer.parseInt(splitValues[1].trim());
            if (r < 1 || r > 3 || c < 1 || c > 3) {
                System.out.print("Invalid entry, reenter position");
                continue;
            }
            if (gameBoard[r ][c ].isOccupied()) {
                System.out.print("Block is Occupied, enter empty space\n");
                continue;
            }
            gameBoard[r ][c ].setMark(mark.O);
            playerMoves.add(new position(r,c));
            if (checkVertical(mark.O, gameBoard) || checkHorizontal(mark.O,gameBoard) || checkDiagonal(mark.O,gameBoard))
                return true;
            return false;
        }
    }
    //helper func
    boolean checkVertical(mark marking,block[][] gameBoard)
    {
        for(int c=1;c<=3;c++) {
            int check=0;
            for (int r = 1; r <=3; r++)
                if(gameBoard[r][c].M==marking)
                    check++;
            if(check==3)
                return true;
        }
        return false;
    }
    //helper func
    boolean checkHorizontal(mark marking,block[][] gameBoard)
    {
        for(int r=1;r<=3;r++) {
            int check=0;
            for (int c = 1; c<=3; c++)
                if(gameBoard[r][c].M==marking)
                    check++;
            if(check==3)
                return true;
        }
        return false;
    }
    //helper func
    boolean checkDiagonal(mark marking,block[][] gameBoard)
    {
        int check=0;
        for(int r=1;r<=3;r++)
            if(gameBoard[r][r].M==marking)
                check++;
        if(check==3)
            return true;
        int r=1,c=3;
        check=0;
        while(r<=3)
        {
            if(gameBoard[r][c].M==marking)
                check++;
            r++;
            c--;
        }
        if(check==3)
            return true;
        return false;
    }

}
