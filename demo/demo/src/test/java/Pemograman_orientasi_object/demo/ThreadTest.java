package Pemograman_orientasi_object.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ThreadTest {

	@Test
	void mainThread() {
		var name = Thread.currentThread().getName();
		System.out.println(name);
	};
	@Test
	void createThread() {
		Runnable runnable =() -> {
			System.out.println("Hello From Thread :" + Thread.currentThread().getName());
		};

		var thread = new Thread(runnable);
		thread.start();
		System.out.println("Program Selesai");
	}
	@Test
	void threadJoin() throws  InterruptedException{
		Runnable runnable =() -> {
			try {
				Thread.sleep(2_000L);
				System.out.println("Hello From Thread :" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		var thread = new Thread(runnable);
		thread.start();
		System.out.println("Menunggu Selesai");
		thread.join();
		System.out.println("Program Selesai");
	}
	@Test
	void threadInterrupted() throws  InterruptedException{
		Runnable runnable =() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Runnable : " + i);
			try {
				Thread.sleep(1_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		};
		var thread = new Thread(runnable);
		thread.start();
		Thread.sleep(5_000);
		thread.interrupt();
		System.out.println("Menunggu Selesai");
		thread.join();
		System.out.println("Program Selesai");
	}
}


