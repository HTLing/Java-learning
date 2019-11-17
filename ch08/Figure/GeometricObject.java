package Figure;
// @Package : Figure
// @Time    : 2019/11/14 22:42
// @Author  : 星空糖
// @File    : GeometricObject.java

enum Color {
    BLUE, RED, GREEN, YELLOW, BLANK, WHITE, TRANSPARENT;

    static public Color[] Colors = {BLUE, RED, GREEN, YELLOW, BLANK, WHITE};

    static public Color value(int num) {
        try {
            return Colors[num];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("超过了范围哦，默认为透明的。");
            return Color.TRANSPARENT;
        }
    }
}

abstract class GeometricObject {
    private boolean isFilled;
    private Color ColorName;

    GeometricObject() {
        this.isFilled = false;
        this.ColorName = Color.TRANSPARENT;
    }

    GeometricObject(boolean filled, Color name) {
        this.isFilled = filled;
        this.ColorName = name;
    }

    boolean Filled() { return isFilled; }

    Color getColorName() { return ColorName; }
}
