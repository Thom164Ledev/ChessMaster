package Main.Components.Pieces;

import Main.Components.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Location l,Player p) {
        super(l,p);
        this.type = Type.KING;
    }

    @Override
    public List<Location> canGo(Game game, Player player) {
        List<Location> kingCanGo = new ArrayList<>();
        return kingCanGo;
    }


    @Override
    public void kill() {

    }
}
