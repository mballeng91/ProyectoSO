package Proyecto;

public abstract class Jugador implements Runnable{
	/**
	 * id: numero unico que le corresponde al jugador
	 * name: Nombre del Jugador
	 * alineacion: posicion del jugador en el campo(Volante, Delatero)
	 */
	protected int id;
	protected String name, alineacion;
	protected Balon brazuca;
	protected Tablero tablero;
	protected boolean termino = false;
	
	public Jugador() {
		super( );
	}
	
	public Jugador(int id, String ubicacion) {
		super();
		this.id = id;
		this.alineacion = ubicacion;
		this.name = "Jugador"+id;
		
	}
	
	public Jugador(int id, String name, String ubicacion) {
		super();
		this.id = id;
		this.name = name;
		this.alineacion = ubicacion;
	}
	
	

	public Jugador(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero) {
		super();
		this.id = id;
		this.name = name;
		this.alineacion = ubicacion;
		this.brazuca = brazuca;
		this.tablero = tablero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUbicacion() {
		return alineacion;
	}

	public void setUbicacion(String ubicacion) {
		this.alineacion = ubicacion;
	}

	public Balon getBrazuca() {
		return brazuca;
	}

	public void setBrazuca(Balon brazuca) {
		this.brazuca = brazuca;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public boolean isTermino() {
		return termino;
	}

	public void setTermino(boolean termino) {
		this.termino = termino;
	}
	
}
