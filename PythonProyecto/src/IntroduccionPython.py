'''
- Introducción a Python. Python es un lenguaje de programación de alto nivel, interpretado, y de 
propósito general. Es conocido por su sencillez y legibilidad.

- Orden común en un archivo Python
Importaciones: Al principio del archivo.
Constantes globales: Variables en mayúsculas (si son necesarias).
Definición de funciones: Generalmente se colocan después de las importaciones y antes del código 
principal.
Código principal: Es común que se coloque dentro de un bloque if __name__ == "__main__":.

- Por qué se colocan las funciones al principio
Legibilidad: Colocar las funciones arriba permite que el código principal sea más fácil de leer.
Disponibilidad: Python ejecuta el código línea por línea. Si intentas llamar a una función antes de 
declararla, obtendrás un error (NameError).
'''
print("Hola, Mundo!")

#En Python, no es necesario declarar el tipo de variable, ya que el tipo se deduce automáticamente.
nombre = "Juan"
edad = 25
altura = 1.75
#Constantes
PI = 3.1416
GRAVEDAD = 9.8

numero = 42         # Entero
pi = 3.1416         # Flotante
mensaje = "Hola"    # Cadena
es_activo = True    # Booleano

x = 10
y = 3
print(x + y)   # 13
print(x ** y)  # 1000 x elevado a y igual que el método pow(x,y)

#Lectura de datos
nombre = input("¿Cómo te llamas? ")

#Conversion de tipos
edad = int(input("¿Cuántos años tienes? "))
print("Hola,", nombre)

edad = 18
if edad >= 18:
    print("Eres mayor de edad.")
else:
    print("Eres menor de edad.")
    
# Bucles
contador = 0
while contador < 5:
    print(contador)
    contador += 1   
    
while True:
    # Código que se ejecutará al menos una vez
    print("Este código se ejecuta al menos una vez.")
    
    # Condición de salida
    if not (input("¿Quieres repetir? (s/n): ").lower() == "s"):
        break
'''
La indentación en Python no es opcional, como en otros lenguajes, sino que es obligatoria para 
definir los bloques. Si no respetas la indentación, obtendrás un error de sintaxis. 
El nivel de indentación suele ser de 4 espacios por convención (aunque también puedes usar un 
tabulador, pero es preferible mantener consistencia).
'''
    
for i in range(5):
    print(i) 
    
for i in range(3,6):
    print(i)    
    
#Funciones
def saludar(nombre):
    return f"Hola, {nombre}!"

mensaje = saludar("Carlos")
print(mensaje)