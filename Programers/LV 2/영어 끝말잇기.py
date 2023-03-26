def solution(n, words):
    answer = []
    
    failTime = -1
    for curTime in range(len(words)) :
        if words[curTime] in words[:curTime]:
            failTime = curTime
            break
        if not curTime == 0 and not words[curTime - 1][-1] == words[curTime][0]:
            failTime = curTime
            break
    if failTime == -1 : return [0, 0]
    return [(failTime % n) + 1, (failTime // n) + 1]