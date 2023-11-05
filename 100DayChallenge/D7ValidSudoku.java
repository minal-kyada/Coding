// https://leetcode.com/problems/valid-sudoku/

import java.util.*;

class Solution {

    // private boolean validateBox(char[][] board, int sr, int er, int sc, int ec) {
    //     Set<Character> set = new HashSet<>();
    //     for (int i=sr; i<er; i++) {
    //         for (int j=sc; j<ec; j++) {
    //             if (board[i][j] != '.') {
    //                 if(!set.add(board[i/3][j/3])) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public boolean isValidSudoku(char[][] board) {
    //     // Approach 1: Brute force 
    //     //1. Traverse all rows to check for duplicates
    //     //2. Traverse all cols to check for duplicates 
    //     //3. Traverse all boxes to check for duplicates
    //     for (int i=0; i<9; i++) {
    //         Set<Character> rows = new HashSet<>();
    //         for (int j=0; j<9; j++) {
    //             if (board[i][j] != '.') {
    //                 if(!rows.add(board[i][j])) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }

    //     for (int j=0; j<9; j++) {
    //         Set<Character> cols = new HashSet<>();
    //         for (int i=0; i<9; i++) {
    //             if (board[j][i] != '.') {
    //                 if(!cols.add(board[j][i])) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }

    //     for (int sr=0; sr<9; sr+=3) {
    //         int er = sr+2;
    //         for (int sc=0; sc<9; sc+=3) {
    //             int ec = sc+2;
    //             return validateBox(board, sr, er, sc, ec);
    //         }
    //     }

    //     return true;

        //Approach 2: Optimised
        HashSet<String> seen = new HashSet();
        for(int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!seen.add(c + "found in row " + i) || 
                        !seen.add(c + "found in col " + j) ||
                        !seen.add(c + "found in box " + i/3 + "_" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}