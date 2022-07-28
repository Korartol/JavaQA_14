public class AlreadyExistsException extends RuntimeException {

    // конструктор с параметром-сообщением, который будет вызывать суперконструктор предка
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
