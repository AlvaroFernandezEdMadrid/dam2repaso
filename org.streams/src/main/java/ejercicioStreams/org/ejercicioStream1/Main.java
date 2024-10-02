package ejercicioStreams.org.ejercicioStream1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
	
	/*
	 * 

1. Find all transactions in the year 2011 and sort them by value (small to high).
2. What are all the unique cities where the traders work?
3. Find all traders from Cambridge and sort them by name.
4. Return a string of all traders' names sorted alphabetically.
5. Are any traders based in Milan?
6. Print all transactions' values from the traders living in Cambridge.
7. What's the highest value of all the transactions?
8. Find the transaction with the smallest value.

9. Mostrar el total de las transacciones por la ciudad de los agentes. Intentar ordenar por cantidad.
	 */
	public static void main(String[] args) {
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950));
		
		//Find all transactions in the year 2011 and sort them by value (small to high).
		
		transactions.stream()
		.filter(t->t.getYear()==2011)
		.sorted((t1,t2)->t1.getValue())
		.collect(Collectors.toList()).forEach(ESCRIBIDOR);;
		
		//What are all the unique cities where the traders work?
		
		
		//Find all traders from Cambridge and sort them by name.
		
		transactions.stream().flatMap(t -> t.getTrader()).anyMatch(Trader::getCity.eqa)
	}

}
