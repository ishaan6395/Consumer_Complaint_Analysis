# -*- coding: utf-8 -*-
"""
Created on Sun Mar  4 19:19:38 2018

@author: Ishaan Thakker and vbshah
Old code:
table_data = {
        "issue": {'issue_name':'Issue'},
        "subissue": {'issue_ID':,'subissue_name':},
        "product": {'product_name':, },
        "subproduct": {'product_id','subproduct_name'},
        "company": {'company_name':},
        "company_location": {'state','city','ZIP'},
        "customer": {'customer_name','zip','age_range','income_range'},
        "cfpb_complaint": {'date_received','product_id','subproduct_id','issue_ID','subissue_id'
,'company_id','submitted_via','complaint_narratives','tags','date_sent_to_company'},
        "company_response": {},
}
for i in data["Issue"]:
    load_Issue += "'" + str(i) + "' "
    print("query", load_Issue)
    cursor.execute(load_Issue)

for table_name, column_name_data in primary_tables.items():
    sql_query = "insert into " + table_name + ' '
    column_name = '('
    column_data = []
    for dbcolumn, csv_name in column_name_data.items():
        column_name += "`" + dbcolumn + "`,"
        column_data.append(list(data[csv_name]))
    sql_query += column_name.rstrip(',') + ') VALUES('
    for i in range(len(column_data[0])):    # 999k
        temp_data = ''
        for j in range(len(column_data)):   #3
            temp_data += "'" + column_data[j][i].replace("'", "''") + "',"
        temp_data = temp_data.rstrip(',') + ')'
        print("query", sql_query + temp_data)
        cursor.execute(sql_query + temp_data) 


"""

from mysql import connector
import pandas as pd
import random
from math import isnan
import sys


data = None
sql = None

def load_data(*file_names):
    global data
    data = pd.read_csv(file_names[0])   # get Complaint dataCSV file
    location_data = pd.read_csv(file_names[1])
    """
    primary_data format: {table_name: {dbname: csv_name}}
    """    
    data["customer_name"] = ["John Doe"] * len(data)     # adding this for temporarily
    data['Age Range'] = [random.randint(20, 80) 
        for _ in range(len(data))]      # adding this for temporarily
    data['Income Range'] = [random.randint(50000,100000) 
        for _ in range(len(data))]
    data['State'] = location_data['State']
    data['Zipcode'] = pd.Series([str(i) for i in location_data['Zipcode']])
    data['City'] = location_data['City']
    data["Company ZIP"] = data['ZIP code']
    return data

def filter_values(list_of_values):
    new_values = []
    for value in list_of_values:
        if type(value) == float and isnan(value):
            new_values.append("NULL")
        else:
            new_values.append(str(value))
    return new_values


order_of_table = ["location", "company", "Issue", "Product", "Customer","SubIssue",
                  "Subproduct", "company_location", "CFPB_Complaint", "Company_response"]

def main():
    global sql, list_of_values, values, column_names
    configs = {
    "host": "localhost",
    "user": "root",
    "password": "",
    "database": "bigdataproject2"
    }

    complaint_file = 'C:\\Users\\Ishaan\\Downloads\\Consumer_Complaints.csv'
    location_file ='C:\\Users\\Ishaan\\Downloads\\free-zipcode-database-Primary.csv'
    data = load_data(complaint_file, location_file)
    # structure: {"table_name": {"column in database":"column in csv"}}
    # {"table name": {"column in database":"column in csv"}}
    table_data = {
        "Issue": {'issue_name':'Issue'},
        "SubIssue": {'subissue_name':'Sub-issue'},
        "Product": {'product_name':'Product'},
        "Subproduct": {'subproduct_Name':'Sub-product'},
        "company": {'company_name':'Company'},
        "location": {'state':'State','city':'City','ZIP':'Zipcode'},
		"Customer": {'customer_name':'customer_name','zip':'Zipcode','age':'Age Range','income':'Income Range', 'age':'Age Range'},
		"CFPB_Complaint": {'Complaint_ID':'Complaint ID','date_received':'Date received','submitted_via':'Submitted via','complaint_narratives':'Consumer complaint narrative','tags':'Tags',
                     'date_sent_to_company':'Date sent to company','consent_provided':'Consumer consent provided?'},
		"Company_response": {'company_response':'Company public response', 'response_status':'Company response to consumer', 'consumer_disputed':'Consumer disputed?','timely_response':'Timely response?'},
       "company_location": {'zip':'Company ZIP'}
    }
    # structure : {"table": {"foreign key name": "primary key table"}}
    relation = {
        "SubIssue": {"Issue_ID":"Issue"},
        "Subproduct": {"product_ID":"product"},
        "company_location": {"company_ID": "Company"},
        "CFPB_Complaint": {"product_ID":"product", "subproduct_ID": "subproduct",
                           "Issue_ID": "Issue", "subIssue_ID": "subIssue",
                           "company_ID":"Company"
                           },
        "Company_response": {"company_ID": "Company"},
    }
    # structure: {table_name: {unique in db: csv column name}}
    name_relation = {
        "SubIssue": {"issue_name": "Issue"},
        "Subproduct": {"product_name": "Product"},
        "company_location": {"company_name": "Company"},
        "CFPB_Complaint": {"product_name": "Product", "subproduct_name": "Sub-product",
                           "issue_name": "Issue",
                           "subissue_name": "Sub-issue",
                           "company_name": "Company"},
        "Company_response": {"company_name": "Company"}                  
    }
    # example query for relational data:
    # select issue_Id from Issue where issue_name = data["Issue"];
    # issue_id from relation[subIssue].key
    # Issue from relation[subIssue].values
    # issue_name from name_relation[subIssue].key
    # Issue (CSV column name) from name_relation[subIssue].values
    db = connector.connect(**configs)
    cursor = db.cursor()
    counter = 0
    for i in range(len(data)):
        for table_name in order_of_table[:5]:
            sql = "INSERT IGNORE INTO %s (" % (table_name)
            column_names = '' 
            list_of_values = []
            values = ''
            for db_column, csv_column in table_data[table_name].items():
                column_names += '`' + db_column + '`,'
                values += '%s, '
                list_of_values.append(data[csv_column][i])
            column_names = column_names.strip(',')
            values = values.strip(' ').strip(',')
            sql += column_names + ') VALUES (' + values + ')'
            list_of_values = filter_values(list_of_values)
            # print("query", sql % tuple(list_of_values))
            try:
                cursor.execute(sql, tuple(list_of_values))
            except Exception as e:
                print("Error!!!", e)
                db.close()
                sys.exit()
        for table_name in order_of_table[5:]:
            column_names = ''
            list_of_values = []
            values = ''
            for (k1, v1), (k2, v2) in zip(relation[table_name].items(), name_relation[table_name].items()):
                get_query = "select `" + k1 + '` from ' +  v1 + ' where `' + k2 + '` = %s'
                column_names += '`' + k1 + '`,'
                ls = filter_values([data[v2][i]])
              #  print(get_query % tuple(ls))
                try:
                    cursor.execute(get_query, tuple(ls))
                except Exception as e:
                    print("Error!!!", e)
                    db.close()
                    sys.exit()
                result = cursor.fetchall()
                # print("result", result)
                # print("query", get_query % tuple(ls))
                result = result[0][0]
                list_of_values.append(result)
                values += '%s, '
            for db_column, csv_column in table_data[table_name].items():
                column_names += '`' + db_column + '`, '
                values += '%s, '
                list_of_values.append(data[csv_column][i])
            column_names = column_names.strip(' ').strip(',')
            values = values.strip(' ').strip(',')
            # insert into (Issue_ID, subIssue_name) values(123, 123);                                
            sql = "INSERT IGNORE INTO %s (" % table_name
            sql += column_names + ') VALUES (' + values + ')'
            list_of_values = filter_values(list_of_values)
            # print("sql", sql)
            # print("list_of_values", list_of_values)
            # print("final insert query", sql % tuple(list_of_values))
            try:
                cursor.execute(sql, tuple(list_of_values))
            except Exception as e:
                print("Error!!!", e)
                db.close()
                sys.exit()
#            column_names = 
        
        """
        table_name = "SubIssue"
        sql = "insert into " + table_name
        column_names = ''
        list_of_values = []
        values = ''
        for db_column, csv_column in table_data[table_data].items():
        """
        if counter % 1000 == 0:
            print(counter, "completed")
            db.commit()
        counter += 1     
        if counter == 1000000:            
            break
    db.close()
if __name__ == "__main__":
    main()
