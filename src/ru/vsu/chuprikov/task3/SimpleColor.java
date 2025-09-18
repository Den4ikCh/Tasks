package ru.vsu.chuprikov.task3;

public enum SimpleColor {
    BLACK,
    WHITE,
    GRAY,
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE;

    @Override
    public String toString() {
        switch (this) {
            case BLACK:
                return "Black";
            case WHITE:
                return "White";
            case GRAY:
                return "Gray";
            case RED:
                return "Red";
            case ORANGE:
                return "Orange";
            case YELLOW:
                return "Yellow";
            case GREEN:
                return "Green";
            default:
                return "Blue";
        }
    }
}
