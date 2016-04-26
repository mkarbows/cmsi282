1. Pint.java and PintGroup.java
3.8: Pouring water. We have three containers whose sizes are 10 pints, 7 pints, and 4 pints, respectively. The 7-pint and 4-pint containers start out full of water, but the 10-pint container is initially empty. We are allowed one type of operation: pouring the contents of one container into another, stopping only when the source container is empty or the destination container is full. We want to know if there is a sequence of pourings that leaves exactly 2 pints in the 7-or 4-pint containers.
	a.) Model this as a graph problem: give a precise definition of the graph involved and state the specific question about this graph that needs to be answered.
This graph has vertices that represent how much water is in each pitcher, and edges that represent if we can get from one vertex to the other by pouring. The specific question that needs to be answered is what is the shortest path to get from (0,7,4) to (2,7,2) or any way that there will be exactly 2 pints in the 7-pint or 4-pint containers.
	b.) What algorithm should be applied to solve the problem?
	c.) Find the answer by applying the algorithm
2. on hard copy
3. on hard copy
4. Dasgupta Problem 4.18.
while H is not empty:
u = deletemin(H)
for all edges (u,v)  E:
if dist(v) > dist(u) + l(u,v):
dist(v) = dist(u) + l(u,v)
best(v) = best(u) + 1
decreasekey(H, v)
if dist(v) = dist(u) + l(u,v):
if best(v) < best(u) + 1:
best(v) = best(u) + 1
5. prim.py
6. SubsetSum.java
7. Changer.java
