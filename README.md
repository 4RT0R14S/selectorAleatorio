#  Selector Aleatorio - Interfaz Hacker con JavaFX

Una aplicación visual de JavaFX que permite introducir elementos en una lista y seleccionar aleatoriamente un número determinado de ellos. Diseñado con estética *hacker* (negro + verde neón) al estilo Matrix o terminal retro.

## Características

-  Interfaz moderna con diseño en tonos **negro puro** y **verde neón intenso**
-  Entrada de datos con **Enter** o con botón
-  Control de duplicados
-  Selección aleatoria de elementos con un solo clic
-  Mensajes de alerta si hay errores o repeticiones

---

## Requisitos

- Java 17 o superior
- JavaFX SDK instalado y configurado
- Maven (opcional si usas IDEs como IntelliJ)

---

##  Ejecución

### Si usas IntelliJ:

1. Crea un nuevo proyecto Maven.
2. Añade las dependencias de JavaFX en tu `pom.xml`.
3. Usa `selectorAleatorio.java` como clase principal.
4. Asegúrate de configurar correctamente el path de JavaFX en *Run Configurations*:

   - VM options (ejemplo en Windows):

     ```
     --module-path "C:\path\to\javafx-sdk-XX\lib" --add-modules javafx.controls,javafx.fxml
     ```

### Si usas línea de comandos con Maven:

```bash
mvn clean javafx:run
