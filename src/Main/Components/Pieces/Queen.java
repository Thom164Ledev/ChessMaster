package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Queen extends Piece {

    public Queen(Location l,Player p) {
        super(l,p);
        this.type = Type.QUEEN;
    }

    @Override
    public List<Location> canGo(Game game, Player player) {
        Player other = Player.BLACK;
        if (player == Player.BLACK) other = Player.WHITE;
        List<Location> queenCanGo = new ArrayList<>();
        for (int i = l.getY() +1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(l.getX(),i), game) == null){
                queenCanGo.add(new Location(l.getX(),i));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(l.getX(),i), game)).player == other){
                    queenCanGo.add(new Location(l.getX(),i));
                }
                break;
            }
        }
        for (int i = l.getY() - 1; i > 0 ; i--) {
            if(Location.getPieceInLocation(new Location(l.getX(),i),game) == null){
                queenCanGo.add(new Location(l.getX(),i));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(l.getX(),i), game)).player == other){
                    queenCanGo.add(new Location(l.getX(),i));
                }
                break;
            }
        }
        for (int i = l.getX() +1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(i,l.getY()), game) == null){
                queenCanGo.add(new Location(i,l.getY()));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i,l.getY()), game)).player == other){
                    queenCanGo.add(new Location(i,l.getY()));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i,l.getY()), game) == null){
                queenCanGo.add(new Location(i,l.getY()));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY()), game)).player == other){
                    queenCanGo.add(new Location(i,l.getY()));
                }
                break;
            }
        }
        for (int i = l.getX() + 1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())),game) == null){
                queenCanGo.add(new Location(i, l.getY() + (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())), game)).player == other){
                    queenCanGo.add(new Location(i, l.getY() + (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() + 1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())),game) == null){
                queenCanGo.add(new Location(i, l.getY() - (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())), game)).player == other){
                    queenCanGo.add(new Location(i, l.getY() - (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())),game) == null){
                queenCanGo.add(new Location(i, l.getY() + (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())), game)).player == other){
                    queenCanGo.add(new Location(i, l.getY() + (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())),game) == null){
                queenCanGo.add(new Location(i, l.getY() - (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())), game)).player == other){
                    queenCanGo.add(new Location(i, l.getY() - (i - l.getX())));
                }
                break;
            }
        }
        return queenCanGo;
    }


    @Override
    public void kill() {

    }
}
