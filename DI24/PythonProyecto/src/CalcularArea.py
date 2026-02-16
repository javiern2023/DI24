# Importaciones
import math

# Constantes globales
PI = 3.14159

# Definición de funciones
def calcular_area_circulo(radio):
    return PI * radio ** 2

# Código principal
if __name__ == "__main__":
    radio = float(input("Ingresa el radio del círculo: "))
    area = calcular_area_circulo(radio)
    print(f"El área del círculo es: {area}")
