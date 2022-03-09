def enroll(name,gender):
    print('name',name)
    print('gender',gender)

def person(name,age,**kw):
    print('name:',name,'\nage:',age,'\nother',kw)

#可接收一个或多个数并计算乘积
def mul(*numbers):
    if len(numbers) == 0:
        raise TypeError
    mu = 1
    for number in numbers:
        mu = mu * number
    return mu

def fact(n):
    if n == 1:
        return 1
    return n*fact(n-1)

#汉诺塔移动，只能小的在上大的在下
def move(n,a,b,c):
    if n == 1:
        print(a,'-->',c)
    else:
        move(n-1,a,c,b)
        move(1,a,b,c)
        move(n-1,b,a,c)
    return #

#利用切片操作，实现一个trim()函数，去除字符串首尾的空格，注意不要调用str的strip()方法：
def trim(s):
    while s[:1]==' ':#看上去似乎if和while在这里的区别不大，但实际上，while是循环删除收尾的空格。当只有一个空格的时候，这里的
                  # while和if作用相同。可是加入首位有两个空格的时候，if只能去除一个空格，而while可以去除所有的。
        s = s[1:]
    while s[-1:]==' ':
        s = s[:-1]
    return s

def findMinAndMax(L): #最大值max() 最小值min()
    if len(L) == 0:
        return (None,None)
    x = L[0]
    y = L[0]
    for n in L:
        if n >= x:
            x = n
        if n <= y:
            y = n
    return (y,x)

if __name__ == '__main__':
    #print(enroll('liming','A'))
    #print(person('liming',18,city='gujiao'))
    #print(fact(5))

    # 测试
    if findMinAndMax([]) != (None, None):

        print('测试失败!')
    elif findMinAndMax([7]) != (7, 7):

        print('测试失败!')
    elif findMinAndMax([7, 1]) != (1, 7):
        print('11')
        print('测试失败!')
    elif findMinAndMax([7, 1, 3, 9, 5]) != (1, 9):

        print('测试失败!')
    else:
        print('测试成功!')
    # 测试:
    '''
    
    if trim('hello  ') != 'hello':
        print('测试失败!')
    elif trim('  hello') != 'hello':
        print('测试失败!')
    elif trim('  hello  ') != 'hello':
        print('测试失败!')
    elif trim('  hello  world  ') != 'hello  world':
        print('测试失败!')
    elif trim('') != '':
        print('测试失败!')
    elif trim('    ') != '':
        print('测试失败!')
    else:
        print('测试成功!')
'''
   # move(3,'A','B','C')