
#2、手动输入两个数字，输出最大的那个
def inputMax(a,b):
    a = int(input('请输入第一个数：'))
    b = int(input('请输入第二个数：'))
    if a>b:
        print('最大的数为：',a)
    else:
        print('最大的数为：',b)

#3、输出1-20中的奇数
def inputNumber():
    i = 1
    print('1-20中的奇数为：',end="")
    while i <= 20:
        if i%2 == 1 :
            print(i,' ',end="")
        i+=1


#4、求1-100的和。
def sumNumber():
    i = 1
    sum = 0
    while i <= 100:
        sum+= i
        i+=1
    print('1-100相加和为：',sum)

#5、手动输入一个三位数，依次输出其 个位 十位 百位
def flower():
    number = int(input('请输入一个三位数：'))
    a = number%10
    b = number//10%10
    c = number//100
    print('个位数：',a)
    print('十位数：',b)
    print('百位数：',c)


if __name__ == '__main__':
   # 1、初始a = 30, b = 40，互换a, b, 使得a = 40, b = 30输出。
    a = 30
    b = 40
    c = a
    a = b
    b = c
    print('a= %d,b= %d'%(a,b))
    inputMax(a,b)
    inputNumber()
    sumNumber()
    flower()