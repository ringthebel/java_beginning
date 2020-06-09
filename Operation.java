public class Operation {
    int data = 50;

    void change_value(int data) {
        data = data + 100;
        System.out.println("giá trị data trong hàm change_value "+data);
    }
    void change_reference(Operation1 op) {
        op.data = op.data + 100;
        System.out.println("giá trị data trong hàm change_reference " +op.data);
    }
    public static void main(String args[]) {
        Operation1 op = new Operation1();

        System.out.println("Trước khi thay đổi: " + op.data);
        op.change_value(500);
        System.out.println("Sau khi thay đổi value: " + op.data);
        op.change_reference(op);
        System.out.println("Sau khi thay đổi reference: " + op.data);

    }
}
