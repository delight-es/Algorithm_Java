def solution(numbers):
    s = [str(n) for n in numbers]
    print(sorted(s, reverse=True))
    return ''.join(sorted(s, reverse=True))
        