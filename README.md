# DeutscheBankExercise
DeutscheBank  Test Exercise

In this exercise I have created 2 tests. One with a happy path and one with a edge case(non happy path)

ETL stands for Extract Transform Load as we are uploading in one format and outputing in another format.

The code can be run 2 ways:
 1- By right click in the RunCukesTest class and choose run from the list or
 2- By using mvn clean install
 
 There is a report created under target -> cucumber-html-report -> Select any of the reports ( i.e feature overview) and choose to load by browser ( choose the desired browser)  -> report should appear.
 
 In the test I am validating the amount assuming that format is similar to (11.00 )and not( 11,8 or 1e44 or null)
 
 I am also assuming that the headers will always be in the format: ID(8),DATE(9),SRC_ACC(9),DEST_ACC(9),TYPE(5),AMOUNT(9),CCY(3), hence why I am not generating the headers (tags) dynamically but hardcoding them. The assumption is because only one file has the headers and in case we upload the txt file before we wouldnt have headers.
