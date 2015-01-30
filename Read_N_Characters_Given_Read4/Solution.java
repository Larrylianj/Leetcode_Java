/*
* int read4(char[] buf) reads 4 character from file, could return <4 if eof meets
**/

public class Solution{
	private Queue<Character> lastLeft = new LinkedList<Character>();

	public int read(char[] buf, int n){
		int i = 0;
		int bufferLength = 0, readLength = 4;
		char[] buffer = new char[4];
		// pop the last left characters first
		while(i < n && !lastLeft.isEmpty()){
			buf[i++] = lastLeft.poll();
		}
		// read in new characters
		while(i < n){
			if(bufferLength==0){
				bufferLength = read4(buffer);
				readLength = bufferLength;
			}
			buf[i++] = buffer[readLength-(bufferLength--)];
			if(readLength < 4 && bufferLength==0)
				return i;
		}
		// push the remaining into queue for next use
		while(bufferLength!=0){
			queue.add(buffer[bufferLength--]);
		}
		return i;
	}
}

