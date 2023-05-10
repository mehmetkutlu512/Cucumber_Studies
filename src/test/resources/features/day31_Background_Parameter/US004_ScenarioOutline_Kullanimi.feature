Feature: Google_Search

  Background: Kullanici_Google_Anasayfasina_Gider
    Given kullanici_"googleUrl"_sayfasina_gider

  # Scenario Outline: TestNG deki @DataProvider mantığıyla çalışır.
  # Birden fazla veriyi tek seferde feature filedan kullanmamıza yardımcı olur.

  Scenario Outline: Google_Aramalari
    * kullanici googleda "<aranacakKelime>" aratir
    * basligin "<aranacakKelime>" icerdigini dogrular
    * sayfayi_kapatir
    Examples:
      | aranacakKelime |
      | volvo          |
      | bmw            |
      | audi           |
      | mercedes       |
      | ford           |