package Main.Components;

import Main.Components.Pieces.*;
import Main.Main;
import jdk.jshell.execution.LocalExecutionControl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    public GameState gameState;
    public List<Piece> blackPieces = new ArrayList<>();
    public List<Piece> whitePieces = new ArrayList<>();
    public List<Location> markers = new ArrayList<>();
    private Scanner in = new Scanner(System.in);
    Image blackPawn;
    Image whitePawn;
    Image blackRook;
    Image whiteRook;
    Image blackKnight;
    Image whiteKnight;
    Image blackBishop;
    Image whiteBishop;
    Image whiteKing;
    Image blackKing;
    Image blackQueen;
    Image whiteQueen;

    {
        try {
            blackPawn = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackPawn.png"));
            whitePawn = ImageIO.read(new File(Main.desktopPath + "ChessPieces//WhitePawn.png"));
            blackRook = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackRook.png"));
            whiteRook = ImageIO.read(new File(Main.desktopPath + "ChessPieces/WhiteRook.png"));
            blackKnight = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackKnight.png"));
            whiteKnight = ImageIO.read(new File(Main.desktopPath + "ChessPieces//WhiteKnight.png"));
            blackBishop = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackBishop.png"));
            whiteBishop = ImageIO.read(new File(Main.desktopPath + "ChessPieces//WhiteBishop.png"));
            whiteKing = ImageIO.read(new File(Main.desktopPath + "ChessPieces//WhiteKing.png"));
            blackKing = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackKing.png"));
            whiteQueen = ImageIO.read(new File(Main.desktopPath + "ChessPieces//WhiteQueen.png"));
            blackQueen = ImageIO.read(new File(Main.desktopPath + "ChessPieces//BlackQueen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;


    public Game() {
        gameState = GameState.START;
        placeWhitePieces();
        placeBlackPieces();
    }

    public void placeBlackPieces() {
        Player p = Player.BLACK;
        for (int i = 1; i < 9; i++) {
            blackPieces.add(new Pawn(new Location(i,2),p));
        }
        blackPieces.add(new Rook(new Location(1,1),p));
        blackPieces.add(new Rook(new Location(8,1),p));
        blackPieces.add(new Knight(new Location(2,1),p));
        blackPieces.add(new Knight(new Location(7,1),p));
        blackPieces.add(new Bishop(new Location(3,1),p));
        blackPieces.add(new Bishop(new Location(6,1),p));
        blackPieces.add(new Queen(new Location(5,4),p));
        blackPieces.add(new King(new Location(5,1),p));
    }

    public void placeWhitePieces(){
        Player p = Player.WHITE;
        for (int i = 1; i < 9; i++) {
            whitePieces.add(new Pawn(new Location(i,7),p));
        }
        whitePieces.add(new Rook(new Location(1,8),p));
        whitePieces.add(new Rook(new Location(8,8),p));
        whitePieces.add(new Knight(new Location(4,5),p));
        whitePieces.add(new Knight(new Location(7,8),p));
        whitePieces.add(new Bishop(new Location(3,8),p));
        whitePieces.add(new Bishop(new Location(6,8),p));
        whitePieces.add(new Queen(new Location(4,8),p));
        whitePieces.add(new King(new Location(5,8),p));
    }

    public void drawWhitePieces(Graphics g){
        for (Piece p : whitePieces) {
            int x = p.getLocation().getX() * 40 -40;
            int y = p.getLocation().getY() * 40 - 40;
            if(p.type == Type.PAWN){
                g.drawImage(whitePawn, x,y,40, 40, null);
            }else if(p.type == Type.ROOK){
                g.drawImage(whiteRook, x,y, 40, 40,null);
            }else if(p.type == Type.KNIGHT){
                g.drawImage(whiteKnight, x,y, 40, 40,null);
            }else if(p.type == Type.BISHOP){
                g.drawImage(whiteBishop, x,y, 40, 40,null);
            }else if(p.type == Type.KING){
                g.drawImage(whiteKing, x,y, 40, 40,null);
            }else if(p.type == Type.QUEEN){
                g.drawImage(whiteQueen, x,y, 40, 40,null);
            }
        }
    }

    public void drawBlackPieces(Graphics g){
        for (Piece p : blackPieces) {
            int x = p.getLocation().getX() * 40 -40;
            int y = p.getLocation().getY() * 40 - 40;
            if(p.type == Type.PAWN){
                g.drawImage(blackPawn, x,y, 40, 40,null);
            }else if(p.type == Type.ROOK){
                g.drawImage(blackRook, x,y, 40, 40,null);
            }else if(p.type == Type.KNIGHT){
                g.drawImage(blackKnight, x,y, 40, 40,null);
            }else if(p.type == Type.BISHOP){
                g.drawImage(blackBishop, x,y, 40, 40,null);
            }else if(p.type == Type.KING){
                g.drawImage(blackKing, x,y, 40, 40,null);
            }else if(p.type == Type.QUEEN){
                g.drawImage(blackQueen, x,y, 40, 40,null);
            }
        }
    }

    public void play(){
        if(gameState == GameState.WHITE){
            Location l1 = Location.toLocation(in.nextLine());
            if(Location.getPieceInLocation(l1, Player.WHITE, this) != null){
                markers.addAll(Objects.requireNonNull(Location.getPieceInLocation(l1, Player.WHITE, this)).canGo(this, Player.WHITE));
                System.out.println("can go :" + markers.toString());
                System.out.println("can eat :" + Objects.requireNonNull(Location.getPieceInLocation(l1, Player.WHITE, this)).canEat(this,Player.WHITE));
                System.out.println("can be eaten by :" +  Location.canBeEatenBy(Location.toLocation("d5"), this, Player.WHITE));
            }
            Location l2 = Location.toLocation(in.nextLine());
            Piece p = null;
            if(Location.getPieceInLocation(l2,this) == null && p.canGo(this,Player.WHITE).contains(l2)){
                p = Location.getPieceInLocation(l1, Player.WHITE, this);
                whitePieces.remove(p);
                Objects.requireNonNull(p).setLocation(l2);
                whitePieces.add(p);
            }
            if(p == null) {
                System.out.println("There is nothing in " + l1.toString());
            }
            gameState = GameState.BLACK;

        }else if(gameState == GameState.BLACK){

            gameState = GameState.WHITE;
        }
    }
}
