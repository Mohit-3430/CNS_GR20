class HillCipher {
    void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
        int x, i, j;
        // matrix multiplication
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;
                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    void algo(String message, String key) {
        // 2d array to fill the key
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        // 2d array with the pt in column
        int[][] messageVector = new int[3][1];
        for (int i = 0; i < 3; i++)
            messageVector[i][0] = (message.charAt(i)) % 65;

        // based on dimmensions initialize here 3x3 * 3x1 => 3x1
        int[][] cipherMatrix = new int[3][1];
        encrypt(cipherMatrix, keyMatrix, messageVector);
        String CipherText = "";
        for (int i = 0; i < 3; i++)
            CipherText += (char) (cipherMatrix[i][0] + 65);

        System.out.print(" Ciphertext:" + CipherText);
    }

}

class Task1c {
    public static void main(String[] args) {
        String message = "ACT";
        String key = "GYBNQKURP";

        HillCipher hc = new HillCipher();
        hc.algo(message, key);
    }
}