# -*- coding: utf-8 -*-
"""
Created on Tue Apr 20 15:43:59 2021

@author: ZLY
"""

from sklearn.datasets import load_iris
from sklearn.svm import LinearSVC
from sklearn import svm
from sklearn.model_selection import train_test_split
iris = load_iris()
X = iris.data[:,:2]
y = iris.target
x_train,x_test,y_train,y_test = train_test_split(X,y,test_size=0.4,random_state=0)
model = svm.SVC(C=1)
model.fit(x_train,y_train)
print(model.score(x_train,y_train))
predicted = model.predict(x_test)
print(predicted)