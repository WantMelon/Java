package task1;

import task1.myCollections.Queue;
import task1.myCollections.Stack;

import java.util.Scanner;

public class Main {
    public static Queue<Clothes> inputClothesQueue() {
        Queue<Clothes> clothesQueue = new Queue<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько предметов одежды: ");
        int clothesAmount = sc.nextInt();
        for (int i = 0; i < clothesAmount; ++i) {
            System.out.println("\n" + (i + 1) + "-ая вещь");
            System.out.print("Количество пуговиц, которые необходимо пришить: ");
            int buttonAmount = sc.nextInt();
            System.out.print("Время на штопку (целое число в секундах): ");
            int buttonDarningTime = sc.nextInt();
            System.out.print("Время поступления на обработку: ");
            int processingTime = sc.nextInt();

            clothesQueue.push(new Clothes(buttonAmount, buttonDarningTime, processingTime));
        }

        return clothesQueue;
    }

    public static void main(String[] args) {
        Queue<Clothes> clothesQueue = inputClothesQueue();
        Stack<Clothes> startStack = new Stack<>();
        Stack<Clothes> bufferedStack = new Stack<>();
        Stack<Clothes> finishStack = new Stack<>();
        Seamstress first = new Seamstress(startStack, bufferedStack);
        Seamstress second = new Seamstress(bufferedStack, finishStack);

        while (!clothesQueue.isEmpty()) {
            clothesQueue.peek().decreaseProcessingTime();
            if (clothesQueue.peek().getProcessingTime() == 0) {
                startStack.push(clothesQueue.pop());
            }
            if (startStack.isEmpty() && !first.isBusy()) {
                first.increaseDownTime();
            } else if (!startStack.isEmpty() && !first.isBusy()) {
                first.addCurrentClothes(startStack.pop());
            } else {
                first.increaseWorkingTime();
            }

            if (bufferedStack.isEmpty() && !second.isBusy()) {
                second.increaseDownTime();
            } else if (!bufferedStack.isEmpty() && !second.isBusy()) {
                second.addCurrentClothes(bufferedStack.pop());
            } else {
                second.increaseWorkingTime();
            }
        }
    }
}
