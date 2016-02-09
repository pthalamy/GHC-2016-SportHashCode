import java.util.Arrays;

public class Picture {

    private int N;
    private int M,count = 0;
    

    private Color cell[][] ;


    public Picture(int N, int M) {
        super();

        this.N = N;
        this.M = M;

        cell = new Color[N][M];
    }

    public int getN() {
	    return N;
    }

    public int getM() {
	return M;
    }

    public void setCell(int R, int C, Color v) {
	this.cell[R][C] = v;
    }

    public Color getCellValue(int R, int C) {
	return this.cell[R][C];
    }

    public void incCount() {
        count++;
    }

    public int getBlackCount(){
        return count;
    }

    @Override
    public Picture clone(){
        Picture p = new Picture(N,M);
        p.cell = this.cell.clone();
        return p;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Picture{" +
                "N=" + N +
                ", M=" + M +
                "\n count=" + count +
                "\n");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M;j++){
                s.append(getCellValue(i,j));
            }
            s.append("\n");
        }
        s.append("\n}");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        return Arrays.deepEquals(cell, picture.cell);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cell);
    }
}
