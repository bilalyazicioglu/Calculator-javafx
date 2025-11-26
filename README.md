# JavaFX Basit Hesap Makinesi
JavaFX lab uygulamasıdır.

## Kurulum ve Çalıştırma

### Gereksinimler

- Java 21 (veya `pom.xml` ile uyumlu bir Java sürümü)
- Maven

### Projeyi Çalıştırma

Proje klasörüne geçin ve Maven ile JavaFX uygulamasını başlatın:

```bash
mvn clean javafx:run
```

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

## Lisans

Bu proje, MIT Lisansı ile lisanslanmıştır. Ayrıntılar için `LICENSE` dosyasına bakabilirsiniz.
