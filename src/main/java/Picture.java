

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

    public getN(int N) {
	return N;
    }

    public getM(int M) {
	return M;
    }

    public setCell(int R, int C, byte v) {
	this.cell[R][C] = v;
    }

    public byte getCellValue(int R, int C) {
	return this.cell[R][C];
    }
}
