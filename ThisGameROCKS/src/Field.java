public class Field 
{
	private int index;
	private Letter letter; // enum
	
	public Field(int index, Letter letter) {
		this.index = index;
		this.letter = letter;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	public Letter getLetter() {
		return letter;
	}
	
	
}
