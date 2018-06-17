package challenge_crypto;
public class Challenge_crypto {
    public String clockwise(char[][] array){
        String output = "";
        int minColumn = 0;
        int maxColumn = array[0].length-1;
        int maxRow = array.length-1;
        int minRow = 0;
        int lengthString = array[0].length * array.length;
        while(true){
            for (int i = minRow; i <= maxRow; i++) {
                output = output + array[i][maxColumn];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            maxColumn--;
            for (int i = maxColumn; i >= minColumn; i--) {
                output = output + array[maxRow][i];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            maxRow--;
            for (int i = maxRow; i >= minRow; i--) {
                output = output + array[i][minColumn];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            minColumn++;
            for (int i = minColumn; i <= maxColumn; i++) {
                output = output + array[minRow][i];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            minRow++;
        }
    }
    
    public String counterClockwise(char[][] array){
        String output = "";
        int minColumn = 0;
        int maxColumn = array[0].length-1;
        int maxRow = array.length-1;
        int minRow = 0;
        int lengthString = array[0].length * array.length;
        while(true){
            for (int i = maxColumn; i >= minColumn; i--) {
                output = output + array[minRow][i];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++) {
                output = output + array[i][minColumn];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            minColumn++;
            
            for (int i = minColumn; i <= maxColumn; i++) {
                output = output + array[maxRow][i];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            maxRow--;
            for (int i = maxRow; i >= minRow; i--) {
                output = output + array[i][maxColumn];
                if(output.length() >= lengthString){
                    return output;
                }
            }
            maxColumn--;
        }
    }
    
    public char[][] toMatrix(String string, int columns, int rows){
        int index = 0;
        char[][] matrix = new char[rows][columns];
        char[] charArray = string.replaceAll("\\s","").replaceAll("[^a-zA-Z0-9]+","").toUpperCase().toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < charArray.length) {
                    matrix[i][j] = charArray[index];
                } else {
                    matrix[i][j] = 'X';
                }
                index++;
            }
        }
        return matrix;
    }

    public void encode(String string, int columns, int rows, String rotationDirection){
        char[][] matrix = this.toMatrix(string, columns, rows);
        if (rotationDirection.equals("clockwise")) {
            System.out.println(this.clockwise(matrix));
        } else if (rotationDirection.equals("counter-clockwise")){
            System.out.println(this.counterClockwise(matrix));
        }
    }
    
    public static void main(String[] args) {
        Challenge_crypto obj = new Challenge_crypto();
        obj.encode("Why does it say paper jam when there is no paper jam?", 3, 14, "counter-clockwise");
    }
}