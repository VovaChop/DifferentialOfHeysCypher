package ua.myproject.heys;

public class Heys {
	short [] blocks;
	private byte [] S = {8, 0, 12, 4, 9, 6, 7, 11, 2, 3, 1, 15, 5, 14, 10, 13};
	
	Heys () {
	}
	
	Heys (short[] inText) {
		blocks = new short [inText.length];
		System.arraycopy(inText, 0, blocks, 0, blocks.length);
	}
	public byte XOR(byte text, byte key) {
		return (byte) (text^key);
	}
	
	public void sBlock (byte [] fragments) {
		for(int i=0; i<fragments.length; i++) {
			fragments[i] = S[fragments[i]];
		}
	}
	
	public byte [] bitPermutation (byte [] afterS) {
		byte [] result = new byte [4];
		for(int i=0; i<4; i++) {
			
		}
		return result;
	}
	
	public byte [] blockIntoFragments (short input) {
		byte [] result = new byte [4];
		for(int i=0; i<4; i++) {
			result[i] = (byte) (input%16);
			input>>=4;
		}
		return result;
	}
}
