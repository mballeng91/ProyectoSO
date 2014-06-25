package Proyecto;

public class Volante extends Jugador{

	
	public Volante(int id, String name, String ubicacion) {
		super(id, name, ubicacion);
		System.out.println("Se a creado el Volante "+id+" Nombre: "+name);
	}
	
	public Volante(int id, String ubicacion) {
		super(id, ubicacion);
		System.out.println("Se a creado Un Volante "+id);
	}

	
	public Volante() {
		super();
		System.out.println("Se a creado Un Volante ");
	}

	public Volante(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero) {
		super(id, name, ubicacion, brazuca, tablero);
		System.out.println("Se a creado Un Volante "+id);
	}

	@Override
	public void run() {
		
		while( !tablero.isTermino() ){
			brazuca.addJugador( this );
			
			//brazuca.moverJugadores();
			brazuca.mover();
		}
		
	}

}
