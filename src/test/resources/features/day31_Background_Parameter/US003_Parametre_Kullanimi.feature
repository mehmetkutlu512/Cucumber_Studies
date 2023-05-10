Feature: US003_TechProeducation_Testi

  Background: Kullanici TechproEducation Sayfasina Gider
    Given kullanici_"techproed_Url"_sayfasina_gider

  Scenario: TC01_TechProeducation_Sayfasi_Testi
    Then cikan_reklam_kapatilir
    When kullanici 2 saniye bekler
    And kullanici_tum_sayfanin_resmini_alir
    And arama_kutusunda_QA_aratir
    Then kullanici 2 saniye bekler
    And sayfa_basliginin_qa_icerdigini_test_eder
    When kullanici_tum_sayfanin_resmini_alir
    And sayfayi_kapatir