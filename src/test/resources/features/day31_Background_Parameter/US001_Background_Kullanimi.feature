Feature: US001_Amazon_Sayfasinda_Urun_Aratma

  #Classlarımızda kullandığımız @Before gibi burada da her Scenario'dan önce @Background yapısı çalışır
  Background: Kullanici_Amazon_Sayfasina_Gider
    Given kullanici_amazon_sayfasina_gider

    Scenario:  TC01_Amazon_Sayfasinda_Selenium_Aratma
      Then arama_kutusunda_Selenium_aratir


    Scenario: TC02_Amazon_Sayfasinda_Java_Aratma
      When arama_kutusunda_java_aratir

    Scenario: TC03_Amazon_Sayfasinda_SQL_Aratma
      And arama_kutusunda_SQL_aratir
      And sayfayi_kapatir

