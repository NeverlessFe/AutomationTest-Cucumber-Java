Feature: saucedemo full test

  Scenario: Login Success
    Given Halaman login terbuka
    When Input username
    And Input password
    And Click login button
    Then user redirect ke halaman home

  Scenario: Failed Login
    Given Halaman login terbuka
    When Input Username Salah
    And Input wrong passowrd
    And Click login button
    Then user diberikan notifikasi error login

  Scenario: Username Null
    Given Halaman login terbuka
    When Click login button
    Then user diberikan notifikasi username kosong

  Scenario: Password Null
    Given Halaman login terbuka
    When Input username
    And Click login button
    Then user diberikan notifikasi password kosong

    Scenario: Checkout Items
      Given Halaman login terbuka
      When Input username
      And Input password
      And Click login button
      Then user redirect ke halaman home
      And user add cart item
      And user click cart button
      Then user click checkout button
      And user input Firstname
      And user input Last Name
      And user input zip postal code
      Then user click continue button
      And user click finish button
      Then checkout success

      Scenario: Go to inventory page without login
        Given Halaman login terbuka
        When Redirect url ke halaman inventory
        Then Notifikasi block muncul

