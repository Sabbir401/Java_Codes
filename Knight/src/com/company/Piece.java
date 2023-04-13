package com.company;

public abstract class Piece {
    public Piece() {}

    public abstract PieceType getPieceType();
    public abstract String toChessNotation();

    public boolean isKnight() {
        return getPieceType() == PieceType.KNIGHT;
    }

    public boolean isBlank() {
        return getPieceType() == PieceType.BLANK;
    }
}
enum PieceType {
    KNIGHT, BLANK;
}
