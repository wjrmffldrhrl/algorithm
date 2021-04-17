import sys


def is_pseudo_palindrome(string):
    left_index = 0
    right_index = -1

    while True:
        if string[left_index] != string[right_index]:
            break

        left_index += 1
        right_index -= 1

    left_tmp = string[0:left_index] + string[left_index + 1:]

    if right_index == -1:
        right_tmp = string[:-1]
    else:
        right_tmp = string[0:right_index] + string[right_index + 1:]

    if left_tmp == left_tmp[::-1] or right_tmp == right_tmp[::-1]:
        return True
    else:
        return False


def is_palindrome(string):
    if string == string[::-1]:
        return 0
    else:
        if is_pseudo_palindrome(string):
            return 1
        else:
            return 2


T = int(sys.stdin.readline().rstrip())

strings = []
for i in range(0, T):
    strings.append(sys.stdin.readline().rstrip())

for string in strings:
    print(is_palindrome(string))

