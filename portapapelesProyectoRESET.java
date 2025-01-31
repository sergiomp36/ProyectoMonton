//METODO RONDA OBSOLETO SIN COMPLETAR 23/01/2025

    repartirMisilesAtaque();
    int opcion,opcionRonda;
    System.out.println();
    System.out.println("Ronda "+numRonda);

    for (int i=0; i<numJugadores;i++) {
        if (!participantes.get(i).isMuerte()) {//comprueba si está muerto y si sigue vivo entra en el if
            opcion = menu.menuRonda(participantes.get(i));
            
            if (opcion == 1) {//si elige ATACAR
                mostrarPaisesAtaque(i);
                opcionRonda = input.nextInt()-1;
                if (opcionRonda!=i && !participantes.get(opcionRonda).isMuerte()) {
                    opcionesAtaque[i] = opcionRonda;
                }	
            }
            
            if (opcion ==2) {//SI ELIGE DEFENDER
                opcionesDefensa[i] = 1;
            }
            
            else {
                // CÓDIGO PARA AYUDA ALIADA
            }
            
        }
    }


    util.vaciarArrayInt(opcionesAtaque);
    util.vaciarArrayInt(opcionesDefensa);



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODO PARA MOSTRAR PAISES DISPONIBLES PARA ATACAR TENIENDO EN CUENTA EL JUGADOR QUE ESTÁ JUGANDO.
    private void mostrarPaisesAtaque(int i) {
        System.out.println("¿A quién quieres atacar?");
        for (int j = 0 ; j < numJugadores ; j++) {//bucle para mostrar los paises que siguen con vida y que no coinciden con el actual
            if (!participantes.get(i).isMuerte() && i!=j) {
                System.out.println("("+(util.indexOf(participantes.get(i).getPaises(),participantes.get(j).getPais())+1)+") "+participantes.get(j).getPais());
            }
        }
    }

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODO PARA MOSTRAR REGLAS E INFORMACIÓN EN FUNCION DE LA OPCIÓN QUE SE ELIJA
    public void mostrarReglasInformacion(int opcion) {
        if (opcion == 2) {
            System.out.println("------ REGLAS ------");
            System.out.println("Hay entre 3 y 10 equipos. El objetivo es ser el último equipo vivo \n");
            System.out.println("Los misiles pueden dividirse para atacar a varios equipos a la vez");
            System.out.println("La defensa cuesta el doble de misiles que atacar");
            System.out.println("Los misiles pueden dividirse entre ataque y defensa.");
            System.out.println("Los jugadores pueden elegir la opción 'Solicitar ayuda aliada' en lugar de atacar o defender. Esto causará uno de los siguientes efectos de manera aleatoria:");
            System.out.println("   1.	Conseguir 25 misiles para atacar extra, 25%.");
            System.out.println("   2.	Conseguir 30 misiles para defender extra, 25%.");
            System.out.println("   3.	Conseguir un 20% de evasión, 25%.");
            System.out.println("   4.	Invulnerabilidad durante ese turno, 10%.");
            System.out.println("   5.	¡Traición aliada! Recibir 10 puntos de daño, 15%. \n");
            System.out.println("Puedes elegir entre varios países, cada país tiene una habilidad pasiva diferente:");
            System.out.println("   •    Alemania: 10 más de misiles al atacar, 10 extra en niebla.");
            System.out.println("   •    Austria: 10 más al defender. 10 extra en lluvia.");
            System.out.println("   •	Francia: 60 más de vida máxima, 5% posibilidades de fallar el ataque.");
            System.out.println("   •	República Checa: 20% más de daño realizado y 10% de daño recibido en climas especiales.");
            System.out.println("   •	Italia: Cada 2 rondas genera automáticamente 5 de escudo.");	
            System.out.println("   •	Hungría: Si usa todos los recursos para defender se vuelve invulnerable, pero pierde el siguiente turno (no podrá atacar o defender).");		
            System.out.println("   •	Polonia: Consigue una ronda extra al llegar a 0 de vida.");	
            System.out.println("   •	Eslovaquia: Consigue una habilidad aleatoria entre 4.");
            System.out.println("   •	Dinamarca: Doble de vida, pero empieza con 10 misiles (que se van incrementado en 10 en cada ronda hasta el numero normal de misiles).");
            System.out.println("   •	Croacia: Mitad de vida, 40% de evasión. \n");
            System.out.println("Los climas afectan a la partida de diferentes formas:");
            System.out.println("   •	Niebla: 20% de posibilidad de fallar ataque.s");
            System.out.println("   •	Lluvia: Baja la defensa en 10.");
            System.out.println("   •	Alto calor: Aumenta el daño en 10.");
            System.out.println("   •	Nieve: Impide pedir ayuda a aliados.");
            System.out.println("   •	Terremoto (muy raro): Hace 5 de daño al jugador por cada turno activo. \n");
            System.out.println("La partida podrá ser guardada para poder continuarla en otra ocasión.");
            
            
        }
        
        else if (opcion == 3) {
            System.out.println("INFORMACIÓN");
            System.out.println("Versión: ");
            System.out.println("Autores: Sergio Montoya Prado / David Antón Gil");
            System.out.println("Contacto: sergiomp36@educastur.es / RFM16975@educastur.es");
            
        }
    }



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS DE LA CLASE UTILITIES PARA VACIAR ARRAYS DE INT Y CONTAINS
    public boolean contains(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false; 
    }


    public int indexOf(String[] array, String valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valor)) {
                return i;  
            }
        }
        return -1; // si no encontrara el valor, retornaria menis 1
    }

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//CLASE EQUIPO

//    private String nombre;
//    private int vidas;
//    private int misilesAtaque;
//    private int misilesDefensa;
//    private String pais;
//    private boolean muerte;
//    private String clima;

    private String [] paises = {"Alemania", "Francia", "Italia", "Eslovaquia", "República Checa","Polonia", "Hungría","Austria","Polonia","Dinamarca","Croacia"};
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


    public String getPaises(int n) {
        return paises[n];
    }


    public String[] getPaises() {
        return paises;
    }	


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//CLASE MENU
	Scanner input = new Scanner(System.in);
	
	
	

	public int menuInicial() {
		int opcion;
		System.out.println("------ COLD WAR ------");
		System.out.println("(1) Jugar\n(2) Reglas\n(3) Información\n(4) Cargar partida\n(0) Salir");
		opcion=input.nextInt();
		while (opcion<0||opcion>4) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		if (opcion==2||opcion==3 || opcion==4) {
			Utilities util = new Utilities();
			util.mostrarReglasInformacion(opcion);
		}
		return opcion;
	}
	
	
	public int menuRonda(Equipo equipo) {
		int opcion;
		System.out.println(equipo.getNombre()+", ¿qué quieres hacer?");
		System.out.println("(1)Atacar\n(2)Defender\n(3)(Ayuda aliada)");//queda por mirar que hace la opcion de la ayuda
		opcion = input.nextInt();
		while (opcion<1||opcion>3) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		return opcion;
	}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
