package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bishop extends Piece {
    public Bishop(Location l,Player p) {
        super(l,p);
        this.type = Type.BISHOP;
    }

    @Override
    public List<Location> canGo(Game game, Player player) {
        Player other = Player.BLACK;
        if (player == Player.BLACK) other = Player.WHITE;
        List<Location> bishopCanGo = new ArrayList<>();
        for (int i = l.getX() + 1; i < 8; i++) {
            if(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())),game) == null){
                bishopCanGo.add(new Location(i, l.getY() + (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())), game)).player == other){
                    bishopCanGo.add(new Location(i, l.getY() + (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() + 1; i < 8; i++) {
            if(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())),game) == null){
                bishopCanGo.add(new Location(i, l.getY() - (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())), game)).player == other){
                    bishopCanGo.add(new Location(i, l.getY() - (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())),game) == null){
                bishopCanGo.add(new Location(i, l.getY() + (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() + (i - l.getX())), game)).player == other){
                    bishopCanGo.add(new Location(i, l.getY() + (i - l.getX())));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())),game) == null){
                bishopCanGo.add(new Location(i, l.getY() - (i - l.getX())));
            }else{
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY() - (i - l.getX())), game)).player == other){
                    bishopCanGo.add(new Location(i, l.getY() - (i - l.getX())));
                }
                break;
            }
        }
        return bishopCanGo;
    }

    @Override
    public void kill() {

    }
}
