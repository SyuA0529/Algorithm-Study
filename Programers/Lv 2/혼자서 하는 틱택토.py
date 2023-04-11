def solution(board):
    answer = -1
    
    # check sequence correct
    OCount = sum(line.count("O") for line in board)
    XCount = sum(line.count("X") for line in board)
    if not (OCount == XCount or OCount == XCount + 1) :
        return 0
    
    # check game end
    OWin = False
    XWin = False
    
    # X is same
    for line in board :
        if line.count("O") == 3 : 
            OWin = True
        elif line.count("X") == 3 :
            XWin = True
    
    # Y is same
    for x in range(3) :
        if board[0][x] == "O" and board[1][x] == "O" and board[2][x] == "O" :
            OWin = True
        elif board[0][x] == "X" and board[1][x] == "X" and board[2][x] == "X" :
            XWin = True
    
    # cross :
    if board[1][1] == "O" :
        if board[0][0] == "O" and board[2][2] == "O" :
            OWin = True
        elif board[0][2] == "O" and board[2][0] == "O" :
            OWin = True
    elif board[1][1] == "X" :
        if board[0][0] == "X" and board[2][2] == "X" :
            XWin = True
        elif board[0][2] == "X" and board[2][0] == "X" :
            XWin = True
    
    # check result
    # when O and X double Win
    # when O Win but X do more
    # When X Win but O do more
    if (OWin and XWin) or (OWin and not OCount == XCount + 1) or (XWin and not OCount == XCount):
        return 0
    return 1