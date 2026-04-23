import java.util.List;

class SVMSafetyModule implements SafetyModuleInterface {
    private double w1, w2, b;
    private double learningRate;
    private int epochs;
    private double lambda; // Regülarizasyon parametresi

    public SVMSafetyModule(double learningRate, int epochs, double lambda) {
        this.w1 = 0.0;
        this.w2 = 0.0;
        this.b = 0.0;
        this.learningRate = learningRate;
        this.epochs = epochs;
        this.lambda = lambda;
    }

    // Gradient Descent (Gradyan İnişi) ile Optimizasyon
    @Override
    public void train(List<Point> data) {
        for (int epoch = 0; epoch < epochs; ++epoch) {
            for (Point point : data) {
                // Şart kontrolü: y_i * (w * x_i + b) >= 1
                double condition = point.label * (w1 * point.x + w2 * point.y + b);

                if (condition >= 1) {
                    // Engel güvenli bölgenin dışında, sadece marjini maksimize et
                    w1 -= learningRate * (2 * lambda * w1);
                    w2 -= learningRate * (2 * lambda * w2);
                } else {
                    // Engel sınırın içinde, çizgiyi doğru yere it
                    w1 -= learningRate * (2 * lambda * w1 - point.label * point.x);
                    w2 -= learningRate * (2 * lambda * w2 - point.label * point.y);
                    b  -= learningRate * (-point.label);
                }
            }
        }
    }

    @Override
    public double predict(Point p) {
        return w1 * p.x + w2 * p.y + b;
    }

    @Override
    public void printEquation() {
        System.out.printf("Optimum Ayristirici Cizgi Denklemi: %.4f * x + %.4f * y + %.4f = 0%n", w1, w2, b);
    }
}