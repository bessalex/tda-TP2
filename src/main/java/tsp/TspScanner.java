package tsp;

import java.io.File;
import java.util.Scanner;

/**
 * Created by alex on 17/11/16.
 */
public class TspScanner {
    Scanner scanner = null;
    int numElem;

    public TspScanner(String filePath, int numElem){
        try {
            this.scanner = new Scanner(new File(filePath));
            this.numElem = numElem;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Integer[][] getMatrix(String sep){
        Integer[][] matrix = new  Integer[this.numElem+1][this.numElem+1];
        scanner.useDelimiter(sep);

        if (!scanner.hasNextInt())
            return null;

        for(int i=0; i <= this.numElem ; i++){
            for(int j=0; j <= this.numElem ; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }


    public Integer[] getSolution(String sep){
        int i=0;
        Integer[] solution = new  Integer[this.numElem+2];
        scanner.useDelimiter(sep);

        if (!scanner.hasNext())
            return null;

        while (scanner.hasNext()  && (i < this.numElem+2 )){
            String value;
            value = scanner.next();
            solution[i] = Integer.parseInt(value);
            i++;
        }

        return solution;
    }

}
