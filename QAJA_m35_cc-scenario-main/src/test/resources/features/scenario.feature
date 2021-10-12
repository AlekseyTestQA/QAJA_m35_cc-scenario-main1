#Gherkin
Feature: Find restaurant
  #Позитивный сценарий: выбираем адрес пицирии и получем контакты пициирии
  Scenario: chose restaurant adres
    Given url of restaurant 'https://dodopizza.ru/volgograd/contacts'
    Then  chose adres 'ул. Аллея Героев, 5'
    And assert that chosen adres is 'ул. Аллея Героев, 5'
  #Негатинвый сценарий: выбираем несушествующий адрес, получаем соответствуещее уведомление
  Scenario: chose absent adres
    Given url of restaurant 'https://dodopizza.ru/volgograd/contacts'
    Then  chose adres 'ул Туполева 5'
    And assert that user got message 'Найдено 0 пиццерий из 4'