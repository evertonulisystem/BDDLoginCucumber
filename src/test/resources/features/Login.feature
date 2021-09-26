
Feature: Realizar login com cadastro ja criado
  Scenario: Realize Login no site
    Given que acesso o conexaoQA
    And clico no login
    When coloco "usuario" e "senha"
    Then sera exibido tela de dashboard
    And o botao de criar perfil estara sendo exibido
    And visualizo a tela de criacao do perfil

