edges = []	
explored = []	
totalWeight = 0 # Will store the total cost of our tree. will update when min -cost edge is chosen and popped from the edges array.

def readGraph(filename):
	global edges
	
	f = open(filename, "r")
	ignorer = 0
	for line in f:
	    # Ignore first line
		if ignorer == 0:
		    ignorer = 1
			continue;
		elif line == "":
			break;
		edges.append([int(line.split(" ")[0]), int(line.split(" ")[1]), int(line.split(" ")[2])])		# Add a new edge
	f.close()
	
def prim():
	global edges
	global explored
	global totalWeight
	
	# Define the first vertex as the one from which to start.
	explored.append(edges[0][0])
	
	while len(edges) > 0:	# Loop while there are still available edges
		print(len(edges))
		weightfound = False
		minweight = 0
		newvertex = 0
		top = len(edges) - 1
		i = 0
		while i <= top:
			#remove the edge if both nodes are already connected
			if edges[i][0] in explored and edges[i][1] in explored:
				del edges[i]
				top -= 1 # decrease number of edges
				continue
			elif edges[i][0] in explored and edges[i][1] not in explored:
				if not weightfound or edges[i][2] < minweight:
					weightfound = True
					minweight = edges[i][2]
					newvertex = edges[i][1] #vertex not already connected                                                      
			elif edges[i][0] not in explored and edges[i][1] in explored:
				if not weightfound or edges[i][2] < minweight:
					weightfound = True
					minweight = edges[i][2] 
#used some code from online to help with determining
when minweight will equal the edge
					newvertex = edges[i][0] #vertex not already connected
			i += 1
		# add the new min bcost edge to the connected graph
		if weightfound:
			cost += minweight
			explored.append(newvertex)
		
		
readGraph("edges.txt")
prim()
print("Minimum spanning tree has cost: ", cost)
