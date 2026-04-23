import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // OOP Polimorfizm: Arayüz üzerinden nesne örneği oluşturulması
        SafetyModuleInterface safetyModule = new SVMSafetyModule(0.01, 1000, 0.01);

        // Otonom araç sensörlerinden geldiği varsayılan dummy engel koordinatları
        List<Point> obstacles = new ArrayList<>();
        // Sol Engeller (Sınıf -1)
        obstacles.add(new Point(1.0, 2.0, -1));
        obstacles.add(new Point(2.0, 1.0, -1));
        obstacles.add(new Point(4.5, 4.5, -1));

        // Sağ Engeller (Sınıf 1)
        obstacles.add(new Point(6.0, 7.0, 1));
        obstacles.add(new Point(7.0, 6.0, 1));
        obstacles.add(new Point(15.0, 12.0, 1));

        System.out.println("Otonom Arac Guvenlik Modulu Egitiliyor...");
        safetyModule.train(obstacles);

        System.out.println("Egitim Tamamlandi.");
        safetyModule.printEquation();

        // Bellek yönetimi uyarısı: Java'da nesneler kapsam dışına çıkınca Garbage Collector
        // tarafından otomatik temizlenir. Bu durum "sıfır bellek sızıntısı" kuralını karşılar.
    }
}