def solution(s):
    answer = 0
    stack = []
    
    for chr in s :
        if len(stack) == 0 :
            stack.append(chr)
        elif stack[-1] == chr :
            stack.pop()
        else :
            stack.append(chr)
    if len(stack) == 0 : answer = 1
    return answer