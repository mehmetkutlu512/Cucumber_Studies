Feature: US002_TechProeducation_Testi

  @hooks
  Scenario: TC02_TechProeducation_Sayfasi_Testi
    Given kullanici_"techproed_Url"_sayfasina_gider
    And cikan_reklam_kapatilir
    And kullanici 2 saniye bekler
    And searchBoxda_"developer"_aratir
    And sayfa_basliginin_"QA"_icerdigini_test_eder
    And sayfayi_kapatir