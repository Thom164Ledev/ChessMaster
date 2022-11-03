package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rook extends Piece {
    public Rook(Location l,Player p) {
        super(l,p);
        this.type = Type.ROOK;
    }

    @Override
    public List<Location> canGo(Game game, Player player) {
        Player other = Player.BLACK;
        if (player == Player.BLACK) other = Player.WHITE;
        List<Location> rookCanGo = new ArrayList<>();
        //Check every location in y , -y, x, -x axis
        for (int i = l.getY() +1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(l.getX(),i), game) == null){
                rookCanGo.add(new Location(l.getX(),i));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(l.getX(),i), game)).player == other){
                    rookCanGo.add(new Location(l.getX(),i));
                }
                break;
            }
        }
        for (int i = l.getY() - 1; i > 0 ; i--) {
            if(Location.getPieceInLocation(new Location(l.getX(),i),game) == null){
                rookCanGo.add(new Location(l.getX(),i));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(l.getX(),i), game)).player == other){
                    rookCanGo.add(new Location(l.getX(),i));
                }
                break;
            }
        }
        for (int i = l.getX() +1; i < 9; i++) {
            if(Location.getPieceInLocation(new Location(i,l.getY()), game) == null){
                rookCanGo.add(new Location(i,l.getY()));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i,l.getY()), game)).player == other){
                    rookCanGo.add(new Location(i,l.getY()));
                }
                break;
            }
        }
        for (int i = l.getX() - 1; i > 0; i--) {
            if(Location.getPieceInLocation(new Location(i,l.getY()), game) == null){
                rookCanGo.add(new Location(i,l.getY()));
            }else {
                if(Objects.requireNonNull(Location.getPieceInLocation(new Location(i, l.getY()), game)).player == other){
                    rookCanGo.add(new Location(i,l.getY()));
                }
                break;
            }
        }
        return rookCanGo;
    }

    @Override
    public void kill() {

    }
}
