package Tema1SWING_2022_23;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploFechas {
	public static void main(String args[]) {
		
		/*
		 * 'Calendar' clase abstracta que proporciona m�todos 
		 * para convertir entre un instante espec�fico en el tiempo y un conjunto
		 * de campos del calendario (A�O, MES, D�A_DE_MES, HORA, etc.)
		 * y para manipular los campos del calendario.
		*/
		
		//getInstance() devuelve toda la informaci�n completa del calendario del d�a de hoy.
		Calendar calendario = Calendar.getInstance();
		System.out.println(calendario);
		
		//Date fecha = calendario.getTime();
		//calendario.setTime(fecha);
		
		
		System.out.println("Fecha: " + calendario.getTime());
		System.out.println(calendario.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendario.get(Calendar.MINUTE));
		System.out.println(calendario.get(Calendar.SECOND));
		
		System.out.println("Fecha Sin Formato: " + calendario.getTime());
		
		//Para formatear una fecha,por ejemplo dia/mes/a�o, usaremos
		//la clase DateFormat y SimpleDateFormat
		//w: Semana del a�o (1-53) -- W: Semana del mes (0-5)
		//m: Minuto (0-59) -- M: Mes del a�o (Determinado por el n�mero de caracteres)
		//d: D�a del a�o (0-366) -- D: D�a del mes (Determinado por el n�mero de caracteres)
		DateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println("Fecha Con Formato: " + formato.format(calendario.getTime()));
		
		//A�o
		calendario.set(Calendar.YEAR, 2021);
		// Mes (0: January, 11: December)
		calendario.set(Calendar.MONTH, 7);
		calendario.set(Calendar.DAY_OF_MONTH, 23);

		//Formato 12 Horas - Se a�ade AM/PM
		calendario.set(Calendar.HOUR, 10);
		calendario.set(Calendar.AM_PM, Calendar.PM);
		//Formato 24 Horas
		calendario.set(Calendar.HOUR_OF_DAY, 22);

		//Hora
		calendario.set(Calendar.MINUTE, 36);
		calendario.set(Calendar.SECOND, 22);
		calendario.set(Calendar.MILLISECOND, 123);

		System.out.println("Fecha Cambiada: " + calendario.getTime());
		System.out.println("Fecha Cambiada con formato: " + formato.format(calendario.getTime()));
		
		
	}
}
