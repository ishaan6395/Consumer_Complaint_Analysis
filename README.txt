Data files:
-> Consumer complaints database: https://catalog.data.gov/dataset/consumer-complaint-database

Guidelines for running the web portal:
-> First unzip the BigDataProjectV1.
-> Import the project in any IDE like Netbeans, Intelliji or Eclipse.
-> Spring-MVC dependencies are needed as the framework implemented for it is Spring-MVC.
-> Glassfish server is needed in order to run the project.
-> For establishing the connection to the Database MYSQL database is needed and you just need to Modify the connection present in the code.

Guidelines for database creation and loading the data:
-> In order to create the database schema you need to run a file named sql_latest.sql.
-> To load the data execute the script named data_loading.py.
-> Once the data is loaded to modify the date column run date.py.
-> After that to add customer_ID attribute with values in cfpb_complaint table run the java code which is present in the controller folder of the web application.

Guidelines for Analytics part:
-> We have provided a file called naive_bayes_classification.py which is used to Classify the issues.
-> Stop_words_txt.txt is the file which contains all the stop words.
-> For KNN Classifier we the program is in file called KNN_classification.py.
-> We have also provided files for data visualization.

Guidelines for Visualization part:
-> We have PDF named visualization which has 4 graphs which we have used for Visualization and also more information related to it is mentioned in the report.
