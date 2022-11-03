package Main.Components;

public enum Type {
    PAWN("Pawn"),ROOK("Rook"),KNIGHT("Knight"),BISHOP("Bishop"),QUEEN("Queen"),KING("King");

    public String name;

    Type(String name) {
        this.name = name;
    }
}
