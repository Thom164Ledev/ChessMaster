package Main.Components;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y){
        setX(x);
        setY(y);
        if(x > 8 || x <= 0 || y > 8 || y <= 0) {
            //System.out.println(this.toString());
        }
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        String letter = "";
        if(x == 1) letter = "a";
        if(x == 2) letter = "b";
        if(x == 3) letter = "c";
        if(x == 4) letter = "d";
        if(x == 5) letter = "e";
        if(x == 6) letter = "f";
        if(x == 7) letter = "g";
        if(x == 8) letter = "h";
        return letter + y;
    }

    @Override
    public boolean equals(Object obj) {
        Location l = (Location) obj;
        return this.x == l.getX() && this.y == l.getY();
    }

    public static Location toLocation(String s){
        int y = Integer.parseInt(String.valueOf(s.charAt(1)));
        int x = 0;
        char cx = s.charAt(0);
        if(String.valueOf(cx).equals("a")) x = 1;
        if(String.valueOf(cx).equals("b")) x = 2;
        if(String.valueOf(cx).equals("c")) x = 3;
        if(String.valueOf(cx).equals("d")) x = 4;
        if(String.valueOf(cx).equals("e")) x = 5;
        if(String.valueOf(cx).equals("f")) x = 6;
        if(String.valueOf(cx).equals("g")) x = 7;
        if(String.valueOf(cx).equals("h")) x = 8;
        return new Location(x,y);
    }

    public static Piece getPieceInLocation(Location l,Game game){
        if(Location.check(l)) {
            for (int i = 0; i < 16; i++) {
                if (game.whitePieces.get(i).getLocation().equals(l)) {
                    return game.whitePieces.get(i);
                }
            }
            for (int i = 0; i < 16; i++) {
                if (game.blackPieces.get(i).getLocation().equals(l)) {
                    return game.blackPieces.get(i);
                }
            }
            return null;
        }
        return null;
    }
    public static Piece getPieceInLocation(Location l, Player player, Game game){
        if(Location.check(l)) {
            if (player.equals(Player.WHITE)) {
                for (int i = 0; i < 16; i++) {
                    if (game.whitePieces.get(i).getLocation().equals(l)) {
                        return game.whitePieces.get(i);
                    }
                }
            } else {
                for (int i = 0; i < 16; i++) {
                    if (game.blackPieces.get(i).getLocation().equals(l)) {
                        return game.blackPieces.get(i);
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static boolean check(Location l){
        int x = l.getX();
        int y = l.getY();
        return x < 9 && x > 0 && y < 9 && y > 0;
    }

    public static List<Piece> canBeEatenBy(Location l, Game game, Player player){
        List<Piece> canBeEatenBy = new ArrayList<>();
        if(player == Player.WHITE){
            for (Piece p: game.blackPieces) {
                if(p.canGo(game,Player.BLACK).contains(l)){
                    canBeEatenBy.add(p);
                }
            }
        }else if(player == Player.BLACK){

        }
        return canBeEatenBy;
    }



}
