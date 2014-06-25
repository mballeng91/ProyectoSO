package Proyecto;

public class Delantero extends Jugador{

	public Delantero(int id, String name, String ubicacion) {
		super(id, name, ubicacion);
		System.out.println("Se a creado Un Delantero "+id+" Nombre: "+name);
	}
	
	public Delantero(int id, String ubicacion) {
		super(id, ubicacion);
		System.out.println("Se a creado Un Delantero "+id);
	}
	
	public Delantero() {
		super();
		System.out.println("Se a creado Un Delantero ");
	}

	public Delantero(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero) {
		super(id, name, ubicacion, brazuca, tablero);
		System.out.println("Se a creado Un Delantero "+id);
	}

	@Override
	public void run() {
		while( !tablero.isTermino() ){
			mover();
			
		}
		
	}
	
	private synchronized void mover(){
		brazuca.addJugador( this );
		//brazuca.moverJugadores();
		brazuca.mover();
	}
	
}
