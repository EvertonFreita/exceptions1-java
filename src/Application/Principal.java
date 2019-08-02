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
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro em reserva: dados da reserva devem ser atualizados");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro em reserva: Check-Out deve ser depois do Check-In encontrado");
			}
			else {
				reservations.updateDates(checkIn, checkOut);
				System.out.println("Reservações: " + reservations);
			}
			
			
		}
		sc.close();
	}

	
}
