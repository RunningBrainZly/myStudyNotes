from random import randint
def play():
    random_int = randint(0,100)

    while True:
        user_guess = int(input('请输入你猜的数字（0-100）：'))
        if user_guess == random_int:
            print(f'恭喜您猜对了,中奖号码为{random_int}!')
            return 0
            break
        if user_guess < random_int:
            print('您猜的数字小于中奖数字。')
            continue
        else :
            print('您猜的数字大于中奖数字。')
            continue

if __name__ == '__main__':
    play()