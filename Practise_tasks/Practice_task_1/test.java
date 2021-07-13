public class test {
    public static void main(String[] args) {
        int[] PlayerList = {1,2,3,4,5};
        for (int k=0; k<3; k++) {
            PlayerList[3 - k] = PlayerList[3 - k-1];
        }
        PlayerList[0] = 4;
        PlayerList[0] += 100;
        for (int k=0; k<5; k++) {
            System.out.println(PlayerList[k]);
        }
    }
}
