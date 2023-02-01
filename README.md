# BÜYÜK VERİDE MULTITHREADING

Müşteri şikayetleri kayıtlarının tutulduğu bir veri seti içerisindeki benzer kayıtlar tespit edilecek ve tespit edilen kayıtlar masaüstü uygulamasında gösterilecektir.
Multithreading kullanarak benzerlik arama süresini düşürmek amaçlanmaktadır.


#### -Arama 1
![Arama 1](https://imgyukle.com/f/2023/02/01/Jdn6YH.png)

#### -Arama 2
![Arama 2](https://imgyukle.com/f/2023/02/01/Jdn7sf.png)

#### -Arama 3
![Arama 3](https://imgyukle.com/f/2023/02/01/JdJPnS.png)

#### -Threadler
![Threadler](https://imgyukle.com/f/2023/02/01/JdJRPQ.png)

#### -Sonuclar
![Sonuclar](https://imgyukle.com/f/2023/02/01/JdJrSe.png)

## İsterler:
1. Verilen veri seti istenen şekilde yeniden düzenlenmelidir.
2. Düzenlenmiş veri setindeki kayıtlar arasında benzerlik kontrolü yapılmalıdır. Kontrol
sırasında mutlaka multithreading kullanılmalıdır. Multithreading için kullanılacak
thread sayısı uygulama arayüzünden girilmelidir.
3. Her thread’in çalışma zamanı ve tüm thread’ler için toplam çalışma zamanı bilgileri
uygulama arayüzünde gösterilmelidir.
4. İstenilen sütun ya da sütunlar arasındaki girilen benzerlik oranı (threshold) ve üzerinde
benzerliğe sahip kayıtlar masaüstü uygulamasında gösterilmelidir.
5. Uygulamanızı sunmak üzere basit bir arayüz geliştirmeniz istenmektedir. Bu arayüz
aşağıdaki isterleri içermelidir:
• Benzerlik oranının (Threshold değeri) seçilebileceği / girilebileceği bir araç,
• Benzerliklerinin araştırılması istenen sütun veya sütunların seçilebileceği bir
araç,
• Kaç tane thread kullanılacağının seçilebileceği / girilebileceği bir araç,
• Her bir thread’in çalışma zamanını ve toplam çalışma zamanını gösteren araçlar
• Sonuçların açıkça ekranda gösterilebileceği bir araç.
6. Uygulamada aşağıdaki ve benzer senaryolardan elde edilen sonuçlar ekranda gösterilmelidir:
• Senaryo 1: Ürün (Product) sütununda %60 ve üzeri benzer olan kayıtları ekranda gösteriniz.
• Senaryo 2: Aynı ürünler (Product) için % 70 ve üzeri benzerlikteki konuları (Issue) içeren Şirket (Company) isimlerini ekranda gösteriniz.
• Senaryo 3: ‘Complaint Id’ = 3198084 olan şikayet kaydı için % 50 ve üzeri benzerlikteki konuları (issue) içeren kayıtları ekranda gösteriniz.
• Senaryo 4: 5 Thread ile Konular(Issue) sütununda %80 ve üzeri benzer olan kayıtları ekranda gösteriniz
