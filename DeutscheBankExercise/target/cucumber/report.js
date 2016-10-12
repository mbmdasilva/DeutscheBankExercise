$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("etl_happy_path.feature");
formatter.feature({
  "line": 2,
  "name": "User uploads and outputs files with correct data and  xml format",
  "description": "",
  "id": "user-uploads-and-outputs-files-with-correct-data-and--xml-format",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "User uploads files correctly",
  "description": "",
  "id": "user-uploads-and-outputs-files-with-correct-data-and--xml-format;user-uploads-files-correctly",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user uploads files",
  "rows": [
    {
      "cells": [
        "input_file_1.csv"
      ],
      "line": 6
    },
    {
      "cells": [
        "input_file_2.txt"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user can see the file \"output.xml\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ETLStepDef.the_user_uploads_files(String\u003e)"
});
formatter.result({
  "duration": 204065242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "output.xml",
      "offset": 27
    }
  ],
  "location": "ETLStepDef.the_user_can_see_the_file(String)"
});
formatter.result({
  "duration": 1404210,
  "status": "passed"
});
formatter.uri("etl_invalid_amount.feature");
formatter.feature({
  "line": 2,
  "name": "User uploads files and one of the files has incorrect amount value",
  "description": "",
  "id": "user-uploads-files-and-one-of-the-files-has-incorrect-amount-value",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "User uploads a file with incorrect data",
  "description": "",
  "id": "user-uploads-files-and-one-of-the-files-has-incorrect-amount-value;user-uploads-a-file-with-incorrect-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "the user uploads an invalid file",
  "rows": [
    {
      "cells": [
        "input_file_2.txt"
      ],
      "line": 8
    },
    {
      "cells": [
        "input_file_invalid.csv"
      ],
      "line": 9
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "no output \"output.xml\" file is produced",
  "keyword": "Then "
});
formatter.match({
  "location": "ETLStepDef.the_user_is_uploads_an_invalid_file(String\u003e)"
});
formatter.result({
  "duration": 4120655,
  "error_message": "java.lang.AssertionError: The value of \u0027invalid\u0027 may have been entered in the incorrect format.\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:26)\n\tat exercise.pages.Transaction.validateAmount(Transaction.java:47)\n\tat exercise.pages.Transaction.\u003cinit\u003e(Transaction.java:39)\n\tat exercise.pages.ETLPage.cvsParser(ETLPage.java:141)\n\tat exercise.pages.ETLPage.parseFile(ETLPage.java:82)\n\tat exercise.pages.ETLPage.upload(ETLPage.java:31)\n\tat exercise.stepdefinitions.ETLStepDef.the_user_is_uploads_an_invalid_file(ETLStepDef.java:21)\n\tat ✽.Given the user uploads an invalid file(etl_invalid_amount.feature:7)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "output.xml",
      "offset": 11
    }
  ],
  "location": "ETLStepDef.no_output_file_is_produced(String)"
});
formatter.result({
  "status": "skipped"
});
});