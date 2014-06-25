package Proyecto;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Balon {
	private Semaphore cupoVolantes;
	private Semaphore cupoDelantero;
	//Atributos que solo tendran acceso internamente. (estan sin get y set)
	private Jugador jugadores[];
	private int idx, posicion;  // idx es el numero jugadores que se han agregado al balon
	private Tablero[] tableros; //El balon tiene los dos tableros
	
	public Balon( Tablero[] tableros ) {
		this(2, 1, tableros);
	}

	public Balon( int posicion, Tablero[] tableros ) {
		this(2, 1, tableros);
		this.posicion = posicion;
	}
	
	public Balon( int nv, int nd, Tablero[] tableros) {
		super( );
		cupoVolantes = new Semaphore( nv );
		cupoDelantero= new Semaphore( nd );
		jugadores = new Jugador[2];
		idx = 0;
		posicion = 0;
		this.tableros = tableros;
	}

	public Balon(Semaphore cupoVolantes, Semaphore cupoDelantero) {
		super();
		this.cupoVolantes = cupoVolantes;
		this.cupoDelantero = cupoDelantero;
		jugadores = new Jugador[2];
		idx = 0;
		posicion = 0;
	}

	public Semaphore getCupoVolantes() {
		return cupoVolantes;
	}

	public void setCupoVolantes(Semaphore cupoVolantes) {
		this.cupoVolantes = cupoVolantes;
	}

	public Semaphore getCupoDelantero() {
		return cupoDelantero;
	}

	public void setCupoDelantero(Semaphore cupoDelantero) {
		this.cupoDelantero = cupoDelantero;
	}
	
	public synchronized void addJugador( Jugador jugador ){
		if(idx >= 2) 
			return;
		jugadores[idx] = jugador;
		idx++;
	}
	
	public synchronized void clearJugadores( Jugador jugador ){
		jugadores[0] = jugadores[1] = null;
		idx = 0;
	}

	@Override
	public String toString() {
		return "Balon [cupoVolantes=" + cupoVolantes + ", cupoDelantero="
				+ cupoDelantero + ", jugadores=" + Arrays.toString(jugadores)
				+ ", idx=" + idx + ", posicion=" + posicion + "]";
	}

	
	public void mover() {
		posicion = (posicion+1)%2;
		System.out.println( printMensaje() );
		for(int i = 0; i < idx; i++){
			int table = jugadores[i].getTablero().getUbicacionInt();
			table = (table+1)%2;
			//Este es el proceso de cambio de tablero para cada jugador
			jugadores[i].desvincularTablero();
			jugadores[i].setTablero( tableros[table] );
			jugadores[i].vincularTablero();
		}
	}
	
	private String printMensaje() {
		StringBuilder mensaje = new StringBuilder();
		if( idx==2 ){
			mensaje.append("El Jugador "+jugadores[0].name+" Y "+jugadores[1].name
					+" realizan una Pared y se diriguen a la porteria contraria.");
		}else{
			mensaje.append("El Jugador "+jugadores[0].name+" toma el balon y se " +
					"dirigue a la porteria contraria.");
		}
		return mensaje.toString();
	}

	public int getPosicion(){
		return posicion;
	}
	
}
