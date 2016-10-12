@test
Feature: User uploads files and one of the files has incorrect amount value

  Scenario: User uploads a file with incorrect data


    Given the user uploads an invalid file
      | input_file_2.txt       |
      | input_file_invalid.csv |

    Then no output "output.xml" file is produced



