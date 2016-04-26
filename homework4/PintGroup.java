import java.util.ArrayList;

//references Pint.java because that defines what one Pint is and here we are implementing 3 pints

public class PintGroup {
	private Pint[] group = new Pint[3];

	public PintGroup(Pint pint1, Pint pint2, Pint pint3) {
		group[0] = pint1;
		group[1] = pint2;
		group[2] = pint3;
	}

	public PintGroup clone() {
		Pint p1 = new Pint(group[0].getMaxVolume(), group[0].getVolume());
		Pint p2 = new Pint(group[1].getMaxVolume(), group[1].getVolume());
		Pint p2 = new Pint(group[2].getMaxVolume(), group[2].getVolume());
		return new PintGroup(p1, p2, p3);
	}

	public Pint get(int x){
		return group[x];
	}

	public boolean p1IntoP2() {
		boolean works = !group[0].isEmpty() && !group[1].isFull();
		if (works) {
			group[0].emptyInto(group[1]);
		}
		return works;
	}

	public boolean p1IntoP3() {
		boolean works = !group[0].isEmpty() && !group[2].isFull();
		if (works) {
			group[0].emptyInto(group[2]);
		}
		return works;
	}

	public boolean p2IntoP1() {
		boolean works = !group[1].isEmpty() && !group[0].isFull();
		if (works) {
			group[1].emptyInto(group[1]);
		}
		return works;
	}

	public boolean p2IntoP3() {
		boolean works = !group[1].isEmpty() && !group[2].isFull();
		if (works) {
			group[1].emptyInto(group[2]);
		}
		return works;
	}

	public boolean p3IntoP1() {
		boolean works = !group[2].isEmpty() && !group[0].isFull();
		if (works) {
			group[2].emptyInto(group[1]);
		}
		return works;
	}

	public boolean isNotIn(ArrayList<PintGroup> pintGroup) {
		int length  = pintGroup.size();
		for (int i = 0; i < length; i++) {
			if (pintGroup.get(i) != null) {
				int val1 = pintGroup.get(i).get(0).getVolume();
				int val2 = pintGroup.get(i).get(1).getVolume();
				int val3 = pintGroup.get(i).get(2).getVolume();
				if (val1 == group[0].getVolume() && val2 == group[1].getVolume()
 && val3 == group[2].getVolume()) {
					return false;
				}
			}
		}
		return true;
	}

	public String toString() {
		return "(" group[0].toString() + " , " + group[1].toString() + " , " + group[2].toString()
 + ")";
	}
}
