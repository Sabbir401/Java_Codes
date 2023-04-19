
import java.util.Scanner;
import java.util.Random;

public class TcpFlowControl {

    public static int generateFrame(int winSize) {

        Random random = new Random();
        int i, noOfGeneratedFrame;

        noOfGeneratedFrame = random.nextInt() % winSize;

        if (noOfGeneratedFrame == 0) {
            return winSize;
        }
        else return noOfGeneratedFrame;
    }

    public static int generateAck(int noOfSent) {
        Random random = new Random();
        int i, noOfAckFrame;
        noOfAckFrame = (int) (random.nextInt() % noOfSent);
        return noOfAckFrame;
    }

    public static void main(String[] args) {
        int noOfFrame, winSize, startByte = 0, endByte = 0, noOfAck = 0,noOfSent = 0;


        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the total no of frame: ");
        noOfFrame = scn.nextInt();

        System.out.println("Enter the window size: ");
        winSize = scn.nextInt();

        int dueFrame = noOfFrame;
        while (dueFrame >= 0) {
            noOfSent = generateFrame(winSize);
            endByte += noOfSent;

            if (endByte > noOfFrame) {
                endByte = noOfFrame;
            }

        for (int i = startByte +1; i <= endByte; i++) {
                System.out.println("Sending frame " + i);
            }

            noOfAck = generateAck(noOfSent);
            startByte += noOfAck;

            if (startByte > noOfFrame) {
                startByte = noOfFrame;
            }

            System.out.println("Acknowledgement for the frame upto " + startByte);

            dueFrame -= noOfAck;

            endByte = startByte;
        }
        System.out.println("\nThe Sliding Window Protocol concludes here.");
    }
}