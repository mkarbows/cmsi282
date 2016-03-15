import java.util.Arrays;

public class autoKeyViginereCipher {
	private String plainText;
	private String keyword;
	private String key;
	private int[] cipherText;

	private String makeKey (String keyword, String plainText) {
		String key = keyword;
		int lettersToCopy = plainText.length() - keyword.length();

		for (int i = 0; i < lettersToCopy; i++) {
			key += plainText.charAt(i);
		}
		this.key = key;
		return key;
	}

	private int[] makeCipher() {
		cipherText = new int[plainText.length()];

		for (int i = 0; i < plainText.length(); i++) {
			int codePointPT = Character.codePointAt(plainText, i);
			int codePointKey = Character.codePointAt(key, i);
			
			cipherText[i] = codePointPT + codePointKey;
			if (cipherText[i] > 0x10FFFF) {
				cipherText[i] -= 0x10FFFF;
			}
		}
		return cipherText;
	}

	public autoKeyViginereCipher(String keyword, String plainText) {
		if (keyword.length() > plainText.length()) {
			throw new IllegalArgumentException("keyword can't be longer than your message");
		}
		this.keyword = keyword;
		this.plainText = plainText;
		this.key = makeKey(keyword, plainText);
		this.cipherText = makeCipher();
	}	

	public void print() {
		System.out.println("Keyword: " + keyword + "\nPlaintext: " + plainText + "\nKey: " + key + 
			"\nCiphertext: " + Arrays.toString(cipherText) + "\n");
	}

	public static void main(String[] args) {
		autoKeyViginereCipher akvc2 = new autoKeyViginereCipher(args[0], args[1]);
		akvc2.print();
	}
}
