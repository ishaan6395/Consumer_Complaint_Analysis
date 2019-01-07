# -*- coding: utf-8 -*-
"""
Created on Sun Apr 22 20:55:29 2018

@author: vbsha
"""
import pandas as pd


# data = pd.read_csv('Consumer_Complaints (1).csv')
state_data = dict()
for i in range(len(data)):
    if type(data['State'][i]) == str:
        if data['State'][i] not in state_data:
            state_data[data['State'][i]] = 1
        else:
            state_data[data['State'][i]] += 1
df = pd.DataFrame.from_dict({'State': list(state_data.keys()), 'Count': 
    list(state_data.values())})

df.to_csv('state_data.csv', columns = ['State', 'Count'])
        