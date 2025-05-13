document.addEventListener("DOMContentLoaded", () => {
window.ocultarPantallaInicio = function() {
    const pantalla = document.getElementById("pantallaInicio");
    pantalla.style.opacity = "0";
    setTimeout(() => {
        pantalla.style.display = "none";
        const imagenAmpliada = document.getElementById("imagenAmpliada");
        imagenAmpliada.src = "bienvenido.gif";
        const musica = document.getElementById("musicaFondo");
    musica.play();
    });
    };

    const modal = document.getElementById("modalImagen");
    modal.style.display = "none"; 
    window.abrirImagen = function(src) {
        if (!src || src === "") return; 
        const imagenAmpliada = document.getElementById("imagenAmpliada");
        imagenAmpliada.src = src;
        modal.style.display = "flex";
    };

    window.cerrarImagen = function() {
        modal.style.display = "none";
        document.getElementById("imagenAmpliada").src = ""; 
    };

    modal.addEventListener("click", function(event) {
        if (event.target === modal) {
            cerrarImagen();
        }
    });

    document.querySelectorAll("img").forEach(img => {
        img.addEventListener("click", function() {
            abrirImagen(this.src);
        });
    });
  
    const secciones = document.querySelectorAll("section");
    const observar = new IntersectionObserver(entries => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add("visible");
            }
        });
    }, { threshold: 0.2 });

    secciones.forEach(seccion => observar.observe(seccion));

   document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
        const pantalla = document.getElementById("pantallaInicio");
        pantalla.style.display = "flex";
    }, 1000);
});
const toggles = document.querySelectorAll('.toggle');

  toggles.forEach(toggle => {
    toggle.addEventListener('click', () => {
      const contenido = toggle.nextElementSibling;
      contenido.classList.toggle('activo');
    });
  });
  
});

