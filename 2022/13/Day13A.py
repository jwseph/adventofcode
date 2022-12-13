s = [pair.split('\n') for pair in open("Day13.in").read().strip().split("\n\n")]
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

res = 0
for i, (l_s, r_s) in enumerate(s):
    l, r = eval(l_s), eval(r_s)
    if compare(l, r) <= 0: res += i+1
print(res)
