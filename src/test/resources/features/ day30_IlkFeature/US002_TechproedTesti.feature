Feature: US002_TechProeducation_Testi

  Scenario: TC01_TechProeducation_Sayfasi_Testi
    Given kullanici_techpro_sayfasina_gider
    Then cikan_reklam_kapatilir
    And arama_kutusunda_QA_aratir
    And sayfa_basliginin_qa_icerdigini_test_eder
    And sayfayi_kapatir