# AutonomousSafetyModule 

Bu proje, **Algoritma Analizi ve Tasarımı** dersi Final Değerlendirme Ödevi -3 kapsamında geliştirilmiştir. Otonom bir araç navigasyon sistemi için, iki farklı engel grubunu birbirinden "en geniş güvenlik koridoru" (maksimum marjin) ile ayıran bir güvenlik modülü simülasyonudur.

## Proje Hakkında
Sistem, 2 boyutlu düzlemde koordinatları verilen engelleri analiz eder ve aracın geçebileceği en güvenli yolu (optimum ayırıcı çizgi) hesaplar. Rastgele bir ayrım yerine, her iki sınıfa da en uzak mesafede duran matematiksel olarak kanıtlanabilir en iyi sonucu bulur.

## Matematiksel Model: Hard Margin SVM
Projenin temelinde **Sert Marjinli Destek Vektör Makineleri (Hard Margin SVM)** algoritması yatmaktadır.

- **Hiperdüzlem Denklemi:** $w \cdot x + b = 0$
- **Marjin Maksimizasyonu:** Marjin mesafesi $\frac{2}{\|w\|}$ formülü ile hesaplanır.
- **Optimizasyon:** $\frac{1}{2}\|w\|^2$ değeri minimize edilerek, engellerden en uzak (en güvenli) sınır çizgisi elde edilir.
- **Global Minimum:** Problem dışbükey (convex) bir karesel optimizasyon problemi olduğu için algoritma her zaman en iyi (global) çözümü bulur.

## Yazılım Mimarisi ve Tasarım Prensipleri
Ödevin "Yazılım Mimarisi" kriterlerine uygun olarak sistem modüler ve izole bir yapıda tasarlanmıştır:

- **SOLID & OOP:** `SafetyModuleInterface` arayüzü (interface) kullanılarak **Bağımlılıkların Tersine Çevrilmesi (Dependency Inversion)** prensibi uygulanmıştır.
- **Polimorfizm:** İş mantığı ve veri yapıları birbirinden ayrılmış, sistem genişletilebilir hale getirilmiştir.
- **Sıfır Bellek Sızıntısı:** Java'nın **Garbage Collector** yapısı ve doğru nesne referans yönetimi sayesinde otonom sistemlerde hayati önem taşıyan bellek güvenliği %100 sağlanmıştır.

## Algoritma Analizi (Big-O)
Modelin çözümü için Gradyan İnişi (Gradient Descent) tabanlı bir optimizasyon kullanılmıştır.

- **Zaman Karmaşıklığı:** $O(N \cdot T)$
  - $N$: Veri noktası (engel) sayısı.
  - $T$: İterasyon (epoch) sayısı.
- **Alan Karmaşıklığı:** $O(N)$ (Koordinatların bellekte tutulma maliyeti).

## Kurulum ve Çalıştırma
Proje **Maven** build sistemi kullanılarak yapılandırılmıştır.

1. Projeyi bilgisayarınıza indirin veya klonlayın.
2. `pom.xml` dosyasını IntelliJ IDEA veya herhangi bir Maven destekli IDE ile açın.
3. Bağımlılıkların (JUnit vb.) yüklenmesini bekleyin.
4. `src/main/java/Main.java` dosyasını çalıştırarak otonom güvenlik modülünün eğitimini ve sonuçlarını görebilirsiniz.

## Yazar
- **İsim Soyisim:** Fırat Bilal Coşkun
- **Ders:** Algoritma Analizi ve Tasarımı
