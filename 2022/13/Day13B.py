from functools import cmp_to_key
lines = [line for line in open("Day13.in").read().strip().split("\n") if line]
def compare(l, r):
    if isinstance(l, list) and isinstance(r, int):
        r = [r]
    if isinstance(l, int) and isinstance(r, list):
        l = [l]
    if isinstance(l, int):
        return -1 if l < r else 1 if l > r else 0
    for l_, r_ in zip(l, r):
        c = compare(l_, r_)
        if c < 0: return -1
        if c > 0: return 1
    if len(l) < len(r): return -1
    if len(l) > len(r): return 1
    return 0

arr = [eval(line) for line in lines]
p1, p2 = [[2]], [[6]]
arr.append(p1)
arr.append(p2)
arr.sort(key=cmp_to_key(compare))
print((1+arr.index(p1))*(1+arr.index(p2)))
