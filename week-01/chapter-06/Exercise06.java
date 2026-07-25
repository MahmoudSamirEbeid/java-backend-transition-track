public class Exercise06 {

    public static void main(String[] args) {

        Service service = new Service();

        try {
            service.methodOne();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.methodTwo();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.methodThree();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program Finished");
    }
}

class Service {

    public void methodOne() throws MyException {
        throw new MyException("Exception from Method One");
    }

    public void methodTwo() throws MyException {
        throw new MyException("Exception from Method Two");
    }

    public void methodThree() throws MyException {
        throw new MyException("Exception from Method Three");
    }
}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}