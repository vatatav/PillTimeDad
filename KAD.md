graph LR
    A[Ana Sayfa] --> B{İlaç Hatırlatıcısı Aktif Mi?};

    B -- Evet --> C[İlaç Alım Uyarısı<br>Sesli/Görsel];
    C --> D1{Şarj Düzeyi Kontrolü};
    D1 -- Şarj >= %25 --> E[İlaç Fotoğrafı Çekme];
    D1 -- Şarj < %25 --> D2[Şarj Uyarısı<br>Sesli/Görsel];
    D2 --> D3{Şarj Takıldı Mı?};
    D3 -- Evet --> E;
    D3 -- Hayır, 5dk Sonra --> D2;
    D3 -- Hayır, %5 Düşüş --> D4{Şarj %15'in Altında Mı?};
    D4 -- Evet --> D5[Bakıcıya Konum Bilgisi<br>İçeren Uyarı Mesajı];
    D4 -- Hayır --> D2;

    E --> F{Fotoğraf Analizi};
    F -- Doğru İlaç/Dozaj --> G[İlaç Alındı Onayı<br>Bakıcıya Mesaj];
    F -- Yanlış İlaç/Dozaj --> I[Uyarı ve Düzeltme İsteği<br>Sesli/Görsel];
    G --> H[İlaç Alım Bilgisi Kaydı<br>medication_history];
    H --> A;
    I --> J{Tekrar Fotoğraf Çekme};
    J --> F;
    I -- Birkaç Deneme Sonucu<br>Düzeltme Yapılmazsa --> K[Bakıcıyla İletişime Geç<br>Uyarı Mesajı];
    K --> A;

    B -- Hayır --> L{Şarj Düzeyi Kontrolü};
    L -- Şarj >= %25 --> A;
    L -- Şarj < %25 --> M[Şarj Uyarısı<br>Sesli/Görsel];
    M --> N{Şarj Takıldı Mı?};
    N -- Evet --> A;
    N -- Hayır, 5dk Sonra --> M;
    N -- Hayır, %5 Düşüş --> O{Şarj %15'in Altında Mı?};
    O -- Evet --> P[Bakıcıya Konum Bilgisi<br>İçeren Uyarı Mesajı];
    O -- Hayır --> M;

    subgraph Bakıcı Akışı
        A1[Bakıcı Girişi] --> B1{Hasta Seçimi};
        B1 --> C1[Hasta İlaç Listesi];
        C1 --> D1_1{İlaç Ekle/Düzenle/Sil};
        D1_1 --> C1;
        C1 --> E1[İlaç Alım Geçmişi];
        E1 --> C1;
    end

    A -.-> A1;