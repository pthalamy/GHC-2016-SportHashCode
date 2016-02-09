public class Picture {

    private int N;
    private int M;
    

    private byte cell[][] ;


    public Picture(int N, int M) {
        super();

        this.N = N;
        this.M = M;

        cell = new byte[N][M];
    }

    public int getN(int N) {
	    return N;
    }

    public int getM() {
	return M;
    }

    public void setCell(int R, int C, byte v) {
	this.cell[R][C] = v;
    }

    public byte getCellValue(int R, int C) {
	return this.cell[R][C];
    }
}
