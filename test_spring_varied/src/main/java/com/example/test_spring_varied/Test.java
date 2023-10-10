package com.example.test_spring_varied;

public class Test {
    public static void main(String[] args) {
        winnerOfGame("AAABABB");
    }

    public static boolean winnerOfGame(String colors) {
        int n = colors.length();

        // Создаем массив, хранящий, может ли игрок сделать ход на данной позиции.
        boolean[] canRemove = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            canRemove[i] = colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A';
            canRemove[i] |= colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B';
        }

        // Если у игрока нет ходов, он проигрывает.
        if (!canRemove[0] && !canRemove[n - 1]) {
            return false;
        }

        // Игрок, который может сделать ход первым, выигрывает.
        return canRemove[0] || canRemove[n - 1];
    }
}
