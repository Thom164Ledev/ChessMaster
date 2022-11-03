package Main.Components;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    public Location l;
    public boolean living;
    public Type type;
    public Player player;
    public boolean firstMove = true;

    public Piece(Location l,Player p){
        this.l = l;
        player = p;
    }
    public abstract List<Location> canGo(Game game,Player player);

    public List<Piece> canEat(Game game,Player player){
        Player other = Player.BLACK;
        if (player == Player.BLACK) other = Player.WHITE;
        List<Piece> pieceCanEat = new ArrayList<>();
        for (Location l: this.canGo(game, player)) {
            if(Location.getPieceInLocation(l,other,game) != null) pieceCanEat.add(Location.getPieceInLocation(l,other,game));
        }
        return pieceCanEat;
    }

    public abstract void kill();

    public void setLocation(Location l){
        this.l = l;
    }

    public Location getLocation(){
        return l;
    }
}
