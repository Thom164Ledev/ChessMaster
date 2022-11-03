package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Location l,Player p) {
        super(l,p);
        this.type = Type.KNIGHT;
    }

    @Override
    public List<Location> canGo(Game game, Player player) {
        List<Location> knightCanGo = new ArrayList<>();
        if (Location.getPieceInLocation(new Location(l.getX() + 2,l.getY() + 1),player,game) == null){
            knightCanGo.add(new Location(l.getX() + 2,l.getY() + 1));
            //System.out.println(new Location(l.getX() + 2,l.getY() + 1).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() + 1,l.getY() + 2),player,game) == null){
            knightCanGo.add(new Location(l.getX() + 1,l.getY() + 2));
            //System.out.println(new Location(l.getX() + 1,l.getY() + 2).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() + 2,l.getY() -1),player,game) == null){
            knightCanGo.add(new Location(l.getX() + 2,l.getY() -1));
            //System.out.println(new Location(l.getX() + 2,l.getY() - 1).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() + 1,l.getY() -2),player,game) == null){
            knightCanGo.add(new Location(l.getX() + 1,l.getY() -2));
            //System.out.println(new Location(l.getX() + 1,l.getY() - 2).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() - 2,l.getY() + 1),player,game) == null){
            knightCanGo.add(new Location(l.getX() - 2,l.getY() + 1));
            //System.out.println(new Location(l.getX()- 2,l.getY() + 1).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() - 1,l.getY() + 2),player,game) == null){
            knightCanGo.add(new Location(l.getX() - 1,l.getY() +2));
            //System.out.println(new Location(l.getX() - 1,l.getY() + 2).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() - 2,l.getY() -1),player,game) == null){
            knightCanGo.add(new Location(l.getX() - 2,l.getY() -1));
            //System.out.println(new Location(l.getX() - 2,l.getY() - 1).toString());
        }
        if (Location.getPieceInLocation(new Location(l.getX() -1,l.getY() -2),player,game) == null){
            knightCanGo.add(new Location(l.getX() -1,l.getY() -2));
            //System.out.println(new Location(l.getX() - 1,l.getY() - 2).toString());
        }
        return knightCanGo;
    }

    @Override
    public void kill() {

    }
}
