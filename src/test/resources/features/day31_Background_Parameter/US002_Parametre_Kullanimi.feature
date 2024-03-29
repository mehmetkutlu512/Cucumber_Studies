Feature: US002_Amazon_Sayfasinda_Urun_Aratma

  #Classlarımızda kullandığımız @Before gibi burada da her Scenario'dan önce @Background yapısı çalışır
  Background: Kullanici_Amazon_Sayfasina_Gider
    Given kullanici_amazon_sayfasina_gider
  #Featute file'da birden fazla ürün aratmak için her ürün için yeni bir method oluşturmak gerekir.
  #Dolayısıyla stepDefinition clasında çok fazla method oluşturmuş oluruz.
  #Tek bir parametreli method oluşturup bunun üstesinden gelebiliriz.
    #Bunun için feature file'da aratmak istediğim metni  " " tırnak içinde yazarsak stepDefinition class'ında bize
  #parametreli method oluşturur. Böylece bu methodu kullanarak istediğimiz kadar metin aratabiliriz.

  Scenario:  TC01_Amazon_Sayfasinda_Selenium_Aratma
    Then arama_kutusunda_"Selenium"_aratir
    And kullanici 3 saniye bekler


  Scenario:  TC02_Amazon_Sayfasinda_giyhub_Aratma
    Then arama_kutusunda_"github"_aratir
    And kullanici 3 saniye bekler

  Scenario:  TC03_Amazon_Sayfasinda_Samsung_Aratma
    Then arama_kutusunda_"samsung"_aratir
    And kullanici 2 saniye bekler

  Scenario:  TC04_Amazon_Sayfasinda_Nokia_Aratma
    Then arama_kutusunda_"nokia"_aratir
    And kullanici 2 saniye bekler
    And sayfayi_kapatir

