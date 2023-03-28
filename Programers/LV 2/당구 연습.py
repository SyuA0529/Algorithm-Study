import math

def calculate(x, y) :
    result = x ** 2 + y ** 2
    return result

def solution(m, n, startX, startY, balls):
    answer = []
    
    for ball in balls :
        diffX = abs(startX - ball[0])
        diffY = abs(startY - ball[1])
        
        curAns = -1
        if diffX == 0 : # 
            if startY > ball[1] : #can't use bottom
                curAns = min(calculate(2 * startX, diffY), 
                             calculate(2 * (m - startX), diffY),
                         calculate(diffX, (2 * n - startY) - ball[1]))
            else : #can't use top
                curAns = min(calculate(2 * startX, diffY),
                            calculate(2 * (m - startX), diffY),
                            calculate(diffX, startY + ball[1]))
        elif diffY == 0 :
            if startX > ball[0] : #can't use left
                curAns = min(calculate(diffX, 2 * startY), 
                             calculate(diffX, 2 * (n - startY)),
                            calculate((2 * m - startX) - ball[0], diffY))
            else : #can't use right
                curAns = min(calculate(diffX, 2 * startY),
                            calculate(diffX, 2 * (n - startY)),
                            calculate(startX + ball[0], diffY))
        else :
            curAns = min(calculate(startX + ball[0], diffY), #left
                         calculate((2 * m - startX) - ball[0], diffY), #right
                        calculate(diffX, startY + ball[1]),  #bottom
                         calculate(diffX, (2 * n - startY) - ball[1])) #top
        answer.append(curAns)
    return answer