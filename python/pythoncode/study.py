# -*- coding: utf-8 -*-
"""
Created on Fri Apr 16 15:49:27 2021

@author: ZLY
"""

import math
def quadratic(a,b,c):
    x = (-b+math.sqrt(b*b-4*a*c))/(2*a)
    y = (-b-math.sqrt(b*b-4*a*c))/(2*a)
    return x,y


print('quadratic(2, 3, 1) =', quadratic(2, 3, 1))
print('quadratic(1, 3, -4) =', quadratic(1, 3, -4))

if quadratic(2, 3, 1) != (-0.5, -1.0):
    print('测试失败')
elif quadratic(1, 3, -4) != (1.0, -4.0):
    print('测试失败')
else:
    print('测试成功')