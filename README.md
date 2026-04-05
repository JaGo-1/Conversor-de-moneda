
# Conversor de Moneda

## Descripción
Aplicación Android que permite convertir valores entre dólares (USD) y euros (EUR).

El usuario puede:
- Ingresar un monto en dólares o euros.
- Seleccionar el tipo de conversión.
- Ver el resultado automáticamente.
- Modificar el valor del tipo de cambio.

---

## Implementación MVVM

La aplicación fue desarrollada utilizando el patrón MVVM (Model - View - ViewModel):

- Model (ConversorDeMoneda):  
  Contiene la lógica de conversión y el valor del tipo de cambio.

- ViewModel (MainViewModel):  
  Maneja la lógica de la aplicación y expone los datos usando LiveData (resultado, tipo de cambio y errores).

- View (MainActivity):  
  Muestra la interfaz al usuario y observa los datos del ViewModel sin contener lógica de negocio.

---

## Funcionalidades

- Conversión entre USD y EUR  
- Selección mediante RadioButtons  
- Visualización del resultado  
- Modificación del tipo de cambio  
- Validación de datos ingresados  
- Manejo de errores  

---

## Integrantes

- Jacqueline Estefanía Gomez - 44019661
- Santiago Godoy - 41055150
