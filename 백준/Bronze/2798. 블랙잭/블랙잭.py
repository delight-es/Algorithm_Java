#카드 개수, 카드 수
N, M = map(int, input().split(' '))
lst = list(map(int, input().split(' ')))
blackjack = 0
max_num = 0

for i in range(N):
    for j in range(i+1,N):
        for k in range(j+1,N):
            blackjack = lst[i]+lst[j]+lst[k]

            # 수 합이 넘지 않는 선에서 가장 큰 수
            if (blackjack <=  M) and (max_num < blackjack):
                max_num = blackjack
                #print(lst[i], lst[j], lst[k], max_num)

print(max_num)

