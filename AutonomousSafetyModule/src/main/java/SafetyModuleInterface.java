import java.util.List;

public interface SafetyModuleInterface {
    void train(List<Point> data);
    double predict(Point p);
    void printEquation();
}