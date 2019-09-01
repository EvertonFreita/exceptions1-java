package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;
import model.exception.DomainException;

public class Principal {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Número da sala: ");
		int number = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
			
		System.out.println();
		System.out.println("Entre com os dados para atualizar as reservações: ");
		System.out.print("Check-in data (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		
		Reservations reservations = new Reservations(number, checkIn, checkOut) ;
		System.out.println("Reservações: " + reservations);
		
		}
		catch(ParseException e) {
			System.out.println("Formatos inválidos");
		}
		catch (DomainException e) {
			System.out.println("Erro em reservas: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado! ");
		}
			
		
		sc.close();
	}

	
}
