Feature: Realizar login com cadastro ja criado
  Scenario: Realizar Login no site
    Given que acesso o conexaoQA
    And clico no login
    When coloco "usuario" e "senha"
    Then sera exibido tela de dashboard

