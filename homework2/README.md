3. The following ciphertext was intercepted. You know the message is in English and that the sender used a monoalphabetic substitution cipher. What is the plaintext?
RYW QVKOVWPP KT KLV FVBP, LQKU DYZIY FEE WEPW IYZWTEG HWQWUHP, ZP FP DWEE AUKDU RK RYW QLXEZI FP RK BGPWET, FUH ZR ZP, Z RVLPR, VWFPKUFXEG PFRZPTFIRKVG FUH WUIKLVFOZUO RK FEE. DZRY YZOY YKQW TKV RYW TLRLVW, UK QVWHZIRZKU ZU VWOFVH RK ZR ZP JWURLVWH.

Using frequency analysis: 
There are 3 ZP’s and 2 ZR’s so these must be the most frequent combination of letters /”words” in the ciphertext. Z is most likely either the letter a or the letter i. Looking at the next most common words, RYW, FUH, and FEE seem to have the most repetition in the ciphertext. ‘FEE’ means that whatever F is must be followed by two of the same letters. Therefor FEE is most likely either “all” or “too”. We determined that FEE was all, and now that we know the plaintext representation of E is the letter l, we look at other words containing E in the ciphertext considering we have a known letter of that word. Looking at DWEE, we figured out that E stands for l and W stands for e, therefore we assume that DWEE is ‘well’. At this point Megan and I put the ciphertext into quipqiup.com to solve for the rest of the ciphertext. The plaintext states:

	“ The progress of our arms, upon which all else chiefly depends, is as well known to the public as to myself, and it is, I trust, reasonably satisfactory and encouraging to all. With high hope of the future, no prediction in regard to it is ventured. ”


4. Decrypt the following ciphertext, given that you know it was encrypted with the bifid algorithm in which the Polybius square was laid out in the usual fashion using the keyphrase "Darn, not another cryptanalysis question".
TWBTLLAEPODTUBTWBTLTDLDDVSNNHEETLSKDDSIFGIIMWLYDKDDSPHBPQKOFHMDLSKRS

If the polybius squares’ keyphrase is “Darn, not another cryptanalysis question” then the polybius square is filled in as follows:
 D A R N O T H E C Y P L S I Q U B F G K M V W X Z  or:
D
A
R 
N
O
T
H
E
C
Y
P
L
S
I
Q
U 
B
F
G
K
M
V
W
X
Z

Using this polybius square, we state the location of each letter vertically, column by row starting with T and working all the way through the sequence for TWBTLLAEPODTUBTWBTLTDLDDVSNNHEETLSKDDSIFGIIMWLYDKDDSPHBPQKOFHMDLSKRS. When finished with the last S, group together the numbers in the top row by two’s and use those coordinates to find the letter and after working through the top row, do the same with the bottom row (from the numbers listed vertically). The final text decoded is:

“COMPUTER SCIENCE IS MORE ABOUT COMPUTERS THAN ASTRONOMY IS ABOUT TELESCOPES.”


5. What are the RSA's public and private keys generated from
p=23847623789462398745236743254827634647
q=80147623789462398745236743254827634711

Step 1: Determine public key by producing N and choosing an e
Public Key = (N, e) → (1911330379750470000000, 7)
Step 2: Compute d for the private key
Private key (N, d) : compute d: (p-1)(q-1) = (23847623789462398745236743254827634646)(80147623789462398745236743254827634710) = 1911330379750465988511865475607817924846043384185557740590270903584228162660
Invmod (e, (p-1)*(q-1)) → (7,1911330379750465988511865475607817924846043384185557740590270903584228162660) 
Woflram alpha:  powermod[7, -1, 1911330379750465988511865475607817924846043384185557740590270903584228162660] = d
Step 3: Produce private key
Private Key = (N, d) = (1911330379750470000000, 546094394214418853860532993030805121384583824053016497311505972452636617903)


6. If someone's RSA public key is (729880581317, 5), what is her private key? Give a detailed derivation, showing all work.

N = 729880581317
Step 1: Using Wolfram alpha, get factors p = 822,893 and q = 886,969
Step 2: Compute d: D=(p-1)*(q-1)
        	        	= (822892)(886968)
                    	= 729,878, 871, 456
Step 3: Using Julia, invmod(e, (p-1)(q-1))      
invmod(5, 729878871456) → 583903097165
Therefore, the private key is (729880581317, 583903097165)


7. Dasgupta Problem 1.45
RSA and digital signatures. Recall that in the RSA public-key cryptosystem, each user has a public key P = (N, e) and a secret key d. In a digital signature scheme, there are two algorithms, sign and verify. The sign procedure takes a message and a secret key, then outputs a signa- ture σ. The verify procedure takes a public key (N, e), a signature σ, and a message M , then returns “true” if σ could have been created by sign (when called with message M and the secret key corresponding to the public key (N, e)); “false” otherwise.			
(a)  Why would we want digital signatures?

We want digital signatures because it is basically the process of signing a document. The signer adds extra information to the message being sent and a digital signature allows the receiver to check whether the message comes from the supposed sender or not. We use this process because then the receiver can check if the message is actually from the original sender and not someone else.

(b)  An RSA signature consists of sign(M, d) = M d (mod N ), where d is a secret key and N is part of the public key. Show that anyone who knows the public key (N,e) can perform verify((N,e),Md,M), i.e., they can check that a signature really was created by the pri- vate key. Give an implementation and prove its correctness.

Yes! We are able to decrypt the signature if you know the public key(N, e).
First we check whether ((M^d)^e)modN is equal to M
((M^d)^e)modN = ((M^e)^d)modN
		=MmodN
		=M
For example: e=5, N=123, 545, 322
		(M^d)^emod123, 545, 322 = (M^5)^dmod(123, 545, 322)
					= M(mod123, 545, 322)
					=M

(c)  Generate your own RSA modulus N = pq, public key e, and private key d (you don’t need to use a computer). Pick p and q so you have a 4-digit modulus and work by hand. Now sign your name using the private exponent of this RSA modulus. To do this you will need to specify some one-to-one mapping from strings to integers in [0, N − 1]. Specify any mapping you like. Give the mapping from your name to numbers m1,m2,...mk, then sign the first number by giving the value md1 (mod N), and finally show that (md1)e = m1 (mod N).

p=163, q=115
(p-1)*(q-1) = (162)*(114) = 18,468
N=p*q = 163*115 = 18,745
e=7
Public key: (N,e) = (18,745,7915)
		x = 7^-1mod18,468
		x=1/7mod18,468
		7(x) = 1mod18,468
		7x(mod18,468) = 1
		7*7,915(mod18,468) = 1
		55,405 (mod18,468) = 1
-----> d is 7,915
binary value of M:  77  (http://www.binaryhexconverter.com/binary-ascii-characters-table)
so 77 is the first value in our message, here we denoted 77 by x.
x^7,915 (mod 18,745) = Y
(X^7,915)^7 (mod 18,745) = X	AND	x(mod 18, 745) = X
Therefore (x^7,915)^7 = x (mod 18,745)

(d)  Alice wants to write a message that looks like it was digitally signed by Bob. She notices that Bob’s public RSA key is (17, 391). To what exponent should she raise her message?

public key = (e, N) = (17, 391) therefore e is 17 and N is 391
391 / 17 = 23
p = 17, q = 23
(p-1)*(q-1) = 16 * 22 =352
d = [e invmod((p-1)*(q-1))]
d = [17 invmod(352)
d = 17^-1 (mod 352)
d = (1/17) mod 352
17(x) = 1 mod 352
17(145) = 1 mod 352
2465 = 1 mod 352
------> d = 145	


8. Dasgupta Problem 1.46
Digital signatures, continued. Consider the signature scheme of Exercise 1.45.
(a) Signing involves decryption, and is therefore risky. Show that if Bob agrees to sign anything he is asked to, Eve can take advantage of this and decrypt any message sent by Alice to Bob.

When Eve intercepts the encrypted message (M^e)modN is sent by Alice to Bob. So Eve can just ask Bob to sign it for her with his private key to get ((M^e)^d)modN=M. This means she will know Bob’s private key so she can decrypt any message Alice sends to Bob.

(b)  Suppose that Bob is more careful, and refuses to sign messages if their signatures look suspiciously like text. (We assume that a randomly chosen message—that is, a random number in the range {1, . . . , N − 1}—is very unlikely to look like text.) Describe a way in which Eve can nevertheless still decrypt messages from Alice to Bob, by getting Bob to sign messages whose signatures look random. 

In this case, Eve can pick k coprime to N at random and ask Bob to sign
(M^e)*( k^e)modN.
and this gives (Mk)^(ed)modN = MkmodN.
Eve can then compute (k^-1)modN to find M.
Now Bob’s signature will be given over all numbers (invertible modN) Mk.


9. Dasgupta Problem 2.12
How many lines, as a function of n (in Θ(·) form), does the following program print? Write a recurrence and solve it. You may assume n is a power of 2.

function f(n)
if n > 1:
print_line(‘‘still going’’) 
f(n/2)
f(n/2)
This function prints the line “still going” if the value of n is > 1. It then calls the same
function twice with the value (n/2). So the function f(n/2) prints a line “still going” if the value of (n/2) is > 1. The number of printed lines are represented as: T(n) = 2T(n/2) + O(1) → equation
Using the master theorem  T(n) = aT(n/b) + O(nc)
T(n) = 2T(n/2) + O(1) where c = 0
logba = log22 and log22 > c
T(n) = O(n^1) = O(n)


10. Dasgupta Problem 2.23
An array A[1...n] is said to have a majority element if more than half of its entries are the same. Given an array, the task is to design an efficient algorithm to tell whether the array has a majority element, and, if so, to find that element. The elements of the array are not necessarily from some ordered domain like the integers, and so there can be no comparisons of the form “is A[i] > A[j]?”. (Think of the array elements as GIF files, say.) However you can answer questions of the form: “is A[i] = A[j]?” in constant time.
(a)  Show how to solve this problem in O(n log n) time. (Hint: Split the array A into two arrays A1 and A2 of half the size. Does knowing the majority elements of A1 and A2 help you figure out the majority element of A? If so, you can use a divide-and-conquer approach.)

To solve the problem in O(nlogn) time:
First divide the array into two halves of size n/2
First array = A1, second array = A2
Majority element from A1 = m1, majority element from A2 =m2
(outline of code to find the majority of the element):
	Function majority(s[1,...,m])
	Input: an array of numbers s[1,...,m]
	Output: majority value of array s
	If (m==1)
	Return (s[1])
	Mid = cieling(m/2)
	L_elem = majority(s[1,...,mid])
	R_elem = majority(s[mid+1,...,m])
	If (L_elem == R_elem):
	Return L_elem
	L_sum = frequency(s[1,...,m], L_elem)
	R_sum = frequency(s[1,...,m], r_elem)
	If L_sum>mid+1:
	Return L_elem
	Else if R_sum>mid+1:
	Return R_elem
	Else
	Return no-majority elements

Check whether the count of m1 or m2 is greater than the size of the array A
(outline of code to find the frequency of the algorithm):
	Function frequency(s[1,...,m], elem)
	Input: an array of numbers s[1,...,m]
	Output: count of element elem of the array s
	For i=1 to m:
	if(s[i]=elem)
	Increase count
	Return count

(b)  Can you give a linear-time algorithm? (Hint: Here’s another divide-and-conquer approach: 
• Pair up the elements of A arbitrarily, to get n/2 pairs
• Look at each pair: if the two elements are different, discard both of them; if they are the same, keep just one of them
Show that after this procedure there are at most n/2 elements left, and that they have a majority element if and only if A does.)

To solve the problem in linear time:
First divide the array into two halves of size n/2
First array = A1, second array = A2
Majority element from A1 = m1, majority element from A2 = m2
(outline to find the majority of the element):
	Function majority_linear(s[1,...,m])
	Input: an array of numbers s[1,...,m]
	Output: majority value of array s
	if(m==2)
	if(m[1]=m[2])
	Return (s[1])
	Else
	Return no-majority-elements
	Create array temp_array
	For k=1 to m:
	If s[k] = s[k+1]
	Insert s[k] into temp
	K=k+1 
	Return majority_linear(temp)

Check whether the count of m1 or m2 is greater than the size of the array A
(outline to find the frequency of the algorithm):
	Function frequency_linear(s[1,...,m])
	Input: an array of numbers s[1,...,m])
	Output: majority element of the array s
	Q = majority_linear(s[1,...,m])
	Count = frequency(s[1,...,m],q)
	If Count>floor(n/2) +1:
	Return Q
	Else
	Return no-majority-elements
