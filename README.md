# JavaFX Simple Calculator

Bu proje, JavaFX kullanılarak geliştirilmiş basit bir hesap makinesi uygulamasıdır. Uygulama toplama, çıkarma, çarpma, bölme ve ondalıklı sayılarla işlem yapabilmektedir.

## Özellikler

- JavaFX ile tasarlanmış basit ve temiz arayüz
- Ekranda (TextField) girilen sayıların ve sonuçların gösterilmesi
- Temel işlemler:
  - Toplama (`+`)
  - Çıkarma (`-`)
  - Çarpma (`x`)
  - Bölme (`÷`)
- Ek tuşlar:
  - `AC` — Tümünü temizler, ekranı ve mevcut durumu sıfırlar
  - `←` — Geri alma, ekrandaki son karakteri siler
  - `.` — Ondalık sayı girişi
- Klavye desteği (0–9, `+ - * / .` ve Enter tuşu)

## Kurulum ve Çalıştırma

### Gereksinimler

- Java 21 (veya proje ayarlarına uygun bir Java sürümü)
- Maven

### Projeyi Çalıştırma

Proje klasörüne geçin:

```bash
cd demo11
```

Maven ile JavaFX uygulamasını başlatın:

```bash
mvn clean javafx:run
```

Bu komut, `HelloApplication` sınıfını çalıştırır ve JavaFX penceresinde hesap makinesini açar.

## Proje Yapısı

- `src/main/java/com/example/demo11/HelloApplication.java`  
  JavaFX arayüzünün ve hesaplama mantığının bulunduğu ana sınıf.
- `pom.xml`  
  Maven yapılandırması ve JavaFX bağımlılıkları.
- `src/main/java/module-info.java`  
  JavaFX modüllerini (`javafx.controls`, `javafx.fxml`) tanımlayan modül bildirimi.

## Lisans

Bu proje, MIT Lisansı ile lisanslanmıştır. Ayrıntılar için `LICENSE` dosyasına bakabilirsiniz.
