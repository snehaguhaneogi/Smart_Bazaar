Feature: Search and verify product price

  Scenario Outline: Verify product price from search
    Given user is on home page
    When user searches for "<searchKey>"
    And user selects product "<productName>"
    Then product price should be "<expectedPrice>"

    Examples:
      | searchKey | productName                                | expectedPrice |
      | rice      | Steel Pongal Pot Pack (White Rice)         | £15.99        |
      | rice      | Telugu Foods Mamra/Pori/Puffed Rice (500g) | £2.69         |
      | rice      | Niru White Raw Rice (1kg)                  | £2.59         |
      | rice      | Rigel Spices Ponni Boiled Rice (10kg)      | £17.99        |
      | rice      | Shree Krishna Idly Rice (10kg)             | £15.99        |