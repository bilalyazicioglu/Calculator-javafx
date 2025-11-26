# JavaFX Basit Hesap Makinesi

Bu proje, JavaFX ve FXML kullanılarak (SceneBuilder ile tasarlanmış) basit bir hesap makinesi arayüzü ve denetleyicisini içerir. Uygulama toplama, çıkarma, çarpma, bölme ve ondalıklı sayılarla işlem yapabilir.

## Özellikler

- JavaFX `GridPane` ile tasarlanmış, görseldeki örneğe benzer sade arayüz
- Sonuçların ve girilen sayıların gösterildiği bir ekran (`TextField`)
- Temel işlemler:
  - Toplama (`+`)
  - Çıkarma (`-`)
  - Çarpma (`x`)
  - Bölme (`÷`)
- Ek tuşlar:
  - `AC` — Tümünü temizler, ekranı ve iç durumu sıfırlar
  - `←` — Geri alma, ekrandaki son karakteri siler
  - `.` — Ondalık sayı girişi
- Ondalıklı sayılarla işlem yapabilme

> Not: Hesaplama mantığı tamamen `CalculatorController` sınıfında tutulur, arayüz ise FXML dosyası üzerinden SceneBuilder ile düzenlenebilir.

## Kurulum ve Çalıştırma

### Gereksinimler

- Java 21 (veya `pom.xml` ile uyumlu bir Java sürümü)
- Maven

### Projeyi Çalıştırma

Proje klasörüne geçin ve Maven ile JavaFX uygulamasını başlatın:

```bash
mvn clean javafx:run
```

Bu komut, `com.example.demo11.HelloApplication` sınıfını çalıştırır ve JavaFX penceresinde hesap makinesini açar.

## Proje Yapısı

- `src/main/java/com/example/demo11/HelloApplication.java`  
  Uygulamanın giriş noktası; `calculator-view.fxml` dosyasını yükler ve sahneyi (`Stage`) oluşturur.
- `src/main/java/com/example/demo11/CalculatorController.java`  
  Tüm hesaplama mantığını, butonların `onAction` metodlarını ve ekran güncellemelerini içeren controller sınıfı.
- `src/main/resources/com/example/demo11/calculator-view.fxml`  
  SceneBuilder ile tasarlanmış hesap makinesi arayüzü (GridPane, butonlar, TextField vb.).
- `src/main/java/module-info.java`  
  JavaFX modüllerini (`javafx.controls`, `javafx.fxml`) açan modül bildirimi.
- `pom.xml`  
  Maven yapılandırması, JavaFX bağımlılıkları ve `javafx-maven-plugin` ayarları.

## SceneBuilder ile Açma

Arayüzü SceneBuilder ile düzenlemek için:

1. SceneBuilder'ı açın.
2. **Open Existing Document** menüsünden
   `src/main/resources/com/example/demo11/calculator-view.fxml` dosyasını seçin.
3. Butonların `onAction` özellikleri ve `fx:controller` alanı zaten `CalculatorController` ile eşleştirilmiştir.

## Lisans

Bu proje, MIT Lisansı ile lisanslanmıştır. Ayrıntılar için `LICENSE` dosyasına bakabilirsiniz.
