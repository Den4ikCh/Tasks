package ru.vsu.chuprikov.task3;

public class Parabola {
    double _a;
    double _b;
    double _c;
    boolean _isVertical;

    public Parabola(double x0, double y0, double a) {
        this(x0, y0, a, true);
    }

    public Parabola(double x0, double y0, double a, boolean isVertical) {
        _isVertical = isVertical;
        if (_isVertical) {
            _a = a;
            _b = x0 * (-2) * a;
            _c = y0 - Math.pow(x0, 2) * a - _b * x0;
        }
        else {
            _a = a;
            _b = y0 * (-2) * a;
            _c = x0 - Math.pow(y0, 2) * a - _b * y0;
        }
    }

    public boolean isPointInParabola(double x, double y) {
        if (_isVertical) {
            return y > Math.pow(x, 2) * _a + x * _b + _c;
        }
        return x > Math.pow(y, 2) * _a + y * _b + _c;
    }
}
