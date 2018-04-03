public class HuffKnoop {
    public char karakter;
    public int frequentie;
    public HuffKnoop leftChild, rightChild;

    public HuffKnoop(char karakter, int freq, HuffKnoop leftChild, HuffKnoop rightChild) {
        this.karakter = karakter;
        this.frequentie = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}