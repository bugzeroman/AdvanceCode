package edu.yuwen.dp.structure.flyweight.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * 7.享元模式（结构型）
 * 
 * 
 *
 * Demo:中国象棋，32个棋子设计为享元类（不可变类），游戏大厅中百万棋局可以节省内存
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));
        // ...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        // ...省略...
    }
}