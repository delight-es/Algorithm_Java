"""
타겟 넘버
 * numbers : 사용할 수 있는 숫자
 * target : 타겟 넘버
 * (분석) 재귀 --> target 값 찾을 때까지 더하고 빼서 다시 호출
"""

answer = 0

def dfs(cnt, total, target, numbers):
    global answer
    if cnt == len(numbers):
        if total == target:
            answer += 1
        return
    dfs(cnt+1, total+numbers[cnt], target, numbers)
    dfs(cnt+1, total-numbers[cnt], target, numbers)

def solution(numbers, target):
    dfs(0, 0, target, numbers)
    return answer