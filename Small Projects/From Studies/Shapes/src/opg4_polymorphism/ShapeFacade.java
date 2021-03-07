package opg4_polymorphism;

public class ShapeFacade {
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {

    }

    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    public String getShapeInfo(SHAPES shape, double... parametre) {
        ShapeInterface currentShape = null;
        switch (shape) {
            case CIRCLE:
                currentShape = new Circle(parametre[0]);
                break;
            case SQUARE:
                currentShape = new Square(parametre[0]);
                break;
            case ELLIPSE:
                currentShape = new Ellipse(parametre[0], parametre[1]);
                break;
            case RECTANGLE:
                currentShape = new Rectangle(parametre[0], parametre[1]);
        }
        return currentShape.toString();

    }

}
