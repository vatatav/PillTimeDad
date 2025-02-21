# Ürün Gereksinimleri Dokümanı (PRD)

## 1. Genel Bakış

- **Ürün Adı:** İlaç Hatırlatma ve Yönetim Uygulaması
- **Amaç:** Yaşlı bireylerin ilaçlarını zamanında ve doğru dozda almalarını sağlamak, bakıcıların ilaç takibini kolaylaştırmak ve telefon şarjının kritik seviyelere düşmesini engellemek.
- **Hedef Kitle:**
    - **Birincil Kullanıcılar:** İlaçlarını takip etmekte zorlanan yaşlı bireyler.
    - **İkincil Kullanıcılar:** Yaşlı bireylerin bakımını üstlenen aile üyeleri veya profesyonel bakıcılar.

## 2. Hedefler

- Yaşlı bireylerin ilaçlarını zamanında ve doğru dozda almalarını sağlamak.
- İlaç takibini kolaylaştırarak bakıcıların iş yükünü azaltmak.
- Kullanıcıların (yaşlı bireylerin) telefonlarının şarjının bitmesini engelleyerek sürekli iletişim halinde olmalarını sağlamak.
- Kullanıcı dostu ve erişilebilir bir arayüz ile yaşlı bireylerin teknolojiyi kolayca kullanabilmelerini sağlamak.

## 3. Temel Özellikler

1.  **İlaç Hatırlatıcı Alarmı:**
    - Belirlenen ilaç saatlerinde kullanıcıya (yaşlı birey) sürekli sesli ve görsel alarm ile hatırlatma yapar.
    - Kullanıcı, ilacı alma veya erteleme seçeneğine sahiptir ("Şimdi Al" veya "Daha Sonra Hatırlat").
    - Alarm, kullanıcı yanıt verene kadar çalmaya devam eder.
    - Erteleme süresi belirli bir limiti aşarsa (örneğin, 2 saat) bakıcıya bildirim gönderilir.

2.  **Şarj Durumu Alarmı:**
    - Telefonun şarj seviyesi kritik bir düzeye (%25) düştüğünde kullanıcıya sürekli sesli ve görsel alarm ile uyarı verir.
    - Şarj seviyesi belirli aralıklarla (örneğin, her %5 düşüşte) alarmı tekrarlar.
    - Şarj seviyesi çok kritik bir düzeye (%15) düştüğünde ve kullanıcı telefonu şarja takmazsa, bakıcıya konum bilgisi içeren bir uyarı mesajı gönderilir. (Bu özellik, ileriki aşamalarda eklenebilir.)
    - Gece yatmadan önce (örneğin, 22:45'te) şarj hatırlatıcısı devreye girer; kullanıcı 23:30'a kadar telefonu şarja takmazsa bakıcıya bildirim gönderilir. (Bu özellik, ileriki aşamalarda eklenebilir.)

3.  **İlaç Yönetimi (Sadece Bakıcılar İçin):**
    - Bakıcılar, uygulama üzerinden yeni ilaç ekleyebilir, mevcut ilaçları düzenleyebilir veya silebilir.
    - İlaçların adı, dozu, kullanım sıklığı (saatleri) ve başlangıç/bitiş tarihleri gibi bilgiler girilebilir.
    - Yaşlı bireyler (birincil kullanıcılar) ilaç bilgilerini değiştiremez veya silemez.

4.  **AI Destekli Fotoğraf Doğrulama (İleriki Aşamalar):**
    - Kullanıcı (yaşlı birey), ilaçlarını almadan önce ilaçların fotoğrafını çeker.
    - Uygulama, yapay zeka (AI) kullanarak çekilen fotoğrafı analiz eder.
    - Doğru ilaçların, doğru dozda olup olmadığını teyit eder.
    - Yanlış ilaç veya dozaj durumunda kullanıcıyı uyarır.

5.  **İlaç Alım Geçmişi:**
    - Kullanıcı (yaşlı birey), aldığı ilaçları ve alım zamanlarını içeren bir geçmiş listesini görüntüleyebilir.
    - Bakıcılar da bu geçmişi görüntüleyebilir.

6.  **Bakıcı Bildirimleri:**
    - İlaç hatırlatıcılarının sürekli ertelenmesi veya şarjın kritik seviyede olması gibi durumlarda bakıcılara bildirim gönderilir.
    - Kritik durumlarda (örneğin, şarjın çok düşük olması), bildirimler kullanıcının (yaşlı bireyin) konum bilgisini içerebilir. (Bu özellik, ileriki aşamalarda eklenebilir.)

7.  **İlaç Alındı Mesajı:**
    - Her ilaç alımında, kullanıcının ilacı aldığını onaylaması durumunda bakıcılara otomatik olarak "ilaç alındı" mesajı gönderilir.

## 4. Kullanıcı Etkileşimi

- **Yaşlı Bireyler (Birincil Kullanıcılar):**
    - Büyük ve okunaklı yazı tipleri, yüksek kontrastlı renkler ve basit bir arayüz ile kolay kullanım hedeflenir.
    - İlaç hatırlatıcıları ve şarj uyarıları, sesli ve görsel alarmlar ile desteklenir.
    - İlaç alımı onayı, basit bir "Şimdi Al" butonu ile yapılır.

- **Bakıcılar (İkincil Kullanıcılar):**
    - İlaç ekleme, düzenleme ve silme işlemleri için yetkilendirilirler.
    - Yaşlı bireyin ilaç alım geçmişini ve uyarıları takip edebilirler.
    - Uygulama üzerinden bildirimler alırlar.

## 5. Başarı Ölçütleri

- **Kullanıcı Benimsemesi:** Uygulamanın belirli bir süre içinde (örneğin, ilk 3 ayda) belirli sayıda yaşlı birey ve bakıcı tarafından aktif olarak kullanılması.
- **İlaç Uyum Oranı:** Yaşlı bireylerin ilaçlarını zamanında ve doğru dozda alma oranının artması (örneğin, %90'ın üzerine çıkması).
- **Bakıcı Memnuniyeti:** Bakıcıların uygulamayı kullanışlı bulma ve ilaç takibinde kendilerine yardımcı olduğunu belirtme oranı (örneğin, %80'in üzerinde olması).
- **Teknik Performans:** Uygulamanın kararlı çalışması, hataların minimumda tutulması ve pil tüketiminin optimize edilmesi.

## 6. Gelecek Geliştirmeler (İleriki Aşamalar)

- **Görüntülü Görüşme:** İlaçların bulunması veya kullanımıyla ilgili sorun yaşayan yaşlı bireylerin, bakıcıları ile uygulama üzerinden görüntülü görüşme yapabilmesi.
- **Gelişmiş Raporlama:** İlaç alım geçmişi, uyarılar ve diğer verilerin daha detaylı raporlar halinde sunulması.
- **Çoklu Dil Desteği:** Uygulamanın farklı dillerde kullanılabilmesi.
- **Akıllı Saat Entegrasyonu:** İlaç hatırlatıcılarının ve şarj uyarılarının akıllı saatler üzerinden de takip edilebilmesi.