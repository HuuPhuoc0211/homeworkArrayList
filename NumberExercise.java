
package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

class NumberExercise {
    
    // Method nhập mảng số nguyên
    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    // Method xuất mảng ra màn hình
    public static void printData(ArrayList<Integer> numbers) {
        System.out.println("Mảng hiện tại: " + numbers);
    }

    // Method tìm giá trị phần tử lớn thứ 2 trong mảng
    public static int findMax2(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Mảng không đủ phần tử để tìm giá trị lớn thứ 2.");
            return -1; // Giá trị mặc định khi không tìm được
        }
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for (int num : numbers) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max2 = num;
            }
        }
        
        return max2 == Integer.MIN_VALUE ? -1 : max2;
    }

    // Method xoá các phần tử lẻ ra khỏi mảng
    public static void deleteOddNumber(ArrayList<Integer> numbers) {
        numbers.removeIf(num -> num % 2 != 0);
    }
}

class Process {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Nhap mang so nguyen");
            System.out.println("2. Xuat mang ra man hinh");
            System.out.println("3. Tim gia tri phan tu lon thu 2 trong mang");
            System.out.println("4. Xoa cac phan tu le ra khoi mang");
            System.out.println("5. Thoat");
            System.out.print("Chon phuong thuc: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    NumberExercise.EnterData(numbers);
                    break;
                case 2:
                    NumberExercise.printData(numbers);
                    break;
                case 3:
                    int max2 = NumberExercise.findMax2(numbers);
                    if (max2 != -1) {
                        System.out.println("Giá trị lớn thứ 2 trong mảng là: " + max2);
                    }
                    break;
                case 4:
                    NumberExercise.deleteOddNumber(numbers);
                    System.out.println("Đã xoá các phần tử lẻ.");
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }
}