1. Dasgupta 0.1
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
get: f(n) = Omega(g(n)) [(logn)^(logn) = Omega(n/logn)]

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

2. Dasgupta 1.13
By Fermat’s little theorem, p = 31 (which is prime)
5^30 =[congruent] 1 (mod 31) 
6^30 =[congruent] 1 (mod 31) 
Now, to find the value of 5^30000 we know that 30000 is a multiple of 30
get: 5^30(mod 31) = 1
therefore: 5^30000(mod 31) = 1
To find the value of 6^123456 we look at 6^30(mod 31) = 1
→ 6^123456(mod 31) = 1
123456(mod 30) = 6
therefore: 6^123456 =[congruent] 6^6
so 6^6(mod 31) = 1
so 6^123456 - 5^30000 = 5^30000(mod 31) - 6^123456(mod 31)
			= 1(mod 31) - 1(mod 31)
			= 0(mod 31)
therefore 5^30000 and 6^123456 is divisible by 31

3. Levitin 2.1.5b
b = [log(base2)(n+1)]
2^b = n+1 → n < 2^b
	therefore 2^(b-1) <= n < 2^b
		2^b-1 < n+1 <= 2^b
now take log(base2) of both sides
get: log(base2)2^(b-1) <= log(base2)(n+1) <= log(base2)2^b
	2^(b-1) <= log(base2)(n+1) <= b
therefore, b is the smallest integer not less than log(base2)(n+1)

4. Levitin 2.1.10
a) we have a chessboard where the 1st square = 1 grain
		2nd = 2 grains
		3rd = 4 grains
		4th = 8 grains
		…
		64th 
		so we get that there are 2^(n-1) grains of rice on each of the n squares
		therefore, 2^(64-1) grains of rice to count = 9.223372 x 10^18 seconds (1 second for each grain)											= 1.5372287 x 10^17 minutes
							= 2.5620478 x 10^15 hours
							…
so about a few hundred billion years. 

b) If the inventor asked to add two grains to each of the squares, instead of doubling the number of grains for each square of the chessboard, it would follow the pattern 1 = 1^2, 1+3 = 2^2, 1+3+5 = 3^2, etc. Therefore, on the 64th square, it would be 64^2 or 4096.

7. How many function calls for C(20,11)?
Without memoization: 335,919
With memoization: 119
