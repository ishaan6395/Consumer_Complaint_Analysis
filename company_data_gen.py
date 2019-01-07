# -*- coding: utf-8 -*-
"""
Created on Sun Apr 22 20:55:29 2018

@author: vbshah
"""
import pandas as pd


# data = pd.read_csv('Consumer_Complaints (1).csv')
state_data = dict()
for i in range(len(data)):
    if type(data['Company'][i]) == str:
        if data['Company'][i] not in state_data:
            state_data[data['Company'][i]] = 1
        else:
            state_data[data['Company'][i]] += 1
            
df = pd.DataFrame.from_dict({'Company': list(state_data.keys())[:15], 'Count': 
    list(state_data.values())[:15]})
df.to_csv('company_data.csv', columns = ['Company', 'Count'])
        