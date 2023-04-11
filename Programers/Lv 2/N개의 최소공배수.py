def gcd(a, b) :
    temp = 0
    while(b != 0) :
        temp = a % b;
        a = b;
        b = temp;
    return a;

def lcm(a, b) :
    return (a * b) / gcd(a, b)

def solution(arr):
    answer = 0
    
    stack = []
    while (len(arr) > 1) :
        num1 = arr.pop()
        num2 = arr.pop()
        arr.append(lcm(max(num1, num2), min(num1, num2)))
    
    answer = int(arr[0])
    return answer