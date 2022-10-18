package com.berns.clients;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import com.berns.concurrency.NonblockingCounter;
import com.berns.concurrency.ProcessingThread;

public class ThreadClient {

	static class Slave {

		synchronized void work() {

			try {
				System.out.println("Go to work!");
				Thread.sleep(20000);
				System.out.println("Work done!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		void rest() {
			System.out.println("Rest!!!");
		}

	}

	static class FactorialCalculator implements Callable<Long> {

		private int number;

		FactorialCalculator(int number) {
			this.number = number;
		}

		@Override
		public Long call() throws Exception {

			return factorial(number);
		}

		private Long factorial(int number) throws InterruptedException {
			long result = 1;
			// 5*4*3*2*1
			while (number != 0) {
				result = number * result;
				--number;
			}
			Thread.sleep(300);
			System.out.println("factorial method: " + result);
			return result;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		// testThreadLocal();
		// testAtomicRef();
		// testAtomicCounter();
		//testCallableFuture();
		testExecutorSvc();
	}

	static void testCallableFuture() throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService es = Executors.newSingleThreadExecutor();

		Future<Long> output = es.submit(new FactorialCalculator(5));

		Long result = output.get(); // call to get() blocks until call()
									// completes
		System.out.println("Output = " + result);

		es.shutdown(); // terminates es disallows new tasks, but allows previous
						// tasks to complete.

		// if(!es.awaitTermination(600, TimeUnit.MILLISECONDS)){
		// System.out.println("Thread didn't terminate...");
		// List<Runnable> pending = es.shutdownNow();
		// System.out.println("pending> " + pending);
		// }else{
		// System.out.println("Factorial of 5 = " + output.get());
		// }

		es.shutdown();
	}

	static void testExecutorSvc() {

		final Slave frankie = new Slave();

		Runnable run1 = () -> {
			System.out.println("Run1 >");
			frankie.work();
		};
		Runnable run2 = () -> {
			System.out.println("Run2 >");
			frankie.rest();
		};

		Thread t1 = new Thread(run1, "run1");
		Thread t2 = new Thread(run2, "run2");

		// t1.start();
		// t2.start();

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(run1);
		exec.execute(run2);

		exec.shutdown();
	}

	private static void testAtomicCounter() {
		NonblockingCounter nbc = new NonblockingCounter();

		Runnable task = () -> {
			System.out.println(">>" + Thread.currentThread().getName());
			nbc.increment();
			System.out.println(">> counter = " + nbc.getValue());
		};

		// Thread t1 = new Thread(task, "t1");
		// Thread t2 = new Thread(task, "t2");
		// t1.start();
		// t2.start();

		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		Stream.of(1, 2, 3).forEach(

				num -> threadPool.execute(task)

		);

		// threadPool.shutdownNow();
		threadPool.shutdown(); // Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			if (!threadPool.awaitTermination(2, TimeUnit.SECONDS)) {
				threadPool.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!threadPool.awaitTermination(2, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			threadPool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}

	}

	private static void testAtomicRef() throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "TA");
		t1.start();
		Thread t2 = new Thread(pt, "TB");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("======================================");
		System.out.println("Processing count=" + pt.getCount());

	}

	private static void testThreadLocal() {
		// ThreadClient.MyRunnable sharedRsc = new MyRunnable();
		// Thread t1 = new Thread(sharedRsc);
		// Thread t2 = new Thread(sharedRsc);
		long start = System.nanoTime();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		long total = TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);

		System.out.println(">>> Seconds : " + total);
	}

}
