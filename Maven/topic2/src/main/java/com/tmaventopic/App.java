package com.tmaventopic;
import org.apache.commons.math3.RealFieldElement;
import com.ning.http.client.consumers.FileBodyConsumer;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entern name:");
		String entry = sc.nextLine();
		System.out.println("Hi! "+ entry);
		sc.close();
		
		//Use of dependecies
		RealFieldElement f;
		FileBodyConsumer g;
	}
	
	public void testMethod(){
		//DoSomething
	}
}
