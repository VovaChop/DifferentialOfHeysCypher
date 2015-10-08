package ua.myproject.heys;

public class Heys {
	short blocksIn [],blocksOut [], keys [];
	private byte [] S = {8, 0, 12, 4, 9, 6, 7, 11, 2, 3, 1, 15, 5, 14, 10, 13};
	
	public Heys () {
	}
	
	public Heys (short[] inText, short[] key) {
		blocksIn = new short [inText.length];
		System.arraycopy(inText, 0, blocksIn, 0, blocksIn.length);
		blocksOut = new short [7];
		keys = new short [7];
		System.arraycopy(key, 0, keys, 0, key.length);
	}
	
	public void cypherFull () {
		for(int i=0; i<7; i++) {
			blocksOut[i] = round(blocksIn[i], keys[i]);
		}
	}
	
	public byte [] XOR(byte [] text, byte [] key) {
		byte [] result = new byte [text.length];
		for(int i=0; i<text.length; i++) {
			result[i] = (byte) (text[i]^key[i]);
		}
		return result;
	}
		
	public void sBlock (byte [] fragments) {
		for(int i=0; i<fragments.length; i++) {
			fragments[i] = S[fragments[i]];
		}
	}
	
	public byte [] bitPermutation (byte [] afterS) {
		byte [] result = new byte [4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				result[3-j] ^= (byte) ((afterS[i]>>j)%2)<<(3-i);
			}
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
	
	public short fragmentsIntoBlock (byte [] input) {
		short result = 0;
		for(int i=0; i<4; i++) {
			result ^= (input[i]<<4*(3-i));
		}
		return result;
	}
	
	public short round (short enterBlock, short key) {
		enterBlock ^=key;
		byte [] fragments = blockIntoFragments(enterBlock);
		sBlock(fragments);
		return fragmentsIntoBlock(bitPermutation(fragments));
		
	}
}
