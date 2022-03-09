# -*- coding: utf-8 -*-
"""
Created on Fri Apr 16 13:29:55 2021

@author: ZLY
"""

x = 2
y = 5
c = 0
c = x + y
print(c)
print(type(c))


c = x / y
print(c)
print(type(c))


first_name = 'Ming'
last_name = 'Xiao'
c = last_name + first_name
print(c)
print(type(c))


P = 3.14
r = float(input("请输入圆的半径："))
s = P*r*r
print('圆的面积为：%f'%s)



Number = [2,4,5,1,6]
max = Number[0]
min = Number[0]
for num in  Number:
    if num > max:
        max = num
    if num < min:
        min = num
print('最大值：%d'%max)
print('最大值：%d'%min)
    



