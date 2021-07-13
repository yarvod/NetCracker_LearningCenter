import java.util.Scanner;

public class Game {

    public static int Play(int K) {
        int score = 0;
        for (int j=0; j<K; j++) {
            score += (int) (Math.random() * 6 + 1); 
        }
        return score;  
    }

    public static int[] maxArray(int[] Array) {
        int index = 0;
        int max = 0;
        int[] maxArray = new int[2];
        for (int i = 0; i<Array.length; i++) {
            if (max <= Array[i]) {
                max = Array[i];
                index = i;
            }
        }
        maxArray[0] = index;
        maxArray[1] = max;
        return maxArray;
    }

    public static int[][] Substitute(int[][] PlayerList, int maxScoreIndex) {
        int[] save_winner = PlayerList[maxScoreIndex];
        for (int k=0; k<maxScoreIndex; k++) {
            PlayerList[maxScoreIndex - k] = PlayerList[maxScoreIndex - k-1];
        }
        PlayerList[0] = save_winner;
        return PlayerList;
    }

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);
        int N;
        int K;
        int maxScoreIndex;
        
        System.out.print("Enter number of players: ");
        N = in.nextInt();

        System.out.print("Enter number of cubes: ");
        K = in.nextInt();
        in.close();

        int[] Scores = new int[N];
        int[][] PlayerList = new int[N][2];
        int[] TotalScores = new int[N];
        int WinnerIndex = 0;


        for (int i=0; i<N; i++) {
            PlayerList[i][0] = i;
            PlayerList[i][1] = 0;
        }

        for (int round=0; round<7; round++) {

            System.out.println("Round: " + (round+1));
            for (int player_num=0; player_num<N; player_num++) {
                Scores[player_num] = Play(K);
            }
            maxScoreIndex = maxArray(Scores)[0];

            PlayerList[maxScoreIndex][1] += 1;
            
            for (int k=0; k<N; k++) {
                System.out.println("Player " + PlayerList[k][0] + " has score: " + Scores[k]);
            }

            PlayerList = Substitute(PlayerList, maxScoreIndex);
        }

        System.out.println("Outcomes: ");

        for (int k=0; k<N; k++) {
            System.out.println("Player " + PlayerList[k][0] + " has number of victories: " + PlayerList[k][1]);
        }
        
        for (int i=0; i<N; i++) {
            TotalScores[i] = PlayerList[i][1];
        }

        WinnerIndex = maxArray(TotalScores)[0];
        
        System.out.println("Winner of the Game: Player " + PlayerList[WinnerIndex][0]);

    }
}