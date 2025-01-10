
public class Equipo {

	private String nombre;
	private int vidas;
	private int misilesAtaque;
	private int misilesDefensa;
	private String pais;
	private boolean muerte;
	private String clima;
	
	public String [] paises = {"Alemania", "Francia", "Italia", "Eslovaquia", "República Checa","Polonia", "Hungría","Austria","Polonia","Dinamarca"};
	public String []climas = {"Niebla", "Lluvia", "Calor", "Nieve", "Terremoto"};
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

	public int getMisilesAtaque() {
		return misilesAtaque;
	}

	public void setMisilesAtaque(int misiles) {
		this.misilesAtaque = misiles;
	}
	
	public int getMisilesDefensa() {
		return misilesDefensa;
	}

	public void setMisilesDefensa(int misiles) {
		this.misilesDefensa = misiles;
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


	public String getClima() {
		return clima;
	}


	public void setClima(int clima) {
		this.clima = climas[clima-1];
	}	
	
	

}
