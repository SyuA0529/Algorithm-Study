def solution(n,a,b):
    answer = 0
    
    oldList = ['X' for _ in range(n)]
    oldList[a - 1] = "A"
    oldList[b - 1] = "B"
    
    newList = []
    for round in range(n // 2) :
        while len(oldList) > 0:
            curFight = [oldList.pop(), oldList.pop()]
            if "A" in curFight and "B" in curFight :
                return round + 1
            elif "A" in curFight :
                newList.append("A")
            elif "B" in curFight :
                newList.append("B")
            else : newList.append("X")
        oldList = newList
        newList = []
    return answer