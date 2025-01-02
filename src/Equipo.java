
public class Equipo {

	private String nombre;
	private int vidas;
	private int misiles;
	private String pais;
	private boolean muerte;
	
	public String [] paises = {"Italia", "Francia", "Alemania", "Austria", "República Checa","Polonia", "Eslovaquia","Hungría"};
	
	//CONSTRUCTOR
	public Equipo (String nombre) {
		this.nombre=nombre;
	}

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

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isMuerte() {
		return muerte;
	}

	public void setMuerte(boolean muerte) {
		this.muerte = muerte;
	}

	public String[] getPaises() {
		return paises;
	}

	public void setPaises(String[] paises) {
		this.paises = paises;
	}
	
	
	
}
