answer = 0
board = []

def solution(n):
    global board
    global answer
    board = [-1 for _ in range(n)]
    backTracking(0, n)
    
    if n % 2 == 0 :
        answer *= 2
    
    return answer

def backTracking(curDepth, totalDepth) :
    global board
    global answer
    if curDepth == totalDepth :
        answer += 1
        return;
    
    repeat = totalDepth
    if totalDepth % 2 == 0 and curDepth == 0:
        repeat = totalDepth // 2
    
    for i in range(repeat) :
        board[curDepth] = i
        if validate(curDepth) :
            backTracking(curDepth + 1, totalDepth)
    
    
def validate(curDepth) :
    global board
    for i in range(curDepth) : 
        if board[curDepth] == board[i] : return False
        if abs(board[curDepth] - board[i]) == abs(curDepth - i) : return False
    return True