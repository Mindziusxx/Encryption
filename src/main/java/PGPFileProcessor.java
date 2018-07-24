import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PGPFileProcessor {

    public static void main(String[] args) throws Exception {


        encrypt();
    ///decrypt();
    }

    // Encrypt
    private static String keyFile = "C:\\Users\\cmsi\\Downloads\\bandom\\ita-pub-key.asc";
    private static String outputFile = "C:\\Users\\cmsi\\Downloads\\bandom\\Enctrypt\\encrypted_first.xlsx.gpg";
    private static String inputFile = "C:\\Users\\cmsi\\Downloads\\bandom\\Enctrypt\\first.xlsx";


//    //    /// Decrypt
//    private static String keyFile = "C:\\Users\\cmsi\\Downloads\\bandom\\ita-secret-key.asc";
//    private static String inputFile = "C:\\Users\\cmsi\\Downloads\\bandom\\Enctrypt\\encrypted_first.xlsx.gpg";
//    private static String outputFile = "C:\\Users\\cmsi\\Downloads\\bandom\\Enctrypt\\decrypt_first.xlsx";


    private static String passphrase = "test";
    private static boolean asciiArmored = false;
    private static boolean integrityCheck = true;


    public static boolean encrypt() throws Exception {
        FileInputStream keyIn = new FileInputStream(keyFile);

        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.encryptFile(out, inputFile, PGPUtil.readPublicKey(keyIn), asciiArmored, integrityCheck);
        out.close();
        keyIn.close();
        return true;
    }

    public static boolean decrypt() throws Exception {
        FileInputStream in = new FileInputStream(inputFile);
        FileInputStream keyIn = new FileInputStream(keyFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.decryptFile(in, out, keyIn, passphrase.toCharArray());
        in.close();
        out.close();
        keyIn.close();
        return true;
    }

    public boolean isAsciiArmored() {
        return asciiArmored;
    }

    public void setAsciiArmored(boolean asciiArmored) {
        this.asciiArmored = asciiArmored;
    }

    public boolean isIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck(boolean integrityCheck) {
        this.integrityCheck = integrityCheck;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

}