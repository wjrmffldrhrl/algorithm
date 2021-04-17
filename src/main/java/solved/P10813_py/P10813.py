import sys

N, M = map(int, sys.stdin.readline().split())
baskets = [i for i in range(1, N + 1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    baskets[a - 1], baskets[b - 1] = baskets[b - 1], baskets[a - 1]

print("".join([str(ball_number) + " " for ball_number in baskets]))
