def solution(nums):
    # init
    limitN = len(nums)/2
    pocketDict = {}
    
    for num in nums :
        pocketDict[num] = 0
    for num in nums :
        pocketDict[num] += 1
    
    curN = 0
    for num in list(set(nums)) :
        if curN < limitN :
            if pocketDict[num] > 0 :
                pocketDict[num] -= 1
                curN += 1
    
    answer = curN
    return answer