
def delete_not_palindrome_word(string):
    left_index = 0
    right_index = -1

    while True:
        print("left " + string[left_index])
        print("right " + string[right_index])
        if string[left_index] != string[right_index]:
            break

        left_index += 1
        right_index -= 1

    if string[left_index + 1] == string[right_index]:
        return string[0:left_index] + string[left_index + 1:]
    elif string[left_index] == string[right_index - 1]:
        return string[0:right_index] + string[right_index + 1:]
    else:
        return "FALSE"

print(delete_not_palindrome_word("comwwtmoc"))