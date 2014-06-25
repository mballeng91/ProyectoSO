package Proyecto;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Balon {
	private Semaphore cupoVolantes;
	private Semaphore cupoDelantero;
	//Atributos que solo tendran acceso internamente. (estan sin get y set)
	private Jugador jugadores[];
	private int idx, posicion;
	
	public Balon() {
		this(2, 1);
		jugadores = new Jugador[2];
		idx = 0;
		posicion = 0;
	}

	public Balon( int posicion ) {
		this(2, 1);
		jugadores = new Jugador[2];
		idx = 0;
		this.posicion = posicion;
	}
	
	public Balon( int nv, int nd) {
		super();
		cupoVolantes = new Semaphore( nv );
		cupoDelantero= new Semaphore( nd );
		jugadores = new Jugador[2];
		idx = 0;
		posicion = 0;
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
		//if( jugador.)
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
	}
	
	public int getPosicion(){
		return posicion;
	}
	
}
