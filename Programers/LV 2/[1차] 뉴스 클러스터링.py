def makeString(str) :
    newSet = []
    for i in range(len(str) - 1) :
        if str[i].isalpha() and str[i+1].isalpha() :
            newSet.append(str[i:i+2].lower())
    return newSet

def makeCombList(list1, list2) :
    result = []
    tempList1 = list(list1)
    tempList2 = list(list2)
    for ele in list1 :
        if ele in tempList1 :
            if ele in tempList2 :
                tempList2.remove(ele)
            tempList1.remove(ele)
            result.append(ele)
    
    for ele in tempList2 :
        result.append(ele)
    return result

def makeInterList(list1, list2) :
    result = []
    tempList1 = list(list1)
    tempList2 = list(list2)
    
    for ele in list1 :
        if ele in tempList1 and ele in tempList2 :
            result.append(ele)
            tempList1.remove(ele)
            tempList2.remove(ele)
    return result

def solution(str1, str2):
    answer = 0
    str1List = makeString(str1)
    str2List = makeString(str2)
    
    combList = makeCombList(str1List, str2List)
    interList = makeInterList(str1List, str2List)
    print(interList, combList)
    
    if len(combList) == 0 : return 65536
    return (len(interList) / len(combList) * 65536) // 1