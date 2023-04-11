def eraseBlock(m, n, board) :
    deleteCount = 0
    newBoard = [list(each) for each in board]
    for y in range(m - 1) :
        for x in range(n - 1) :
            curCheckList = [board[y][x], board[y][x + 1], board[y + 1][x], board[y + 1][x + 1]]
            if curCheckList.count(board[y][x]) == 4 and not board[y][x] == '_':
                newBoard[y][x] = '_'
                newBoard[y][x + 1] = '_'
                newBoard[y + 1][x] = '_'
                newBoard[y + 1][x + 1] = '_'
                deleteCount += 1
                
    return newBoard, deleteCount

def downBlock(m, n, board) :
    tempBoard = [list() for _ in range(n)]
    for x in range(n) :
        for y in range(m) :
            tempBoard[x].append(board[y][x])
    
    tempBoard2 = [list('_' * line.count('_')) for line in tempBoard]
    for x in range(n) :
        for y in range(m) :
            if not tempBoard[x][y] == '_' :
                tempBoard2[x].append(tempBoard[x][y])
    
    newBoard = [['' for _ in range(n)] for __ in range(m)]
    
    for x in range(n) :
        for y in range(m) :
            newBoard[y][x] = tempBoard2[x][y]
            
    return newBoard
    
def solution(m, n, board):
    answer = 0
    board = [list(line) for line in board]
    
    while True :
        board, deleteCount = eraseBlock(m, n, board)
        if deleteCount == 0 : 
            break
        board = downBlock(m, n, board)
    
    for line in board :
        answer += line.count('_')
    return answer