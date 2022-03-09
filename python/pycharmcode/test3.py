# 1.输出一个由“*”组成的等腰三角形（要求最下边一行19个“*”）
def dengyaosanjiao():
    i = 1
    while i <= 10:
        print(" "*(19-i)+"*"*(2*i-1)+" "*(19-i))
        i+=1
# 2.输出11×11乘法口诀表
def chengfa(row,clo):
    row1 = 1
    while row1 <= row:
        clo1 = 1
        while clo1 <= row1:
            print("%d * %d = %d" % (clo1,row1,row1*clo1),end="\t")
            clo1 += 1
        print("")
        row1 += 1


if __name__ == '__main__':
    dengyaosanjiao()
    chengfa(11,11)