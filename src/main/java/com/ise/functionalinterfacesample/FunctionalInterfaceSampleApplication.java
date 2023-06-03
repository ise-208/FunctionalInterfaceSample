package com.ise.functionalinterfacesample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class FunctionalInterfaceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalInterfaceSampleApplication.class, args);
	}

	@Component
	public class func implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {

//			supplier
			Supplier<String> supplier = () -> "supplier";
			System.out.println(supplier.get());
			List<String> list = Arrays.asList("s","u","p");
			Logger logger = Logger.getLogger("logger");
//			public void info(Supplier<String> msgSupplier) {
//				log(Level.INFO, msgSupplier);
//			}
//			supperを受ける
			logger.info(() -> "list=" + list);

//			consumer
			Consumer<String> consumer = c -> System.out.println(c);
			consumer.accept("consumer");
			Consumer<String> c1 = s -> System.out.println("c1: " + s);
			Consumer<String> c2 = s -> System.out.println("c2: " +s);
			Consumer<String> c = c1.andThen(c2);
			c.accept("abc");


		}

	}

}
