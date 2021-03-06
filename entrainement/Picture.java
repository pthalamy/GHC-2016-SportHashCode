package entrainement;

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
        for (int i = 0; i < cell.length; i++) {
            for (int i1 = 0; i1 < cell[i].length; i1++) {
                cell[i][i1] = Color.BLANK;
            }
        }
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

	public void decCount() {
		count--;
	}
	
    public int getBlackCount(){
        return count;
    }

    /**
     * Compte le nombre de pixels à colorier dans le sous-rectangle défini
     * @param R1 Ligne haute gauche
     * @param C1 Colonne haute gauche
     * @param R2 Ligne basse droite
     * @param C2 Colonne basse droite
     * @return
     */
    public int getSubPictureBlackCount(int R1, int C1, int R2, int C2) {
        int ret = 0;
        for (int i = R1; i < R2; i++) {
            for (int j = C1; j < C2; j++) {
                if (this.getCellValue(i, j) == Color.BLACK) {
                    ret += 1;
                }
            }
        }
        return ret;
    }
    
    public HorizontalLine getBestHorizontalLine(){
        HorizontalLine hl = new HorizontalLine(0, 0, 0);
        
        for (int i = 0; i < N; i++) {
            boolean black = false;
            int start = 0,size = 0;
            for(int j = 0;j < M;j++) {
                if (black && this.cell[i][j] == Color.BLACK){
                    size++;
                }
                if(black && this.cell[i][j] == Color.BLANK) {
                    if (size > hl.size) {
                        hl.size = size;
                        hl.R = i;
                        hl.C1 = start;
                        hl.C2 = j - 1;
                    }
                    black = false;
                    size = 0;
                }
                if (!black && this.cell[i][j] == Color.BLACK) {
                    start = j;
                    black = true;
                    size = 1;
                }
            }
            if (size > hl.size) {
                hl.size = size;
                hl.R = i;
                hl.C1 = start;
                hl.C2 = M - 1;
            }
        }
        return hl;
    }

    public VerticalLine getBestVerticalLine(){
        VerticalLine vl = new VerticalLine(0, 0, 0);
        
        for (int j = 0; j < M; j++) {
            boolean black = false;
            int start = 0,size = 0;
            for(int i = 0;i < N;i++) {
                if (black && this.cell[i][j] == Color.BLACK){
                    size++;
                }
                if(black && this.cell[i][j] == Color.BLANK) {
                    if (size > vl.size) {
                        vl.size = size;
                        vl.C = j;
                        vl.R1 = start;
                        vl.R2 = i - 1;
                    }
                    black = false;
                    size = 0;
                }
                if (!black && this.cell[i][j] == Color.BLACK) {
                    start = i;
                    black = true;
                    size = 1;
                }
            }
            if (size > vl.size) {
                vl.size = size;
                vl.C = j;
                vl.R1 = start;
                vl.R2 = N - 1;
            }
        }
        return vl;
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
                "\n blackCount=" + count +
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
