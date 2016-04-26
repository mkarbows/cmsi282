public class Pint {

	private int volume;
	private int maxVolume;
	private boolean full;
	private boolean empty;

	public Pint(int maxVol) {
		maxVolume =  maxVol;
	}

	public Pint(int maximumVol, int vol) {
		maxVolume = maximumVol;
		volume = vol;
		if (maximumVol == vol) {
			full = true;
		} else {
			full = false;
		}
		if (vol == 0) {
			empty = true;
		} else {
			empty = false;
		}
	}

	public void filling(Pint otherPint) {
		if (otherPint.isEmpty()) {
			return;
		}
		if (this.isFull()) {
			return;
		}
		int totalVolume = volume + otherPint.getVolume();
		if (totalVolume > maxVolume) {
			volume = maxVolume;
			otherPint.setVolume(totalVolume - maxVolume);
			this.isCompletelyFull();
			otherPint.neitherEmptyNorFull;
		}
		else {
			volume = totalVolume;
			otherPint.setVolume(0);
			if (totalVolume == maxVolume) {
				this.isCompletelyFull();
			} else {
				this.isNeitherEmptyNorFull();
			}
			otherPint.isCompletelyEmpty();
		}
	}

	public void empty(Pint otherPint) {
		otherPint.filling(this);
	}


	public void emptyInto(Pint otherPint) {
		otherPint.fillWith(this);
	}

	public void isCompletelyEmpty() {
		empty = true;
		full = false;
	}

	public void isCompletelyFull() {
		empty = false;
		full = true;
	}

	public void isFull() {
		return full;
	}

	public void isEmpty() {
		return empty;
	}

	public void neitherEmptyNorFull() {
		empty = false;
		full = false; 
	}
}
