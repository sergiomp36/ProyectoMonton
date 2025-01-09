
public class Equipo {

	private String nombre;
	private int vidas;
	private int misiles;
	private String pais;
	private boolean muerte;
	
	public String [] paises = {"Alemania", "Francia", "Italia", "Eslovaquia", "República Checa","Polonia", "Hungría","Austria","Polonia","Dinamarca"};
	
	//CONSTRUCTOR
	public Equipo (String nombre) {
		this.nombre=nombre;
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getMisiles() {
		return misiles;
	}

	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = paises[pais-1];
	}

	public boolean isMuerte() {
		return muerte;
	}

	public void setMuerte(boolean muerte) {
		this.muerte = muerte;
	}	
	
	
}
