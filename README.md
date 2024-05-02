---

<h1 align="center">Juego de Verdadero o Falso con Corrutinas</h1>

<p align="center">
  <em>Un juego simple desarrollado en Kotlin con Jetpack Compose y corrutinas.</em>
</p>

## Descripción

Este proyecto consiste en un juego interactivo de Verdadero o Falso desarrollado en Kotlin con el uso de Jetpack Compose y corrutinas. El juego muestra frases aleatorias y el jugador debe decidir si son verdaderas o falsas antes de que termine el tiempo.

## Funcionalidades Principales

- **Botón "Start"**: Permite iniciar el juego y lanzar una cuenta regresiva de 20 segundos.
- **Visualización de la cuenta regresiva**: Muestra en tiempo real el tiempo restante para responder.
- **Frases aleatorias**: Mostrar frases aleatorias almacenadas en una lista mutable.
- **Botones "Verdadero" y "Falso"**: Permiten al jugador seleccionar su respuesta.
- **Visualización de la puntuación**: Muestra la puntuación del jugador en tiempo real.
- **Reinicio del juego**: El juego puede reiniciarse con el botón "Start" después de que la cuenta regresiva llegue a cero.

---

### Estructura del Proyecto

El proyecto está organizado en un solo archivo `IU.kt`, que contiene todos los componentes de la interfaz de usuario necesarios para el juego.

- `botonStart()`: Crea el botón "Start" para iniciar el juego.
- `cuentaAtras()`: Muestra la cuenta regresiva en tiempo real.
- `fraseVF()`: Agrupa la visualización de la frase y los botones de Verdadero/Falso.
- `frase()`: Muestra la frase actual.
- `botonesFalsoVerdadero()`: Agrupa los botones de Verdadero y Falso.
- `botonFV()`: Crea un botón de Verdadero o Falso según el parámetro recibido.
- `comprobarFrase()`: Verifica si la respuesta seleccionada coincide con la frase actual.
- `puntuacion()`: Muestra la puntuación del jugador en tiempo real.

---


