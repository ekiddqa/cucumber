Feature: Google various search terms

    Scenario: Google "<Animal>" images
        Given That I can access "<Domain>"
        When I search for "<Animal>"
        And I select the images tab
        Then I should be able to view images of "<Animal>"
        
        |Animal|Domain|
        |Kittens|www.google.com|
        |Puppies|www.google.com|