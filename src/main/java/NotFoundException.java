public class NotFoundException extends RuntimeException {

    // конструктор с параметром-сообщением, который будет вызывать суперконструктор предка
    public NotFoundException(String message) {
        super(message);
    }
}
