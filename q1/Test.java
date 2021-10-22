import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void read() {
        try {
            System.out.println("시작 값을 입력 해 주세요");
            int initValue = Integer.parseInt(br.readLine());
            System.out.println("끝 값을 입력 해 주세요");
            int endValue = Integer.parseInt(br.readLine());
            if(initValue>endValue){
                System.out.println("error! 시작값은 끝 값보다 작아야 합니다.");
                read();
            }
            System.out.print("반복할 횟수를 정해주세요!");
            int loopCount = Integer.parseInt(br.readLine());
            if(loopCount<=0){
                System.out.println("반복횟수는 0보다 커야합니다");
                read();
            }
            writeIntoFile(loop(initValue, endValue, loopCount));
        } catch (NumberFormatException ne) {
            System.out.println("error! 숫자를 입력해주세요");
            read();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    void writeIntoFile(String value) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt",true));
            PrintWriter pw = new PrintWriter(bw,true);
            pw.println(value);
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String loop(int initVal, int endVal, int count) {
        int[] arr = {1, 2, 3, 4, 5};
        StringBuilder b = new StringBuilder();
        b.append("[결과]").append("\n");
        IntStream.range(0, count)
                .forEach(i ->
                        IntStream.
                                rangeClosed(initVal, endVal)
                                .forEach(
                                        j -> b.append(Arrays.stream(arr).anyMatch(arrData -> arrData == j) ? "" : j % 10 == 0 ? j + "\n" : +j + " ")
                                )

                );
        System.out.println("반복 완료");
        return b.toString();
    }

    public static void main(String[] args) {
        new Test().read();
    }
}
