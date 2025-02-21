# Teknik Gereksinim Dokümanı (TRD)

## 1. Genel Bilgiler

- **Proje Adı:** İlaç Hatırlatma ve Yönetim Uygulaması
- **Amaç:** Yaşlı bireylerin ilaçlarını zamanında ve doğru dozda almalarını sağlamak, bakıcıların ilaç takibini kolaylaştırmak ve telefon şarjının kritik seviyelere düşmesini engellemek.
- **Platform:** Android
- **Hedef Kitle:** Yaşlı bireyler (hasta) ve onların bakımını üstlenen kişiler (bakıcı).

## 2. Kullanılacak Teknolojiler

### Frontend (Kullanıcı Arayüzü)

- **Dil:** Kotlin
- **UI Framework:** Jetpack Compose
- **Tasarım Kütüphanesi:** Material Design Components
- **Navigasyon:** Jetpack Navigation Component
- **Erişilebilirlik:**
  - Büyük yazı tipleri
  - Yüksek kontrastlı renkler
  - Kolay dokunulabilir butonlar
  - Sesli geri bildirim

### Backend (Veri Yönetimi ve İş Mantığı)

- **Bulut Hizmeti:** Firebase
- **Veritabanı:** Firebase Firestore (NoSQL)
  - Gerçek zamanlı veri senkronizasyonu
  - Çevrimdışı erişim desteği
- **Alarm Sistemi:**
  - İlaç hatırlatıcıları ve şarj durumu uyarıları için cihazın yerel alarm API'leri kullanılacak. (FCM yerine)
  - Sürekli sesli ve görsel uyarılar (kullanıcı yanıt verene kadar).
- **AI Entegrasyonu (Gelecek Aşama):**
  - Firebase ML Kit veya TensorFlow Lite
  - İlaç fotoğraflarını analiz ederek doğru ilaç ve dozajı teyit etme

### Diğer Araçlar

- **Versiyon Kontrolü:** Git (GitHub veya GitLab)
- **Test Araçları:** Android Studio Emulator, Firebase Test Lab

## 3. Veri Yapısı (Firestore)

### Koleksiyonlar ve Belgeler

1.  **`users` Koleksiyonu:**
    -   Kullanıcı (hasta) bilgilerini saklar.
    -   Örnek Belge:

        ```json
        {
          "id": "user_001",
          "name": "Ahmet Yılmaz",
          "phone": "5551234567",
          "role": "hasta"
        }
        ```

2.  **`caregivers` Koleksiyonu:**
    -   Bakıcı bilgilerini saklar.
    -   Örnek Belge:

        ```json
        {
          "id": "caregiver_001",
          "name": "Ayşe Demir",
          "phone": "5559876543",
          "email": "ayse@example.com"
        }
        ```

3.  **`medications` Koleksiyonu:**
    -   İlaç bilgilerini saklar.
    -   Örnek Belge:

        ```json
        {
          "id": "med_001",
          "name": "Parol",
          "dosage": "500 mg",
          "start_date": "2025-01-01",
          "end_date": "2025-01-10",
          "schedule": ["08:00", "14:00", "20:00"],
          "photo": "parol_photo_url",
          "status": "active"
        }
        ```

4.  **`medication_history` Koleksiyonu:**
    -   İlaç alım geçmişini saklar.
    -   Örnek Belge:

        ```json
        {
          "id": "history_001",
          "medication_id": "med_001",
          "date": "2025-01-01",
          "time": "08:00",
          "status": "taken"
        }
        ```

## 4. Uygulama Özellikleri

### Temel Özellikler

1.  **İlaç Hatırlatıcı Alarmı:**
    -   Belirlenen ilaç saatlerinde cihazda sürekli sesli ve görsel alarm.
    -   Kullanıcı "Şimdi Al" veya "Daha Sonra Hatırlat" seçeneklerini kullanabilir.
    -   Alarm, kullanıcı yanıt verene kadar devam eder.
    -   Erteleme seçenekleri: 15 dakika, 30 dakika, 1 saat.
    -   2 saatten fazla erteleme durumunda bakıcıya bildirim.

2.  **Şarj Durumu Alarmı:**
    -   Cihazın pil seviyesi %25'in altına düştüğünde sürekli sesli ve görsel alarm.
    -   Her %5 düşüşte alarm tekrarlanır (%20, %15...).
    -   Şarj %15'e düştüğünde ve şarja takılmazsa bakıcıya konum bilgisi içeren uyarı mesajı. (İleriki aşamalarda)
    -   Gece uykudan önce (varsayılan 22:45) şarj hatırlatıcısı; 23:30'a kadar şarja takılmazsa bakıcıya bildirim. (İleriki aşamalarda)

3.  **İlaç Yönetimi:**
    -   **Sadece bakıcılar** ilaç ekleyebilir, düzenleyebilir veya silebilir.
    -   Hasta (yaşlı birey) ilaç bilgilerini değiştiremez.

4.  **İlaç Alındı Bildirimi:**
    -   Hasta, ilacı aldığını onayladığında bakıcıya otomatik olarak "ilaç alındı" mesajı gönderilir.

5.  **Fotoğraf Doğrulama (Gelecek Aşama):**
    -   Hasta, ilaçlarını almadan önce fotoğraf çeker.
    -   AI (Yapay Zeka) ile fotoğraf analiz edilerek doğru ilaç ve dozaj teyit edilir.

### Ek Özellikler (Gelecek Aşamalar)

-   Video görüşme ile uzaktan destek.
-   Gelişmiş raporlama ve analiz.

## 5. Alarm ve Bildirim Akışları

### İlaç Hatırlatıcı Alarmı

1.  Cihazın yerel alarm API'leri kullanılarak ilaç alma zamanı geldiğinde sürekli sesli ve görsel alarm tetiklenir.
2.  Kullanıcı "Şimdi Al" veya "Daha Sonra Hatırlat" seçeneklerinden birini seçer.
3.  İlaç alındı onayı verilirse:
    -   İlaç alım bilgisi `medication_history` koleksiyonuna kaydedilir.
    -   Bakıcıya "ilaç alındı" mesajı gönderilir.
4.  Erteleme süresi 2 saati aşarsa bakıcıya bildirim gönderilir.

### Şarj Durumu Alarmı

1.  Android'in `BatteryManager` API'si ile pil seviyesi sürekli kontrol edilir.
2.  Pil seviyesi %25'in altına düştüğünde sürekli sesli ve görsel alarm tetiklenir.
3.  Her %5 düşüşte alarm tekrarlanır.
4.  Pil %15'e düştüğünde ve cihaz şarja takılmamışsa, bakıcıya konum bilgisi içeren uyarı mesajı gönderilir. (İleriki aşamalarda)
5.  Gece 22:45'te şarj hatırlatıcısı; 23:30'a kadar şarja takılmazsa bakıcıya bildirim gönderilir. (İleriki aşamalarda)

## 6. Güvenlik

-   **Veri Güvenliği:**
    -   Firestore güvenlik kuralları ile kullanıcıların yalnızca kendi verilerine erişimi sağlanır.
    -   Bakıcılar, sadece sorumlu oldukları hastaların bilgilerini görebilir.
-   **Şifreleme:**
    -   Firebase, verileri hem aktarım sırasında (TLS) hem de depolama sırasında şifreler.

## 7. Performans ve Optimizasyon

-   **Offline Desteği:**
    -   Firebase Firestore'un offline özelliği sayesinde, internet bağlantısı olmadığında bile verilere erişilebilir.
- **AI Optimizasyonu (Gelecek Aşama):**
  - Fotoğraf analizi için hafif bir AI modeli (örneğin, TensorFlow Lite) kullanılır.

## 8. Test Planı

-   **Fonksiyonel Testler:**
    -   İlaç ekleme, düzenleme, silme işlemleri (sadece bakıcılar için).
    -   Alarm sistemlerinin (ilaç ve şarj) doğru zamanda çalışması.
    -   Bildirimlerin (ilaç alındı, şarj durumu) doğru kişilere ulaşması.
-   **Kullanıcı Testleri:**
    -   Yaşlı bireylerin uygulamayı kolaylıkla kullanıp kullanamadığının belirlenmesi.
    -   Arayüzün anlaşılırlığı ve erişilebilirliğinin değerlendirilmesi.
-   **AI Testleri (Gelecek Aşama):**
    -   Fotoğraf analizinin doğru ilaç ve dozajı teyit etme başarısı.
-   **Performans Testleri:**
    -   Uygulamanın pil tüketimi ve tepki süresi.

## 9. Sonraki Adımlar

1.  **Kullanıcı Akış Diyagramı (KAD):** Kullanıcıların uygulamada nasıl ilerleyeceğini görselleştiren diyagramın hazırlanması.
2.  **UI/UX Tasarımı:** Wireframe'ler ve detaylı tasarımların oluşturulması.
3.  **Kodlama ve Test:** Uygulamanın geliştirilmesi ve kapsamlı test süreçlerinden geçirilmesi.