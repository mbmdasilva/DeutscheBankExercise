@test
Feature: User uploads and outputs files with correct data and  xml format

 Scenario: User uploads files correctly
    Given the user uploads files
    | input_file_1.csv |
    | input_file_2.txt |

    Then the user can see the file "output.xml"

