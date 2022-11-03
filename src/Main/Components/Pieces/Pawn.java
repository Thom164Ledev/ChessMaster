package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Location l,Player p) {
        super(l,p);
        this.type = Type.PAWN;
    }

    @Override
    public List<Location> canGo(Game game,Player player) {
        Player other = Player.BLACK;
        if (player == Player.BLACK) other = Player.WHITE;
        List<Location> pawnCanGo = new ArrayList<>();
        if(game.whitePieces.contains(this)) {
            if (Location.getPieceInLocation(new Location(l.getX(), l.getY() - 1), game) == null) {
                pawnCanGo.add(new Location(l.getX(), l.getY() - 1));
                if (Location.getPieceInLocation(new Location(l.getX(), l.getY() - 2), game) == null && firstMove) {
                    pawnCanGo.add(new Location(l.getX(), l.getY() - 2));
                }
            }
        }else {
            if (Location.getPieceInLocation(new Location(l.getX(), l.getY() + 1), game) == null) {
                pawnCanGo.add(new Location(l.getX(), l.getY() + 1));
                if (Location.getPieceInLocation(new Location(l.getX(), l.getY() + 2), game) == null && firstMove) {
                    pawnCanGo.add(new Location(l.getX(), l.getY() + 2));
                }
            }
        }
        return pawnCanGo;
    }

    @Override
    public void kill() {

    }
}
