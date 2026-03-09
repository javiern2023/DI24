package Tema1SWING_2022_23;

import java.util.Date;

public class EjemploFechas2 {
	public static void main(String[] args) {
		Date fecha2 = new Date(116, 5,3, 10, 5, 6);
		System.out.println(fecha2);
		
		System.out.println("Año: "+ (fecha2.getYear()+1900) );
		 System.out.println("Mes: "+fecha2.getMonth());
		 System.out.println("Dia: "+fecha2.getDate());
		 System.out.println("Dia de la semana "+fecha2.getDay());
		 System.out.println("Hora: "+fecha2.getHours());
		 System.out.println("Minutos: "+fecha2.getMinutes());
		 System.out.println("Segundos: "+fecha2.getSeconds());
	}

}
