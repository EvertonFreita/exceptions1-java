package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Principal {

	public static void main(String[] args) throws ParseException {
			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número da sala: ");
		int number = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Check-Out encontro deve ser depois Check-In encontrado ");
		}
		else {
			Reservations reservations = new Reservations(number, checkIn, checkOut) ;
			System.out.println("Reservações: " + reservations);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar as reservações: ");
			System.out.print("Check-in data (dd/MM/yyyy): ");
		    checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
				String error = reservations.updateDates(checkIn, checkOut);
			
				if(error != null) {
					System.out.println("Erro em reserva: " + error);
				}
				else {
					System.out.println("Reserva: " + reservations);
				}
			
			
		}
		sc.close();
	}

	
}
