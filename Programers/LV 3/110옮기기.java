def get_solution(string) :
    count = 0
    string = list(string)
    solution = []
    for i in range(len(string)) :
        if string[i] == "0" :
            if not i == "0" and len(solution) >= 2 :
                if solution[-1] == "1" and solution[-2] == "1" :
                    solution.pop()
                    solution.pop()
                    count += 1
                    continue
        solution.append(string[i])
    
    solution = "".join(solution)
    insert_index = solution.rfind("0")
    if insert_index == len(solution) :
        solution = solution + "110"
    else :
        solution = solution[0:insert_index + 1] + "110" * count + solution[insert_index + 1:]
    return solution


def solution(s):
    answer = []
    for i in s :
        answer.append(get_solution(i))
    
    return answer