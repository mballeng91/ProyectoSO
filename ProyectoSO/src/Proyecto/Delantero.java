package Proyecto;

public class Delantero extends Jugador{


	
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
			if(tablero.getUbicacionInt() ==  brazuca.getPosicion()){
				mover();
				//notifyAll();
			}else{
//				try {
//					this.wait();
//				} catch (InterruptedException e) {
//					System.out.println("NO quiero detenerme, ahora te mordere :3" + name);
//					e.printStackTrace();
//				}
			}
			
		}
		
	}
	
	/**
	 * hace que el delantero se embarque en balon y se mueva de una
	 */
	private synchronized void mover(){
		brazuca.addJugador( this );
		//brazuca.moverJugadores();
		brazuca.mover();
	}
	
}
