# 🎬 CineLatam

**CineLatam** es una aplicación de consola en Java que permite buscar títulos de películas o series utilizando la [API de OMDb](https://www.omdbapi.com/). Convierte los resultados en objetos Java, los filtra, clasifica y finalmente los guarda en un archivo JSON local.

---

## 🧰 Tecnologías utilizadas

- Java 17+
- Librería [Gson](https://github.com/google/gson) para parseo de JSON
- API HTTP de Java (`java.net.http.HttpClient`)
- OMDb API (requiere clave gratuita)

---

## 🚀 Funcionalidades

- Búsqueda de películas y series por título
- Conversión de JSON en objetos Java (`TituloOmdb`, `Titulo`)
- Manejo de excepciones personalizadas
- Persistencia de resultados en archivo `titulos.json`
- Diseño orientado a objetos, organizado en paquetes

---

## 📦 Estructura del proyecto
cinelatam/

├── principal/ # Contiene la clase PrincipalConBusqueda

├── modelos/ # Clases que representan películas, series, episodios, etc.

├── servicios/ # Lógica de negocio como búsqueda, conversión, gestión

├── excepcion/ # Excepciones personalizadas

└── titulos.json # Archivo de salida con los títulos buscados

---

## ▶️ Cómo ejecutar

1. Clona el repositorio:
```bash
git clone https://github.com/TomasMoralesR/CineLatam.git
```
2. Abre el proyecto con tu IDE Java favorito (por ejemplo, IntelliJ o Eclipse).

3. Ejecuta la clase PrincipalConBusqueda.java.

---
## Ejemplo de uso
Escriba el nombre del título: Interstellar
...
Escriba el nombre del título: salir

Al salir, los títulos buscados se guardan en titulos.json

---
## 🧪 En desarrollo
Este proyecto es parte de una práctica personal con Java. Se planean futuras mejoras como:

Interfaz gráfica (Swing o JavaFX)

Filtros por género, año o clasificación

Exportación a otros formatos (CSV, XML)

---
## 🧑‍💻 Autor
Tomás Morales R.

https://github.com/TomasMoralesR