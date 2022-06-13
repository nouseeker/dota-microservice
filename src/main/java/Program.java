import lombok.SneakyThrows;

public class Program		//Класс с методом main().
{
    public static void main(String[] args) throws InterruptedException {
        //Создание потока
        Thread myThready = new Thread(new Runnable()
        {
            @SneakyThrows
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    System.out.println("Привет из побочного потока!");
                }
            }
        });
        myThready.start();	//Запуск потока

        for (int i = 0; i < 10; i++) {
            Thread.sleep(200);
            System.out.println("Главный поток завершён...");
        }
    }
}