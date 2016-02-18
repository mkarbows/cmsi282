 1.
a) f(n) = n-100, g(n) = n-200
both are O(n) and Omega(n) → computational speed of f(n) is superior to g(n) and computational speed of g(n) is superior to f(n)
get: f(n) = Ѳ(g(n)) [n-100 = Ѳ(n-200]

b) f(n) = n^(½), g(n) = n^(⅔)
n^(½) < n(⅔) → f(n) = O(g(n)) → f(n) computational speed is superior to g(n)
n^(½) dominates n^(⅔)
get: f(n) = O(g(n)) [n^(½) = O(n^⅔)]

c) f(n) = 100n + logn, g(n) = n + (logn)^2
both are O(n) and Omega(n)
100n dominates logn in f(n) and n dominates (logn)^2 in g(n) [according to rules that help simplify functions, any polynomial dominates any logarithm]
get: f(n) = Ѳ(g(n)) [100n + logn = Ѳ(n + (logn)^2)]

d) f(n) = nlogn, g(n) = 10nLog10n
get: f(n) = Ѳ(g(n)) [nlogn = Ѳ(10nlog10n)]

e) f(n) = log2n, g(n) = log3n
get: f(n) = Ѳ(g(n)) [log2n = Ѳ(log3n)]

f) f(n) = 10logn, g(n) = log(n^2)
get: f(n) = Ѳ(g(n)) [10longn = Ѳ(log(n^2))]

g) f(n) = n^1.01, g(n) = nlog^2n
get: f(n) = Omega(g(n)) [n^1.01 = Omega(nlog^2n)]

h) f(n) = (n^2)/logn, g(n) = n(logn)^2
f(n) is not dominated by g(n)
get: f(n) = Omega(g(n)) [(n^2)/logn = Omega(n(logn)^2)]

i) f(n) = n^0.1, g(n) = (logn)^10
get: f(n) = Omega(g(n)) [n^0.1 = Omega((logn)^10)]

j) f(n) = (logn)^(logn), g(n) = n/logn
get: f(n) = Omega(g(n)) [(logn)^(logn), g(n) = n/logn******************

k) f(n) = sqrt(n), g(n) = (logn)^3
get: f(n) = Omega(g(n)) [sqrt(n) = Omega((logn)^3)]

l) f(n) = n^(½), g(n) = 5^(log(base2)n)
g(n) = 5^(log(base2)n) is approximately n^2.32
so comparing the powers, n^(½) < n^(2.32) → n^(½) dominates n^(2.32) → f(n) is superior to g(n)
get: f(n) = O(g(n)) [n^(½) = O(5^(log(base2)n)]

m) f(n) = n2^n, g(n) = 3^n
2^n < 3^n → f(n) is superior to g(n) because 2^n dominates 3^n
get: f(n) = O(g(n)) [n2^n = O(3^n)]

n) f(n) = 2^n, g(n) = 2^(n+1)
both are O(n) and Omega(n)
get: f(n) = Ѳ(g(n)) [2^n = Ѳ(2^(n+1))]

o) f(n) = n!, g(n) = 2^n
n! > sqrt(2pi*n)((n/e)^n)
f(n) is dominated by g(n)
get: f(n) = Omega(g(n)) [n! = Omega(2^n)]

p) f(n) = n^(loglogn), g(n) = 2(log(base2)n)^2
f(n) can be written as f(n) = n^(loglogn) and g(n) can be written as
				g(n) = (2^(log(base2)n)^(log(base2)n))
              = n^(log(base2)n)
so f(n) < g(n) → f(n) is superior to g(n)
get: f(n) = O(g(n)) [n^(loglogn) = O(2(log(base2)n)^2)]

q) f(n) = summation(n, i=1) i^k, g(n) = n^(k+1)
f(n) = Ѳ(g(n)) [summation(n, i=1) i^k = Ѳ(n^(k+1))]
